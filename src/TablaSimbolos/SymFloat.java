/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class SymFloat extends  Simbolo{
    Float valor;
    
    public SymFloat(Float valor, int numeroLinea, int numeroColumna, String nombre) {
        super(numeroLinea, numeroColumna, nombre);
        this.valor = valor;
    }

    public SymFloat(int numeroLinea, int numeroColumna, String nombre) {
        super(numeroLinea, numeroColumna, nombre);
    }
    
    public SymFloat(int numeroLinea, int numeroColumna, String nombre, PTReadLn _r) {
        super(numeroLinea, numeroColumna, nombre);
        this.r=_r;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
    
    @Override
    public TipoSimbolo TipoDato()
    {
        return TipoSimbolo.Flotante;
    }
}
