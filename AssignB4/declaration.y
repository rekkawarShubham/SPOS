%{
	#include<stdio.h>
	void yyerror(char *);
        int yylex();
%}
%token INT FLOAT AS VD INTD SC NL COMMA CHAR CHVAL BL BLVAL REAL

%% 
s:type1|type2|type3|type4;
type1:INT varlist SC NL {printf("\nValid Integer declaration");return 0;};
type2:FLOAT varlist2 SC NL {printf("\nValid Float Declaration");return 0;};
type3: CHAR varlist3 SC NL {printf("\n Valid Char Declaration");return 0;};
type4: BL varlist4 SC NL {printf("\n Valid Boolean Declaration");return 0;};


varlist: VD AS INTD |VD|VD COMMA varlist|VD AS INTD COMMA varlist; 
varlist2: VD AS REAL|VD|VD COMMA varlist2|VD AS REAL COMMA varlist2;
varlist3: VD AS CHVAL |VD | VD COMMA varlist3 | VD AS CHVAL COMMA varlist3;
varlist4: VD AS BLVAL |VD | VD COMMA varlist4| VD AS BLVAL COMMA varlist4;
%%

void yyerror(char *s)
{
	fprintf(stderr,"ERROr:%s",s);
}
int main(){
yyparse();
return 0;
}
