/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class PTReadLn extends PTExp{

String data="";
Object ret;

    public Object getRet() {
        return ret;
    }

    public PTReadLn(String data) {
        this.data = data;
    }

 
    
    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
       this.ret =JOptionPane.showInputDialog(data);
       Boolean.parseBoolean(data);
    }
    
}
