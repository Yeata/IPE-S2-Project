

import java.awt.Color;

import javax.swing.*;

public class Taskdetail {
    public static void main(String[] args) {
        JFrame f = new JFrame("My First GUI");
        f.setLayout(null); 

        JLabel title = new JLabel("Task Detail"); 
        title.setBounds(10, 10, 100, 15);
        f.add(title);
        
        JLabel aText = new JLabel("Activity1");
        aText.setBounds(10,33,50,15);
        f.add(aText);
        
        JLabel bText = new JLabel("Start date | End date");
        bText.setBounds(200,33,200,15);
        f.add(bText);
        
        JLabel cText = new JLabel("Activity2");
        cText.setBounds(10,66,50,15);
        f.add(cText);
        
        JLabel cText1 = new JLabel("Start date | End date");
        cText1.setBounds(200,66,200,15);
        f.add(cText1);
        
        JLabel dText = new JLabel("Activity3");
        dText.setBounds(10,99,50,15);
        f.add(dText);
        
        JLabel eText1 = new JLabel("Start date | End date");
        eText1.setBounds(200,99,200,15);
        f.add(eText1);
        
        JLabel fText = new JLabel("Activity4");
        fText.setBounds(10,132,50,15);
        f.add(fText);
        
        JLabel gText1 = new JLabel("Start date | End date");
        gText1.setBounds(200,132,200,15);
        f.add(gText1);
        
        JLabel hText = new JLabel("Activity5");
        hText.setBounds(10,165,50,15);
        f.add(hText);
        
        JLabel iText1 = new JLabel("Start date | End date");
        iText1.setBounds(200,165,200,15);
        f.add(iText1);
        
        
        
        	

        f.setSize(500, 600); 
        f.setVisible(true);
        f.getContentPane().setBackground(Color.PINK);
    }
}