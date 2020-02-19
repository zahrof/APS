import java.util.ArrayList;

public class AstEcho extends AstStatement{

    private AstExpression expr;

    public AstEcho(String name, AstExpression e){
        super(name);
        expr=e;
    }

    public AstExpression getExpr(){
        return expr;
    }

    @Override
    public String toPrologString() {
        String r = "";
        r = this.name + this.expr.toprologString();
        return r;
    }
}