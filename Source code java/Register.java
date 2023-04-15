/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ashutosh
 */
public class Register extends JFrame implements ActionListener {

    JTextField tfusername;
    JPasswordField tfpassword;
    JButton Add, Back;

    Register() {
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setTitle("NEW USER REGISTRATION");

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        Add = new JButton("Add User");
        Add.setBounds(40, 150, 120, 30);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.addActionListener(this);
        add(Add);

        Back = new JButton("BACK");
        Back.setBounds(200, 150, 120, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setBounds(500, 200, 600, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Add) {

            String username = tfusername.getText();
            String password = tfpassword.getText();
            try {
                Conn conn = new Conn();

                String query = "INSERT INTO login VALUES ('" + username + "','" + password + "')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "User added successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {
        new Register();
    }

}
