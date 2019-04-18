%{
  #include<stdio.h>
%}
DIGIT [0-9]+
%%
class 				   {printf("%s: is Class Type\n",yytext);}
[A-Z]+ 				   {printf("%s: is Classname\n",yytext);}
public|private|protected	   {printf("%s: is Scope\n",yytext);}
"static"			   {printf("%s: is Shares program memory\n",yytext);}
main				   {printf("%s: is main funtion\n",yytext);}
"("				   {printf("%s: is opening braces\n",yytext);}
")"				   {printf("%s: is Closing  braces\n",yytext);}
"{"				   {printf("%s: is opening curly braces\n",yytext);}
"}"				   {printf("%s: is Closing  curly braces\n",yytext);}
"System"			    {printf("%s: is System Class\n",yytext);}	
"out"				    {printf("%s: is Static member of System Class\n",yytext);}	
"println"			    {printf("%s: is method in io package\n",yytext);}	
int|float|char|boolean|double|String|void      {printf("%s: is Dataype\n",yytext);}
[a-zA-Z]+            	           {printf("%s: is variale\n",yytext);}	
"="				   {printf("%s: is Assignment operator\n",yytext);}
{DIGIT}				   {printf("%s: is interger value\n",yytext);}
{DIGIT}[.]+{DIGIT}+		   {printf("%s: is float value\n",yytext);}
["][a-zA-Z0-9_]["]		   {printf("%s: is string in sysout\n",yytext);}	  
";"				   {printf("%s: is Semicolon\n",yytext);}
"\n"				   {printf("%s: is new line\n",yytext);}
%%

int yywrap(){return 1;}
int main(int argc,char *argv[]){
 yyin = fopen(argv[1],"r"); 
 yylex();
return 0;
}
