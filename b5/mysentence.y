%{
     #include<stdio.h>
	void yyerror(char*);
       FILE* yyin;
	int yylex();
%}

%token VERB NOUN PRONOUN ADVERB ADJECTIVE CONJUNCTION PREPOSITION 

%%

sentence : simple {printf("Its is simple statment");}  |  compound {printf("Its is Compound statment");};
simple   : subject VERB object;
compound : subject VERB object CONJUNCTION subject VERB object;
subject  : NOUN|PRONOUN;
object   : NOUN|ADJECTIVE NOUN|ADVERB NOUN|PREPOSITION NOUN;

%%

void yyerror(char *s)
{
printf("ERROR:%s",s);
}
int main(int argc,char* argv[])
{
yyin=fopen(argv[1],"r");
yyparse();
fclose(yyin);
return 0;
}
