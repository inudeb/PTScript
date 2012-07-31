/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PTSGUI;

import java.awt.peer.SystemTrayPeer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author alex
 */
public class PTout {
    JTextArea textArea;
    boolean toError=false;

    public PTout(JTextArea textArea) {
        this.textArea = textArea;
    }

    public PTout(JTextArea textArea, boolean toError) {
        this.textArea = textArea;
        this.toError = toError;
    }
    
    
    private void updateTextArea(final String text) {
            SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            textArea.append(text);

            }
        });
    }
    public  void redirectSystemStream()
    {
        OutputStream out = new OutputStream() {

            @Override
            public void write(int b) throws IOException {
                updateTextArea(String.valueOf((char)b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
               updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                 write(b, 0, b.length);
            }
            
            
        };
        if(this.toError)
            System.setErr(new PrintStream(out,true));
        System.setOut(new PrintStream(out,true));
        
    }
    
}
