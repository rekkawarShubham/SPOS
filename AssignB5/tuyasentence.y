%{
   #include<stdio.h>
   void yyerror(char*);
   int yylex();
   FILE* yyin;
%}

%token NOUN PRONOUN VERB ADVERB ADJECTIVE PREPOSITION CONJUNCTION

%%

sentence :  simple {printf("This is simple statement\n");} | compound {printf("This is compound statement\n");} ;
simple   :  subject VERB object;
compound : subject VERB object CONJUNCTION subject VERB object;
subject  : NOUN|PRONOUN;
object   : NOUN|ADJECTIVE NOUN|ADVERB NOUN|PREPOSITION NOUN;


%%

void yyerror(char *s)
{
  printf("\nErross:",s);
}

int main(int argc,char* argv[])
{
    yyin = fopen(argv[1],"r");
    yyparse();
    fclose(yyin);
    return 0;
}


