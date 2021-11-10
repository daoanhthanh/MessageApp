package vn.daoanhthanh.messageapp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) {

        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostAddress();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Host address : " + hostname);

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
    }
}
