package ast.types;

import interfaces.IAstVisitor;

/**
 * AstIntType
 */
public class AstIntType extends AstType{
	public <Result,Data,Exc extends Throwable> Result accept(IAstVisitor<Result,Data,Exc> visitor, Data data) throws Exc{
		return visitor.visit(this, data);
	}
}