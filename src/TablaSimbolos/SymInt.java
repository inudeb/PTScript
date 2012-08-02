/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class SymInt extends Simbolo{
    Integer valor;

    public SymInt(Integer valor, int numeroLinea, int numeroColumna, String nombre) {
        super(numeroLinea, numeroColumna, nombre);
        this.valor = valor;
    }

    public SymInt(int numeroLinea, int numeroColumna, String nombre) {
        super(numeroLinea, numeroColumna, nombre);
    }
public SymInt(int numeroLinea, int numeroColumna, String nombre,PTReadLn _r) {
        super(numeroLinea, numeroColumna, nombre);
        this.r=_r;
    }
    
    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    
    @Override
    public  TipoSimbolo TipoDato()
    {
        return TipoSimbolo.Entero;
    }
    
    
}
