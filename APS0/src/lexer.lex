%%

%byaccj

%{
	private Parser yyparser;
	
	public Yylex(java.io.Reader r, Parser yyparser) {
		this(r);
		this.yyparser = yyparser;
	}
%}

nums = -?[0-9]+
ident = [a-z][a-zA-Z0-9]*
nls  = \n | \r | \r\n

%%

/* booleans */
"true" { return Parser.TRUE; }
"false" { return Parser.FALSE; }

/* operators */
"add"  { return Parser.PLUS; }
"sub"  { return Parser.MINUS; }
"mul"  { return Parser.TIMES; }
"div"  { return Parser.DIV; }
"and"  { return Parser.AND; }
"or"  { return Parser.OR; }
"eq"  { return Parser.EQ; }
"lt"  { return Parser.LT; }
"not" { return Parser.NOT; }

/* tprim */
"bool" { return Parser.BOOL; }
"int" { return Parser.INT; }

/* parenthesis */
"("  { return Parser.LPAR; }
")"  { return Parser.RPAR; }

/* brackets */
"["  { return Parser.LBAR; }
"]"  { return Parser.RBAR; }

/* semicolon */
";"  { return Parser.SEMCOL; }

/* two-points */
":"  { return Parser.TWOPOINTS; }

/* comma */
","  { return Parser.COMMA; }

/* STAR */
"*"  { return Parser.STAR; }

/* arrow */
"->"  { return Parser.ARROW; }

/* newline */
{nls}   { return 0; } //{ return Parser.NL; }

/* if */
"if" { return Parser.IF; }

/* float */
{nums}  { yyparser.yylval = new ParserVal(Integer.parseInt(yytext()));
	return Parser.NUM; }
	
{ident} { yyparser.yylval = new ParserVal(yytext());
	return Parser.IDENT;}

/* for functions */
"CONST"  { return Parser.CONST; }
"FUN"  { return Parser.FUN; }
"REC"  { return Parser.REC; }

/* to print */
"ECHO"  { return Parser.ECHO; }
	
/* whitespace */
[ \t]+ { }

\b     { System.err.println("Sorry, backspace doesn’t work"); }

/* error fallback */
[^]    { System.err.println("Error: unexpected character ’"+yytext()+"’"); return -1; }
