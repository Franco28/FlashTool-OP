/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneplus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class flashfirmware extends javax.swing.JFrame {

    /**
     * Creates new form flashfirmware
     */
    public flashfirmware() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Flash Firmware - BETA Es");
        setResizable(false);

        jProgressBar1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jFormattedTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oneplus/images/flashb.png"))); // NOI18N
        jButton1.setText("Flashear");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oneplus/images/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jFormattedTextField1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    File f = new File("/img/firmware/*.img");
   
    if(!f.exists()){
    JOptionPane.showMessageDialog(null,"Error: No se pudo encontrar la imagen twrp.img \n\n Por favor coloca el archivo twrp.img en /img");
    }else{        
        ProcessBuilder pb =
                    new ProcessBuilder("fastboot", "flash", "recovery", "twrp.img");            
        try {
            Map<String, String> env = pb.environment();
            env.put("VAR1", "myValue");
            env.remove("OTHERVAR");
            env.put("VAR2", env.get("VAR1") + "suffix");
            pb.directory(new File("adb/"));
            File log = new File("log");
            pb.redirectErrorStream(true);
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
            Process p = pb.start();
            if (p != pb.start()){
              JOptionPane.showMessageDialog(null,"Error:  " +pb.start()+ "\n\n Conecta el dispositivo");
              dispose();//To close the current window
              new OPVisual().setVisible(true); 
            }           
            assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
            assert pb.redirectOutput().file() == log;
            assert p.getInputStream().read() == -1; 
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " +ex);
        }              
        //Read LOG
 try {
                try (FileInputStream fstream = new FileInputStream("log")) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                    String strLine;
                    /* read log line by line */
                    while ((strLine = br.readLine()) != null)   {
                        /* parse strLine to obtain what you want */
                        jFormattedTextField1.setText(strLine);     
                    }            
                }
} catch (IOException e) {
     jFormattedTextField1.setText("Error: " +e.getMessage());    
     JOptionPane.showMessageDialog(null,"Error:  " +e.getMessage());
}
 //End Reading LOG when fail
 }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(flashfirmware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(flashfirmware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(flashfirmware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(flashfirmware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new flashfirmware().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
