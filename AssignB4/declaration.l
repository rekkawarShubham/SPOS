%{
#include<stdio.h>
#include "y.tab.h"
%}

DIGIT [0-9]
%%
int 			{printf("%s is a datatype\n",yytext);return(INT);}
float			{printf("%s is a datatype\n",yytext);return(FLOAT);}
char 			{printf("%s is a datatype\n",yytext);return(CHAR);}
['][^\n\t][']		{printf("%s is a character variiable",yytext);return(CHVAL);}
boolean 		{printf("%s is Boolean datatype",yytext);return(BL);}
true|false   		{printf("%s is bool",yytext);return(BLVAL);}
[a-zA-Z]+[a-zA-Z0-9_]*	{printf("%s is a variable\n",yytext);return(VD);}		
"="                     {printf("%s is assignment operator\n",yytext);return(AS);}
{DIGIT}+		{printf("%s is digit\n",yytext);return(INTD);}
{DIGIT}+[.]{DIGIT}*	{printf("%s is a float\n",yytext);return(REAL);}
";"			{printf("%s: is a SEMICOLON\n",yytext);return(SC);}	
","			{printf("%s: is a COMMA\n",yytext);return(COMMA);}	
"\n"			return NL;

%%
int yywrap(){return 1;}


