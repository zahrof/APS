package lexer;
import java_cup.runtime.*;

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

/* regulars expressions */

entier = -?[0-9]+
identifier = [a-z][a-zA-Z0-9]*
eol  = \n | \r | \r\n

%%

/* booleans */
"true" { return symbol(sym.TRUE); }
"false" { return  symbol(sym.FALSE); }

/* operators */
"add"  { return symbol(sym.PLUS); }
"sub"  { return symbol(sym.MINUS); }
"mul"  { return symbol(sym.TIMES); }
"div"  { return symbol(sym.DIV); }
"and"  { return symbol(sym.AND); }
"or"  { return symbol(sym.OR); }
"eq"  { return symbol(sym.EQ); }
"lt"  { return symbol(sym.LT); }
"not" { return symbol(sym.NOT); }

/* types */
"bool" { return symbol(sym.BOOL); }
"int" { return symbol(sym.INT); }

/* parenthesis */
"("  { return symbol(sym.LPAR); }
")"  { return symbol(sym.RPAR); }

/* brackets */
"["  { return symbol(sym.LBAR); }
"]"  { return symbol(sym.RBAR); }

/* semicolon */
";"  { return symbol(sym.SEMCOL); }

/* two-points */
":"  { return symbol(sym.DIV); }

/* comma */
","  { return symbol(sym.COMMA); }

/* STAR */
"*"  { return symbol(sym.STAR); }

/* arrow */
"->"  { return symbol(sym.ARROW); }

/* newline */
{eol}   { /* ignore */ } 

/* if */
"if" { return symbol(sym.IF); }

/* entiers */
{entier}  {return symbol(sym.NUM, Integer.ParseInt(yytext())); }

/* identifier */
{identifier} { return symbol(sym.IDENT, yytext());}

/* for functions */
"CONST"  { return symbol(sym.CONST); }
"FUN"  { return symbol(sym.FUN); }
"REC"  { return symbol(sym.REC); }

/* to print */
"ECHO"  { return symbol(sym.ECHO); }

/* whitespace */
[ \t]+ { }

\b     { System.err.println("Sorry, backspace doesn’t work"); }

/* error fallback */
[^]    { System.err.println("Error: unexpected character ’"+yytext()+"’"); return null; }
