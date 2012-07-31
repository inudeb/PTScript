/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PTSGUI;

import PTLex.PTLexer;
import PTSintax.parser;
import java.awt.event.WindowAdapter;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author alex
 */
public class MainFrame extends javax.swing.JFrame {

    PTout p;
    PTout Consola;
    File archivoFuente;
    FileReader lector;
    JFileChooser selector;
    String nombreArchivo;
    Scanner sc;
    PTLexer lexico;
    parser par; 
    FileWriter fw;
    ExecDialog dexe;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setTitle("PT-IDE");
        this.selector= new JFileChooser("user.home");
        this.selector.setAcceptAllFileFilterUsed(false);
        FileFilter filtro = new FileFilter() {

            @Override
            public boolean accept(File f) {
                if(f.getName().endsWith(".pts")||f.getName().endsWith(".PTS"))
                    return true;
                else
                  return f.isDirectory();
            }

            @Override
            public String getDescription() {
               return "Archivo de codigo fuente PTScript";
            }
        };
        this.selector.setFileFilter(filtro);
        this.selector.setDialogTitle("Seleccione el archivo de codigo fuente");
        this.Consola= new PTout(this.ConsolaTextArea,true);
        this.Consola.redirectSystemStream();
       
        //p= new PTout(AreaSalida);
        //p.redirectSystemStream();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaSalida = new javax.swing.JTextArea();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 0), new java.awt.Dimension(200, 32767));
        jScrollPane3 = new javax.swing.JScrollPane();
        ConsolaTextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AreaSalida.setColumns(20);
        AreaSalida.setRows(5);
        jScrollPane1.setViewportView(AreaSalida);

        ConsolaTextArea.setColumns(20);
        ConsolaTextArea.setEditable(false);
        ConsolaTextArea.setRows(5);
        jScrollPane3.setViewportView(ConsolaTextArea);

        jMenu1.setText("Archivo");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setBackground(new java.awt.Color(217, 217, 217));
        jMenuItem6.setLabel("Nuevo");
        jMenu1.add(jMenuItem6);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setLabel("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setLabel("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Guardar como");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Depurar");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem7.setLabel("Correr");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addGap(366, 366, 366))
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(!this.AreaSalida.getText().equals("")  && this.archivoFuente==null)
        {
            int result=  JOptionPane.showConfirmDialog(this, "Desea guardar el codigo fuente?");
            if(result== JOptionPane.YES_OPTION)
            {
                    int se=selector.showSaveDialog(this);
                    if(se== JFileChooser.APPROVE_OPTION)
                    {
                        archivoFuente= selector.getSelectedFile();
                        if( !archivoFuente.getAbsolutePath().endsWith(".pts") || !archivoFuente.getAbsolutePath().endsWith(".PTS"))
                        {
                            try {
                                this.nombreArchivo= archivoFuente.getAbsolutePath()+".pts";
                                fw= new FileWriter(this.nombreArchivo);
                                PrintWriter pw= new PrintWriter(fw);
                                    pw.println(this.AreaSalida.getText());

                            }
                            catch(IOException e)
                            {
                                System.err.println("Error al crear el archivo");
                            }
                            catch (Exception e) {
                            }
                            finally
                            {
                                if(null != fw)
                                        try {
                                        fw.close();
                                    } catch (IOException ex) {
                                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                            }

                        }
                    }
            }
        }
        else{
            int rc= this.selector.showDialog(this, "Seleccionar Archivo");
                if(rc== JFileChooser.APPROVE_OPTION)
                {
                    try {
                        this.AreaSalida.setText("");
                        this.archivoFuente=selector.getSelectedFile();
                        this.nombreArchivo=this.archivoFuente.getAbsolutePath();
                        this.setTitle("PT-IDE : "+this.nombreArchivo);
                        sc= new Scanner(archivoFuente);
                        sc.useDelimiter("\n");
                        String linea;
                        while(sc.hasNext())
                        {
                            linea= sc.next();
                            this.AreaSalida.append(linea+"\n");
                        }
                        sc.close();

                    }
                    catch (FileNotFoundException ex) {
                    //          Logger.getLogger(TextViewer.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null, "Error abriendo la ***** : " + nombreArchivo);
                    }
                    catch (Exception e) {
                    }
                }
           }   
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        if(this.archivoFuente==null)
        {
           int se=selector.showSaveDialog(this);
           if(se== JFileChooser.APPROVE_OPTION)
           {
               archivoFuente= selector.getSelectedFile();
               if( !archivoFuente.getAbsolutePath().endsWith(".pts") || !archivoFuente.getAbsolutePath().endsWith(".PTS"))
               {
                   try {
                       this.nombreArchivo= archivoFuente.getAbsolutePath()+".pts";
                       fw= new FileWriter(this.nombreArchivo);
                       PrintWriter pw= new PrintWriter(fw);
                        pw.println(this.AreaSalida.getText());
                       
                   }
                   catch(IOException e)
                   {
                       System.err.println("Error al crear el archivo");
                   }
                   catch (Exception e) {
                   }
                   finally
                   {
                       if(null != fw)
                            try {
                            fw.close();
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   }
                   
               }
               //fw= new FileW archivoFuente.getAbsolutePath().endsWith(".pts")riter();
           }
        }
        else
        {
            try {
                this.nombreArchivo= archivoFuente.getAbsolutePath();
                 fw= new FileWriter(this.nombreArchivo,false);
                  PrintWriter pw= new PrintWriter(fw);
                 pw.print("");
                  pw.println(this.AreaSalida.getText());
                  fw.close();
                this.lexico= new PTLexer(new FileReader(this.nombreArchivo));
                this.par= new parser(lexico);
                 this.dexe= new ExecDialog(this, true);
               dexe.addWindowListener(new WindowAdapter() 
               {
                   public void windowClosing(java.awt.event.WindowEvent e)
                   {
                       dexe.setVisible(false);
                   }
               });
               this.dexe.setPar(par);
                   dexe.setVisible(true);
             //
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(Exception e)
            {
                
            }
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         if(this.archivoFuente==null)
        {
           int se=selector.showSaveDialog(this);
           if(se== JFileChooser.APPROVE_OPTION)
           {
               archivoFuente= selector.getSelectedFile();
               if( !archivoFuente.getAbsolutePath().endsWith(".pts") || !archivoFuente.getAbsolutePath().endsWith(".PTS"))
               {
                   try {
                       this.nombreArchivo= archivoFuente.getAbsolutePath()+".pts";
                       fw= new FileWriter(this.nombreArchivo);
                       PrintWriter pw= new PrintWriter(fw);
                        pw.println(this.AreaSalida.getText());
                       
                   }
                   catch(IOException e)
                   {
                       System.err.println("Error al crear el archivo");
                   }
                   catch (Exception e) {
                   }
                   finally
                   {
                       if(null != fw)
                            try {
                            fw.close();
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   }
                   
               }
               //fw= new FileW archivoFuente.getAbsolutePath().endsWith(".pts")riter();
           }
        }
          else
        {
            try {
                this.nombreArchivo= archivoFuente.getAbsolutePath();
                 fw= new FileWriter(this.nombreArchivo,false);
                  PrintWriter pw= new PrintWriter(fw);
                 pw.print("");
                  pw.println(this.AreaSalida.getText());
                  fw.close();
            }
             catch (Exception ex) {
                  Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   finally
                   {
                       if(null != fw)
                            try {
                            fw.close();
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   }
        
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaSalida;
    private javax.swing.JTextArea ConsolaTextArea;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}