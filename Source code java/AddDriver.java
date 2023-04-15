/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author Ashutosh
 */
public class AddDriver extends JFrame implements ActionListener {

    JButton add, cancel;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox drivercombo, agecombo;

    AddDriver() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("ADD DRIVER");

        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);

        JLabel lblroomno = new JLabel("Name");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomno.setBounds(60, 70, 120, 30);
        add(lblroomno);

        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);

        JLabel lblavailable = new JLabel("Age");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 120, 120, 30);
        add(lblavailable);

        tfage = new JTextField();
        tfage.setBounds(200, 120, 150, 30);
        add(tfage);

        JLabel lblclean = new JLabel("Gender");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 170, 120, 30);
        add(lblclean);

        String cleanOptions[] = {"Male", "Female"};
        agecombo = new JComboBox(cleanOptions);
        agecombo.setBounds(200, 170, 150, 30);
        agecombo.setBackground(Color.WHITE);
        add(agecombo);

        JLabel lblprice = new JLabel("Car Company");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 220, 120, 30);
        add(lblprice);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 220, 150, 30);
        add(tfcompany);

        JLabel lbltype = new JLabel("Car Model");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60, 270, 120, 30);
        add(lbltype);

        tfmodel = new JTextField();
        tfmodel.setBounds(200, 270, 150, 30);
        add(tfmodel);

        lblavailable = new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 320, 120, 30);
        add(lblavailable);

        String driverOptions[] = {"Available", "Busy"};
        drivercombo = new JComboBox(driverOptions);
        drivercombo.setBounds(200, 320, 150, 30);
        drivercombo.setBackground(Color.WHITE);
        add(drivercombo);

        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbllocation.setBounds(60, 370, 120, 30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200, 370, 150, 30);
        add(tflocation);

        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(450, 370, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(620, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));

        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(300, 200, 980, 470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) agecombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String) drivercombo.getSelectedItem();
            String location = tflocation.getText();

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO driver VALUES ('" + name + "','" + age + "','" + gender + "','" + company + "','" + brand + "','" + available + "','" + location + "')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "New Driver added successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
