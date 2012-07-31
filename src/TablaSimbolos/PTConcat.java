/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class PTConcat extends PTExp {
    String cadena1;
    String cadena2;
    String concatResult;
    PTIdent ident1;
    PTIdent ident2;
    PTConcat l;
    PTConcat r;

    public String getConcatResult() {
        return concatResult;
    }
    

    public PTConcat(String cadena1, String cadena2) {
        this.cadena1 = cadena1;
        this.cadena2 = cadena2;
    }

    public PTConcat(PTIdent ident1, PTIdent ident2) {
        this.ident1 = ident1;
        this.ident2 = ident2;
    }
    boolean cadenafirst;
    public PTConcat(String cadena1, PTIdent ident2,boolean t) {
        this.cadena1 = cadena1;
        this.ident2 = ident2;
        this.cadenafirst= t;
    }

    public PTConcat(PTConcat l, PTConcat r) {
        this.l = l;
        this.r = r;
    }

    public PTConcat(String cadena1, PTConcat l,boolean t) {
        this.cadena1 = cadena1;
        this.l = l;
        this.cadenafirst= t;
    }
boolean identfisrt;
    public PTConcat(PTIdent ident1, PTConcat l,boolean t) {
        this.ident1 = ident1;
        this.l = l;
        this.identfisrt=t;
    }
    
    
    
Simbolo s1;
Simbolo s2;
    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
        if(this.l!=null)
            this.l.verificarTablaSimbolos(t);
        if(this.r!=null)
            this.r.verificarTablaSimbolos(t);
        if(this.ident1!=null)
            s1= t.buscar(this.ident1.getNombre());
        if(this.ident2!=null)
            s2= t.buscar(this.ident2.getNombre());
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
       
        if(s1!=null&& s2!=null)
        {
            if(s1.TipoDato()==Simbolo.TipoSimbolo.Cadena && s2.TipoDato() == Simbolo.TipoSimbolo.Cadena)
                this.concatResult=((SymString)s1).getValor()+((SymString)s2).getValor();
        }
        if(this.cadena1!=null && this.cadena2!=null)
       {
           this.concatResult= this.cadena1+ this.cadena2;
       }
       if(this.cadena1!=null && this.s2!=null)
       {
           if(s2.TipoDato()==Simbolo.TipoSimbolo.Cadena)
            this.concatResult=this.cadena1+ ((SymString)s2).getValor();
           if(s2.TipoDato()== Simbolo.TipoSimbolo.Entero)
               this.concatResult= this.cadena1+((SymInt)s2).getValor().toString();
           if(s2.TipoDato()==Simbolo.TipoSimbolo.Flotante)
               this.concatResult= this.cadena1+((SymFloat)s2).getValor().toString();
           if(s2.TipoDato()== Simbolo.TipoSimbolo.Booleano)
               this.concatResult=this.cadena1+((SymBoolean)s2).getValor().toString();
       }
      // this.concatResult.replace('"',' ');
    }
    
}
