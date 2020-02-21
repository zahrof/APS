%{
import java.io.*;
import java.util.ArrayList;
import ast.*; 
%}

/* Non terminals */
%type <obj> progr
%type <obj> cmds
%type <obj> stat
%type <obj> dec
%type <obj> type
%type <obj> types
%type <obj> arg
%type <obj> args
%type <obj> expr
%type <obj> exprs
%type <sval> op

%token LBAR, RBAR, LPAR, RPAR, SEMCOL, COMMA, STAR, ARROW, TWOPOINTS, EOF
%token TRUE, FALSE, BOOL, INT, IF, CONST, FUN, REC, ECHO, ADD, SUB, MUL, DIV, AND, OR, LT, EQ, NOT
%token <ival> NUM
%token <sval> IDENT

%start progr

%%
/* grammar */
progr:   LBAR cmds RBAR EOF
  {  prog = new AstProgramme((ArrayList<AstCommand>) $2); 
    $$ = prog;} 

cmds:   stat   
          {  ArrayList<AstCommand> l = new ArrayList<AstCommand>(); 
             l.add(0,(AstStatement) $1);
             $$ = l; } 
          | 
          dec SEMCOL cmds
          {((ArrayList<AstCommand>) $3).add(0,(AstDeclaration) $1);
             $$ = $3; }
          |
          stat SEMCOL cmds
          {((ArrayList<AstCommand>) $3).add(0,(AstStatement) $1);
             $$ = $3; }

stat:   ECHO expr
          {  $$ = new AstEcho("ECHO",(AstExpression) $2); }

dec: CONST IDENT type expr
          { $$ = new AstConst($2,(AstType) $3, (AstExpression) $4); }
          |
          FUN IDENT type LBAR args RBAR expr
          { $$ = new AstFun($2,(AstType) $3,(ArrayList<AstArgument>) $5,(AstExpression) $7); }
          |
          FUN REC IDENT type LBAR args RBAR expr
          { $$ = new AstFunRec($3,(AstType) $4,(ArrayList<AstArgument>) $6,(AstExpression) $8); }

type:   BOOL  
          { $$ = new AstBoolType(); }
          |
          INT
          {  $$ = new AstIntType(); }
          |
          LPAR types ARROW type RPAR
          { $$ = new AstFuncType((ArrayList<AstType>) $2,(AstType) $4); }

types: type
          { ArrayList<AstType> l = new ArrayList<AstType>(); 
             l.add(0,(AstType) $1);
             $$ = l; }
          |
          type STAR types
          { ((ArrayList<AstType>) $3).add(0,(AstType) $1);
             $$ = $3; }

arg: IDENT TWOPOINTS type
          { $$ = new AstArgument($1,(AstType) $3); }

args: arg
          { ArrayList<AstArgument> l = new ArrayList<AstArgument>(); 
             l.add(0,(AstArgument) $1);
             $$ = l; }
          |
          arg COMMA args
          { ((ArrayList<AstArgument>) $3).add(0,(AstArgument) $1);
             $$ = $3; }

expr: NUM
          { $$ = new AstNum($1); }
          |
          TRUE
          { $$ = new AstBool(true); }
          |
          FALSE
          { $$ = new AstBool(false); }
          |
          IDENT
          { $$ = new AstVar($1); }
          |
          LPAR IF expr expr expr RPAR
          { $$ = new AstIf((AstExpression) $3,(AstExpression) $4,(AstExpression) $5); }
          |
          LPAR op exprs RPAR
          { $$ = new AstOp($2, (ArrayList<AstExpression>) $3); }
          |
          LBAR args RBAR expr
          { $$ = new AstLambda((ArrayList<AstArgument>) $2, (AstExpression) $4); }
          |
          LPAR expr exprs RPAR
          { $$ = new AstApplication((AstExpression) $2,(ArrayList<AstExpression>) $3); }

op: ADD 
          { $$ = "add"; }
          |
          SUB
          { $$ = "sub"; }
          |
          MUL
          {$$ = "mul"; }
          |
          DIV
          { $$ = "div"; }
          |
          AND
          { $$ = "and"; }
          |
          OR
          { $$ = "or"; }
          |
          NOT
          { $$ = "not"; }
          |
          EQ
          { $$ = "eq"; }
          |
          LT
          { $$ = "lt"; }

exprs: expr
          { ArrayList<AstExpression> l = new ArrayList<AstExpression>(); 
             l.add(0,(AstExpression) $1);
             $$ = l; }
          |
          expr exprs
          {((ArrayList<AstExpression>) $2).add(0,(AstExpression) $1);
             $$ = $2; }

%%
  public AstProgramme prog;

  private Lexer lexer;

  private int yylex () {
	  int yyl_return = -1;
	  try {
		yyl_return = lexer.next_token();
	  }catch (IOException e) {
	    System.err.println("IO error :"+e);
	  }
	  return yyl_return;
  }

  public void yyerror (String error) {
  }

  public Parser(Reader r) {
	lexer = new Lexer(r, this);
  }

  public void parse(){
     yyparse();
  }