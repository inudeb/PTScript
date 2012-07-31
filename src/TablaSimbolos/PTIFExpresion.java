/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class PTIFExpresion extends PTExp {
    
    
    PTBoolExpresion l;
    PTexpList expl;
    PTexpList els;

    public PTIFExpresion(PTBoolExpresion l, PTexpList expl) {
        this.l = l;
        this.expl = expl;
    }

    
    public PTIFExpresion(PTexpList expl) {
        this.expl = expl;
    }

    public PTIFExpresion(PTBoolExpresion l, PTexpList expl, PTexpList els) {
        this.l = l;
        this.expl = expl;
        this.els = els;
    }
    
    
    
    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
        l.verificarTablaSimbolos(t);
        expl.verificarTablaSimbolos(t);
       if(this.els!=null)
        {
              this.els.verificarTablaSimbolos(t);
        }
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
        l.ejecutarSintaxis();
        if(this.l.getResult()){
           this.expl.ejecutarSintatxis();
        }else
        {
            if(this.els!=null)
            {
              this.els.ejecutarSintatxis();
            }
        }
    }
    
}
