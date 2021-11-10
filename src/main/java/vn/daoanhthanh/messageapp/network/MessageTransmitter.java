package vn.daoanhthanh.messageapp.network;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.daoanhthanh.messageapp.utils.BlockTransmitter;

/**
 * @author Dao Anh Thanh
 * @version 1.1
 */
public class MessageTransmitter extends Thread {

    private String message;
    private String hostname;
    private int port;
    private WritableGUI gui;
    private final Security security = new Security();
    private final String secretKey = "NPR-secret_key";

    public MessageTransmitter() {
    }

    public MessageTransmitter(String message, String hostname, int port, WritableGUI gui) {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
        this.gui = gui;
    }

    @Override
    public void run() {
        if (!BlockTransmitter.needBlock) {
            try {
                Socket socket = new Socket(hostname, port);
                if (!message.isBlank()) {
                    gui.write("\t\tMe: " + message);
                    // encrypt message
                    // String encryptedmsg = security.encrypt("(secure) " + message, secretKey);
                    String encryptedmsg = security.encrypt(message, secretKey);
                    // send encrypted message
                    socket.getOutputStream().write(encryptedmsg.getBytes());
                }
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, "line 41 " + ex.getMessage());
            }
        }
    }
}
