%{
#include<stdio.h>
int lcount=0,ccount=0,wcount=0;
%}
%%
"\n"		{lcount++;}
[^ \n\t]+       {wcount++,ccount+=yyleng;}

%%
int yywrap(){return 1;}
int main(int argc,char*argv[]){
	yyin=fopen(argv[1],"r");
	yylex();
	printf("\nLine=%d\nWord Count=%d\nCharacter Count=%d",lcount,wcount,ccount);
	return 0;
}
