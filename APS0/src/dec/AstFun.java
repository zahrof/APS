public class  AstFun extends AstFunTemplate{


public AstFun(AstId ident, AstType type, AstArgs args, AstExpression body) {
        super("FUN", ident, type, body, args);

        }

@Override
public String toPrologString() {
        return super();
        }

        }