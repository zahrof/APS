package ast;

import java.util.List;

/**
 * AstApplication
 */
public class AstApplication extends AstExpression{  
    private AstExpression invocable;
    private List<AstExpression> expressions;

    public AstApplication(AstExpression invocable, List<AstExpression> expressions){
        this.invocable=invocable;
        this.expressions=expressions;
    }

    public AstExpression getInvocable(){
        return invocable;
    }

    public List<AstExpression> getExpressions(){
        return expressions;
    }
}