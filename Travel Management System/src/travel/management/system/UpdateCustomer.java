package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    
    private JTextField userTF, idTF, numTF, nameTF, genderTF, countryTF, addressTF, phTF, emailTF;
    private JButton updateButton, backButton;
    
    UpdateCustomer(String username){
        
        this.setBounds(410, 150, 850, 550);
        this.getContentPane().setBackground(Color.WHITE);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        JLabel label = new JLabel("UPDATE CUSTOMER DETAILS");
        label.setBounds(30, 0, 300, 50);
        label.setFont(new Font("Tahoma",Font.BOLD,16));
        label.setForeground(Color.red);
        add(label);
        
        JLabel userLabel = new JLabel("Username :");
        userLabel.setBounds(30, 40, 100, 50);
        this.add(userLabel);
        
        userTF = new JTextField();
        userTF.setBounds(200, 54, 150, 25);
        this.add(userTF);
        
        JLabel idLabel = new JLabel("ID :");
        idLabel.setBounds(30, 80, 100, 50);
        this.add(idLabel);
        
        idTF = new JTextField();
        idTF.setBounds(200, 94, 150, 25);
        this.add(idTF);
        
        JLabel numLabel = new JLabel("Number :");
        numLabel.setBounds(30, 120, 100, 50);
        this.add(numLabel);
        
        numTF = new JTextField();
        numTF.setBounds(200, 134, 150, 25);
        add(numTF);
        
        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(30, 160, 100, 50);
        this.add(nameLabel);
        
        nameTF = new JTextField();
        nameTF.setBounds(200, 174, 150, 25);
        add(nameTF);
        
        JLabel genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(30, 200, 100, 50);
        this.add(genderLabel);
        
        genderTF = new JTextField();
        genderTF.setBounds(200, 214, 150, 25);
        add(genderTF);
        
        JLabel countryLabel = new JLabel("Country :");
        countryLabel.setBounds(30, 240, 100, 50);
        this.add(countryLabel);
        
        countryTF = new JTextField();
        countryTF.setBounds(200, 254, 150, 25);
        add(countryTF);
        
        JLabel addressLabel = new JLabel("Address :");
        addressLabel.setBounds(30, 280, 100, 50);
        this.add(addressLabel);
        
        addressTF = new JTextField();
        addressTF.setBounds(200, 294, 150, 25);
        add(addressTF);
        
        JLabel phLabel = new JLabel("Phone :");
        phLabel.setBounds(30, 320, 100, 50);
        this.add(phLabel);
        
        phTF = new JTextField();
        phTF.setBounds(200, 334, 150, 25);
        add(phTF);
        
        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(30, 360, 100, 50);
        this.add(emailLabel);
        
        emailTF = new JTextField();
        emailTF.setBounds(200, 374, 150, 25);
        add(emailTF);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(100, 430, 100, 25);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusable(false);
        updateButton.addActionListener(this);
        add(updateButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(250, 430, 100, 25);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        add(backButton);
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/update.png"));
        //Image image = icon1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        //ImageIcon icon2 = new ImageIcon(image);
        JLabel iconLabel = new JLabel(icon1);
        iconLabel.setBounds(400, 50, 400, 400);
        add(iconLabel);
        
        try{
            Conn connection = new Conn();
            ResultSet rs = connection.statement.executeQuery("select * from customer where username = '"+username+"'");
                while(rs.next()){
                    userTF.setText(rs.getString("username"));
                    idTF.setText(rs.getString("id"));
                    numTF.setText(rs.getString("number"));
                    nameTF.setText(rs.getString("name"));
                    genderTF.setText(rs.getString("gender"));
                    countryTF.setText(rs.getString("country"));
                    addressTF.setText(rs.getString("address"));
                    phTF.setText(rs.getString("phone"));
                    emailTF.setText(rs.getString("email"));
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource() == updateButton){
            
            String username = userTF.getText();
            String id = idTF.getText();
            String number = numTF.getText();
            String name = nameTF.getText();
            String gender = genderTF.getText();
            String country = countryTF.getText();
            String address = addressTF.getText();
            String phone = phTF.getText();
            String email = emailTF.getText();

            String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'";
                    try{
                        Conn connection = new Conn();
                        connection.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully.");
                        this.setVisible(false);
                  
                    }catch(Exception e){
                        e.printStackTrace();
                    }
        }else if(ae.getSource() == backButton){
            try{
                this.setVisible(false);
            }catch(Exception e){}
        }
    }

    public static void main(String[] args){
        new UpdateCustomer("").setVisible(true);
    }
}
