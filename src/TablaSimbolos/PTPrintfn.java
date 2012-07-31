/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class PTPrintfn extends PTExp {

    Object texto;
    PTIdent iden;
    Simbolo s;
    PTConcat concat;

    public PTPrintfn(Object texto) {
        this.texto = texto;
        this.iden=null;
    }

    public PTPrintfn(PTIdent iden) {
        this.iden = iden;
        this.texto=null;
    }

    public PTPrintfn(Object texto, PTIdent iden) {
        this.texto = texto;
        this.iden = iden;
    }

    public PTPrintfn(PTIdent iden, PTConcat concat) {
        this.iden = iden;
        this.concat = concat;
    }
   
    
    SymbolsTable tab;
    
    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
        this.tab=t;
       if(iden!=null){
           s= t.buscar(iden.getNombre());
       }
       if(concat!=null)
           concat.verificarTablaSimbolos(t);
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
        if(this.s!=null)
        {
            if(s.TipoDato()== Simbolo.TipoSimbolo.Cadena)
                System.out.println(((SymString)s).getValor());
            if(s.TipoDato()== Simbolo.TipoSimbolo.Entero)
                System.out.println(((SymInt)s).getValor());
            if(s.TipoDato()== Simbolo.TipoSimbolo.Flotante)
                System.out.println(((SymInt)s).getValor());
            if(s.TipoDato()== Simbolo.TipoSimbolo.Booleano)
                System.out.println(((SymInt)s).getValor());
        }
        if(this.texto!=null)
        {
            if(this.texto instanceof PTConcat)
            {
                ((PTConcat)this.texto).verificarTablaSimbolos(tab);
                
                ((PTConcat)this.texto).ejecutarSintaxis();
                 System.out.println(((PTConcat)this.texto).getConcatResult());
            }
            else
                 System.out.println(texto);
        }
        
    }
    
    
    
}
