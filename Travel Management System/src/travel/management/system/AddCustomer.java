package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
    
        private JTextField userTF, numTF, nameTF, countryTF, addressTF, phTF, emailTF;
        private JComboBox box;
        private JRadioButton radio1,radio2;
        private JButton addButton, backButton;
    
    AddCustomer(String username){
        
            this.setBounds(410, 150, 850, 550);
            this.getContentPane().setBackground(Color.WHITE);
           // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);

            JLabel userLabel = new JLabel("Username :");
            userLabel.setBounds(30, 40, 100, 50);
            this.add(userLabel);

            userTF = new JTextField();
            userTF.setBounds(200, 54, 150, 25);
            this.add(userTF);

            JLabel idLabel = new JLabel("ID :");
            idLabel.setBounds(30, 80, 100, 50);
            this.add(idLabel);

            box = new JComboBox(new String[]{"Passport", "Visa Card", "Master Card", "NRIC NO."});
            box.setBounds(200, 94, 150, 25);
            this.add(box);

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

            radio1 = new JRadioButton("Male");
            radio1.setBounds(200, 214, 70, 25);
            radio1.setBackground(null);
            radio1.setFocusable(false);
            add(radio1);

            radio2 = new JRadioButton("Female");
            radio2.setBounds(280, 214, 70, 25);
            radio2.setBackground(null);
            radio2.setFocusable(false);
            add(radio2);

            ButtonGroup group = new ButtonGroup();
            group.add(radio1);
            group.add(radio2);

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

            addButton = new JButton("Add");
            addButton.setBounds(100, 430, 100, 25);
            addButton.setBackground(Color.BLACK);
            addButton.setForeground(Color.WHITE);
            addButton.setFocusable(false);
            addButton.addActionListener(this);
            add(addButton);

            backButton = new JButton("Back");
            backButton.setBounds(250, 430, 100, 25);
            backButton.setBackground(Color.BLACK);
            backButton.setForeground(Color.WHITE);
            backButton.addActionListener(this);
            backButton.setFocusable(false);
            add(backButton);

            ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/customer.png"));
            Image image = icon1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
            ImageIcon icon2 = new ImageIcon(image);
            JLabel iconLabel = new JLabel(icon2);
            iconLabel.setBounds(450, 100, 300, 300);
            add(iconLabel);

            try{
                Conn connection = new Conn();
                ResultSet rs = connection.statement.executeQuery("select * from account where username = '"+username+"'");
                    while(rs.next()){
                        userTF.setText(rs.getString("username"));
                        nameTF.setText(rs.getString("name"));
                    }
            }catch(Exception e){
                e.getStackTrace();
            }

    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource() == addButton){
            
                String username = userTF.getText();
                String id = (String) box.getSelectedItem();
                String number = numTF.getText();
                String name = nameTF.getText();
                String radio = null;
                    if(radio1.isSelected()){
                        radio = "Male";
                    }else if(radio2.isSelected()){
                        radio = "Female";
                    }
                String country = countryTF.getText();
                String address = addressTF.getText();
                String phone = phTF.getText();
                String email = emailTF.getText();
            
                    if(username.isEmpty() ||  id.isEmpty() || number.isEmpty() || name.isEmpty() || radio.isEmpty() || country.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Fill the Form Properly!", "Warning", JOptionPane.ERROR_MESSAGE);
                    }else{
                            String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+radio+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                                try{
                                    Conn connection = new Conn();
                                    connection.statement.executeUpdate(query);
                                    JOptionPane.showMessageDialog(null, "Customer Details Added Successfully.");
                                    this.setVisible(false);

                                }catch(Exception e){
                                    e.printStackTrace();
                                } 
                    }
        }else if(ae.getSource() == backButton){
            try{
                this.setVisible(false);
            }catch(Exception e){}
        }
    }

    public static void main(String[] args){
        new AddCustomer("").setVisible(true);
    }
}
