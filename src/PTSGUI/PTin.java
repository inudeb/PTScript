/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PTSGUI;

import java.io.IOException;
import java.io.InputStream;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class PTin  {
    
    JTextArea t;
    
    public void redirectSystemin()
    {
        InputStream in = new InputStream() {

            @Override
            public int read() throws IOException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public int read(byte[] b, int off, int len) throws IOException {
                //t.r
                return super.read(b, off, len);
            }

            @Override
            public int read(byte[] b) throws IOException {
                return super.read(b);
            }
            
            
        };
    }
    
}
