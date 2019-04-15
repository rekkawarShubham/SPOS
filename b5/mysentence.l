%{
     #include "y.tab.h"
%}

%%
[\t ];
is|are|were|shall|will|studying|sleeping       {printf("%s : It is VERB",yytext);return(VERB);}
he|she|it|they|them 	     {printf("%s : It is PRONOUN",yytext);return(PRONOUN);} 
gently|firmly 		     {printf("%s : It is ADVERB",yytext);return(ADVERB);}
good|bad|beautiful|ugly      {printf("%s : It is AdJECTIVE",yytext);return(ADJECTIVE);}
and|or|but                   {printf("%s : It is CONJUCTION",yytext);return(CONJUNCTION);}	   
under|below|in|above|on      {printf("%s : It is PREPOSITION",yytext);return(PREPOSITION);}
[a-zA-Z]+                    {printf("%s : It is NOUN",yytext);return(NOUN);}

. ;
%%
int yywrap(){return 1;}
