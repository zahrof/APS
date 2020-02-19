public class  AstFunRec extends AstFunTemplate{


public AstFunRec(AstId ident, AstType type, AstArgs args, AstExpression body) {
        super("FUN REC", ident, type, body, args);

        }

@Override
public String toPrologString() {
        return super();
        }

        }