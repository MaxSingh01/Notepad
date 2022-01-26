/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    
    About(){
         setBounds(600,200,700,600);
         setLayout(null);
         
         ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("notepad/icon/windows.png"));
         Image i2 = i1.getImage().getScaledInstance(400, 80, Image.SCALE_DEFAULT);
         ImageIcon i3 =new ImageIcon(i2);
         
         JLabel l1= new JLabel(i3);
         l1.setBounds(150,40,400,80);
         add(l1);
         
          ImageIcon i4 =new ImageIcon(ClassLoader.getSystemResource("notepad/icon/notepad.png"));
         Image i5= i4.getImage().getScaledInstance( 70,70, Image.SCALE_DEFAULT);
         ImageIcon i6 =new ImageIcon(i5);
         
         JLabel l2= new JLabel(i6);
         l2.setBounds(50,180,70,70);
         add(l2);
    
         JLabel l3 = new JLabel("<html>Notepad</html>");
         l3.setBounds(150,130,500,300);
         l3.setFont(new Font("SAN SARIF", Font.PLAIN, 18));
         add(l3);
         
         JButton b1=new JButton("OK");
         b1.addActionListener(this);
         b1.setBounds(580,500,80,25);
         add(b1);
    
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
 
    
   public static void main(String[] args){
       new About().setVisible(true);
   }
}