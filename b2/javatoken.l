%{
	#include<stdio.h>
%}
DIGIT [0-9]*

%%
{DIGIT}			{printf("\n%s:It is a digit",yytext);}
int|float|String 	{printf("\n %s:It is a datatype",yytext);}
"="			{printf("\n %s:It is assignment operator",yytext);}
[a-zA-Z]		{printf("\n %s:It is variable",yytext);}
";"			{printf("\n%s:It is a semicolon",yytext);}
"\n"		return 0;
%%


int yywrap(){return 1;}
int main()
{
	printf("Enter the java Statement:");
	yylex();
}

