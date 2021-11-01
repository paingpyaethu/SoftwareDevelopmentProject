package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class BookPackage extends JFrame implements ActionListener {
    
    JLabel userLabel1, idLabel1, numLabel1, phLabel1, priceLabel1, priceLabel, idLabel, numLabel, phLabel, userLabel;
    Choice choice;
    JTextField textField;
    JButton checkButton, bookButton, backButton;
    
    BookPackage(String username){
        this.setBounds(400, 200, 800, 400);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/bookpackage.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(350, 260, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel iconLabel = new JLabel(icon3);
        iconLabel.setBounds(400, 20, 350, 300);
        this.add(iconLabel);
        
        JLabel label = new JLabel("BOOK PACKAGE");
        label.setBounds(100, 10, 200, 30);
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
        
        JLabel packLabel= new JLabel("Select Package");
        packLabel.setBounds(50, 80, 150, 30);
        packLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(packLabel);
        
        choice = new Choice();
        choice.add("Gold Package");
        choice.add("Silver Package");
        choice.add("Bronze Package");
        choice.setBounds(230, 85, 150, 30);
        this.add(choice);
        
        JLabel personLabel = new JLabel("Total Persons");
        personLabel.setBounds(50, 110, 150, 30);
        personLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.add(personLabel);
        
        textField = new JTextField("1");
        textField.setBounds(230, 115, 150, 20);
        this.add(textField);
        
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
            ResultSet rs = connection.statement.executeQuery("select * from customer where username = '"+username+"'");
                while(rs.next()){
                    userLabel1.setText(rs.getString("username"));
                    idLabel1.setText(rs.getString("id"));
                    numLabel1.setText(rs.getString("number"));
                    phLabel1.setText(rs.getString("phone"));
                }
        }catch(Exception e){e.printStackTrace();}
        
        checkButton = new JButton("Check Price");
        checkButton.setBounds(50, 280, 120, 20);
        checkButton.setBackground(Color.black);
        checkButton.setForeground(Color.white);
        checkButton.setFocusable(false);
        checkButton.addActionListener(this);
        this.add(checkButton);
        
        bookButton = new JButton("Book Package");
        bookButton.setBounds(180, 280, 120, 20);
        bookButton.setBackground(Color.black);
        bookButton.setForeground(Color.white);
        bookButton.setFocusable(false);
        bookButton.addActionListener(this);
        this.add(bookButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(310, 280, 80, 20);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        this.add(backButton);

    }

    
    
    @Override
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == checkButton){
             
             String pack = choice.getSelectedItem();
             int cost = 0;
             switch (pack) {
                 case "Gold Package":
                     cost += 100000;
                     break;
                 case "Silver Package":
                     cost += 80000;
                     break;
                 case "Bronze Package":
                     cost += 50000;
                     break;
                 default:
                     break;
             }
             
             int person = Integer.parseInt(textField.getText());
             cost *= person;
             priceLabel1.setText(cost + " MMK");
             
         }else if(ae.getSource() == bookButton){
             
             if(userLabel1.getText().isEmpty() || choice.getSelectedItem().isEmpty() || textField.getText().isEmpty() || idLabel1.getText().isEmpty() || numLabel1.getText().isEmpty() || phLabel1.getText().isEmpty() || priceLabel1.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null, "Fill the Form Properly!", "Warning", JOptionPane.ERROR_MESSAGE);
             }else{
                    try{
                        Conn connection = new Conn();
                        connection.statement.executeUpdate("insert into BookPackage values('"+userLabel1.getText()+"','"+choice.getSelectedItem()+"','"+textField.getText()+"','"+idLabel1.getText()+"','"+numLabel1.getText()+"','"+phLabel1.getText()+"','"+priceLabel1.getText()+"')");
                        JOptionPane.showMessageDialog(null, "Package Booked Successfully!");
                        this.setVisible(false);
                 
                    }catch(Exception e){}
             
             }
         }else if(ae.getSource() == backButton){
             this.setVisible(false);
         }
         
         
     }
     
    
    public static void main(String[] args){
        new BookPackage("").setVisible(true);
    }
}
