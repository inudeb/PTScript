/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

import java.util.Hashtable;

/**
 *
 * @author alex
 */
 class SymbolsTable {
    
    Hashtable h;
    
    SymbolsTable predecesor;

    public SymbolsTable(SymbolsTable predecesor) {
        this.h= new Hashtable();
        this.predecesor = predecesor;
    }
    public SymbolsTable() {
        this(null);
    }
    
    public Simbolo buscar(String nombre){
        Object valor = h.get(nombre);
        if(valor==null && predecesor!=null)
            valor= predecesor.buscar(nombre);
        return (valor!=null)?((Simbolo)valor):null;
    } 
    
    public boolean  agregarSimbolo(Simbolo b,String nombre)
    {
       Object valor = buscar(nombre);
       h.put(nombre, b);
       return (valor==null);
    }
    
    public int size()
    {
        return h.size();
    }
    
    
    
}
