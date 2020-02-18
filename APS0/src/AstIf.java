import java.util.ArrayList;

public class AstIf implements Ast{
    Ast cond;
    Ast res;
    Ast alt;

    AstIf(Ast cond, Ast res, Ast alt) {
        this.cond = cond;
        this.res = res;
        this.alt = alt;
    }

    @Override
    public String toPrologString() {
        String r = "";
        r += "([";

        r += "if (" + cond.toPrologString() +") "+res.toPrologString() + " " + alt.toPrologString() + "])";

        return r;
    }

}
