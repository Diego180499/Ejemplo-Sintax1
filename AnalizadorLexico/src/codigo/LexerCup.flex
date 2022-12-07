package codigo;
import java_cup.runtime.Symbol;

%%

%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

digit = [0-9]
letter = [a-zA-Z]
whitespace = [ \t\r\n]

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}

%%


"Evaluar"                     {return new Symbol(sym.EVALUAR, yychar, yyline, yytext());}
"("                           {return new Symbol(sym.PAR_A,yychar, yyline, yytext());}
")"                           {return new Symbol(sym.PAR_C,yychar, yyline, yytext());}
"+"                           {return new Symbol(sym.PLUS,yychar, yyline, yytext());}
","                           {return new Symbol(sym.COMA,yychar, yyline, yytext());}
{letter}({letter}|{digit})*     {return new Symbol(sym.ID,yychar, yyline, yytext());}
{digit}+                        {return new Symbol(sym.NUM,yychar, yyline, yytext());}
{whitespace}+     {/*Ignore*/}
[^]                             {return new Symbol(sym.ERROR,yychar, yyline, yytext());}

