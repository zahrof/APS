package ast;

/**
 * AstNum
 */
public class AstNum extends AstExpression {
    private Integer integer;

    public AstNum(Integer i){
        integer=i;
    }

    public Integer getInteger(){
        return integer;
    }
}