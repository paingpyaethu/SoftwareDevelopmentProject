package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {
    
    private JProgressBar pBar;
    private Thread thread;
    private String username;
    
    Loading(String name){
        
        username = name;
        thread = new Thread(this);
        
        this.setBounds(400, 180, 600, 400);
        this.getContentPane().setBackground(new Color(0, 204, 204));
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel titleLabel = new JLabel("Travel and Tourism Application");
        titleLabel.setBounds(65, 20, 600, 40);
        titleLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        titleLabel.setForeground(new Color(96, 96, 96));
        this.add(titleLabel);
        
        pBar = new JProgressBar();
        pBar.setBounds(130, 135, 300, 25);
        //pBar.setBackground(Color.green);
        pBar.setForeground(new Color(0, 102, 0));
        pBar.setStringPainted(true);
        this.add(pBar);
        
        JLabel waitLabel = new JLabel("Please Wait...");
        waitLabel.setBounds(230, 165, 150, 20);
        waitLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
        waitLabel.setForeground(new Color(160, 82, 45));
        this.add(waitLabel);
        
        JLabel userLabel = new JLabel("Welcome " + username);
        userLabel.setBounds(30, 330, 150, 20);
        userLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
        userLabel.setForeground(new Color(51, 0, 0));
        this.add(userLabel);
        
        thread.start();
    }
    
        public void run(){
            try{
                for(int i = 1; i <= 101; i++){
                    int x = pBar.getMaximum();  // 100
                    int y = pBar.getValue();
                    
                    if(y<x){
                        
                        pBar.setValue(pBar.getValue() + 1);
                    }else{
                        i = 101;
                        setVisible(false);
                        new Dashboard(username).setVisible(true);
                    }
                    Thread.sleep(50);
                }
            }catch(Exception e){}
        }
    
    
    public static void main(String[] args){
        new Loading("").setVisible(true);
    }
         
}
