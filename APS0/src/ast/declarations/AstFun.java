package ast.declarations;

import java.util.List;

import ast.AstArgument;
import ast.expressions.AstExpression;
import ast.types.AstType;
import interfaces.IAstVisitor;

/**
 * AstFun
 */
public class AstFun extends AstDeclaration{
    private List<AstArgument> arguments;
    
    public AstFun(String name, AstType type, List<AstArgument> args, AstExpression expr){
        super(name,type,expr);
        arguments=args;
    }

    public List<AstArgument> getArguments(){
        return arguments;
    }
    
    public <Result,Data,Exc extends Throwable> Result accept(IAstVisitor<Result,Data,Exc> visitor, Data data) throws Exc{
		return visitor.visit(this, data);
	}
}