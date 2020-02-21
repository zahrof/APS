import java.io.FileReader;
import java.io.IOException;

import ast.AstProgramme;
import parser.*;

public class Test {

	public static void main(String args[]) throws IOException {
		Parser parser;
		AstProgramme prog=null;
		PrologTerm p = new PrologTerm();
		parser = new Parser(new FileReader("Samples/test.aps"));
		try {
			parser.parse();
			prog = parser.prog;

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (prog != null)
			try {
				System.out.println(p.visit(prog, null));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		else
			System.out.println("Null");
	}

}
