/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class PTForExpresion extends PTExp {

    PTexpList explist;
    PTBoolExpresion expbool;
    PTIdent a1,a2;
    Integer i1,i2;
    Float f1,f2;
    SymbolsTable t;
    boolean to=true;

    public PTForExpresion(PTIdent a1, PTIdent a2, PTexpList e,boolean to) {
        this.a1 = a1;
        this.a2 = a2;
        this.explist= e;
        this.to=to;
    }

    public PTForExpresion(PTIdent a1, Integer i1,PTexpList e,boolean to) {
        this.a1 = a1;
        this.i1 = i1;
        this.explist= e;
         this.to=to;
    }

    public PTForExpresion(PTIdent a1, Float f1,PTexpList e,boolean to) {
        this.a1 = a1;
        this.f1 = f1;
        this.explist= e;
        this.to=to;
    }

    public PTForExpresion(Integer i1, Integer i2,PTexpList e,boolean to) {
        this.i1 = i1;
        this.i2 = i2;
        this.explist= e;
        this.to=to;
    }

    public PTForExpresion(Float f1, Float f2,PTexpList e,boolean to) {
        this.f1 = f1;
        this.f2 = f2;
        this.explist= e;
        this.to=to;
    }

    public PTForExpresion(PTexpList explist, PTBoolExpresion expbool, PTIdent a1,boolean to) {
        this.explist = explist;
        this.expbool = expbool;
        this.a1 = a1;
        this.to=to;
    }

    public PTForExpresion(PTexpList explist, PTBoolExpresion expbool, Integer i1,boolean to) {
        this.explist = explist;
        this.expbool = expbool;
        this.i1 = i1;
        this.to=to;
    }

    public PTForExpresion(PTexpList explist, PTBoolExpresion expbool, Float f1,boolean to) {
        this.explist = explist;
        this.expbool = expbool;
        this.f1 = f1;
        this.to=to;
    }

    public PTForExpresion(PTexpList explist, PTIdent a2, Integer i1,boolean to) {
        this.explist = explist;
        this.a2 = a2;
        this.i1 = i1;
        this.to=to;
    }

    public PTForExpresion(PTexpList explist, PTIdent a2, Float f1,boolean to) {
        this.explist = explist;
        this.a2 = a2;
        this.f1 = f1;
        this.to=to;
    }
    
    
    Simbolo s1,s2;
    
    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
      this.t=t;
      if(a1!=null)
        s1= t.buscar(a1.getNombre());
      if(a2!=null)
        s2= t.buscar(a2.getNombre());
      if(this.expbool!=null)
          this.expbool.verificarTablaSimbolos(t);
      explist.verificarTablaSimbolos(t);
      if(s1!=null)
      {  
          if(s1.TipoDato() == Simbolo.TipoSimbolo.Cadena)
            throw  new Exception("No se puede realizar una iteracion con la variable de tipo cadena "+a1.getNombre()+". Linea: "+s1.getNumeroLinea()+". Columna: "+ s1.getNumeroColumna());
          if(s1.TipoDato()==Simbolo.TipoSimbolo.Booleano)
              throw  new Exception("No se puede realizar una iteracion con la variable de tipo booleano "+a1.getNombre()+". Linea: "+s1.getNumeroLinea()+". Columna: "+ s1.getNumeroColumna());
          if(s1.TipoDato()== Simbolo.TipoSimbolo.Entero && this.f1!=null)
              throw  new Exception("Error con los tipos de datos, no se puede realizar una iteracion entre tipos de datos enteros y flotanes. Linea: "+s1.getNumeroLinea()+". Columna: "+s1.getNumeroColumna());
          if(s1.TipoDato()== Simbolo.TipoSimbolo.Flotante && this.i1!=null)
              throw  new Exception("Error con los tipos de datos, no se puede realizar una iteracion entre tipos de datos enteros y flotanes. Linea: "+s1.getNumeroLinea()+". Columna: "+s1.getNumeroColumna());
      }
      if(s2!=null)
      {
          if(s2.TipoDato() == Simbolo.TipoSimbolo.Cadena)
            throw  new Exception("No se s realizar una iteracion con la variable de tipo cadena "+a2.getNombre()+". Linea: "+s2.getNumeroLinea()+". Columna: "+ s2.getNumeroColumna());
          if(s1!=null)
          {
              if(s2.TipoDato()!= s1.TipoDato())
                  throw  new Exception("Error con los tipos de datos. No se puede realizar una iteracion entre tipos de datos "+s1.TipoDato().name()+" y "+ s2.TipoDato().name()+". Linea: "+ s1.getNumeroLinea()+". Columna: "+s1.getNumeroColumna());
          }
          if(s2.TipoDato()== Simbolo.TipoSimbolo.Entero && this.f1!=null)
              throw  new Exception("Error con los tipos de datos, no se puede realizar una iteracion entre tipos de datos enteros y flotanes. Linea: "+s2.getNumeroLinea()+". Columna: "+s2.getNumeroColumna());
          if(s2.TipoDato()== Simbolo.TipoSimbolo.Flotante && this.i1!=null)
              throw  new Exception("Error con los tipos de datos, no se puede realizar una iteracion entre tipos de datos enteros y flotanes. Linea: "+s2.getNumeroLinea()+". Columna: "+s2.getNumeroColumna());
      }
     }

    @Override
    public void ejecutarSintaxis() throws Exception {
        if(to){
            if(this.i1!=null && this.i2!=null){
                for (int i = this.i1; i < this.i2; i++) {
                    this.explist.ejecutarSintatxis();
                }
            }
            if(this.f1!=null && this.f2!=null)
            {
                for (float i = this.f1; i < this.f2; i++) {
                    this.explist.ejecutarSintatxis();
                }
            }
          if(this.s1!=null && this.i1!=null)
          {
              for (int i = ((SymInt)s1).getValor(); i < this.i1; i++,((SymInt)s1).setValor(i))
              { 
                  this.explist.ejecutarSintatxis();
              }
          }
          if(this.s1!=null && this.f1!=null)
          {
              for (float i = ((SymFloat)s1).getValor(); i < this.f1; i++,((SymFloat)s1).setValor(i))
              { 
                  this.explist.ejecutarSintatxis();
              }
          }
          if(this.s1!=null && this.s2!=null)
          {
              if(s2.TipoDato()== Simbolo.TipoSimbolo.Entero)
              {
                  for (int i = ((SymInt)s1).getValor(); i < ((SymInt)s2).getValor(); i++,((SymInt)s1).setValor(i)) {
                      this.explist.ejecutarSintatxis();
                  }
              }
              if(s2.TipoDato()== Simbolo.TipoSimbolo.Flotante)
              {
                  for (float i = ((SymFloat)s1).getValor(); i < ((SymFloat)s2).getValor(); i++,((SymFloat)s1).setValor(i)) {
                      this.explist.ejecutarSintatxis();
                  }
              }
          }
          if(s1!=null && this.expbool!=null )
          {
              if(s1.TipoDato()==Simbolo.TipoSimbolo.Entero)
              {
                  expbool.ejecutarSintaxis();
                  for (int i = ((SymInt)s1).getValor();expbool.getResult(); i++,((SymInt)s1).setValor(i)) {
                      this.explist.ejecutarSintatxis();
                      this.expbool.ejecutarSintaxis();
                  }
              }
               if(s1.TipoDato()==Simbolo.TipoSimbolo.Flotante)
              {
                  expbool.ejecutarSintaxis();
                  for (float i = ((SymFloat)s1).getValor();expbool.getResult(); i++,((SymFloat)s1).setValor(i)) {
                      this.explist.ejecutarSintatxis();
                      this.expbool.ejecutarSintaxis();
                  }
              }
          }
        }
        else
        {
          if(this.i1!=null && this.i2!=null){
                for (int i = this.i1; i > this.i2; i--) {
                    this.explist.ejecutarSintatxis();
                }
            }
            if(this.f1!=null && this.f2!=null)
            {
                for (float i = this.f1; i > this.f2; i--) {
                    this.explist.ejecutarSintatxis();
                }
            }
          if(this.s1!=null && this.i1!=null)
          {
              for (int i = ((SymInt)s1).getValor(); i > this.i1; i--,((SymInt)s1).setValor(i))
              { 
                  this.explist.ejecutarSintatxis();
              }
          }
          if(this.s1!=null && this.f1!=null)
          {
              for (float i = ((SymFloat)s1).getValor(); i > this.f1; i--,((SymFloat)s1).setValor(i))
              { 
                  this.explist.ejecutarSintatxis();
              }
          }
          if(this.s1!=null && this.s2!=null)
          {
              if(s2.TipoDato()== Simbolo.TipoSimbolo.Entero)
              {
                  for (int i = ((SymInt)s1).getValor(); i > ((SymInt)s2).getValor(); i--,((SymInt)s1).setValor(i)) {
                      this.explist.ejecutarSintatxis();
                  }
              }
              if(s2.TipoDato()== Simbolo.TipoSimbolo.Flotante)
              {
                  for (float i = ((SymFloat)s1).getValor(); i > ((SymFloat)s2).getValor(); i--,((SymFloat)s1).setValor(i)) {
                      this.explist.ejecutarSintatxis();
                  }
              }
          }
          if(s1!=null && this.expbool!=null )
          {
              if(s1.TipoDato()==Simbolo.TipoSimbolo.Entero)
              {
                  expbool.ejecutarSintaxis();
                  for (int i = ((SymInt)s1).getValor();expbool.getResult(); i--,((SymInt)s1).setValor(i)) {
                      this.explist.ejecutarSintatxis();
                      this.expbool.ejecutarSintaxis();
                  }
              }
               if(s1.TipoDato()==Simbolo.TipoSimbolo.Flotante)
              {
                  expbool.ejecutarSintaxis();
                  for (float i = ((SymFloat)s1).getValor();expbool.getResult(); i--,((SymFloat)s1).setValor(i)) {
                      this.explist.ejecutarSintatxis();
                      this.expbool.ejecutarSintaxis();
                  }
              }
          }   
        }
    }
    
    
}
