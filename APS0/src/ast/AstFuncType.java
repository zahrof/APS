package ast;

import java.util.List;

/**
 * AstFuncType
 */
public class AstFuncType extends AstType{
    private List<AstType> typesArguments;
    private AstType typeResult;

    public AstFuncType(List<AstType> targs, AstType tr){
        typesArguments=targs;
        typeResult=tr;
    }

    public List<AstType> getTypesArguments(){
        return typesArguments;
    }

    public AstType getTypeResult(){
        return typeResult;
    }
}