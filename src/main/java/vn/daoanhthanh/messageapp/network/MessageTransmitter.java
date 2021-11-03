package vn.daoanhthanh.messageapp.network;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageTransmitter extends Thread {

    private String message;
    private String ipAddress;
    private int port;
    private WritableGUI gui;

    public MessageTransmitter() {
    }

    public MessageTransmitter(String message, String ipAddress, int port, WritableGUI gui) {
        this.message = message;
        this.ipAddress = ipAddress;
        this.port = port;
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(ipAddress, port);
            socket.getOutputStream().write(message.getBytes());
            if (message != null) {
                gui.write("\t\t\tMe: " + message);
            }
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}
