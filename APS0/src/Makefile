LEX_J = /usr/bin/jflex
YACC_J = ./yacc.linux -J
JAVAC =  javac

prologTerm: parser Op.java PrologTerm.java
					$(JAVAC) PrologTerm.java

parser: parser.y lexer.lex
			$(LEX_J) lexer.lex
			$(YACC_J) parser.y

clean:
	rm Parser*.java
	rm Yylex.java
	rm *.class