package vn.daoanhthanh.messageapp.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

import java.net.*;
// import java.awt.event.ActionListener;
import java.io.IOException;

public class GUIriks2 extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = -3379727916484935739L;
    JButton poga1 = new JButton("Poga 1"); // Definejam gui komponentes
    JTextArea area1 = new JTextArea(30, 20); // Definejam gui komponentes
    JButton poga2 = new JButton("Poga 2"); // Definejam gui komponentes
    JTextArea area2 = new JTextArea(30, 20); // Definejam gui komponentes
    JButton poga3 = new JButton("Poga 3"); // Definejam gui komponentes
    JTextArea area3 = new JTextArea(30, 20); // Definejam gui komponentes
    JButton poga4 = new JButton("Poga 4"); // Definejam gui komponentes
    JTextArea area4 = new JTextArea(30, 20); // Definejam gui komponentes

    public GUIriks2() {
        super("GUI Rīks");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container content = getContentPane();

        content.setBackground(Color.gray);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        content.add(poga1);
        content.add(area1);
        content.add(poga2);
        content.add(area2);
        content.add(poga3);
        content.add(area3);
        content.add(poga4);
        content.add(area4);

        JScrollPane scrollPane1 = new JScrollPane(area1);
        JScrollPane scrollPane2 = new JScrollPane(area2);
        JScrollPane scrollPane3 = new JScrollPane(area3);
        JScrollPane scrollPane4 = new JScrollPane(area4);
        content.add(scrollPane1, BorderLayout.WEST);
        content.add(scrollPane2, BorderLayout.NORTH);
        content.add(scrollPane3, BorderLayout.EAST);
        content.add(scrollPane4, BorderLayout.EAST);

        poga1.addActionListener(this);
        poga2.addActionListener(this);
        poga3.addActionListener(this);
        poga4.addActionListener(this);

        poga1.setBackground(new Color(175, 238, 238));
        poga2.setBackground(new Color(255, 182, 193));
        poga3.setBackground(new Color(211, 211, 211));
        poga4.setBackground(new Color(152, 251, 152));

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(poga1)
                        .addComponent(poga2).addComponent(poga3).addComponent(poga4))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(area1)
                        .addComponent(area2).addComponent(area3).addComponent(area4)));

        // Vertically, we want to align each label with his textfield
        // on the baseline of the components
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(poga1)
                        .addComponent(area1))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(poga2)
                        .addComponent(area2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(poga3)
                        .addComponent(area3))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(poga4)
                        .addComponent(area4)));

        setSize(1000, 400);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent a) {

        if (a.getSource() == poga1) {

            this.metode1();
        } else if (a.getSource() == poga2) {

            this.metode2();
        } else if (a.getSource() == poga3) {

            this.metode3();
        } else if (a.getSource() == poga4) {

            this.metode4();
        }
    }

    public void metode1()

    {
        try {
            InetAddress[] adreses = InetAddress.getAllByName("www.delfi.lv");
            for (int i = 0; i < adreses.length; i++) {
                area1.append("Adresse ir:" + adreses[i] + "\n");
            }
        } catch (UnknownHostException ex) {
            area1.append("Nevaru atrastfind www.delfi.lv");
        }
    }

    public void metode2()

    {
        boolean rootaccess = false;
        for (int port = 1; port < 1024; port += 100) {
            try {
                ServerSocket ss = new ServerSocket(port);
                // ja tas izdodas... tad...
                rootaccess = true;
                ss.close();
                break;
            } catch (IOException ex) {
            }
        }
        int startport = 1;
        if (!rootaccess)
            startport = 1024;
        int stopport = 65535;
        for (int port = startport; port <= stopport; port++) {
            try {
                ServerSocket socket1 = new ServerSocket(port);
                socket1.close();
            } catch (IOException ex) {
                area2.append("Ports " + port + " ir aiznemts \n");
            }
        }
        area2.append("Skenesana ir pabeigta!");
    }

    public void metode3() {
        Date sysDate = new Date();
        String dateString = sysDate.toString();
        area3.setText("Sodien ir " + dateString);
        area3.append("\n\n\n");
        area3.append("Seit var pievienot izvadu no citam metodem \n");
    }

    public void metode4() {
        try {
            InetAddress es = InetAddress.getLocalHost();
            area4.append("Mani sauc " + es.getHostName() + "\n");
            area4.append("Mana adrese ir " + es.getHostAddress() + "\n");
            byte[] adrese = es.getAddress();
            for (int i = 0; i < adrese.length; i++) {
                area4.append(adrese[i] + " ");
            }

        } catch (UnknownHostException e) {
            area4.append("Nevaru noteikt lokalo adresi.");
            area4.append("Baidos ka tīks nestrādā...");
        }
    }

    public static void main(String[] args) {
        new GUIriks2();
    }

}