/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notepad;

import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

    public class Notepad extends JFrame implements ActionListener {

    JTextArea area;
    String text;
    JScrollPane pane;
    Notepad(){
        setBounds(0,0,850,745);
        
        JMenuBar menubar = new JMenuBar();
        
        JMenu file = new JMenu("File");
        
        JMenuItem newdoc = new JMenuItem("New");
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newdoc.addActionListener(this);
        
        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        
        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        
        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
        exit.addActionListener(this);
        
        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);
        
        JMenu edit = new JMenu("Edit");
        
        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        
        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cut.addActionListener(this);
        
        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        
        JMenuItem selectall = new JMenuItem("Select ALL");
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        selectall.addActionListener(this);
        
        edit.add(copy);
        edit.add(cut);
        edit.add(paste);
        edit.add(selectall);
        
        JMenu help = new JMenu("Help");
        
        JMenuItem about = new JMenuItem("About the Notepad");
        about.addActionListener(this);
        help.add(about);
        
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);
        
        setJMenuBar(menubar);
        
        area = new JTextArea();
        area.setFont(new Font("SAN SERIF", Font.PLAIN , 20));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        
        pane =new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane,BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("New")){
           area.setText("");
        }else if (ae.getActionCommand().equals("Open")){
            JFileChooser chooser= new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt file","txt");
            chooser.addChoosableFileFilter(restrict);
            
             int action= chooser.showOpenDialog(this);
            if(action!= JFileChooser.APPROVE_OPTION){
                return;
            }
            File file= chooser.getSelectedFile();
            try{
                BufferedReader reader=new BufferedReader(new FileReader(file));
                area.read(reader, null);
            }catch(Exception e){}
        }
        else if (ae.getActionCommand().equals("Save")){
            JFileChooser saveas= new JFileChooser();
            saveas.setApproveButtonText("Save");
            int action= saveas.showOpenDialog(this);
            if(action!= JFileChooser.APPROVE_OPTION){
                return;
            }
            
            File filename= new File(saveas.getSelectedFile() + ".txt");
            BufferedWriter outFile= null;
            try{
                outFile= new BufferedWriter( new FileWriter(filename));
                area.write(outFile);
            }catch(IOException e){}
        }else if (ae.getActionCommand().equals("Exit")){
            System.exit(0);
        }else if (ae.getActionCommand().equals("Print")){
        try{
            area.print();
        }catch(PrinterException e){}
       }
        else if (ae.getActionCommand().equals("Copy")){
            text=area.getSelectedText();
        }
        else if (ae.getActionCommand().equals("Paste")){
            
            area.insert(text, area.getCaretPosition());
            
        }else if (ae.getActionCommand().equals("Cut")){
             text=area.getSelectedText();
             area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
        }else if (ae.getActionCommand().equals("Select ALL")){
            area.selectAll();
        }else if (ae.getActionCommand().equals("About the Notepad")){
            new About().setVisible(true);
        }
        
    
    
        
    
    }
    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }
    
}
