public abstract class AstDeclaration extends AstCmds{
    private String name;
    private AstId ident;
    private AstType type;
    private AstExpression body;

    public AstDeclaration(String name, AstId ident, AstType type, AstExpression body) {
        this.name = name;
        this.ident = ident;
        this.type = type
        this.body = body;
    }

    public AstId getIdent() { return ident; }

    public AstType getType() { return type; }

    public AstArgs getArgs() { return args; }

    public AstExpression getBody() { return body; }


}