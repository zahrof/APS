LEXER = /usr/bin/jflex
PARSER = java -jar lib/java-cup-11b.jar
LEX_FILE = flex/lexer.flex
PARS_FILE = cup/parser.cup
JAVAC =  javac
SRC = $(wildcard src/ast/*.java)
LEXER_DEST = src/lexer
PARSER_DEST = src/parser

all: prologTerm

prologTerm: parser Op.java typage.PrologTerm.java
					$(JAVAC) typage.PrologTerm.java

parser: $(PARS_FILE) lexer
	$(PARSER) $(PARS_FILE) -package $(PARSER_DEST) 

lexer: $(LEX_FILE) 
	$(LEXER) $(LEX_FILE) -d $(LEXER_DEST) 

clean:
	rm Parser*.java
	rm Yylex.java
	rm *.class