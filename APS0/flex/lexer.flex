package lexer;
import java_cup.runtime.*;
import parser.*;

%%

%class Lexer
%public
%unicode
%line
%column
%cup

%{
	private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

%eofval{
    return symbol(ParserSym.EOF);
%eofval}

/* regulars expressions */

entier = -?[0-9]+
identifier = [a-z][a-zA-Z0-9]*
eol  = \n | \r | \r\n

%%

/* booleans */
"true" { return symbol(ParserSym.TRUE); }
"false" { return  symbol(ParserSym.FALSE); }

/* operators */
"add"  { return symbol(ParserSym.OPRIM,"add"); }
"sub"  { return symbol(ParserSym.OPRIM, "sub"); }
"mul"  { return symbol(ParserSym.OPRIM, "mul"); }
"div"  { return symbol(ParserSym.OPRIM, "div"); }
"and"  { return symbol(ParserSym.OPRIM, "and"); }
"or"  { return symbol(ParserSym.OPRIM, "or"); }
"eq"  { return symbol(ParserSym.OPRIM, "eq"); }
"lt"  { return symbol(ParserSym.OPRIM, "lt"); }
"not" { return symbol(ParserSym.OPRIM, "not"); }

/* types */
"bool" { return symbol(ParserSym.BOOL); }
"int" { return symbol(ParserSym.INT); }

/* parenthesis */
"("  { return symbol(ParserSym.LPAR); }
")"  { return symbol(ParserSym.RPAR); }

/* brackets */
"["  { return symbol(ParserSym.LBAR); }
"]"  { return symbol(ParserSym.RBAR); }

/* semicolon */
";"  { return symbol(ParserSym.SEMCOL); }

/* two-points */
":"  { return symbol(ParserSym.TWOPOINTS); }

/* comma */
","  { return symbol(ParserSym.COMMA); }

/* STAR */
"*"  { return symbol(ParserSym.STAR); }

/* arrow */
"->"  { return symbol(ParserSym.ARROW); }

/* newline */
{eol}   { /* ignore */ } 

/* if */
"if" { return symbol(ParserSym.IF); }

/* entiers */
{entier}  {return symbol(ParserSym.NUM, Integer.parseInt(yytext())); }

/* identifier */
{identifier} { return symbol(ParserSym.IDENT, yytext());}

/* for functions */
"CONST"  { return symbol(ParserSym.CONST); }
"FUN"  { return symbol(ParserSym.FUN); }
"REC"  { return symbol(ParserSym.REC); }

/* to print */
"ECHO"  { return symbol(ParserSym.ECHO); }

/* whitespace */
[ \t]+ { }

\b     { System.err.println("Sorry, backspace doesn’t work"); }

/* error fallback */
[^]    { System.err.println("Error: unexpected character ’"+yytext()+"’"); return null; }
