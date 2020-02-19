public class AstDeclaration extends AstDeclarations{

    public AstConst(AstId ident, AstType type, AstExpression body) {
       super("const", ident, type, body)
    }

    	    @Override
            public String toPrologString() {
               String r;
               r+= this.name + this.ident.toPrologString() + this.type.toPrologString() + this.body.toPrologString();
            }

}