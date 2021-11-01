package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    
    private JButton logButton, signButton, forgotButton;
    private JTextField textfield;
    private JPasswordField passfield;
            
    Login(){
		
	ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/login.png"));
	Image icon2 = icon1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
	ImageIcon icon3 = new ImageIcon(icon2);
	JLabel iLabel1 = new JLabel();
	iLabel1.setIcon(icon3);
	iLabel1.setBounds(50, 100, 300, 200); // x,y, width, height
        
	textfield = new JTextField();
	textfield.setBounds(60, 60, 240, 25);
	textfield.setBorder(BorderFactory.createEmptyBorder());
	
	passfield = new JPasswordField();
	passfield.setBounds(60, 145, 240, 25);
	passfield.setBorder(BorderFactory.createEmptyBorder());
	
	logButton = new JButton("Login");
	logButton.setBounds(60, 200, 100, 25);
	logButton.setBackground(new Color(224,224,224));
	logButton.setBorder(BorderFactory.createLineBorder(new Color(0x330019)));
        logButton.setFocusable(false);
        logButton.addActionListener(this);
		
	signButton = new JButton("Sign Up");
	signButton.setBounds(200, 200, 100, 25);
	signButton.setBackground(new Color(0xFFE5CC));
	signButton.setBorder(BorderFactory.createLineBorder(new Color(0x009900)));
        signButton.setFocusable(false);
        signButton.addActionListener(this);
	
	forgotButton = new JButton("Forgot Password?");
	forgotButton.setBounds(110, 245, 140, 25);
	//forgotButton.setBorder(BorderFactory.createEmptyBorder());
        forgotButton.setFocusable(false);
        forgotButton.addActionListener(this);
	
	JLabel tLabel = new JLabel();
	tLabel.setText("Username");
	tLabel.setBounds(60, 20, 100, 25);
	tLabel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	
	JLabel tLabel2 = new JLabel("Password");
	tLabel2.setBounds(60, 105, 100, 25);
	tLabel2.setFont(new Font("SAN_SERIF",Font.PLAIN,20));

	JLabel troubleLabel = new JLabel("Travel to log in...");
	troubleLabel.setBounds(260, 245, 100, 25);
	troubleLabel.setForeground(new Color(153, 0, 0));
	troubleLabel.setFont(new Font("Bahnschrift Light",Font.BOLD,12));
	
	JPanel iPanel1 = new JPanel();
	iPanel1.setBackground(new Color(224,224,224));
	iPanel1.setBounds(0, 0, 400, 400);
	iPanel1.setLayout(null);
	iPanel1.add(iLabel1);
	
	JPanel tpanel = new JPanel();
	tpanel.setBackground(new Color(0, 128, 225));
	tpanel.setBounds(400, 30, 370, 300);
	tpanel.setLayout(null);
	tpanel.add(tLabel);
	tpanel.add(textfield);
	tpanel.add(tLabel2);
	tpanel.add(passfield);
	tpanel.add(logButton);
	tpanel.add(signButton);
	tpanel.add(forgotButton);
	tpanel.add(troubleLabel);
	
	//JFrame frame = new JFrame();
	setVisible(true);
	setBounds(200, 200, 830, 400);
	getContentPane().setBackground(Color.white);
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null); // BorderLayout, FlowLayout, GridLayout, Grid;
	add(iPanel1);
	add(tpanel);
	
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == logButton){
            try{
                String username = textfield.getText();
                String password = passfield.getText();
                String sql = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                
                Conn connection = new Conn();
                ResultSet rs = connection.statement.executeQuery(sql);
                
                if(rs.next()){
                    this.setVisible(false);
                    new Loading(username).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invaild Matched!");
                }
            }catch(Exception e){}
            
        }else if(ae.getSource() == signButton){
            
            new SignUp().setVisible(true);
            this.setVisible(false);
           
        }else if(ae.getSource() == forgotButton){
            this.setVisible(false);
            new ForgotPassword().setVisible(true);
        }
        
    }
	
public static void main(String[] args) {
    
    new Login();
		
	}
    
}
