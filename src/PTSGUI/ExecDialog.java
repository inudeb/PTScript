/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PTSGUI;

import PTSintax.parser;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class ExecDialog extends java.awt.Dialog {

    parser par;
   PTout re; 
    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public ExecDialog(parser par, Frame owner, boolean modal) {
        super(owner, modal);
        this.par = par;
    }

    public parser getPar() {
        return par;
    }

    public void setPar(parser par) {
        this.par = par;
    }

    @Override
    public void setVisible(boolean b) {
        if(b){
            try {
                Object o=   this.par.parse().value;
            } catch (Exception ex) {
                Logger.getLogger(ExecDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.setVisible(b);
        
    }

   
    
    /**
     * Creates new form ExecDialog
     */
    public ExecDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        super.setSize(640, 480);
        this.re= new PTout(jTextArea1,false);
        this.re.redirectSystemStream();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setForeground(new java.awt.Color(1, 1, 1));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
