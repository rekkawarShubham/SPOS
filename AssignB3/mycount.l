%{
   #include<stdio.h>
  int lcount=0,wcount=0,ccount=0;
%}

%%

"\n"		{lcount++;} 
[^ \n\t]+       {wcount++,ccount+=yyleng;}
.		{ccount++;}
%%
int yywrap(){return 1;}
int main(int argc,char* argv[])
{
  yyin = fopen(argv[1],"r");
  yylex();
  printf("Line Count=%d\nWord Count=%d\nChar Count=%d\n",lcount,wcount,ccount);
   return 0;
}

