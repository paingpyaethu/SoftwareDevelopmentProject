package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
    
    private JButton button1,  button2,  button3, button4, button5, button6, button7, button8,  button9 , button10,
            button11, button12, button13, button14, button15;
    String username;
    
    Dashboard(String username){
        this.username = username;
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // setSize(1950,1000)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        JPanel dashPanel = new JPanel();
        dashPanel.setLayout(null);
        dashPanel.setBounds(0, 0, 1950, 65);
        dashPanel.setBackground(new Color(0, 0, 102));
        this.add(dashPanel);
        
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/dashboard.png"));
        Image image1 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon(image1);
        JLabel iconLabel2 = new JLabel(icon4);
        iconLabel2.setBounds(7, 7, 50, 50);
        dashPanel.add(iconLabel2);
        
        JLabel dashLabel = new JLabel("Dashboard");
        dashLabel.setBounds(70, 10, 300, 40);
        dashLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        dashLabel.setForeground(Color.WHITE);
        dashPanel.add(dashLabel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 65, 300, 1000);
        buttonPanel.setBackground(new Color(0, 0, 102));
        this.add(buttonPanel);
        
        button1 = new JButton("Add Personal Details");
        button1.setBounds(0, 0, 300, 30);
        button1.setBackground(new Color(0, 0, 102));
        button1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button1.setForeground(Color.white);
        //button1.setMargin(new Insets(0, 0, 0, 60));
        button1.addActionListener(this);
        buttonPanel.add(button1);
        
        button2 = new JButton("Update Personal Details");
        button2.setBounds(0, 30, 300, 30);
        button2.setBackground(new Color(0, 0, 102));
        button2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button2.setForeground(Color.white);
        //button2.setMargin(new Insets(0, 0, 0, 30));
        button2.addActionListener(this);
        buttonPanel.add(button2);
        
        button3 = new JButton("View Details");
        button3.setBounds(0, 60, 300, 30);
        button3.setBackground(new Color(0, 0, 102));
        button3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button3.setForeground(Color.white);
        //button3.setMargin(new Insets(0, 0, 0, 134));
        button3.addActionListener(this);
        buttonPanel.add(button3);
        
        button4 = new JButton("Delete Personal Details");
        button4.setBounds(0, 90, 300, 30);
        button4.setBackground(new Color(0, 0, 102));
        button4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button4.setForeground(Color.white);
        //button4.setMargin(new Insets(0, 0, 0, 33));
        buttonPanel.add(button4);
        
        button5 = new JButton("Check Package");
        button5.setBounds(0, 120, 300, 30);
        button5.setBackground(new Color(0, 0, 102));
        button5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button5.setForeground(Color.white);
        button5.addActionListener(this);
        buttonPanel.add(button5);
        
        button6 = new JButton("Book Package");
        button6.setBounds(0, 150, 300, 30);
        button6.setBackground(new Color(0, 0, 102));
        button6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button6.setForeground(Color.white);
        button6.addActionListener(this);
        buttonPanel.add(button6);
        
        button7 = new JButton("View Package");
        button7.setBounds(0, 180, 300, 30);
        button7.setBackground(new Color(0, 0, 102));
        button7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button7.setForeground(Color.white);
        button7.addActionListener(this);
        buttonPanel.add(button7);
        
        button8 = new JButton("View Hotels");
        button8.setBounds(0, 210, 300, 30);
        button8.setBackground(new Color(0, 0, 102));
        button8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button8.setForeground(Color.white);
        buttonPanel.add(button8);
        
        button9 = new JButton("Book Hotels");
        button9.setBounds(0, 240, 300, 30);
        button9.setBackground(new Color(0, 0, 102));
        button9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button9.setForeground(Color.white);
        buttonPanel.add(button9);
        
        button10 = new JButton("View Booked Hotels");
        button10.setBounds(0, 270, 300, 30);
        button10.setBackground(new Color(0, 0, 102));
        button10.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button10.setForeground(Color.white);
        buttonPanel.add(button10);
        
        button11 = new JButton("Destinations");
        button11.setBounds(0, 300, 300, 30);
        button11.setBackground(new Color(0, 0, 102));
        button11.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button11.setForeground(Color.white);
        buttonPanel.add(button11);
        
        button12 = new JButton("Payment");
        button12.setBounds(0, 330, 300, 30);
        button12.setBackground(new Color(0, 0, 102));
        button12.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button12.setForeground(Color.white);
        buttonPanel.add(button12);
        
        button13 = new JButton("Calculator");
        button13.setBounds(0, 360, 300, 30);
        button13.setBackground(new Color(0, 0, 102));
        button13.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button13.setForeground(Color.white);
        button13.addActionListener(this);
        buttonPanel.add(button13);
        
        button14 = new JButton("Notepad");
        button14.setBounds(0, 390, 300, 30);
        button14.setBackground(new Color(0, 0, 102));
        button14.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button14.setForeground(Color.white);
        button14.addActionListener(this);
        buttonPanel.add(button14);
        
        button15 = new JButton("About");
        button15.setBounds(0, 420, 300, 30);
        button15.setBackground(new Color(0, 0, 102));
        button15.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button15.setForeground(Color.white);
        buttonPanel.add(button15);
        
        
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/home.png"));
        Image image = icon1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel iconLabel = new JLabel(icon2);
        iconLabel.setBounds(0, 0, 1950, 1000);
        this.add(iconLabel);
    }
    
    @Override
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == button1){
                new AddCustomer(username).setVisible(true);
                
        }else if(ae.getSource() == button13){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){}
            
        }else if(ae.getSource() == button14){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){}
            
        }else if(ae.getSource() == button2){
            new UpdateCustomer(username).setVisible(true);
        }else if(ae.getSource() == button3){
            new ViewCustomerDetails(username).setVisible(true);
        }
        else if(ae.getSource() == button5){
            new CheckPackage().setVisible(true);
        }
        else if(ae.getSource() == button6){
            new BookPackage(username).setVisible(true);
        }
        else if(ae.getSource() == button7){
            new ViewBookedPackage(username).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Dashboard("").setVisible(true);
    }
}
