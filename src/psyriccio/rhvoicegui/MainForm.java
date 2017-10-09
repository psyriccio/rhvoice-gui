/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psyriccio.rhvoicegui;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author psyriccio
 */
public class MainForm extends javax.swing.JFrame {

    private boolean rendered = false;
    private RHVoiceServiceThread serviceThread;
    
    private static String execAndWait(String cmd) {
        String result = "";
        Process exec;
        try {
            exec = Runtime.getRuntime().exec(cmd);
            InputStream inStr = exec.getInputStream();
            while(exec.isAlive()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
            }
            result = new String(ByteStreams.toByteArray(inStr), "UTF-8");
        } catch (IOException ex) {
            result = "";
        }
        return result;
    }
    
    /**
     * Creates new form MainForm
     */
    public MainForm() throws IOException, InterruptedException {
        initComponents();
        serviceThread = new RHVoiceServiceThread();
        serviceThread.start();
        Thread.sleep(500);
        String version = execAndWait("RHVoice-client --version");
        String[] voices = execAndWait("ls -m /usr/share/RHVoice/voices/").split(", ");
        jLabelInfo.setText(version);
        jComboBoxVoice.setModel(new DefaultComboBoxModel<>(voices));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();
        jComboBoxVoice = new javax.swing.JComboBox<>();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jButtonPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RHVoice-gui");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelInfo.setText("   ");

        jTextPane.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jTextPaneVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane);

        jSlider1.setFont(new java.awt.Font("Dialog", 1, 5)); // NOI18N
        jSlider1.setMajorTickSpacing(5);
        jSlider1.setMaximum(10);
        jSlider1.setMinimum(-10);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setToolTipText("Rate");
        jSlider1.setValue(0);
        jSlider1.setName(""); // NOI18N

        jSlider2.setFont(new java.awt.Font("Dialog", 1, 5)); // NOI18N
        jSlider2.setMajorTickSpacing(5);
        jSlider2.setMaximum(10);
        jSlider2.setMinimum(-10);
        jSlider2.setMinorTickSpacing(1);
        jSlider2.setPaintLabels(true);
        jSlider2.setPaintTicks(true);
        jSlider2.setToolTipText("Pitch");
        jSlider2.setValue(0);

        jButtonPlay.setText("‣");
        jButtonPlay.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonPlay.setMaximumSize(new java.awt.Dimension(32, 32));
        jButtonPlay.setMinimumSize(new java.awt.Dimension(32, 32));
        jButtonPlay.setPreferredSize(new java.awt.Dimension(32, 32));
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jComboBoxVoice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jComboBoxVoice))
                    .addComponent(jButtonPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(serviceThread != null) {
            serviceThread.interrupt();
            while(!serviceThread.isInterrupted()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void render() {
        File file = new File("/tmp/rhvoice-gui-text.txt");
        File rndFile = new File("/tmp/rhvoice-gui-rendered.wav");
        if(file.exists()) {
            file.delete();
        }
        if(rndFile.exists()) {
            rndFile.delete();
        }
        try {
            Files.write(jTextPane.getText().getBytes("UTF-8"), file);
            execAndWait("cat /tmp/rhvoice-gui-text.txt | RHVoice-client -s aleksandr -r 0 -p 0 > /tmp/rhvoice-gui-rendered.wav");
            if(rndFile.exists()) {
                rendered = true;
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jTextPaneVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jTextPaneVetoableChange
        rendered = false;
    }//GEN-LAST:event_jTextPaneVetoableChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JComboBox<String> jComboBoxVoice;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JTextPane jTextPane;
    // End of variables declaration//GEN-END:variables
}
