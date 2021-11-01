package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SignUp extends JFrame implements ActionListener {
    private JButton button1, button2;
    private JTextField userTF, nameTF, passTF, ansTF;
    private Choice choice;
    public SignUp(){
            
            JLabel userLabel = new JLabel("Username");
            userLabel.setBounds(50,20,100,25);
            userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
           
            userTF = new JTextField();
            userTF.setBounds(190, 20, 180, 25);
            userTF.setBorder(BorderFactory.createEmptyBorder());
            
            JLabel nameLabel = new JLabel("Name");
            nameLabel.setBounds(50,60,100,25);
            nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
            
            nameTF = new JTextField();
            nameTF.setBounds(190, 60, 180, 25);
            nameTF.setBorder(BorderFactory.createEmptyBorder());
            
            JLabel passLabel = new JLabel("Password");
            passLabel.setBounds(50,100,100,25);
            passLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
            
            passTF = new JTextField();
            passTF.setBounds(190, 100, 180, 25);
            passTF.setBorder(BorderFactory.createEmptyBorder());
            
            JLabel sqLabel = new JLabel("Security Question");
            sqLabel.setBounds(50,140,125,25);
            sqLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
            
            choice = new Choice();
            choice.add("Spiderman or Superman");
            choice.add("Mom or Dad");
            choice.add("Your Lucky Number?");
            choice.setBounds(190, 140, 180, 25);
            
            JLabel ansLabel = new JLabel("Answer");
            ansLabel.setBounds(50,180,125,25);
            ansLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
            
            ansTF = new JTextField();
            ansTF.setBounds(190, 180, 180, 25);
            ansTF.setBorder(BorderFactory.createEmptyBorder());
            
            ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/signup.png"));
            //Image icon2 = icon1.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT);
            //ImageIcon icon3 = new ImageIcon(icon2);
            JLabel iconLabel = new JLabel();
            iconLabel.setIcon(icon1);
            iconLabel.setBounds(590, 50, 200, 250);
            this.add(iconLabel);
            
            button1 = new JButton("Create");
            button1.setBounds(120,250,100,30);
            button1.setFont(new Font("Tahoma", Font.BOLD, 14));
            button1.setForeground(new Color(133,193,233));
            button1.setBackground(Color.WHITE);
            button1.addActionListener(this);
            
            button2 = new JButton("Back");
            button2.setBounds(270,250,100,30);
            button2.setFont(new Font("Tahoma", Font.BOLD, 14));
            button2.setForeground(new Color(133,193,233));
            button2.setBackground(Color.WHITE);
            button2.addActionListener(this);
            
            JPanel panel = new JPanel();
            panel.setBounds(0,0,500,400);
            panel.setBackground(new Color(133,193,233));
            panel.setLayout(null);
            panel.add(userLabel); panel.add(userTF);  
            panel.add(nameLabel); panel.add(nameTF); 
            panel.add(passLabel); panel.add(passTF);
            panel.add(sqLabel); panel.add(choice); panel.add(ansLabel); panel.add(ansTF);
            panel.add(button1); panel.add(button2);
         
            this.setBounds(300,250,900,400); // this -> JFrame (frame) = new JFrame();
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.getContentPane().setBackground(Color.WHITE);
            this.setLayout(null);
            //this.setVisible(true);
            this.add(panel);
        }
        
    @Override
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == button1){
                
                String username = userTF.getText();
                String name = nameTF.getText();
                String password = passTF.getText();
                String security = choice.getSelectedItem();
                String answer = ansTF.getText();
                
                if(username.isEmpty() || name.isEmpty() || password.isEmpty() || security.isEmpty() || answer.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Sorry", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                
                String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+security+"', '"+answer+"')";
                
                try{
                    Conn connection = new Conn();
                    connection.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Account Created Successfully!");
                    
                    this.setVisible(false);
                    new Login().setVisible(true);
                    
                    
                }catch(Exception e){
                    
                }
                }
            }else if(ae.getSource() == button2){
                this.setVisible(false);
                new Login().setVisible(true);
                
            }
        }
    public static void main(String[] args) {
       new SignUp().setVisible(true);
    }
}