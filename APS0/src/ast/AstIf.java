package ast;

/**
 * AstIf
 */
public class AstIf extends AstExpression{
    private AstExpression condition;
    private AstExpression consequence;
    private AstExpression alternative;

    public AstIf(AstExpression cond, AstExpression cons, AstExpression alt){
        condition = cond;
        consequence = cons;
        alternative = alt;
    }

    public AstExpression getCondition(){
        return condition;
    }

    public AstExpression getConsequence(){
        return consequence;
    }

    public AstExpression getAlternative(){
        return alternative;
    }
}