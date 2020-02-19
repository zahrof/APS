package ast;

/**
 * AstVar
 */
public class AstVar extends AstExpression {
    
    private String name;

    public AstVar(String n){
        name=n;
    }

    public String getName(){
        return name;
    }
}