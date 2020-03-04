package ast.statements;

import ast.AstCommand;

/**
 * AstStatement
 */
public abstract class AstStatement extends AstCommand {

    private String name;

    public AstStatement(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}