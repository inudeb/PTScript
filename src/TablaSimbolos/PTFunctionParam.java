/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class PTFunctionParam extends PTExp {
  
    public static final int variable=1;
    public static final int entero=2;
    public static final int cadena=3;
    public static final int booleano=4;
    public static final int flotante=5;
    
    PTIdent ident;
    int  tipoParametro;
    Integer valorEntero;
    Boolean valorBooleano;
    Float valorFlotante;
    String valorCadena;
    PTFunctionParam next;

    public PTFunctionParam(PTIdent ident) {
        this.ident = ident;
        this.tipoParametro= PTFunctionParam.variable;
    }

    public PTFunctionParam(Integer valorEntero) {
        this.valorEntero = valorEntero;
        this.tipoParametro= PTFunctionParam.entero;
    }

    public PTFunctionParam(Boolean valorBooleano) {
        this.valorBooleano = valorBooleano;
        this.tipoParametro= PTFunctionParam.booleano;
    }

    public PTFunctionParam(Float valorFlotante) {
        this.valorFlotante = valorFlotante;
        this.tipoParametro= PTFunctionParam.flotante;
    }

    public PTFunctionParam(String valorCadena) {
        this.valorCadena = valorCadena;
        this.tipoParametro= PTFunctionParam.cadena;
    }

    public PTFunctionParam(Integer valorEntero, PTFunctionParam next) {
        this.valorEntero = valorEntero;
        this.next = next;
         this.tipoParametro= PTFunctionParam.entero;
    }

    public PTFunctionParam(Boolean valorBooleano, PTFunctionParam next) {
        this.valorBooleano = valorBooleano;
        this.next = next;
         this.tipoParametro= PTFunctionParam.booleano;
    }

    public PTFunctionParam(Float valorFlotante, PTFunctionParam next) {
        this.valorFlotante = valorFlotante;
        this.next = next;
         this.tipoParametro= PTFunctionParam.flotante;
    }

    public PTFunctionParam(String valorCadena, PTFunctionParam next) {
        this.valorCadena = valorCadena;
        this.next = next;
         this.tipoParametro= PTFunctionParam.cadena;
    }

    public PTFunctionParam(PTIdent ident, PTFunctionParam next) {
        this.ident = ident;
        this.next = next;
         this.tipoParametro= PTFunctionParam.variable;
    }
    
    
    Simbolo s1;
    
    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
        if(this.next!=null)
            this.next.verificarTablaSimbolos(t);
        if(this.tipoParametro== PTFunctionParam.variable)
           s1=t.buscar(this.ident.getNombre()); 
          
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
