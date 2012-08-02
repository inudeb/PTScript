package PTLex;
import PTSintax.*;
import java_cup.runtime.*;

%%
%line
%column
%public
%state COMENTARIOS
%full
%cup
%class PTLexer
%{
  private int comment_count = 0;

	private Symbol symbol(int type) {
	        return new Symbol(type);
    	}

         private Symbol symbol(int type,int l, int r) {
        	return new Symbol(type,l,r);
    	}
	 private Symbol symbol(int type,int l, int r, Object value) {
        	return new Symbol(type,l,r, value);
    	}
%} 
%init{
	//TablaDeSimbolos.GetInstance();
%init}
letra=[A-Za-z]
digito= 0 | [1-9][0-9]* 
fdl=\r|\n|\r\n
caracterblanco={fdl} | [ \t\f]
cadena_de_texto=(\\\"|[^\n\r\"]|\\{caracterblanco}+\\)*
textoComentario=([^*/\n]|[^*\n]"/"[^*\n]|[^/\n]"*"[^/\n]|"*"[^/\n]|"/"[^*\n])*
id={letra}+({letra}|{digito}|_)*
numeroDecimal={digito}+(\.{digito}+)
%% 
<YYINITIAL> 
{
        
        "."     {return symbol(sym.PUNTO,yyline,yycolumn);}
        "+"     {return symbol(sym.SUM,yyline,yycolumn);}
        "-"     {return symbol(sym.REST,yyline,yycolumn);}
        "*"     {return symbol(sym.MULT,yyline,yycolumn);}
        "/"     {return symbol(sym.DIV,yyline,yycolumn);}
	"if"	{return symbol( sym.IF,yyline,yycolumn);}
         "then" {return symbol( sym.THEN,yyline,yycolumn);}
         "("    {return symbol( sym.PDERECHO,yyline,yycolumn);}
         ")"    {return symbol( sym.PIZQUIERDO,yyline,yycolumn);}
         ">"    {return symbol(sym.MAYQ,yyline,yycolumn);}
         "<"    {return symbol(sym.MENQ,yyline,yycolumn);}
         "equals"   {return symbol(sym.IGU,yyline,yycolumn);}
         "readln" {return symbol(sym.READLN,yyline,yycolumn);}
         "not"  {return symbol(sym.NOT,yyline,yycolumn); }
         "true" {return symbol(sym.BOLEANOS,yyline,yycolumn,true);}
         "false" {return symbol(sym.BOLEANOS,yyline,yycolumn,false);}
	"else"	{return symbol(sym.ELSE,yyline,yycolumn);}	
	"for"	{return symbol(sym.FOR,yyline,yycolumn);}
	"while"	{return symbol(sym.WHILE,yyline,yycolumn);}
	"do"	{return symbol(sym.DO,yyline,yycolumn);}
	"begin"	{return symbol(sym.BEGIN,yyline,yycolumn);}
	"end"	{return symbol(sym.END,yyline,yycolumn);}
	"int"	{return symbol(sym.INT,yyline,yycolumn);} 
	"string"	{ return symbol(sym.STRING,yyline,yycolumn);}
	"float"	{return symbol(sym.FLOAT,yyline,yycolumn);}
	"to"	{return symbol(sym.TO,yyline,yycolumn);}
	"downto"	{return symbol(sym.DOWNTO,yyline,yycolumn);}
	"switch"	{return symbol(sym.SWITCH,yyline,yycolumn);}
	"return"	{return symbol(sym.RETURN,yyline,yycolumn);}
	"let"	{return symbol(sym.LET,yyline,yycolumn);}
        "function" {return symbol(sym.FUNCTION,yyline,yycolumn);}
        "startfn"   {return symbol(sym.STARTFN,yyline,yycolumn);}
	"default" {return symbol(sym.DEFAULT,yyline,yycolumn);}
	"case"	{return symbol(sym.CASE,yyline,yycolumn);}
	"printfn"	{return symbol(sym.PRINTFN,yyline,yycolumn);}
	";"	{return symbol(sym.PCOMA,yyline,yycolumn);}
	{digito} {return symbol(sym.ENTEROS,yyline,yycolumn,Integer.parseInt(yytext()));}
	{numeroDecimal}	{return symbol(sym.FLOTANTES,yyline,yycolumn,Float.parseFloat(yytext()));}			
	{id}	{return symbol(sym.ID,yyline,yycolumn, yytext());}
	"="	{return symbol(sym.ASIG,yyline,yycolumn);}
	\"{cadena_de_texto}\" {return symbol(sym.CADENA,yyline,yycolumn,yytext());}
	\"{cadena_de_texto}	{System.out.println("Cadena mal formada");}
	{caracterblanco} {}	
	"/*"	{yybegin(COMENTARIOS); comment_count++;}
}
<COMENTARIOS>
{
	"/*"	{comment_count++;}
	"*/"	{if(--comment_count==0)yybegin(YYINITIAL);}
	{textoComentario}	{}
}
.
{
	System.out.println("Error: <" + yytext() + ">");
}
