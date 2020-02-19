public abstract class AstStatement extends AstCmds {

    private String name;

    public AstStatement(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}