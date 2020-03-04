package ast.declarations;

import ast.expressions.AstExpression;
import ast.types.AstType;
import interfaces.IAstVisitor;

/**
 * AstConst
 */
public class AstConst extends AstDeclaration{


    public AstConst(String name, AstType type, AstExpression expr){
        super(name,type,expr);
    }
    
    public <Result,Data,Exc extends Throwable> Result accept(IAstVisitor<Result,Data,Exc> visitor, Data data) throws Exc{
		return visitor.visit(this, data);
	}
}