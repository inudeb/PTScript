/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class SymString extends  Simbolo{
    String valor;

    public SymString(String valor, int numeroLinea, int numeroColumna, String nombre) {
        super(numeroLinea, numeroColumna, nombre);
        this.valor = valor;
    }

    public SymString(int numeroLinea, int numeroColumna, String nombre) {
        super(numeroLinea, numeroColumna, nombre);
    }
    public SymString(int numeroLinea, int numeroColumna, String nombre, PTReadLn _r) {
        super(numeroLinea, numeroColumna, nombre);
        this.r=_r;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    @Override
    public TipoSimbolo TipoDato()
    {
        return TipoSimbolo.Cadena;
    }
}
