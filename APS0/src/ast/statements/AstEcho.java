package ast.statements;

import ast.expressions.AstExpression;
import interfaces.IAstVisitor;

/**
 * AstEcho
 */
public class AstEcho extends AstStatement{

    private AstExpression expr;

    public AstEcho(String name, AstExpression e){
        super(name);
        expr=e;
    }

    public AstExpression getExpr(){
        return expr;
    }
    
    public <Result,Data,Exc extends Throwable> Result accept(IAstVisitor<Result,Data,Exc> visitor, Data data) throws Exc{
		return visitor.visit(this, data);
	}
}