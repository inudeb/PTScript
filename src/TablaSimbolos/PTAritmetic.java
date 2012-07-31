/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimbolos;

/**
 *
 * @author alex
 */
public class PTAritmetic extends PTExp {

    Integer numEntero;
    Float numFlotante;
    String cadena;
    String cadenaresultado;
    PTIdent id1;
    PTAritmetic l;
    PTAritmetic r;
    Simbolo s;
    char tipoOperacion;
    Double resultado=0d;
    boolean isIdent=false;

    public PTIdent getId1() {
        return id1;
    }

    public boolean isIsIdent() {
        return isIdent;
    }
    

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public String getCadenaresultado() {
        return cadenaresultado;
    }
    

    public PTAritmetic(PTAritmetic l, PTAritmetic r, char tipoOperacion) {
        this.l = l;
        this.r = r;
        this.numEntero=null;
        this.numFlotante=null;
        this.id1=null;
        this.tipoOperacion = tipoOperacion;
    }
    

    
    public PTAritmetic(Integer numEntero, char tipoOperacion ) {
        this.numEntero = numEntero;
        this.id1=null;
        this.numFlotante=null;
        this.l=null;
        this.tipoOperacion=tipoOperacion;
    }

    public PTAritmetic(Float numFlotante, char tipoOperacion) {
        this.numFlotante = numFlotante;
        this.id1=null;
        this.numEntero=null;
        this.l=null;
         this.tipoOperacion=tipoOperacion;
    }

    public PTAritmetic(PTIdent id1,char  tipoOperacion) {
        this.id1 = id1;
        this.numEntero=null;
        this.numFlotante=null;
        this.l=null;
         this.tipoOperacion=tipoOperacion;
    }

    public PTAritmetic(String cadena, char tipoOperacion) {
        this.cadena = cadena;
        this.tipoOperacion = tipoOperacion;
    }

    public PTAritmetic(Integer numEntero, PTAritmetic l, char tipoOperacion) {
        this.numEntero = numEntero;
        this.id1=null;
        this.numFlotante=null;
        this.l = l;
        this.tipoOperacion=tipoOperacion;
    }

    public PTAritmetic(Float numFlotante, PTAritmetic l,char tipoOperacion) {
        this.numFlotante = numFlotante;
        this.l = l;
        this.id1=null;
        this.numEntero=null;
        this.tipoOperacion=tipoOperacion;
    }

    public PTAritmetic(PTIdent id1, PTAritmetic l,char tipoOperacion) {
        this.id1 = id1;
        this.l = l;
        this.numEntero=null;
        this.numFlotante=null;
        this.tipoOperacion=tipoOperacion;
    }
   
    
    
    @Override
    public void verificarTablaSimbolos(SymbolsTable t) throws Exception {
        if(this.l!=null)
            l.verificarTablaSimbolos(t);
        if(this.r!=null)
            r.verificarTablaSimbolos(t);
        if(this.id1!=null){
                    s= t.buscar(this.id1.getNombre());
                if((s.TipoDato()!= Simbolo.TipoSimbolo.Entero || s.TipoDato()!= Simbolo.TipoSimbolo.Flotante )&&this.tipoOperacion!='#')
                    throw  new Exception("el tipo de la  variable "+ s.getNombre()+" no es apta para este tipo de operaciones. Linea: "+s.getNumeroLinea() +" Columna: "+s.getNumeroColumna());
        }
    }

    @Override
    public void ejecutarSintaxis() throws Exception {
        
        
        if(s!=null){
            if((s.TipoDato()!= Simbolo.TipoSimbolo.Entero && s.TipoDato()!= Simbolo.TipoSimbolo.Flotante )&&this.tipoOperacion=='#')
            {
                this.isIdent=true;
              //  return;
            }
           if(s.TipoDato()== Simbolo.TipoSimbolo.Cadena)
               this.cadenaresultado=((SymString)s).getValor();
        }
        if(this.isIdent)
        {
             this.isIdent=true;
        }
        else{
            Double expresult=0d;
            Double op1=0d;
            if(this.r!=null)
                {
                    this.r.ejecutarSintaxis();
                    op1= this.r.getResultado();
                }
            if(this.numEntero!= null)
                op1= Double.parseDouble(numEntero.toString());
            if(this.numFlotante!=null)
                op1= Double.parseDouble(this.numFlotante.toString());
            if(this.id1!=null)
            {
                if(s.TipoDato()== Simbolo.TipoSimbolo.Entero)
                    op1= Double.parseDouble(((SymInt) s).getValor().toString());
                if(s.TipoDato()== Simbolo.TipoSimbolo.Flotante)
                    op1= Double.parseDouble(((SymFloat)s).getValor().toString());
            }
                if(this.l!=null)
            {
                this.l.ejecutarSintaxis();
                expresult= this.l.getResultado();
                if(this.l.isIsIdent()){
                    this.id1= this.l.getId1();
                    this.isIdent=true;
                }
                
            }
            if(!this.isIdent){
                switch(this.tipoOperacion)
                {
                    case '+':
                        this.resultado= op1+expresult;
                        break;
                    case '-':
                        this.resultado= expresult-op1 ;
                        break;
                    case '*':
                        this.resultado= op1* expresult;
                        break;
                    case '/':
                        if(expresult!=0)
                            this.resultado= op1/expresult;
                        else
                            throw new Exception("Error de division por cero ");
                        break;
                    case '#':
                        this.resultado= op1;
                        break;
                }
            }
        }
   
    }
    
}
