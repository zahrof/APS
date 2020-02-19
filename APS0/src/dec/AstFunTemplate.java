public abstract class AstFun extends AstDeclarations{

    private AstArgs args;

    public AstConst(String name, AstId ident, AstType type, AstExpression body ,AstArgs args) {
        super(name, ident, type, body);
        this.args = args;
    }

    @Override
    public String toPrologString() {
       String r;
       r+= this.name + this.ident.toPrologString() + this.type.toPrologString() + " [ " + this.args.toPrologString()+
               " ] " + this.body.toPrologString();
    }



}