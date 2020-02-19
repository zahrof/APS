package ast;

/**
 * AstStatement
 */
public abstract class AstStatement extends Ast {

    private String name;

    public AstStatement(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}