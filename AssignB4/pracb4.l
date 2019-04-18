%{
   #include<stdio.h>
   #include "y.tab.h"
%}

DIGIT [0-9] 
%%
int 			{printf("%s: is Integer datatype\n",yytext); return INT;}
float 			{printf("%s: is float datatype\n",yytext); return FLOAT;}
char 			{printf("%s: is Character datatype\n",yytext); return CHAR;}
boolean 		{printf("%s: is Boolean datatype\n",yytext); return BL;}
{DIGIT}			{printf("%s: is Integer value",yytext); return INTD; }
{DIGIT}[.]+{DIGIT}*     {printf("%s: is real value",yytext); return FD; }
['][^\n\t][']		{printf("%s: is char value",yytext); return CHVAL;}
true|false		{printf("%s: is bool value",yytext); return BLVAL;}
[a-zA-Z]+[a-zA-Z0-9_]*   {printf("%s: is variable",yytext); return VD;}
"="			{printf("%s: is Assignment operator",yytext); return AS;}
","		{printf("%s: is Comma",yytext); return COMMA;}
";"			{printf("%s: is Semicolon",yytext); return SC;}
"\n"			return NL;
%%
int yywrap(){return 1;}
