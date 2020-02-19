
import java.io.*;

class PrologTerm {
	public static void main(String args[]) throws IOException {
	Parser yyparser;
	Ast prog;

	yyparser = new Parser(new InputStreamReader(new FileInputStream(args[0])));
	yyparser.yyparse();
	prog = (Ast) yyparser.yyval.obj;
// il faudra mettre un "." à la fin du terme prolog
	if (prog != null)System.out.println(prog.toPrologString());
	else System.out.println("Null");
		}
}
