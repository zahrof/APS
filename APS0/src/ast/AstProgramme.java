package ast;

import java.util.List;

/**
 * AstProgramme
 */
public class AstProgramme extends Ast{

    private List<AstCommand> commands;

    public AstProgramme (ArrayList<AstCommand> cmds){
        commands = cmds;
    }

    public ArrayList<AstCommand> getCommands(){
        return commands;
    }
}