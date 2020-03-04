package interfaces;

import ast.*;
import ast.declarations.AstConst;
import ast.declarations.AstFun;
import ast.declarations.AstFunRec;
import ast.expressions.*;
import ast.statements.AstEcho;
import ast.types.AstBoolType;
import ast.types.AstFuncType;
import ast.types.AstIntType;

public interface IAstVisitor<Return,Data,Exc extends Throwable> {
	Return visit(AstApplication ast, Data data) throws Exc;
	Return visit(AstArgument ast, Data data) throws Exc;
	Return visit(AstBool ast, Data data) throws Exc;
	Return visit(AstBoolType ast, Data data) throws Exc;
	Return visit(AstConst ast, Data data) throws Exc;
	Return visit(AstEcho ast, Data data) throws Exc;
	Return visit(AstFun ast, Data data) throws Exc;
	Return visit(AstFuncType ast, Data data) throws Exc;
	Return visit(AstFunRec ast, Data data) throws Exc;
	Return visit(AstIf ast, Data data) throws Exc;
	Return visit(AstIntType ast, Data data) throws Exc;
	Return visit(AstLambda ast, Data data) throws Exc;
	Return visit(AstNum ast, Data data) throws Exc;
	Return visit(AstOp ast, Data data) throws Exc;
	Return visit(AstProgramme ast, Data data) throws Exc;
	Return visit(AstVar ast, Data data) throws Exc;
}
