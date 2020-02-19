package ast;

import java.util.List;

/**
 * AstLambda
 */
public class AstLambda extends AstExpression{
    private List<AstArgument> arguments;
    private AstExpression body;

    public AstLambda(List<AstArgument> arguments, AstExpression body){
        this.arguments=arguments;
        this.body=body;
    }

    public List<AstArgument> getArguments(){
        return arguments;
    }

    public AstExpression getBody(){
        return body;
    }
}