//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "parser.y"
  import java.io.*;
  import java.util.ArrayList;
//#line 20 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short NL=257;
public final static short NUM=258;
public final static short TRUE=259;
public final static short FALSE=260;
public final static short IDENT=261;
public final static short PLUS=262;
public final static short MINUS=263;
public final static short TIMES=264;
public final static short DIV=265;
public final static short LT=266;
public final static short EQ=267;
public final static short OR=268;
public final static short AND=269;
public final static short NOT=270;
public final static short IF=271;
public final static short BOOL=272;
public final static short INT=273;
public final static short LPAR=274;
public final static short RPAR=275;
public final static short LBAR=276;
public final static short RBAR=277;
public final static short SEMCOL=278;
public final static short TWOPOINTS=279;
public final static short COMMA=280;
public final static short STAR=281;
public final static short ARROW=282;
public final static short CONST=283;
public final static short FUN=284;
public final static short REC=285;
public final static short ECHO=286;
public final static short types=287;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    3,    3,    1,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    1,    1,    1,    1,    2,    2,
};
final static short yylen[] = {                            2,
    1,    1,    1,    1,    1,    1,    1,    1,    4,    4,
    4,    4,    4,    4,    4,    4,    4,    6,    1,    2,
};
final static short yydefred[] = {                         0,
    5,    6,    7,    8,    3,    4,    0,    0,    2,    1,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   20,    9,   10,   11,   12,   13,   14,   15,   16,
   17,    0,    0,   18,
};
final static short yydgoto[] = {                          8,
   21,   22,   10,
};
final static short yysindex[] = {                      -256,
    0,    0,    0,    0,    0,    0, -229,    0,    0,    0,
 -252, -252, -252, -252, -252, -252, -252, -252, -252, -252,
 -252, -275, -265, -264, -263, -262, -261, -260, -255, -251,
 -252,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0, -252, -250,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
 -249,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    1,   32,    0,
};
final static int YYTABLESIZE=53;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         33,
    9,    1,    2,    3,    4,    1,    2,    3,    4,   34,
   35,   36,   37,   38,   39,    5,    6,    7,    0,   40,
   31,    7,    0,   41,   44,   19,    0,    0,    0,    0,
    0,   42,   11,   12,   13,   14,   15,   16,   17,   18,
   19,   20,   43,   23,   24,   25,   26,   27,   28,   29,
   30,    0,   32,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                        275,
    0,  258,  259,  260,  261,  258,  259,  260,  261,  275,
  275,  275,  275,  275,  275,  272,  273,  274,   -1,  275,
   20,  274,   -1,  275,  275,  275,   -1,   -1,   -1,   -1,
   -1,   31,  262,  263,  264,  265,  266,  267,  268,  269,
  270,  271,   42,   12,   13,   14,   15,   16,   17,   18,
   19,   -1,   21,
};
}
final static short YYFINAL=8;
final static short YYMAXTOKEN=287;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"NL","NUM","TRUE","FALSE","IDENT","PLUS","MINUS","TIMES","DIV",
"LT","EQ","OR","AND","NOT","IF","BOOL","INT","LPAR","RPAR","LBAR","RBAR",
"SEMCOL","TWOPOINTS","COMMA","STAR","ARROW","CONST","FUN","REC","ECHO","types",
};
final static String yyrule[] = {
"$accept : line",
"line : type",
"line : expr",
"type : BOOL",
"type : INT",
"expr : NUM",
"expr : TRUE",
"expr : FALSE",
"expr : IDENT",
"expr : LPAR PLUS exprs RPAR",
"expr : LPAR MINUS exprs RPAR",
"expr : LPAR TIMES exprs RPAR",
"expr : LPAR DIV exprs RPAR",
"expr : LPAR LT exprs RPAR",
"expr : LPAR EQ exprs RPAR",
"expr : LPAR OR exprs RPAR",
"expr : LPAR AND exprs RPAR",
"expr : LPAR NOT exprs RPAR",
"expr : LPAR IF expr expr expr RPAR",
"exprs : expr",
"exprs : expr exprs",
};

//#line 69 "parser.y"
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
//#line 251 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 36 "parser.y"
{prog=(Ast)val_peek(0).obj; yyval.obj=val_peek(0).obj; }
break;
case 2:
//#line 37 "parser.y"
{ prog=(Ast)val_peek(0).obj; yyval.obj=val_peek(0).obj; }
break;
case 3:
//#line 42 "parser.y"
{ yyval.obj = new AstType(Tprim.BOOL); }
break;
case 4:
//#line 43 "parser.y"
{ yyval.obj = new AstType(Tprim.INT); }
break;
case 5:
//#line 49 "parser.y"
{ yyval.obj = new AstNum(val_peek(0).ival); }
break;
case 6:
//#line 50 "parser.y"
{ yyval.obj = new AstBool(cBool.TRUE); }
break;
case 7:
//#line 51 "parser.y"
{ yyval.obj = new AstBool(cBool.FALSE); }
break;
case 8:
//#line 52 "parser.y"
{ yyval.obj = new AstId(val_peek(0).sval); }
break;
case 9:
//#line 53 "parser.y"
{ yyval.obj = new AstPrim(Op.ADD,(ArrayList<Ast>)val_peek(1).obj); }
break;
case 10:
//#line 54 "parser.y"
{ yyval.obj = new AstPrim(Op.SUB,(ArrayList<Ast>)val_peek(1).obj); }
break;
case 11:
//#line 55 "parser.y"
{ yyval.obj = new AstPrim(Op.MUL,(ArrayList<Ast>)val_peek(1).obj); }
break;
case 12:
//#line 56 "parser.y"
{ yyval.obj = new AstPrim(Op.DIV,(ArrayList<Ast>)val_peek(1).obj); }
break;
case 13:
//#line 57 "parser.y"
{ yyval.obj = new AstPrim(Op.LT,(ArrayList<Ast>)val_peek(1).obj); }
break;
case 14:
//#line 58 "parser.y"
{ yyval.obj = new AstPrim(Op.EQ,(ArrayList<Ast>)val_peek(1).obj); }
break;
case 15:
//#line 59 "parser.y"
{ yyval.obj = new AstPrim(Op.OR,(ArrayList<Ast>)val_peek(1).obj); }
break;
case 16:
//#line 60 "parser.y"
{ yyval.obj = new AstPrim(Op.AND,(ArrayList<Ast>)val_peek(1).obj); }
break;
case 17:
//#line 61 "parser.y"
{ yyval.obj = new AstPrim(Op.NOT,(ArrayList<Ast>)val_peek(1).obj); }
break;
case 18:
//#line 62 "parser.y"
{ yyval.obj = new AstIf((Ast)val_peek(3).obj,(Ast)val_peek(2).obj,(Ast)val_peek(1).obj ); }
break;
case 19:
//#line 65 "parser.y"
{ ArrayList<Ast> r = new ArrayList<Ast>(); r.add((Ast)val_peek(0).obj); yyval.obj = r; }
break;
case 20:
//#line 66 "parser.y"
{ ((ArrayList<Ast>)val_peek(1).obj).add((Ast)val_peek(0).obj); yyval.obj = val_peek(0).obj; }
break;
//#line 480 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
