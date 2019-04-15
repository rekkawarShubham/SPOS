%{
 #include "y.tab.h"
%}

%%
sleeping|studying|is|are  {printf("VERB=%s",yytext);return VERB;}
sleeply|gently 		  {printf("ADVERB=%s",yytext);return ADVERB;}
good|bad       		  {printf("ADJECTIVE=%s",yytext);return ADJECTIVE;}
Pratiksha|SHADAB  	  {printf("Noun:=%s",yytext);return NOUN;}
He|She|It|They  	  {printf("PRONOUN:=%s",yytext);return PRONOUN;}
and|but   		  {printf("CONJUNCTION:=%s",yytext);return CONJUNCTION;}
in|under	          {printf("PREPOSITION:=%s",yytext);return PREPOSITION;}      

%%
int yywrap(){
return 0;
}

