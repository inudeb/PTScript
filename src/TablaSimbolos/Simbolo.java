/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
 public class Simbolo extends PTExp {
    
    int numeroLinea,numeroColumna,indice;
    String nombre;
    SymbolsTable t;
    PTReadLn r;
    public int getIndice() {
        return indice;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroColumna() {
        return numeroColumna;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
      this.t= t;
      this.t.agregarSimbolo(this, nombre);
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
      if(r!=null){
          r.ejecutarSintaxis();
           if(this.TipoDato()==Simbolo.TipoSimbolo.Cadena)
                    ((SymString)this).setValor(r.getRet().toString());
           if(this.TipoDato()== Simbolo.TipoSimbolo.Entero)
               ((SymInt)this).setValor(Integer.parseInt(r.getRet().toString()));
           if(this.TipoDato()== Simbolo.TipoSimbolo.Flotante)
               ((SymFloat)this).setValor(Float.parseFloat(r.getRet().toString()));
           if(this.TipoDato()== Simbolo.TipoSimbolo.Booleano)
               ((SymBoolean)this).setValor(Boolean.parseBoolean( r.getRet().toString()));
      }
    }
    
    public static enum TipoSimbolo{Entero,Flotante,Cadena,Booleano,Funcion,Anonimo };
    
    public Simbolo(int numeroLinea, int numeroColumna, String nombre) {
        this.numeroLinea = numeroLinea;
        this.numeroColumna = numeroColumna;
        this.nombre = nombre;
    }
    
    public TipoSimbolo TipoDato()
    {
        return TipoSimbolo.Anonimo;
    }
    
    
}
