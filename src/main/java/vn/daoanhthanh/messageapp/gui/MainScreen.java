package vn.daoanhthanh.messageapp.gui;

import java.awt.Cursor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import vn.daoanhthanh.messageapp.network.MessageListener;
import vn.daoanhthanh.messageapp.network.MessageTransmitter;
import vn.daoanhthanh.messageapp.network.WritableGUI;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;

public class MainScreen extends JFrame implements WritableGUI {

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ipTextField = new javax.swing.JTextField();
        ipTextField.setHorizontalAlignment(SwingConstants.CENTER);
        targetPort = new javax.swing.JTextField();
        targetPort.setHorizontalAlignment(SwingConstants.CENTER);
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextField();
        message.setHorizontalAlignment(SwingConstants.LEFT);
        sendButton = new javax.swing.JButton();
        sendButton.setMnemonic(KeyEvent.VK_ENTER);
        sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        listenButton = new javax.swing.JButton();
        listenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        receivePort = new javax.swing.JTextField();
        receivePort.setHorizontalAlignment(SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        targetPort.setText("7749");

        ipTextField.setText("localhost");

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        listenButton.setText("Start");
        listenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenButtonActionPerformed(evt);
            }
        });

        receivePort.setText("9981");
        chat = new javax.swing.JTextArea();

        chat.setColumns(20);
        chat.setRows(5);
        
        JLabel lblNewLabel = new JLabel("Listen to:");
        
        JLabel lblPort = new JLabel("Port:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(message, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(sendButton, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        					.addGap(8))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(listenButton)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(receivePort, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
        									.addComponent(ipTextField, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
        									.addGap(18)
        									.addComponent(targetPort, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
        								.addGroup(layout.createSequentialGroup()
        									.addGap(31)
        									.addComponent(lblPort))))
        						.addComponent(chat, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(369)
        			.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        			.addGap(175))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel)
        						.addComponent(lblPort))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(targetPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(receivePort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(ipTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(listenButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
        				.addComponent(chat, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(message, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
        				.addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    MessageListener listener;

    private void listenButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_listenButtonActionPerformed
        listener = new MessageListener(this, Integer.parseInt(receivePort.getText()));
        listener.start();
    }// GEN-LAST:event_listenButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sendButtonActionPerformed
        MessageTransmitter transmitter = new MessageTransmitter(message.getText(), ipTextField.getText(),
                Integer.parseInt(targetPort.getText()), this);
        transmitter.start();
    }// GEN-LAST:event_sendButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chat;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listenButton;
    private javax.swing.JTextField message;
    private javax.swing.JTextField receivePort;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField targetPort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void write(String s) {
        chat.append(s + System.lineSeparator());
    }
}
