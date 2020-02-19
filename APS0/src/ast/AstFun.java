package ast;

import java.util.List;

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
}