%{
	#include<stdio.h>
	void yyerror(char*);
	FILE* yyin;
         int yylex();
%}
%token VERB ADVERB NOUN PRONOUN ADJECTIVE CONJUNCTION PREPOSITION

%%
sentence:compound {printf("COMPOUND STATEMENt");} | simple {printf("SIMPLE STATEMENT");};
compound:subject VERB object CONJUNCTION subject VERB object;
simple:subject VERB object;
subject:NOUN|PRONOUN;
object:NOUN |ADJECTIVE NOUN|ADVERB NOUN|PREPOSITION NOUN;

%%

void yyerror(char *s){
printf(stderr,"Error:",s);

}
int main(int argc,char *argv[])
{
 yyin=fopen(argv[1],"r");
 yyparse();
 fclose(yyin);
return 0;
}

