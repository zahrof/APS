package ast;

import java.util.List;

/**
 * AstProgramme
 */
public class AstProgramme extends Ast{

    private List<AstCommand> commands;

    public AstProgramme (List<AstCommand> cmds){
        commands = cmds;
    }

    public List<AstCommand> getCommands(){
        return commands;
    }
}