package travel.management.system;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    
    public static void main(String[] args) {
        
        MyFrame frame = new MyFrame();
        //JFrame frame = new JFrame();
        Thread thread1 = new Thread(frame);
        thread1.start();
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/myFrame.png"));
        
        JLabel label1 = new JLabel(icon1);
                
        ImageIcon ppIcon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/pp.png"));
        frame.setIconImage(ppIcon.getImage());
        
        frame.setVisible(true);
        //frame.setBounds(200, 200, 800, 400);
        frame.setTitle("T & T Management System!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(label1);
        
        int x = 1;
        for(int i=1; i<=400; i+=5, x+=6){
            frame.setBounds(200, 200, x + i, i);
            try{
                Thread.sleep(20);
            }catch(Exception e){
            }
        } 
        
    }
    
}
