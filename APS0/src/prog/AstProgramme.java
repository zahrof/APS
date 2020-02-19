public class AstProgamme implements Ast {
    private List<AstCmds> commands;

    public AstProgramme (ArrayList<AstComds> cmds){
        commands = cmds;
    }

    public ArrayList<AstCommand> getCommands(){
        return commands;
    }
}