package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class ViewBookedPackage extends JFrame implements ActionListener {
    
    JLabel userLabel1, idLabel1, numLabel1, phLabel1, priceLabel1, userLabel, priceLabel, idLabel, numLabel, phLabel;
    JButton backButton;
    
    ViewBookedPackage(String username){
        
        this.setBounds(400, 200, 800, 400);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/bookedDetails.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(350, 260, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel iconLabel = new JLabel(icon3);
        iconLabel.setBounds(400, 20, 350, 300);
        this.add(iconLabel);
        
        JLabel label = new JLabel("VIEW PACKAGE DETAILS");
        label.setBounds(100, 10, 250, 30);
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.add(label);
        
        userLabel = new JLabel("Username");
        userLabel.setBounds(50, 50, 150, 30);
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(userLabel);
        
        userLabel1 = new JLabel();
        userLabel1.setBounds(230, 50, 200, 30);
        userLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(userLabel1);
        
        JLabel packLabel= new JLabel("Package");
        packLabel.setBounds(50, 80, 150, 30);
        packLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(packLabel);
        
        JLabel packLabel2= new JLabel();
        packLabel2.setBounds(230, 85, 150, 30);
        packLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(packLabel2);
        
        JLabel personLabel = new JLabel("Total Persons");
        personLabel.setBounds(50, 110, 150, 30);
        personLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(personLabel);
        
        JLabel personLabel2 = new JLabel();
        personLabel2.setBounds(230, 115, 150, 20);
        personLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(personLabel2);
        
        idLabel = new JLabel("ID :");
        idLabel.setBounds(50, 140, 150, 30);
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(idLabel);
        
        idLabel1 = new JLabel();
        idLabel1.setBounds(230, 135, 150, 30);
        idLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(idLabel1);
        
        numLabel = new JLabel("Number");
        numLabel.setBounds(50, 170, 150, 30);
        numLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(numLabel);
        
        numLabel1 = new JLabel();
        numLabel1.setBounds(230, 165, 150, 30);
        numLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(numLabel1);
        
        phLabel = new JLabel("Phone");
        phLabel.setBounds(50, 200, 150, 30);
        phLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(phLabel);
        
        phLabel1 = new JLabel();
        phLabel1.setBounds(230, 195, 150, 30);
        phLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(phLabel1);
        
        priceLabel = new JLabel("Total Price");
        priceLabel.setBounds(50, 230, 150, 30);
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(priceLabel);
        
        priceLabel1 = new JLabel();
        priceLabel1.setBounds(230, 225, 150, 30);
        priceLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        priceLabel1.setForeground(Color.red);
        this.add(priceLabel1);
        
        try{
            Conn connection = new Conn();
            ResultSet rs = connection.statement.executeQuery("select * from bookpackage where username = '"+username+"'");
                while(rs.next()){
                    userLabel1.setText(rs.getString("username"));
                    packLabel2.setText(rs.getString("package"));
                    personLabel2.setText(rs.getString("persons"));
                    idLabel1.setText(rs.getString("id"));
                    numLabel1.setText(rs.getString("number"));
                    phLabel1.setText(rs.getString("phone"));
                    priceLabel1.setText(rs.getString("price"));
                }
        }catch(Exception e){e.printStackTrace();}
        
        backButton = new JButton("Back");
        backButton.setBounds(160, 280, 120, 20);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        add(backButton);
        
    }
    
    @Override
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource() == backButton){
            try{
                this.setVisible(false);
                
            }catch(Exception e){}
        }
         
     }
    
    public static void main(String[] args){
        new ViewBookedPackage("").setVisible(true);
    }
    
}
