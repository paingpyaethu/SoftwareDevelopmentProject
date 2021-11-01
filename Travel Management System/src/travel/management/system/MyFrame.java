package travel.management.system;

import javax.swing.*;

public class MyFrame extends JFrame implements Runnable {
    
    public void run(){
        try{
            Thread.sleep(6000);
            this.setVisible(false);
            
            new Login().setVisible(true);
        }catch(Exception e){}
        
    }
    
}
