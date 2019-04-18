%{
    #include<stdio.h>
%}
 
%%
int|float|char        {printf("%s: This datatype\n",yytext);}
[0-9]*		      {printf("%s : It is digit\n",yytext);}
"="		      {printf("%s: this assignment operator\n",yytext);}
[a-zA-Z]	      {printf("%s: this variable\n",yytext);}		
";"		      {printf("%s: this is semicolon\n",yytext);}		
"\n"			return 0;

%%
int yywrap(){return 1;}
int main(){
    yylex();
   return 0;
}
