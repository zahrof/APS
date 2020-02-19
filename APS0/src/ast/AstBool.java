package ast;

/**
 * AstBool
 */
public class AstBool extends AstExpression {

    private Boolean bool;
    
    public AstBool(Boolean b){
        bool=b;
    }

    public Boolean getBool(){
        return bool;
    }
}