package compiler;

import java_cup.runtime.SymbolFactory;

%%

%cup
%class Scanner

%{
    private SymbolFactory sf;
    private int line;
    
    public Scanner(java.io.InputStream r, SymbolFactory sf){
        this(r);
        this.sf = sf;
        this.line = 1;
    }
    
    public int getLine() {
        return this.line;
    }
    
    public void nextLine() {
        this.line++;
    }
%}

%eofval{
    return sf.newSymbol("EOF", sym.EOF);
%eofval}

L_INT = (0|([1-9][0-9]*))
L_FLOAT = {L_INT}\.(0|([0-9]*[1-9]))
L_STRING = \"[^\"\n]*\"

L_IDENT = (_?[a-zA-Z][:jletterdigit:]*)

%%

"function"              { return sf.newSymbol("key function", sym.FUNCTION); }
"main"                  { return sf.newSymbol("key main", sym.MAIN); }
"if"                    { return sf.newSymbol("key if", sym.IF); }
"else"                  { return sf.newSymbol("key else", sym.ELSE); }
"for"                   { return sf.newSymbol("key for", sym.FOR); }
"while"                 { return sf.newSymbol("key while", sym.WHILE); }
"return"                { return sf.newSymbol("key return", sym.RETURN); }
"true"                  { return sf.newSymbol("key true", sym.TRUE); }
"false"                 { return sf.newSymbol("key false", sym.FALSE); }
"void"                  { return sf.newSymbol("key void", sym.VOID); }
"print"                 { return sf.newSymbol("key print", sym.PRINT); }

"boolean"               { return sf.newSymbol("type boolean", sym.T_BOOL); }
"int"                   { return sf.newSymbol("type int", sym.T_INT); }
"float"                 { return sf.newSymbol("type float", sym.T_FLOAT); }
"String"                { return sf.newSymbol("type string", sym.T_STRING); }

"+"                     { return sf.newSymbol("op plus", sym.PLUS); }
"-"                     { return sf.newSymbol("op minus", sym.MINUS); }
"*"                     { return sf.newSymbol("op times", sym.TIMES); }
"/"                     { return sf.newSymbol("op divide", sym.DIV); }
"%"                     { return sf.newSymbol("op modulo", sym.MOD); }
"="                     { return sf.newSymbol("op equal", sym.EQUAL); }
"!"                     { return sf.newSymbol("op excl", sym.EXCL); }

"<"                     { return sf.newSymbol("comp lt", sym.LT); }
"<="                    { return sf.newSymbol("comp le", sym.LE); }
">"                     { return sf.newSymbol("comp gt", sym.GT); }
">="                    { return sf.newSymbol("comp ge", sym.GE); }
"=="                    { return sf.newSymbol("comp eq", sym.EQ); }
"!="                    { return sf.newSymbol("comp ne", sym.NE); }
"||"                    { return sf.newSymbol("comp or", sym.OR); }
"&&"                    { return sf.newSymbol("comp and", sym.AND); }
"?"                     { return sf.newSymbol("comp ques", sym.QUES); }

"{"                     { return sf.newSymbol("sep L brack", sym.LBRACK); }
"}"                     { return sf.newSymbol("sep R brack", sym.RBRACK); }
"("                     { return sf.newSymbol("sep L par", sym.LPAR); }
")"                     { return sf.newSymbol("sep R par", sym.RPAR); }
":"                     { return sf.newSymbol("sep colon", sym.COLON); }
","                     { return sf.newSymbol("sep coma", sym.COMA); }
";"                     { return sf.newSymbol("sep semi", sym.SEMI); }

{L_INT}                 { return sf.newSymbol("expr int", sym.INT, new Integer(yytext())); }
{L_FLOAT}               { return sf.newSymbol("expr float", sym.FLOAT, new Float(yytext())); }
{L_STRING}              { return sf.newSymbol("expr string", sym.STRING, new String(yytext())); }
{L_IDENT}               { return sf.newSymbol("identifier", sym.IDENT, new String(yytext())); }

\n                      { this.nextLine(); }
[ \t\r\f]               { /* Delete blank space characters */ }

.                       {
                            System.err.println("Illegal character <" + yytext() + "> on line " + this.getLine());
                            System.exit(-1);
                        }
