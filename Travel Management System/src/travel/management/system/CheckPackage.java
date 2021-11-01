package travel.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class CheckPackage extends JFrame {
    
    CheckPackage(){
        
        this.setBounds(400, 200, 800, 450);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String[] package1 = new String[]{"GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour",
                                         "Daily Buffet", "Welcome Drinks on Arrival", "Full Day 3 Island Cruise",
                                         "English Speaking Guide", "BOOK NOW", "SUMMER SPECIAL         100,000 MMK"};
        String[] package2 = new String[]{"SILVER PACKAGE", "5 Days and 6 Nights", "Airport Assistance", "Half Day City Tour",
                                         "Daily Buffet", "Welcome Drinks on Arrival", "Full Day 3 Island Cruise",
                                         "English Speaking Guide", "BOOK NOW", "SUMMER SPECIAL         80,000 MMK"};
        String[] package3 = new String[]{"BRONZE PACKAGE", "3 Days and 4 Nights", "Airport Assistance", "Half Day City Tour",
                                         "Daily Buffet", "Welcome Drinks on Arrival", "Full Day 3 Island Cruise",
                                         "English Speaking Guide", "BOOK NOW", "SUMMER SPECIAL         50,000 MMK"};
        
        
        JTabbedPane pane = new JTabbedPane();
        
        JPanel panel1 = createPackage(package1);
        pane.addTab("Package 1", null, panel1);
        
        JPanel panel2 = createPackage(package2);
        pane.addTab("Package 2", null, panel2);
        
        JPanel panel3 = createPackage(package3);
        pane.addTab("Package 3", null, panel3);
        this.add(pane, BorderLayout.CENTER);
    
    }
    
    public JPanel createPackage(String[] pack){
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.WHITE);
        this.add(panel1);
        
        JLabel label1 = new JLabel(pack[0]);
        label1.setBounds(50, 5, 300, 30);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        panel1.add(label1);
        
        JLabel label2 = new JLabel(pack[1]);
        label2.setBounds(10, 55, 300, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.red);
        panel1.add(label2);
        
        JLabel label3 = new JLabel(pack[2]);
        label3.setBounds(10, 80, 300, 30);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.blue);
        panel1.add(label3);
        
        JLabel label4 = new JLabel(pack[3]);
        label4.setBounds(10, 120, 300, 30);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.red);
        panel1.add(label4);
        
        JLabel label5 = new JLabel(pack[4]);
        label5.setBounds(10, 145, 300, 30);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.blue);
        panel1.add(label5);
        
        JLabel label6 = new JLabel(pack[5]);
        label6.setBounds(10, 185, 300, 30);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.red);
        panel1.add(label6);
        
        JLabel label7 = new JLabel(pack[6]);
        label7.setBounds(10, 210, 300, 30);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setForeground(Color.blue);
        panel1.add(label7);
        
        JLabel label8 = new JLabel(pack[7]);
        label8.setBounds(10, 250, 300, 30);
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        label8.setForeground(Color.red);
        panel1.add(label8);
        
        JLabel label9 = new JLabel(pack[8]);
        label9.setBounds(10, 330, 300, 30);
        label9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label9.setForeground(Color.BLUE);
        panel1.add(label9);
        
        JLabel label10 = new JLabel(pack[9]);
        label10.setBounds(400, 350, 400, 30);
        label10.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label10.setForeground(Color.red);
        panel1.add(label10);
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/Icons/package1.jpg"));
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(300, 30, 450, 300);
        panel1.add(iconLabel);
        
        return panel1;
    }
    
    public static void main(String[] args){
        new CheckPackage().setVisible(true);
    }
    
    
}
