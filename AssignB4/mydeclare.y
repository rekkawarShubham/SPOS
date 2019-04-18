%{
    #include<stdio.h>
    void yyerror(char *);
  
%}

%token   INTD FD VD CHAR CHVAL BOOL BLVAL COMMA DIGI REAL ASSIGN SC NL
%%
s: type1;
type1 : INTD varlist SC NL  {printf("This is valid integer declaration");}

varlist :  VD | VD ASSIGN DIGI | VD COMMA VD ASSIGN DIGI | VD ASSIGN DIGI COMMA varlist;

%%
void yyerror(char* s)
{
  fprintf(stderr,"Errors: %s",s);
}

int main(){
  yyparse();
  return 0;
}
