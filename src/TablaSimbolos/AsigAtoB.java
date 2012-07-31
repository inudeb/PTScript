/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
 public class AsigAtoB extends PTExp {
     
     PTIdent id1;
     PTIdent id2;
     Simbolo  a1;
     Simbolo a2;
     Object dato;
     PTAritmetic operacionAritmetica;
     SymbolsTable t;
     
     
    public AsigAtoB(PTIdent id1, PTIdent id2) {
        this.id1 = id1;
        this.id2 = id2;
        this.operacionAritmetica=null;
    }

    public AsigAtoB(PTIdent id1, Object dato) {
        this.id1 = id1;
        this.dato = dato;
        this.operacionAritmetica=null;
    }

    public AsigAtoB(PTIdent id1, PTAritmetic operacionAritmetica) {
        this.id1 = id1;
        this.operacionAritmetica = operacionAritmetica;
    }

    public AsigAtoB(PTIdent id1, PTConcat c) {
        this.id1 = id1;
        this.c = c;
    }
     
     

    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
        this.t=t;
        if(this.c!=null)
            c.verificarTablaSimbolos(t);
        a1= t.buscar(id1.getNombre());
        if(this.c!=null)
            this.c.verificarTablaSimbolos(t);
        if(this.operacionAritmetica!=null)
        {
            this.operacionAritmetica.verificarTablaSimbolos(t);
        }
        if(this.id2!=null)
        {
            a2= t.buscar(id2.getNombre());
            if(a2!=null)
            {    if((a1.TipoDato()== Simbolo.TipoSimbolo.Entero && (a2.TipoDato()== Simbolo.TipoSimbolo.Cadena ||a2.TipoDato()== Simbolo.TipoSimbolo.Booleano))||(a1.TipoDato()== Simbolo.TipoSimbolo.Flotante && (a2.TipoDato()== Simbolo.TipoSimbolo.Cadena ||a2.TipoDato()== Simbolo.TipoSimbolo.Booleano)))
                      throw  new Exception("Error con los tipos de datos en la Linea: "+a1.getNumeroLinea()+" Columna: "+a1.getNumeroColumna() );
                 if(a1.TipoDato()==Simbolo.TipoSimbolo.Booleano && a1.TipoDato()!= a2.TipoDato())
                     throw  new Exception("Error con los tipos de datos en la Linea: "+a1.getNumeroLinea()+" Columna: "+a1.getNumeroColumna() );
                 if(a1.TipoDato()==Simbolo.TipoSimbolo.Cadena && a1.TipoDato()!= a2.TipoDato())
                     throw  new Exception("Error con los tipos de datos en la Linea: "+a1.getNumeroLinea()+" Columna: "+a1.getNumeroColumna() );
            }
            else
                throw new Exception("La variable "+id2.getNombre()+" no esta declarada.");
        }
        
       if(this.dato!=null && a2==null)
        {
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Entero ||a1.TipoDato()== Simbolo.TipoSimbolo.Flotante){
                try {
                    Integer.parseInt(dato.toString());
                    Float.parseFloat(dato.toString());
                } catch (Exception e) {
                    throw  new Exception("No se puede asignar cadena de caracteres a una variable numerica. Linea: "+a1.getNumeroLinea() +" Columna: "+a1.getNumeroColumna());
                }
            }
            if(a1.TipoDato()==Simbolo.TipoSimbolo.Booleano)
            {
                try {
                    Boolean.parseBoolean(dato.toString());
                } catch (Exception e) {
                    throw  new Exception("Solo se puede asignar valores booleanos a la variable "+ a1.getNombre()+" Linea: "+a1.getNumeroLinea()+" Columna "+a1.getNumeroColumna());
                }
            }
        }
    }
    PTConcat c;
    @Override
    public void ejecutarSintaxis() throws Exception {
        if(a2!=null){
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Cadena && a2.TipoDato()== Simbolo.TipoSimbolo.Cadena)
                ((SymString) a1).setValor(((SymString)a2).getValor());
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Flotante && a2.TipoDato()== Simbolo.TipoSimbolo.Flotante)
                ((SymFloat) a1).setValor(((SymFloat)a2).getValor());
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Booleano && a2.TipoDato()== Simbolo.TipoSimbolo.Booleano)
                ((SymBoolean) a1).setValor(((SymBoolean)a2).getValor());
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Entero && a2.TipoDato()== Simbolo.TipoSimbolo.Entero)
                ((SymInt) a1).setValor(((SymInt)a2).getValor());
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Entero && a2.TipoDato()== Simbolo.TipoSimbolo.Flotante)
                ((SymInt) a1).setValor(Integer.parseInt(((SymFloat)a2).getValor().toString()));
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Flotante && a2.TipoDato()== Simbolo.TipoSimbolo.Entero)
                ((SymFloat) a1).setValor(Float.parseFloat(((SymInt)a2).getValor().toString()));
        }
       if(dato!=null)
        {
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Flotante)
                ((SymFloat) a1).setValor(Float.parseFloat(dato.toString()));
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Entero)
                ((SymInt) a1).setValor(Integer.parseInt(dato.toString()));
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Booleano)
                 ((SymBoolean) a1).setValor(Boolean.parseBoolean(dato.toString()));
            if(a1.TipoDato()==Simbolo.TipoSimbolo.Cadena)
                 ((SymString) a1).setValor(dato.toString());
        }
       if(this.operacionAritmetica!=null)
       {
           this.operacionAritmetica.ejecutarSintaxis();
           if(this.operacionAritmetica.isIsIdent()){
               this.id2= this.operacionAritmetica.getId1();
               this.operacionAritmetica=null;
               this.verificarTablaSimbolos(this.t);
               this.ejecutarSintaxis();
           }
           else{
                if(a1.TipoDato()== Simbolo.TipoSimbolo.Flotante)
                    ((SymFloat) a1).setValor(Float.parseFloat(this.operacionAritmetica.getResultado().toString()));
                if(a1.TipoDato()== Simbolo.TipoSimbolo.Entero)
                    ((SymInt) a1).setValor(Integer.parseInt(this.operacionAritmetica.getResultado().toString().substring(0,this.operacionAritmetica.getResultado().toString().indexOf('.'))));
         }
       }
       if(this.c!=null)
       {
           if(this.a1.TipoDato()!=Simbolo.TipoSimbolo.Cadena)
               throw  new Exception("No se puede asignar cadenas concatenadas a una variable que no es de tipo cadena. Linea : "+this.a1.getNumeroLinea()+". Columna: "+this.a1.getNumeroColumna());
           ((SymString)a1).setValor(c.getConcatResult());
       }
       if(this.c!=null)
       {
           if(a1.TipoDato()!=Simbolo.TipoSimbolo.Cadena)
           {
               throw  new Exception("Error en el tipo de datos. Linea :"+a1.getNumeroLinea()+". Columna: "+a1.getNumeroColumna());
           }
           else
           {
               c.ejecutarSintaxis();
               ((SymString)a1).setValor(c.getConcatResult());
           }
       }
    }
    
}
