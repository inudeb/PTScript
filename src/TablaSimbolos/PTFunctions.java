/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class PTFunctions extends  PTExp{

    String ident;
    SymbolsTable t;
    PTexpList  explist;
    PTFunctionParam parametros;

    public PTFunctions(String ident, PTexpList explist, PTFunctionParam parametros) {
        this.ident = ident;
        this.explist = explist;
        this.parametros = parametros;
        //Esta es la tabla de simbolos para la funcion
        this.t= new SymbolsTable();
    }
    
    
    
    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
        //this.t=t;
        this.parametros.verificarTablaSimbolos(this.t);
        this.explist.verificarTablaSimbolos(this.t);
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
