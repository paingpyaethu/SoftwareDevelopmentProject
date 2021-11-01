package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class ViewCustomerDetails extends JFrame implements ActionListener {
    
    private JButton backButton;
    
    ViewCustomerDetails(String username){
        
        this.setBounds(410, 150, 900, 550);
        this.getContentPane().setBackground(Color.WHITE);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        JLabel label = new JLabel("CUSTOMER DETAILS");
        label.setBounds(30, 0, 300, 50);
        label.setFont(new Font("Tahoma",Font.BOLD,16));
        label.setForeground(Color.red);
        add(label);
        
        JLabel userLabel = new JLabel("Username :");
        userLabel.setBounds(30, 40, 100, 50);
        this.add(userLabel);
        
        JLabel userLabel1 = new JLabel();
        userLabel1.setBounds(200, 53, 150, 25);
        userLabel1.setForeground(new Color(0, 102, 0));
        this.add(userLabel1);
        
        JLabel idLabel = new JLabel("ID :");
        idLabel.setBounds(30, 80, 100, 50);
        this.add(idLabel);
        
        JLabel idLabel1 = new JLabel();
        idLabel1.setBounds(200, 94, 150, 25);
        idLabel1.setForeground(new Color(0, 102, 0));
        this.add(idLabel1);
        
        JLabel numLabel = new JLabel("Number :");
        numLabel.setBounds(30, 120, 100, 50);
        this.add(numLabel);
        
        JLabel numLabel1 = new JLabel();
        numLabel1.setBounds(200, 134, 150, 25);
        numLabel1.setForeground(new Color(0, 102, 0));
        add(numLabel1);
        
        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(30, 160, 100, 50);
        this.add(nameLabel);
        
        JLabel nameLabel1 = new JLabel();
        nameLabel1.setBounds(200, 174, 150, 25);
        nameLabel1.setForeground(new Color(0, 102, 0));
        add(nameLabel1);
        
        JLabel genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(30, 200, 100, 50);
        this.add(genderLabel);
        
        JLabel genderLabel1 = new JLabel();
        genderLabel1.setBounds(200, 214, 150, 25);
        genderLabel1.setForeground(new Color(0, 102, 0));
        add(genderLabel1);
        
        JLabel countryLabel = new JLabel("Country :");
        countryLabel.setBounds(380, 40, 100, 50);
        this.add(countryLabel);
        
        JLabel countryLabel1 = new JLabel();
        countryLabel1.setBounds(550, 53, 150, 25);
        countryLabel1.setForeground(new Color(0, 102, 0));
        add(countryLabel1);
        
        JLabel addressLabel = new JLabel("Address :");
        addressLabel.setBounds(380, 80, 100, 50);
        this.add(addressLabel);
        
        JLabel addressLabel1 = new JLabel();
        addressLabel1.setBounds(550, 93, 150, 25);
        addressLabel1.setForeground(new Color(0, 102, 0));
        add(addressLabel1);
        
        JLabel phLabel = new JLabel("Phone :");
        phLabel.setBounds(380, 120, 100, 50);
        this.add(phLabel);
        
        JLabel phLabel1 = new JLabel();
        phLabel1.setBounds(550, 133, 150, 25);
        phLabel1.setForeground(new Color(0, 102, 0));
        add(phLabel1);
        
        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(380, 160, 100, 50);
        this.add(emailLabel);
        
        JLabel emailLabel1 = new JLabel();
        emailLabel1.setBounds(550, 173, 150, 25);
        emailLabel1.setForeground(new Color(0, 102, 0));
        add(emailLabel1);
     
        backButton = new JButton("Back");
        backButton.setBounds(50, 430, 100, 25);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        add(backButton);
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/test.png"));
        //Image image = icon1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        //ImageIcon icon2 = new ImageIcon(image);
        JLabel iconLabel = new JLabel(icon1);
        iconLabel.setBounds(150, 150, 550, 400);
        add(iconLabel);
        
        try{
            Conn connection = new Conn();
            ResultSet rs = connection.statement.executeQuery("select * from customer where username = '"+username+"'");
                while(rs.next()){
                    userLabel1.setText(rs.getString("username"));
                    idLabel1.setText(rs.getString("id"));
                    numLabel1.setText(rs.getString("number"));
                    nameLabel1.setText(rs.getString("name"));
                    genderLabel1.setText(rs.getString("gender"));
                    countryLabel1.setText(rs.getString("country"));
                    addressLabel1.setText(rs.getString("address"));
                    phLabel1.setText(rs.getString("phone"));
                    emailLabel1.setText(rs.getString("email"));
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource() == backButton){
            try{
                this.setVisible(false);
                
            }catch(Exception e){}
        }
    }

    public static void main(String[] args){
        new ViewCustomerDetails("").setVisible(true);
    }
}

