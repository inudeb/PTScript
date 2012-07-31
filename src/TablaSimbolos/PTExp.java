/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public abstract class PTExp {
    int indice=0;
    abstract public void verificarTablaSimbolos(SymbolsTable t)throws Exception;
    abstract public void ejecutarSintaxis() throws Exception;
    
}
