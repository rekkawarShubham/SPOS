%{
   #include "y.tab.h"
%}
%%

[\t ] ;
is|were|go|going|eating|playing   { printf("%s:This is Verb\n",yytext);return(VERB);}
gently|firmly   		  { printf("%s:This is Adverb\n",yytext);return(ADVERB); }
and|or 				  {printf("%s:This is Conjunction\n",yytext);return(CONJUNCTION);}
good|beautiful|ugly 	  	{printf("%s:This is Adjective\n",yytext);return(ADJECTIVE);}
he|she|it|they|them|him|her      {printf("PRONOUN\t==>%s\n",yytext);return (PRONOUN);}
in|above|under|below|on 	  {printf("%s:This is Preposition\n",yytext);return (PREPOSITION);}
[a-zA-Z]+			  {printf("%s:This is NOUN\n",yytext);return (NOUN);}
. ;
%%
int yywrap()
{
return 1;
}
