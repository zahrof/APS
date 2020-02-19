package ast;

import java.util.List;

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
}