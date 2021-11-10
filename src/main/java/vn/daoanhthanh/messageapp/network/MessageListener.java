package vn.daoanhthanh.messageapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.daoanhthanh.messageapp.utils.BlockTransmitter;

/**
 * @author Dao Anh Thanh
 * @version 1.1
 */
public class MessageListener extends Thread {

    private ServerSocket server;
    private WritableGUI gui;
    private final Security security = new Security();
    private final String secretKey = "NPR-secret_key";

    public MessageListener(WritableGUI gui, int port, InetAddress ipAddress) {
        // InetAddress localAddress = null;
        // try {
        // localAddress = InetAddress.getLocalHost();
        // } catch (UnknownHostException e) {
        // e.printStackTrace();
        // }
        this.gui = gui;
        try {
            server = new ServerSocket(port, 1, ipAddress);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }

    @Override
    public void run() {
        Socket clientSocket;
        try {
            if (server == null) {
                BlockTransmitter.needBlock = true;
            }
            while ((clientSocket = server.accept()) != null) {
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String reply = br.readLine();
                if (reply != null) {
                    gui.write("Encrypted message: " + reply);
                    reply = security.decrypt(reply, secretKey);
                    gui.write("Re: " + reply);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
