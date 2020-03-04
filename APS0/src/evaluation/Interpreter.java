package evaluation;

import ast.AstArgument;
import ast.AstProgramme;
import ast.declarations.AstConst;
import ast.declarations.AstFun;
import ast.declarations.AstFunRec;
import ast.expressions.*;
import ast.statements.AstEcho;
import ast.types.AstBoolType;
import ast.types.AstFuncType;
import ast.types.AstIntType;
import interfaces.IEnvironment;

public class Interpreter implements interfaces.IAstVisitor<Object, IEnvironment, Exception>{

    @Override
    public Object visit(AstApplication ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstArgument ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstBool ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstBoolType ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstConst ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstEcho ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstFun ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstFuncType ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstFunRec ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstIf ast, IEnvironment env) throws Exception {
        Number cond = (Number) ast.getCondition().accept(this, env);
        if(cond.getVal()==1){
            return ast.getConsequence().accept(this,env);
        }
        return ast.getAlternative().accept(this, env);
    }

    @Override
    public Object visit(AstIntType ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstLambda ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstNum ast, IEnvironment env) throws Exception {
       return new Number(ast.getInteger());
    }

    @Override
    public Object visit(AstOp ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstProgramme ast, IEnvironment env) throws Exception {
        return null;
    }

    @Override
    public Object visit(AstVar ast, IEnvironment env) throws Exception {
        return env.find(ast.getName());
    }
}
