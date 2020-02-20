package ast;

import java.util.List;

/**
 * AstOp
 */
public class AstOp extends AstExpression {
    private String operation;
    private List<AstExpression> expressions;

    public AstOp(String operation, List<AstExpression> expressions){
        this.operation = operation;
        this.expressions = expressions;
    }

    public String getOperation(){
        return operation;
    }

    public List<AstExpression> getExpressions(){
        return expressions;
    }
}