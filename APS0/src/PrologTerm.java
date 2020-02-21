import ast.AstApplication;
import ast.AstArgument;
import ast.AstBool;
import ast.AstBoolType;
import ast.AstCommand;
import ast.AstConst;
import ast.AstEcho;
import ast.AstExpression;
import ast.AstFun;
import ast.AstFunRec;
import ast.AstFuncType;
import ast.AstIf;
import ast.AstIntType;
import ast.AstLambda;
import ast.AstNum;
import ast.AstOp;
import ast.AstProgramme;
import ast.AstType;
import ast.AstVar;
import interfaces.IAstVisitor;

public class PrologTerm implements IAstVisitor<String, Void, Exception> {

	@Override
	public String visit(AstArgument ast, Void data) throws Exception {
		return ast.getName() + ":" + ast.getType().accept(this, data);
	}

	@Override
	public String visit(AstBool ast, Void data) throws Exception {
		return ast.getBool().toString();
	}

	@Override
	public String visit(AstBoolType ast, Void data) throws Exception {
		return "bool";
	}

	@Override
	public String visit(AstConst ast, Void data) throws Exception {
		return "CONST " + ast.getName() + " " + ast.getType().accept(this, data) + " "
				+ ast.getBody().accept(this, data);
	}

	@Override
	public String visit(AstEcho ast, Void data) throws Exception {
		return "ECHO " + ast.getExpr().accept(this, data);
	}

	@Override
	public String visit(AstFun ast, Void data) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("FUN " + ast.getName() + " ");
		sb.append("[");
		for (AstArgument arg : ast.getArguments()) {
			sb.append(arg.accept(this, data));
			sb.append(", ");
		}
		sb.delete(sb.length() - 2, sb.length() - 1);
		sb.append("] ");
		sb.append(ast.getBody().accept(this, data));
		return sb.toString();
	}

	@Override
	public String visit(AstFuncType ast, Void data) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (AstType arg : ast.getTypesArguments()) {
			sb.append(arg.accept(this, data));
			sb.append(" * ");
		}
		sb.delete(sb.length() - 3, sb.length() - 1);
		sb.append(") -> ");
		sb.append(ast.getTypeResult().accept(this, data));
		return sb.toString();
	}

	@Override
	public String visit(AstFunRec ast, Void data) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("FUN rec" + ast.getName() + " ");
		sb.append("[");
		for (AstArgument arg : ast.getArguments()) {
			sb.append(arg.accept(this, data));
			sb.append(", ");
		}
		sb.delete(sb.length() - 2, sb.length() - 1);
		sb.append("] ");
		sb.append(ast.getBody().accept(this, data));
		return sb.toString();
	}

	@Override
	public String visit(AstIf ast, Void data) throws Exception {
		return "(if " + ast.getCondition().accept(this, data) + " " + ast.getConsequence().accept(this, data) + " "
				+ ast.getAlternative().accept(this, data) + ")";
	}

	@Override
	public String visit(AstIntType ast, Void data) throws Exception {
		return "int";
	}

	@Override
	public String visit(AstLambda ast, Void data) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (AstArgument arg : ast.getArguments()) {
			sb.append(arg.accept(this, data));
			sb.append(", ");
		}
		sb.delete(sb.length() - 2, sb.length() - 1);
		sb.append("] ");
		sb.append(ast.getBody().accept(this, data));
		return sb.toString();
	}

	@Override
	public String visit(AstNum ast, Void data) throws Exception {
		return ast.getInteger().toString();
	}

	@Override
	public String visit(AstOp ast, Void data) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("("+ast.getOperation()+" ");
		for (AstExpression expr : ast.getExpressions()) {
			sb.append(expr.accept(this, data));
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		return sb.toString();
	}

	@Override
	public String visit(AstProgramme ast, Void data) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (AstCommand cmd : ast.getCommands()) {
			sb.append(cmd.accept(this, data));
			sb.append("; ");
		}
		sb.delete(sb.length() - 2, sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public String visit(AstVar ast, Void data) throws Exception {
		return ast.getName();
	}

	@Override
	public String visit(AstApplication ast, Void data) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("("+ast.getInvocable().accept(this, data)+" ");
		for (AstExpression expr : ast.getExpressions()) {
			sb.append(expr.accept(this, data));
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		return sb.toString();
	}

}
