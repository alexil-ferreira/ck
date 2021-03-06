package com.github.mauricioaniche.ck.metric;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.InfixExpression;

public class NumberOfComparisons extends ASTVisitor implements ClassLevelMetric, MethodLevelMetric {

	private int qty = 0;

	@Override
	public boolean visit(InfixExpression node) {

		if(node.getOperator() == InfixExpression.Operator.EQUALS)
			qty++;

		if(node.getOperator() == InfixExpression.Operator.NOT_EQUALS)
			qty++;

		return super.visit(node);

	}

	@Override
	public void setResult(CKMethodResult result) {
		result.setComparisonsQty(qty);
	}

	@Override
	public void setResult(CKClassResult result) {
		result.setComparisonsQty(qty);
	}
}
