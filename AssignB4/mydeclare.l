%{
    #include<stdio.h>
    #include "y.tab.h"
%}
DIGIT [0-9]

%%
int                 {printf("%s: It is int",yytext);return INTD;}
{DIGIT}*            {printf("%s: It is int val",yytext);return DIGI;}

float               {printf("%s: It is float",yytext);return FD;}
{DIGIT}[.]+{DIGIT}* {printf("%s: It is Real Value ",yytext);return REAL;} 
[a-zA-Z]+[a-zA-Z0-9_]* {printf("%s: It is vAR",yytext);return VD;} 
char                {printf("%s: It is char",yytext);return CHAR;}
['][a-zA-Z][']      {printf("%s: It is char val",yytext);return CHVAL;}
boolean 	    {printf("%s: It is boolean",yytext);return BOOL;}
true|false	    {printf("%s: It is boolm val",yytext);return BLVAL;}
","		    {printf("%s: It is Comma",yytext);return COMMA;}
"="		    {printf("%s: It is Assignment",yytext);return ASSIGN;}
";"		    {printf("%s: It is Semilon",yytext);return SC;}
"\n"		    return NL;

%%
int yywrap(){return 1;}




