package src;

import src.constants.WindowConstants;
import javax.swing.*;

import java.awt.event.*;

class Main {
    public static JFrame window = new JFrame("Game");
    

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
        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

            }
        });
        window.setVisible(true);
    }
}

