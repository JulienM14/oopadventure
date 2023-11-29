package src;

import src.constants.WindowConstants;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;

class Main {
    public static JFrame window = new JFrame("Game");
    public MyPanel p;
    

    public void main(String[] args) {
        windowCreator();
        Draw();
        
    }

    public static void windowCreator() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WindowConstants.windowWidth, WindowConstants.windowHeight);
        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

            }
        });
        window.setVisible(true);
    }
    public void Draw(){  
        Container c = window.getContentPane();    
        // set the LayoutManager
        c.setLayout(new BorderLayout());        
        p = new MyPanel();    
        // add MyPanel object into container    
        c.add(p);    
        // sets close behavior; EXIT_ON_CLOSE invokes System.exit(0) on closing the JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

}


