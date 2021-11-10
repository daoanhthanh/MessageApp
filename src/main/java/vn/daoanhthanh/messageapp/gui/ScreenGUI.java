/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.daoanhthanh.messageapp.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

import vn.daoanhthanh.messageapp.network.MessageListener;
import vn.daoanhthanh.messageapp.network.MessageTransmitter;
import vn.daoanhthanh.messageapp.network.WritableGUI;

/**
 *
 * @author ADMIN
 */
public class ScreenGUI extends javax.swing.JFrame implements WritableGUI {

    /**
     * Creates new form ScreenGUI
     */
    public ScreenGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ipAddress = new javax.swing.JTextField();
        ipAddress.setHorizontalAlignment(SwingConstants.CENTER);
        ipAddress.setText("localhost");
        targetPort = new javax.swing.JTextField();
        targetPort.setHorizontalAlignment(SwingConstants.CENTER);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        chatArea = new javax.swing.JTextArea(100, 200);
        chatArea.setMargin(new Insets(2, 6, 2, 2));
        chatArea.setEditable(false);
        chatArea.setAlignmentY(Component.TOP_ALIGNMENT);
        chatArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        msgField = new javax.swing.JTextField();
        msgField.setBackground(Color.LIGHT_GRAY);
        msgField.setSelectedTextColor(Color.GRAY);
        msgField.setMargin(new Insets(2, 12, 2, 2));
        sendButton = new javax.swing.JButton();
        sendButton.setMnemonic(KeyEvent.VK_ENTER);
        sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        port.setHorizontalAlignment(SwingConstants.CENTER);
        startButton = new javax.swing.JButton();
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ipAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipfieldActionPerformed(evt);
            }
        });

        targetPort.setText("7749");
        targetPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetportActionPerformed(evt);
            }
        });

        chatArea.setBackground(Color.LIGHT_GRAY);
        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        sendButton.setBackground(Color.WHITE);
        sendButton.setForeground(Color.BLACK);
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("IP Address");

        jLabel2.setText("Target Port:");

        port.setText("9981");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Port:");
        DefaultCaret caret = (DefaultCaret) chatArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(msgField, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addGap(23))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(port,
                                                        GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup().addGap(35).addComponent(jLabel3)))
                                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup().addGap(44).addComponent(ipAddress,
                                                GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addPreferredGap(ComponentPlacement.RELATED,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 95,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(50)))
                                .addGap(28)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 72,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(targetPort, GroupLayout.PREFERRED_SIZE, 67,
                                                GroupLayout.PREFERRED_SIZE))))
                .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout
                                .createSequentialGroup()
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel3)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(port, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ipAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(targetPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(3))
                        .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(msgField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                .addContainerGap()));
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void targetportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_targetportActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_targetportActionPerformed

    private void ipfieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ipfieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_ipfieldActionPerformed

    MessageListener listener;

    private void listenButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_listenbuttonActionPerformed
        listener = new MessageListener(this, Integer.parseInt(port.getText()));
        listener.start();
    }// GEN-LAST:event_listenbuttonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sendbuttonActionPerformed
        MessageTransmitter transmitter = new MessageTransmitter(msgField.getText(), ipAddress.getText(),
                Integer.parseInt(targetPort.getText()), this);
        transmitter.start();
        msgField.setText("");
    }// GEN-LAST:event_sendbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
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
            java.util.logging.Logger.getLogger(ScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatArea;
    private javax.swing.JTextField ipAddress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField msgField;
    private javax.swing.JTextField port;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField targetPort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void write(String s) {
        chatArea.append(s + System.lineSeparator());
        // chatArea.append("You: " + s + System.lineSeparator());
    }
}
