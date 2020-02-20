
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package parser;

import java.io.*;
import java_cup.runtime.*;
import java.util.ArrayList;
import lexer.Lexer;
import ast.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ParserSym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\033\000\002\002\004\000\002\002\005\000\002\003" +
    "\004\000\002\003\005\000\002\003\005\000\002\004\004" +
    "\000\002\005\006\000\002\005\011\000\002\005\012\000" +
    "\002\006\003\000\002\006\003\000\002\006\007\000\002" +
    "\007\003\000\002\007\005\000\002\010\005\000\002\011" +
    "\003\000\002\011\005\000\002\012\003\000\002\012\003" +
    "\000\002\012\003\000\002\012\003\000\002\012\010\000" +
    "\002\012\006\000\002\012\006\000\002\012\006\000\002" +
    "\013\003\000\002\013\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\107\000\004\004\004\001\002\000\010\022\007\023" +
    "\013\025\012\001\002\000\004\002\006\001\002\000\004" +
    "\002\001\001\002\000\004\030\107\001\002\000\004\005" +
    "\106\001\002\000\020\004\037\006\036\010\103\015\035" +
    "\016\040\027\034\030\041\001\002\000\016\004\037\006" +
    "\036\015\035\016\040\027\034\030\041\001\002\000\006" +
    "\024\017\030\020\001\002\000\004\010\015\001\002\000" +
    "\010\022\007\023\013\025\012\001\002\000\004\005\ufffe" +
    "\001\002\000\004\030\074\001\002\000\010\006\021\017" +
    "\023\020\024\001\002\000\010\006\021\017\023\020\024" +
    "\001\002\000\004\004\025\001\002\000\030\004\ufff8\005" +
    "\ufff8\006\ufff8\007\ufff8\011\ufff8\012\ufff8\013\ufff8\015\ufff8" +
    "\016\ufff8\027\ufff8\030\ufff8\001\002\000\030\004\ufff7\005" +
    "\ufff7\006\ufff7\007\ufff7\011\ufff7\012\ufff7\013\ufff7\015\ufff7" +
    "\016\ufff7\027\ufff7\030\ufff7\001\002\000\004\030\030\001" +
    "\002\000\006\005\ufff2\011\063\001\002\000\004\005\033" +
    "\001\002\000\004\014\031\001\002\000\010\006\021\017" +
    "\023\020\024\001\002\000\006\005\ufff3\011\ufff3\001\002" +
    "\000\016\004\037\006\036\015\035\016\040\027\034\030" +
    "\041\001\002\000\024\004\ufff0\005\ufff0\006\ufff0\007\ufff0" +
    "\010\ufff0\015\ufff0\016\ufff0\027\ufff0\030\ufff0\001\002\000" +
    "\024\004\uffef\005\uffef\006\uffef\007\uffef\010\uffef\015\uffef" +
    "\016\uffef\027\uffef\030\uffef\001\002\000\022\004\037\006" +
    "\036\015\035\016\040\021\047\026\046\027\034\030\041" +
    "\001\002\000\004\030\030\001\002\000\024\004\uffee\005" +
    "\uffee\006\uffee\007\uffee\010\uffee\015\uffee\016\uffee\027\uffee" +
    "\030\uffee\001\002\000\024\004\uffed\005\uffed\006\uffed\007" +
    "\uffed\010\uffed\015\uffed\016\uffed\027\uffed\030\uffed\001\002" +
    "\000\004\010\ufffa\001\002\000\004\005\044\001\002\000" +
    "\016\004\037\006\036\015\035\016\040\027\034\030\041" +
    "\001\002\000\024\004\uffea\005\uffea\006\uffea\007\uffea\010" +
    "\uffea\015\uffea\016\uffea\027\uffea\030\uffea\001\002\000\016" +
    "\004\037\006\036\015\035\016\040\027\034\030\041\001" +
    "\002\000\016\004\037\006\036\015\035\016\040\027\034" +
    "\030\041\001\002\000\016\004\037\006\036\015\035\016" +
    "\040\027\034\030\041\001\002\000\020\004\037\006\036" +
    "\007\uffe8\015\035\016\040\027\034\030\041\001\002\000" +
    "\004\007\053\001\002\000\024\004\uffe9\005\uffe9\006\uffe9" +
    "\007\uffe9\010\uffe9\015\uffe9\016\uffe9\027\uffe9\030\uffe9\001" +
    "\002\000\004\007\uffe7\001\002\000\016\004\037\006\036" +
    "\015\035\016\040\027\034\030\041\001\002\000\016\004" +
    "\037\006\036\015\035\016\040\027\034\030\041\001\002" +
    "\000\004\007\060\001\002\000\024\004\uffec\005\uffec\006" +
    "\uffec\007\uffec\010\uffec\015\uffec\016\uffec\027\uffec\030\uffec" +
    "\001\002\000\004\007\062\001\002\000\024\004\uffeb\005" +
    "\uffeb\006\uffeb\007\uffeb\010\uffeb\015\uffeb\016\uffeb\027\uffeb" +
    "\030\uffeb\001\002\000\004\030\030\001\002\000\004\005" +
    "\ufff1\001\002\000\004\013\071\001\002\000\006\012\067" +
    "\013\ufff5\001\002\000\010\006\021\017\023\020\024\001" +
    "\002\000\004\013\ufff4\001\002\000\010\006\021\017\023" +
    "\020\024\001\002\000\004\007\073\001\002\000\030\004" +
    "\ufff6\005\ufff6\006\ufff6\007\ufff6\011\ufff6\012\ufff6\013\ufff6" +
    "\015\ufff6\016\ufff6\027\ufff6\030\ufff6\001\002\000\010\006" +
    "\021\017\023\020\024\001\002\000\004\004\076\001\002" +
    "\000\004\030\030\001\002\000\004\005\100\001\002\000" +
    "\016\004\037\006\036\015\035\016\040\027\034\030\041" +
    "\001\002\000\004\010\ufff9\001\002\000\020\004\ufffc\006" +
    "\ufffc\010\ufffc\015\ufffc\016\ufffc\027\ufffc\030\ufffc\001\002" +
    "\000\010\022\007\023\013\025\012\001\002\000\004\005" +
    "\uffff\001\002\000\004\005\ufffd\001\002\000\004\002\000" +
    "\001\002\000\010\006\021\017\023\020\024\001\002\000" +
    "\016\004\037\006\036\015\035\016\040\027\034\030\041" +
    "\001\002\000\004\010\ufffb\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\107\000\004\002\004\001\001\000\010\003\007\004" +
    "\010\005\013\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\012\103\001" +
    "\001\000\004\012\101\001\001\000\002\001\001\000\002" +
    "\001\001\000\010\003\015\004\010\005\013\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\006\021\001\001" +
    "\000\006\006\065\007\064\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\010\025\011\026" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\006\031\001\001\000\002\001\001\000\004" +
    "\012\041\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\012\047\001\001\000\006\010\025\011\042\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\012\044\001\001\000\002\001\001" +
    "\000\006\012\050\013\060\001\001\000\004\012\054\001" +
    "\001\000\006\012\050\013\051\001\001\000\006\012\050" +
    "\013\053\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\012\055\001\001\000\004\012\056" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\010\025\011\063\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\006\065\007\067\001\001\000\002\001\001\000\004" +
    "\006\071\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\006\074\001\001\000\002\001\001\000\006\010\025" +
    "\011\076\001\001\000\002\001\001\000\004\012\100\001" +
    "\001\000\002\001\001\000\002\001\001\000\010\003\104" +
    "\004\010\005\013\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\006\107\001\001\000\004" +
    "\012\110\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



  public Parser (java.io.Reader input) {
    super(new Lexer(input));
  }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= prog EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AstProgramme start_val = (AstProgramme)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // prog ::= LBAR cmds RBAR 
            {
              AstProgramme RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		ArrayList<AstCommand> c = (ArrayList<AstCommand>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AstProgramme(c); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("prog",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // cmds ::= stat expr 
            {
              ArrayList<AstCommand> RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AstStatement s = (AstStatement)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 ArrayList<AstCommand> l = new ArrayList<AstCommand>(); 
             l.add(0,s);
             RESULT = l; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("cmds",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // cmds ::= dec SEMCOL cmds 
            {
              ArrayList<AstCommand> RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AstDeclaration d = (AstDeclaration)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int csleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int csright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ArrayList<AstCommand> cs = (ArrayList<AstCommand>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 cs.add(0,d);
             RESULT = cs; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("cmds",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // cmds ::= stat SEMCOL cmds 
            {
              ArrayList<AstCommand> RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AstStatement s = (AstStatement)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int csleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int csright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ArrayList<AstCommand> cs = (ArrayList<AstCommand>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 cs.add(0,s);
             RESULT = cs; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("cmds",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // stat ::= ECHO expr 
            {
              AstStatement RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AstExpression e = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AstEcho("ECHO",e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stat",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // dec ::= CONST IDENT type expr 
            {
              AstDeclaration RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AstType t = (AstType)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AstExpression e = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AstConst(id,t,e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("dec",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // dec ::= FUN IDENT type LBAR args RBAR expr 
            {
              AstDeclaration RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		AstType t = (AstType)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int asleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int asright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		ArrayList<AstArgument> as = (ArrayList<AstArgument>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AstExpression e = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AstFun(id,t,as,e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("dec",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // dec ::= FUN REC IDENT type LBAR args RBAR expr 
            {
              AstDeclaration RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		AstType t = (AstType)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int asleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int asright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		ArrayList<AstArgument> as = (ArrayList<AstArgument>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AstExpression e = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AstFunRec(id,t,as,e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("dec",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // type ::= BOOL 
            {
              AstType RESULT =null;
		 RESULT = new AstBoolType(); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // type ::= INT 
            {
              AstType RESULT =null;
		 RESULT = new AstIntType(); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // type ::= LPAR types ARROW type RPAR 
            {
              AstType RESULT =null;
		int targsleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int targsright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		ArrayList<AstType> targs = (ArrayList<AstType>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int tresleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int tresright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AstType tres = (AstType)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AstFuncType(targs,tres); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // types ::= type 
            {
              ArrayList<AstType> RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AstType t = (AstType)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 ArrayList<AstType> l = new ArrayList<AstType>(); 
             l.add(0,t);
             RESULT = l; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("types",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // types ::= type STAR types 
            {
              ArrayList<AstType> RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AstType t = (AstType)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int tsleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tsright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ArrayList<AstType> ts = (ArrayList<AstType>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 ts.add(0,t);
             RESULT = ts; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("types",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // arg ::= IDENT TWOPOINTS type 
            {
              AstArgument RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AstType t = (AstType)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AstArgument(id,t); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("arg",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // args ::= arg 
            {
              ArrayList<AstArgument> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AstArgument a = (AstArgument)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 ArrayList<AstArgument> l = new ArrayList<AstArgument>(); 
             l.add(0,a);
             RESULT = l; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("args",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // args ::= arg COMMA args 
            {
              ArrayList<AstArgument> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AstArgument a = (AstArgument)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int asleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int asright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ArrayList<AstArgument> as = (ArrayList<AstArgument>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 as.add(0,a); 
             RESULT = as; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("args",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expr ::= NUM 
            {
              AstExpression RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer i = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AstNum(i); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expr ::= TRUE 
            {
              AstExpression RESULT =null;
		 RESULT = new AstBool(true); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expr ::= FALSE 
            {
              AstExpression RESULT =null;
		 RESULT = new AstBool(false); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expr ::= IDENT 
            {
              AstExpression RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String v = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AstVar(v); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expr ::= LPAR IF expr expr expr RPAR 
            {
              AstExpression RESULT =null;
		int condleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int condright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		AstExpression cond = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int consleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int consright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AstExpression cons = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int altleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int altright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AstExpression alt = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AstIf(cond,cons,alt); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expr ::= LPAR OPRIM exprs RPAR 
            {
              AstExpression RESULT =null;
		int oleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String o = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int esleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int esright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		ArrayList<AstExpression> es = (ArrayList<AstExpression>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AstOp(o,es); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expr ::= LBAR args RBAR expr 
            {
              AstExpression RESULT =null;
		int asleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int asright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		ArrayList<AstArgument> as = (ArrayList<AstArgument>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AstExpression e = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AstLambda(as,e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // expr ::= LPAR expr exprs RPAR 
            {
              AstExpression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AstExpression e = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int esleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int esright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		ArrayList<AstExpression> es = (ArrayList<AstExpression>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AstApplication(e,es); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // exprs ::= expr 
            {
              ArrayList<AstExpression> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AstExpression e = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 ArrayList<AstExpression> l = new ArrayList<AstExpression>(); 
             l.add(0,e);
             RESULT = l; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("exprs",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // exprs ::= expr exprs 
            {
              ArrayList<AstExpression> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AstExpression e = (AstExpression)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int esleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int esright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		ArrayList<AstExpression> es = (ArrayList<AstExpression>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 es.add(0,e);
             RESULT = es; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("exprs",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
