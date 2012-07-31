/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class SymBoolean extends  Simbolo{
    Boolean valor;

    public SymBoolean(Boolean valor, int numeroLinea, int numeroColumna, String nombre) {
        super(numeroLinea, numeroColumna, nombre);
        this.valor = valor;
    }

    public SymBoolean(int numeroLinea, int numeroColumna, String nombre) {
        super(numeroLinea, numeroColumna, nombre);
    }

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }
    
    @Override 
    public TipoSimbolo TipoDato()
    {
        return  TipoSimbolo.Booleano;
    }
}
