lexer grammar InternalComprendo;
@header {
package xtext.comprendo.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'public-executions' ;
T12 : 'private-executions' ;
T13 : 'Comprendo' ;
T14 : '{' ;
T15 : '}' ;
T16 : 'scope' ;
T17 : '=' ;
T18 : ';' ;
T19 : ':' ;
T20 : 'outdir' ;
T21 : 'summary' ;

// $ANTLR src "../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g" 1012
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g" 1014
RULE_INT : ('0'..'9')+;

// $ANTLR src "../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g" 1016
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g" 1018
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g" 1020
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g" 1022
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g" 1024
RULE_ANY_OTHER : .;


