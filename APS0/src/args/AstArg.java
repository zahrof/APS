
public class AstArg implements Ast extends AstArgs{

    AstId id;
    AstType type;

    AstArg(AstId id, AstType type){
        this.id = id;
        this.type = type;
    }

    @Override
    public String toPrologString() {
        return " Arg ("+ this.id.toPrologString()+ this.type.toPrologString()+ " )";
    }

}
