/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author Ashutosh
 */
public class Checkout extends JFrame implements ActionListener {

    Choice ccustomer;
    JButton checkout, back;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;

    Checkout() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("CHECKOUT");

        JLabel text = new JLabel("CheckOut");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 25);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 130, 20);
        add(ccustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(300, 80, 20, 20);
        add(tick);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 25);
        add(lblroom);

        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 100, 30);
        add(lblroomnumber);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 180, 100, 25);
        add(lblcheckin);

        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 180, 30);
        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30, 230, 100, 25);
        add(lblcheckout);

        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 230, 180, 30);
        add(lblcheckouttime);

        checkout = new JButton("CHECKOUT");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        checkout.setBounds(30, 280, 120, 30);
        add(checkout);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(170, 280, 120, 30);
        add(back);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);
        add(image);

        setBounds(300, 200, 800, 400);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {

            String query = "delete from customer where number='" + ccustomer.getSelectedItem() + "'";
            String query1 = "update room set availability='Available' where roomnumber='" + lblroomnumber.getText() + "'";

            try {
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "Checkout Done");

                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String args[]) {
        new Checkout();
    }

}
