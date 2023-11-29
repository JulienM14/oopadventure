package src;

import src.constants.WindowConstants;
import javax.swing.*;

import java.awt.event.*;

class Main {
    public static JFrame window = new JFrame("Game");
    public static JLabel textOut = new JLabel("Null");
    public Player player = new Player("Testing");

    public static void main(String[] args) {
        windowCreator();
        
        
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
                    case 87: textOut.setText("W Pressed"); break;
                    case 65: textOut.setText("A Pressed"); break;
                    case 83: textOut.setText("S Pressed"); break;
                    case 68: textOut.setText("D Pressed"); break;
                    default: break;
                }
            }
        });
        window.setVisible(true);
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

