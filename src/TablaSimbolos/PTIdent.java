/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;


/**
 *
 * @author alex
 */
public class PTIdent extends  PTExp{
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public PTIdent(String nombre) {
        this.nombre = nombre;
    }
    int indice;
    @Override
    public void verificarTablaSimbolos(SymbolsTable t)throws Exception
    {
        Simbolo s= t.buscar(nombre);
        if(s!=null)
            throw  new Exception("Ya existe un elemento con el identificador.");
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
