package ast;

/**
 * AstConst
 */
public class AstConst extends AstDeclaration{


    public AstConst(String name, AstType type, AstExpression expr){
        super(name,type,expr);
    }
}