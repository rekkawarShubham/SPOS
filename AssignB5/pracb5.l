%{
#include<stdio.h>
#include "y.tab.h"
%}

%%
[\t ]+ ;

he|she|it|they     {printf("%s: is PRONOUN",yytext); return PRONOUN;}
is|go|going|studying    {printf("%s: is VERB",yytext); return VERB;}
gently|firmly        {printf("%s: is ADVERB",yytext); return ADVERB;}
good|clever          {printf("%s: is ADJECTIVE",yytext); return ADJECTIVE;}
on|above|in|out     {printf("%s: is PREPOSITION",yytext); return PREPO;}
and|or|but          {printf("%s: is Conjunction",yytext); return CONJ;}
[a-zA-Z]+          {printf("%s: is NOUN",yytext); return NOUN;}
. ;
%%

int yywrap(){return 1;}
