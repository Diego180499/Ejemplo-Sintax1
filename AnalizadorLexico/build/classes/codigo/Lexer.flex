package codigo;

import java.io.*;

%%
%public
%class MiLexer

digit = [0-9]
letter = [a-zA-Z]
whitespace = [ \t\r\n]

%type Token

%eofval{
    
    return new Token(TokenConstant.EOF, null);

%eofval}


%%


"Evaluar"                     {return new Token(TokenConstant.EVALUAR, yytext());}
"("                           {return new Token(TokenConstant.PAR_A, yytext());}
")"                           {return new Token(TokenConstant.PAR_C, yytext());}
"+"                           {return new Token(TokenConstant.PLUS, yytext());}
","                           {return new Token(TokenConstant.COMA, yytext());}
{letter}({letter}|{digit})*     {return new Token(TokenConstant.ID, yytext());}
{digit}+                        {return new Token(TokenConstant.NUM, yytext());}
{whitespace}+     {/*Ignore*/}
[^]                             {return new Token(TokenConstant.ERROR, yytext());}
