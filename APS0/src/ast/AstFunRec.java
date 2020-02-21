package ast;

import java.util.List;

import interfaces.IAstVisitor;

/**
 * AstFunRec
 */
public class AstFunRec extends AstDeclaration{
    private List<AstArgument> arguments;
    
    public AstFunRec(String name, AstType type, List<AstArgument> args, AstExpression expr){
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