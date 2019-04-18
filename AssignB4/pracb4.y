%{
  #include<stdio.h>
   void yyerror(char *);
   int yylex();
%}

%token  INT FLOAT CHAR BL INTD FD COMMA CHVAL VD BLVAL AS SC NL
%%
s:type1|type2|type3|type4;

type1: INT varlist SC NL  {printf("\nVALID INTEGER DECLARATION");};
type2: FLOAT varlist1 SC NL  {printf("\nVALID FLOAT DECLARATION");};
type3: CHAR varlist2 SC NL  {printf("\nVALID CHAR DECLARATION");};
type4: BL varlist3 SC NL  {printf("\nVALID BOOLEAN DECLARATION");};


varlist :  VD| VD COMMA varlist  | VD AS INTD  | VD AS INTD COMMA varlist;
varlist1 : VD| VD COMMA varlist1 | VD AS FD    | VD AS FD COMMA varlist1;
varlist2 : VD| VD COMMA varlist2 | VD AS CHVAL | VD AS CHVAL COMMA varlist2;
varlist3 : VD| VD COMMA varlist3 | VD AS BLVAL | VD AS BLVAL COMMA varlist3;

%%

void yyerror(char *s)
{
  fprintf(stderr,"\nErrors:%s",s);
}
int main(){
yyparse();
return 0;
}
