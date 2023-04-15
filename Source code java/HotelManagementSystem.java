package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Ashutosh
 */
public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() { //Constructor to run by just creating object
        setSize(1366, 565);
        setLocation(100, 100); //Location on screen 100 from left and up
        setLayout(null);
        setTitle("THE TAJ");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 60);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);

        setVisible(true);

        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HotelManagementSystem(); //object of the class
        // TODO code application logic here
    }

}
