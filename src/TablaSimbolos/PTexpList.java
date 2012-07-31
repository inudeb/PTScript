/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class PTexpList {
    PTExp exp;
    PTexpList l;
    int indice=0;
    public PTexpList(PTExp exp, PTexpList l) {
        this.exp = exp;
        this.exp.indice= l.length()+1;
        this.l = l;
         
    }

    public PTexpList(PTExp exp) {
        this.exp = exp;
        this.l=null;
        indice++;
    }
    
    public void ejecutarSintatxis()throws Exception
    {
        if(this.l!=null){
            this.l.ejecutarSintatxis();
        }
        this.exp.ejecutarSintaxis();
    }
    
    public void verificarTablaSimbolos(SymbolsTable t)throws Exception
    {
        if((this.exp.getClass() == SymBoolean.class)||(this.exp.getClass() == SymFloat.class)||(this.exp.getClass() == SymInt.class)||(this.exp.getClass() == SymString.class))
        {
            this.exp.verificarTablaSimbolos(t);
            if(this.l!=null)
                l.verificarTablaSimbolos(t);
        }
        else{
         if(this.l!=null)
            l.verificarTablaSimbolos(t);
         this.exp.verificarTablaSimbolos(t);
        }
    }
    public PTExp getElementAt(int _indice)throws IndexOutOfBoundsException
    {
         if(this.indice==_indice)
            return exp;
        else
        {
            if(l!=null)
                 return  l.getElementAt(_indice);
            throw new IndexOutOfBoundsException("No se encontro el elemento en el indice "+_indice);
        }
    }
     public int  length()
    {
        if(l==null)
            return 1;
        else
            return 1+ l.length();
    }
    
    
}
