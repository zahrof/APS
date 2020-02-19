package ast;

/**
 * AstArgument
 */
public class AstArgument extends Ast {
    private String name;
    private AstType type;

    public AstArgument(String n, AstType t){
        name=n;
        type=t;
    }

    public String getName(){
        return name;
    }

    public AstType getType(){
        return type;
        
    }
}