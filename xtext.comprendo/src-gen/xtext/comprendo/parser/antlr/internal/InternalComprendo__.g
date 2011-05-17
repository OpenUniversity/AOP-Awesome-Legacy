lexer grammar InternalComprendo;
@header {
package xtext.comprendo.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'Comprendo' ;
T12 : '{' ;
T13 : '}' ;
T14 : 'scope' ;
T15 : '=' ;
T16 : ';' ;
T17 : 'public-executions' ;
T18 : 'private-executions' ;
T19 : ':' ;
T20 : 'summary' ;
T21 : 'outdir' ;

// $ANTLR src "../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g" 466
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g" 468
RULE_INT : ('0'..'9')+;

// $ANTLR src "../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g" 470
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g" 472
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g" 474
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g" 476
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g" 478
RULE_ANY_OTHER : .;


