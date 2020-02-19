%{
  import java.io.*;
  import java.util.ArrayList;
%}

%token NL                    /* newline  */
%token <ival> NUM            /* a number */
%token TRUE           	     /* the true boolean */
%token FALSE           	     /* the false boolean */
%token <sval> IDENT          /* an identifier */
%token PLUS MINUS TIMES DIV LT EQ OR AND NOT /* operators */
%token IF 		/* if */
%token BOOL			/* tprim */
%token INT 	    		 /* tprim */
%token LPAR RPAR             /* parethesis */
%token LBAR RBAR             /* brackets */
%token SEMCOL		     /* semicolon */
%token TWOPOINTS	     /* two points : */
%token COMMA 		     /* comma  */
%token STAR 		     /* STAR * */
%token ARROW                 /* ARROW -> */
%token CONST FUN REC	    /* for functions */
%token ECHO 		    /* to print */


%type <obj> line
%type <obj> expr
%type <obj> exprs
%type <obj> type
%type <obj> types

%start line
%%

line: LBRA cmds  RBRA { prog=(Ast)$2; $$=$2; }

cmds: stat
| dec SEMCOL cmds
| stat SEMCOL cmds

type:
BOOL  { $$ = new AstType(Tprim.BOOL); }
| INT { $$ = new AstType(Tprim.INT); }
| LPAR types ARROW type RPAR { $$ = new AstType((ArrayList<Ast>)$2, $); }

types:
type { ArrayList<Ast> r = new ArrayList<Ast>(); t.add((Ast)$1); $$ = t  ; }
| type STAR types    { ((ArrayList<Ast>)$1).add((Ast)$3); $$ = $3; }

arg:
| IDENT TWOPOINTS type

args:
arg
| arg COMMA args

dec: CONST IDENT type expr
| FUN IDENT type LBRA args RBRA expr
| FUN REC IDENT type LBRA args RBRA expr

stat: ECHO expr


expr:
  NUM                      { $$ = new AstNum($1); }
| TRUE 			{ $$ = new AstBool(cBool.TRUE); }
| FALSE			{ $$ = new AstBool(cBool.FALSE); }
| IDENT                    { $$ = new AstId($1); }
| LPAR PLUS exprs RPAR   { $$ = new AstPrim(Op.ADD,(ArrayList<Ast>)$3); }
| LPAR MINUS exprs RPAR  { $$ = new AstPrim(Op.SUB,(ArrayList<Ast>)$3); }
| LPAR TIMES exprs RPAR  { $$ = new AstPrim(Op.MUL,(ArrayList<Ast>)$3); }
| LPAR DIV exprs RPAR    { $$ = new AstPrim(Op.DIV,(ArrayList<Ast>)$3); }
| LPAR LT exprs RPAR    { $$ = new AstPrim(Op.LT,(ArrayList<Ast>)$3); }
| LPAR EQ exprs RPAR    { $$ = new AstPrim(Op.EQ,(ArrayList<Ast>)$3); }
| LPAR OR exprs RPAR    { $$ = new AstPrim(Op.OR,(ArrayList<Ast>)$3); }
| LPAR AND exprs RPAR    { $$ = new AstPrim(Op.AND,(ArrayList<Ast>)$3); }
| LPAR NOT exprs RPAR    { $$ = new AstPrim(Op.NOT,(ArrayList<Ast>)$3); }
| LPAR IF expr expr expr RPAR  { $$ = new AstIf((Ast)$3,(Ast)$4,(Ast)$5 ); }
;
exprs:
expr                   { ArrayList<Ast> r = new ArrayList<Ast>(); r.add((Ast)$1); $$ = r; }
| expr exprs           { ((ArrayList<Ast>)$1).add((Ast)$2); $$ = $2; }
;
%%
  public Ast prog;

  private Yylex lexer;

  private int yylex () {
	  int yyl_return = -1;
	  try {
		yylval = new ParserVal(0);
		yyl_return = lexer.yylex();
	  }catch (IOException e) {
	    System.err.println("IO error :"+e);
	  }
	  return yyl_return;
  }

  public void yyerror (String error) {
	System.err.println ("Error: " + error);
  }

  public Parser(Reader r) {
	lexer = new Yylex(r, this);
  }