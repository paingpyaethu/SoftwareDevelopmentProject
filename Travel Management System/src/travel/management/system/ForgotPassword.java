package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ForgotPassword extends JFrame implements ActionListener {
    
    JPanel panel;
    JTextField userTF, nameTF, secTF, ansTF, passTF;
    JButton sButton, rButton, backButton;
     
    public ForgotPassword(){
        
        this.setBounds(350, 250, 850, 400);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setBounds(30, 30, 500, 300);
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        this.add(panel);
        
        JLabel userLabel = new JLabel("Username");
	userLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	userLabel.setBounds(40, 20, 150, 25);
	panel.add(userLabel);
        
        JLabel nameLabel = new JLabel("Name");
	nameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	nameLabel.setBounds(40, 60, 150, 25);
	panel.add(nameLabel);
        
        JLabel secLabel = new JLabel("Your Security Question");
	secLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	secLabel.setBounds(40, 100, 150, 25);
	panel.add(secLabel);
        
        JLabel ansLabel = new JLabel("Answer");
	ansLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	ansLabel.setBounds(40, 140, 150, 25);
	panel.add(ansLabel);
        
        JLabel passLabel = new JLabel("Password");
	passLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	passLabel.setBounds(40, 180, 150, 25);
	panel.add(passLabel);
        
        userTF = new JTextField();
        userTF.setBounds(200, 20, 150, 25);
        userTF.setBorder(BorderFactory.createEmptyBorder());
        userTF.setFont(new Font("Tahoma", Font.BOLD, 13));
        userTF.setForeground(new Color(105, 105, 105));
        panel.add(userTF);
        
        nameTF = new JTextField();
        nameTF.setBounds(200, 60, 150, 25);
        nameTF.setBorder(BorderFactory.createEmptyBorder());
        nameTF.setFont(new Font("Tahoma", Font.BOLD, 13));
        nameTF.setForeground(new Color(165, 42, 42));
        panel.add(nameTF);
        
        secTF = new JTextField();
        secTF.setBounds(200, 100, 250, 25);
        secTF.setBorder(BorderFactory.createEmptyBorder());
        secTF.setFont(new Font("Tahoma", Font.BOLD, 13));
        secTF.setForeground(new Color(165, 42, 42));
        panel.add(secTF);
        
        ansTF = new JTextField();
        ansTF.setBounds(200, 140, 150, 25);
        ansTF.setBorder(BorderFactory.createEmptyBorder());
        ansTF.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(ansTF);
        
        passTF = new JTextField();
        passTF.setBounds(200, 180, 150, 25);
        passTF.setBorder(BorderFactory.createEmptyBorder());
        passTF.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(passTF);
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/forgotpassword.jpg"));
        Image image = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image);
        
        JLabel iconLabel = new JLabel(icon2);
        iconLabel.setBounds(580, 70, 200, 200);
        this.add(iconLabel);
        
        sButton = new JButton("Search");
        sButton.addActionListener(this);
        sButton.setBounds(360, 20, 90, 25);
        sButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        sButton.setBackground(Color.BLACK);
        sButton.setForeground(Color.WHITE);
        sButton.setFocusable(false);
        panel.add(sButton);
        
        rButton = new JButton("Retrieve");
        rButton.addActionListener(this);
        rButton.setBounds(360, 140, 90, 25);
        rButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        rButton.setBackground(Color.BLACK);
        rButton.setForeground(Color.WHITE);
        rButton.setFocusable(false);
        panel.add(rButton);
        
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(200, 240, 90, 25);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        panel.add(backButton);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        Conn connection = new Conn();
        
            if(ae.getSource() == sButton){
                try{
                String sql = "select * from account where username = '"+userTF.getText()+"'";
                ResultSet rs = connection.statement.executeQuery(sql);
                while(rs.next()){
                    nameTF.setText(rs.getString("name"));
                    secTF.setText(rs.getString("security"));
                }
                
                }catch(Exception e){
            
                }
            }else if(ae.getSource() == rButton){
                 try{
                String sql = "select * from account where answer = '"+ansTF.getText()+"' And username = '"+userTF.getText()+"'";
                ResultSet rs = connection.statement.executeQuery(sql);
                while(rs.next()){
                    passTF.setText(rs.getString("password"));
                }
                
                }catch(Exception e){
            
                }
                
            }else if(ae.getSource() == backButton){
                this.setVisible(false);
                new Login().setVisible(true);
            }
        }
    
    public static void main(String[] args) {
       new ForgotPassword().setVisible(true);
    }
}
