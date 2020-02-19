
public class AstArgs implements Ast{

    AstArg arg;
    AstArgs args;

    AstArgs(AstArg arg, AstArgs args){
        this.arg = arg;
        this.args = args;
    }

    @Override
    public String toPrologString() {
        return " Args ("+ this.arg.toPrologString()+ this.args.toPrologString()+ " )";
    }

}
