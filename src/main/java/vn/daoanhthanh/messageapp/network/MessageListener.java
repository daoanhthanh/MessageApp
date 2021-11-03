package vn.daoanhthanh.messageapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.util.Set;
import java.util.HashSet;

public class MessageListener extends Thread {

    private ServerSocket server;
    private int port; // default port
    private WritableGUI gui;
    private final int limit = 2;

    public MessageListener(WritableGUI gui, int port) {
        this.port = port;
        this.gui = gui;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }

    @Override
    public void run() {
        Socket clientSocket;
        Set<String> vault = new HashSet<>();
        try {
            while ((clientSocket = server.accept()) != null) {

                // InetSocketAddress sockaddr =
                // (InetSocketAddress)clientSocket.getRemoteSocketAddress();
                // sockaddr.getAddress();
                // String inaddr = InetAddress.getLocalHost().getHostAddress();
                // if(!vault.add(inaddr)) {
                // server.close();
                // }
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String reply = br.readLine();
                if (reply != null) {
                    gui.write("Re: " + reply);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
