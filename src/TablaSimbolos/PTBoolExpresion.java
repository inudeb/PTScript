/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class PTBoolExpresion extends PTExp {

     PTIdent id1;
     PTIdent id2;
     Simbolo  a1;
     Simbolo a2;
     Object dato1;
     Object dato2;
     Boolean result;
     char compexp;

    public Boolean getResult() {
        return result;
    }

    public PTBoolExpresion(Boolean result) {
        this.result = result;
    }
     
     

    public PTBoolExpresion(PTIdent id1, PTIdent id2,char compexp) {
        this.id1 = id1;
        this.id2 = id2;
        this.compexp= compexp;
    }

    public PTBoolExpresion(PTIdent id1, Object dato1, char compexp) {
        this.id1 = id1;
        this.dato1 = dato1;
          this.compexp= compexp;
    }

    public PTBoolExpresion(Object dato1, Object dato2, char compexp) {
        this.dato1 = dato1;
        this.dato2 = dato2;
          this.compexp= compexp;
    }
    
     
    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {

        // <editor-fold defaultstate="collapsed" desc="a1!=null && a2!=null">
        if(id1!=null && id2!=null)
        {
          a1= t.buscar(id1.getNombre());
           a2=t.buscar(id2.getNombre());
           if(a1==null || a2==null)
            throw  new Exception("La variable  no esta declarada. "+((a1==null)? id1.getNombre(): id2.getNombre()));
           if(a1.TipoDato()==Simbolo.TipoSimbolo.Booleano && (a1.TipoDato()!= a2.TipoDato()))
               throw  new Exception("El identificador booleano "+ a1.getNombre()+" solo se puede comparar con otro booleano. Linea: "+a1.getNumeroLinea()+" Collumna: "+a2.getNumeroColumna());
           if(a1.TipoDato()==Simbolo.TipoSimbolo.Cadena && (a1.TipoDato()!= a2.TipoDato()))
               throw  new Exception("El identificador string "+ a1.getNombre()+" solo se puede comparar con otro string. Linea: "+a1.getNumeroLinea()+" Collumna: "+a2.getNumeroColumna());
           if(a2.TipoDato()==Simbolo.TipoSimbolo.Booleano && (a1.TipoDato()!= a2.TipoDato()))
               throw  new Exception("El identificador booleano "+ a2.getNombre()+" solo se puede comparar con otro booleano. Linea: "+a2.getNumeroLinea()+" Collumna: "+a2.getNumeroColumna());
           if(a2.TipoDato()==Simbolo.TipoSimbolo.Cadena && (a1.TipoDato()!= a2.TipoDato()))
               throw  new Exception("El identificador string "+ a2.getNombre()+" solo se puede comparar con otro string. Linea: "+a2.getNumeroLinea()+" Collumna: "+a2.getNumeroColumna());
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="a1!=null && dato1!=null">
        if(this.id1!=null && this.dato1!=null)
        {
           a1= t.buscar(id1.getNombre()); 
           if(a1==null)
            throw  new Exception("La variable  no esta declarada. " + id1.getNombre());
           if(a1.TipoDato()== Simbolo.TipoSimbolo.Booleano)
           {
               try {
                   Boolean.parseBoolean(dato1.toString());
               } catch (Exception e) {
                   throw  new Exception("Error, tipos de datos incomparables. Linea :"+a1.getNumeroLinea()+" Columna: "+a1.getNumeroColumna());
               }
           }
           if(a1.TipoDato()== Simbolo.TipoSimbolo.Entero ||a1.TipoDato()== Simbolo.TipoSimbolo.Flotante )
           {
               try {
                   Integer.parseInt(dato1.toString());
                   Float.parseFloat(this.dato1.toString());
               } catch (Exception e) {
                   throw  new Exception("Error, tipos de datos incomparables. Linea :"+a1.getNumeroLinea()+" Columna: "+a1.getNumeroColumna());
               }
           }
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="dato1!=null && dato2!=null">
        if(dato1!=null && dato2!=null)
        {
            if((dato1.getClass() == Boolean.class ) &&  dato2.getClass()!= Boolean.class)
                throw  new Exception("Error. Tipos de datos incomparables.");
            if(dato1.getClass() == String.class &&   dato2.getClass()!= String.class)
                throw  new Exception("Error. Tipos de datos incomparables.");
            
        }
         //</editor-fold>
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
        
        // <editor-fold defaultstate="collapsed" desc="a1!=null && a2!=null">
        if(this.a1!=null && this.a2!=null)
        {
            if(this.a1.TipoDato()== Simbolo.TipoSimbolo.Cadena)
            {
                switch(this.compexp)
                {
                    case '=':
                        this.result=((SymString)this.a1).getValor().compareTo(((SymString)this.a2).getValor())==0;
                        break;
                    case '!':
                        this.result=((SymString)this.a1).getValor().compareTo(((SymString)this.a2).getValor())!=0;
                        break;
                        default:
                            throw  new Exception("Las operaciones de comparacion con cadenas solo pueden ser del tipo equals y dif. Linea: "+this.a1.getNumeroLinea()+" Columna: "+this.a1.getNumeroColumna());
                            
                }
            }
            if(this.a1.TipoDato()== Simbolo.TipoSimbolo.Booleano)
            {
                switch(this.compexp)
                {
                    case '=':
                        this.result=((SymBoolean)this.a1).getValor()==((SymBoolean)this.a2).getValor();
                        break;
                    case '!':
                        this.result=((SymBoolean)this.a1).getValor()!=((SymBoolean)this.a2).getValor();
                        break;
                        default:
                            throw  new Exception("Las operaciones de comparacion con booleanos solo pueden ser del tipo equals y dif. Linea: "+this.a1.getNumeroLinea()+" Columna: "+this.a1.getNumeroColumna());
                            
                }
            }
            if(this.a1.TipoDato()== Simbolo.TipoSimbolo.Entero )
            {
                if(a2.TipoDato()== Simbolo.TipoSimbolo.Flotante || a2.TipoDato()== Simbolo.TipoSimbolo.Entero)
                {
                    switch(this.compexp)
                    {
                        case '=':
                            this.result=((SymInt)this.a1).getValor()==((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());
                            break;
                        case '!':
                            this.result=((SymInt)this.a1).getValor()!=((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                            break;
                        case '>':
                            this.result=((SymInt)this.a1).getValor()>((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                            break;
                        case '<':
                            this.result=((SymInt)this.a1).getValor()<((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                            break;
                            /*Mayor igual*/
                        case '~':
                            this.result=((SymInt)this.a1).getValor()>=((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                          break;
                            /*Menor igual*/
                        case '#':
                            this.result=((SymInt)this.a1).getValor()<=((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                            break;
                        }
                }
                else
                    throw new Exception("Tipos de datos incomprarables, "+ a1.TipoDato() +" , " + a2.TipoDato()+ " Linea: "+ a1.getNumeroLinea()+" Columna: "+a1.getNumeroColumna());
            }
            if(this.a1.TipoDato()== Simbolo.TipoSimbolo.Flotante )
            {
                if(a2.TipoDato()== Simbolo.TipoSimbolo.Flotante || a2.TipoDato()== Simbolo.TipoSimbolo.Entero)
                {
                     switch(this.compexp)
                    {
                        case '=':
                            this.result=((SymFloat)this.a1).getValor()==((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());
                            break;
                        case '!':
                            this.result=((SymFloat)this.a1).getValor()!=((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                            break;
                        case '>':
                            this.result=((SymFloat)this.a1).getValor()>((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                            break;
                        case '<':
                            this.result=((SymFloat)this.a1).getValor()<((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                            break;
                            /*Mayor igual*/
                        case '~':
                            this.result=((SymFloat)this.a1).getValor()>=((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                          break;
                        case '#':
                            this.result=((SymFloat)this.a1).getValor()<=((a2.TipoDato()== Simbolo.TipoSimbolo.Entero)?((SymInt)this.a2).getValor():((SymFloat)this.a2).getValor());;
                            break;
                        }
                }
                else
                    throw new Exception("Tipos de datos incomprarables, "+ a1.TipoDato() +" , " + a2.TipoDato()+ " Linea: "+ a1.getNumeroLinea()+" Columna: "+a1.getNumeroColumna());
            }
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="a1!=null && dato1!=null">
        if(a1!=null && dato1!=null)
        {
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Booleano)
            {
                switch(this.compexp)
                {
                    case '=':
                        this.result=((SymBoolean)a1).getValor()== Boolean.parseBoolean(dato1.toString());
                        break;
                   case '!':
                        this.result=((SymBoolean)a1).getValor()!= Boolean.parseBoolean(dato1.toString());
                        break;
                       default:
                            throw  new Exception("Las operaciones de comparacion con booleanos solo pueden ser del tipo equals y dif. Linea: "+this.a1.getNumeroLinea()+" Columna: "+this.a1.getNumeroColumna());
                }
            }
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Cadena)
            {
                switch(this.compexp)
                {
                    case '=':
                        this.result= ((SymString)a1).getValor().compareTo(dato1.toString())==0;
                        break;
                    case '!':
                        this.result= ((SymString)a1).getValor().compareTo(dato1.toString())!=0;
                        break;
                        default:
                            throw  new Exception("Las operaciones de comparacion con cadenas solo pueden ser del tipo equals y dif. Linea: "+this.a1.getNumeroLinea()+" Columna: "+this.a1.getNumeroColumna());
                }
            }
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Entero)
            {
                float dato= Float.parseFloat(dato1.toString());
                switch(this.compexp)
                {
                    case '=':
                        this.result= ((SymInt)a1).getValor()==dato;
                        break;
                    case '!':
                        this.result= ((SymInt)a1).getValor()== dato;
                        break;
                    case '>':
                        this.result=((SymInt)a1).getValor()>dato;
                        break;
                    case '<':
                        this.result= ((SymInt)a1).getValor()< dato;
                        break;
                    case '~':
                        this.result= ((SymInt)a1).getValor()>=dato;
                        break;
                    case '#':
                        this.result= ((SymInt)a1).getValor()<= dato;
                        break;
                }
            }
            if(a1.TipoDato()== Simbolo.TipoSimbolo.Flotante)
            {
                float dato= Float.parseFloat(dato1.toString());
                switch(this.compexp)
                {
                    case '=':
                        this.result= ((SymFloat)a1).getValor()==dato;
                        break;
                    case '!':
                        this.result= ((SymFloat)a1).getValor()== dato;
                        break;
                    case '>':
                        this.result=((SymFloat)a1).getValor()>dato;
                        break;
                    case '<':
                        this.result= ((SymFloat)a1).getValor()< dato;
                        break;
                    case '~':
                        this.result= ((SymFloat)a1).getValor()>=dato;
                        break;
                    case '#':
                        this.result= ((SymFloat)a1).getValor()<= dato;
                        break;
                }
            }
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="dato1!=null && dato2!=null">
        if(dato1!=null && dato2!=null)
        {
            if(dato1.getClass()== String.class)
            {
                switch(this.compexp)
                {
                    case '=':
                        this.result=((String)dato1).compareTo(((String)dato2))==0;
                        break;
                        case '!':
                        this.result=((String)dato1).compareTo(((String)dato2))!=0;
                        break;
                        default:
                              throw  new Exception("Las operaciones de comparacion con cadenas solo pueden ser del tipo equals y dif.");
                }
            }
            if(dato1.getClass()== Boolean.class)
            {
                switch(this.compexp)
                {
                    case '=':
                        this.result= ((Boolean)dato1)== ((Boolean)dato2);
                        break;
                    case '!':
                        this.result=((Boolean)dato1)!= ((Boolean)dato2);
                     break;
                        default:
                              throw  new Exception("Las operaciones de comparacion con booleanos solo pueden ser del tipo equals y dif.");
                        
                }
            }
            if(dato1.getClass()== Float.class)
            {
                if(dato2.getClass()!= Integer.class || dato2.getClass()!= Float.class)
                    throw new Exception("Error. tipos incomparables.");
                float da= (Float.parseFloat(dato1.toString()));
                float  db=((Float)dato2);
                switch(this.compexp)
                {
                    case '=':
                        this.result=da==db;
                        break;
                    case '!':
                        this.result= da!= db;
                        break;
                    case '>':
                        this.result= da>db;
                        break;
                    case '<':
                            this.result= da<db;
                        break;
                    case '~':
                        this.result= da>=db;
                        break;
                    case '#':
                        this.result= da<= db;
                        break;
                }
            }
            if(dato1.getClass()== Integer.class)
            {
                if(dato2.getClass()!= Integer.class || dato2.getClass()!= Float.class)
                    throw new Exception("Error. tipos incomparables.");
                int da= (Integer.parseInt(dato1.toString()));
                float  db=((Float)dato2);
                switch(this.compexp)
                {
                    case '=':
                        this.result=da==db;
                        break;
                    case '!':
                        this.result= da!= db;
                        break;
                    case '>':
                        this.result= da>db;
                        break;
                    case '<':
                            this.result= da<db;
                        break;
                    case '~':
                        this.result= da>=db;
                        break;
                    case '#':
                        this.result= da<= db;
                        break;
                }
            }
        }
         //</editor-fold>
        
    }
    
}
