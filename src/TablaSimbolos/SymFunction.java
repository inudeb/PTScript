/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class SymFunction {
    PTExp exp;
    String nombre;
    PTexpList listaExpresiones;
    SymbolsTable tabla;

    public SymFunction( String nombre,PTexpList ptlist) {
        this.exp = null;
        this.nombre = nombre;
        tabla= new SymbolsTable();
        /*Agrega las variables a la tabla de simbolo*/
        try {
        if(ptlist!=null){
            ptlist.verificarTablaSimbolos(tabla);
            ptlist.ejecutarSintatxis();
        }
        
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        
    }
    
    
    
}
