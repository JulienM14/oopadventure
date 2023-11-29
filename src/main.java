package src;

import src.constants.WindowConstants;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;

class Main {
    public static JFrame window = new JFrame("Game");
    public static JLabel textOut = new JLabel("Null");
    public Player player = new Player("Testing");
    public static MyPanel p;
    

    public static void main(String[] args) {
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
        window.add(textOut);
        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case 87: p.setLocation(p.getX(), (p.getY()-10)); break;
                    case 65: p.setLocation(p.getX()-10, p.getY()); break;
                    case 83: p.setLocation(p.getX(), (p.getY()+10)); break;
                    case 68: p.setLocation(p.getX()+10, (p.getY())); break;
                    default: break;
                }
            }
        });
        window.setVisible(true);
    }
    public static void Draw(){  
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

class Player {
    String name;
    String[] inventory = new String[15];
    int lives;
    public Player(String name) {
        this.name = name;
        inventory[0] = "Map";
    }
}

