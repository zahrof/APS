package ast.declarations;

import ast.AstCommand;
import ast.expressions.AstExpression;
import ast.types.AstType;

/**
 * AstDeclaration
 */
public abstract class AstDeclaration extends AstCommand {
    private String name;
    private AstType type;
    private AstExpression body;

    public AstDeclaration(String name, AstType t, AstExpression expr){
        this.name=name;
        type=t;
        body=expr;
    }

    public String getName(){
        return name;
    } 

    public AstType getType(){
        return type;
    }

    public AstExpression getBody(){
        return body;
    }
}