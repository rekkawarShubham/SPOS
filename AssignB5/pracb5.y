%{
    #include<stdio.h>
    void yyerror(char*);
    int yylex();
    FILE* yyin;
%}

%token  NOUN PRONOUN VERB ADVERB ADJECTIVE PREPO CONJ
%%
sentence:  simple {printf("\n This is simple sentence");}; |compound {printf("\n This is Compound sentence");};

simple : subject VERB object;
compound : subject VERB object CONJ subject VERB object;
subject : NOUN|PRONOUN;
object : NOUN|ADJECTIVE NOUN|ADVERB NOUN|PREPO NOUN;

%%
void yyerror(char *s)
{
  printf("%s Error:",s);
}

int main(int argc,char *argv[])
{
 yyin = fopen(argv[1],"r");
 yyparse();
 fclose(yyin); 
 return 0;
}
