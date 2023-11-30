package src;

import src.constants.WindowConstants;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.io.*;

import javax.sound.sampled.*;
@SuppressWarnings("unused")
class Main {
    public static final boolean printKeyPresses = true;
    public static JFrame window = new JFrame("Game");
    public static JLabel textOut = new JLabel("Null");
    public Player player = new Player("Testing");
    public static MyPanel p;
    public static String hero = "src\\Sprites\\Hero.png";
    public static BufferedImage image;
    public static Container c;

    public static void main(String[] args) {
        windowCreator();
        Draw();
        try {
            Image();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void windowCreator() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WindowConstants.windowWidth, WindowConstants.windowHeight);
        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case 87:
                        keyPress(1);
                        break;
                    case 65:
                        keyPress(2);
                        break;
                    case 83:
                        keyPress(3);
                        break;
                    case 68:
                        keyPress(4);
                        break;
                    default:
                        break;
                }
            }
        });
        window.setVisible(true);
    }

    public static void Draw() {
        c = window.getContentPane();
        // set the LayoutManager
        c.setLayout(new BorderLayout());
        p = new MyPanel();
        // add MyPanel object into container
        c.add(p);
        // sets close behavior; EXIT_ON_CLOSE invokes System.exit(0) on closing the
        // JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void Image() throws IOException{
         Graphics g = p.getGraphics();
         g.drawImage(Hero.getImage(), Hero.getX(), Hero.getY(), p);
    }

    /**
     * Method used for keypresses in switchcase
     * @param key Key pressed, W=1, A=2, S=3, D=4
     */
    public static void keyPress(int key) {
        if (key == 1) {
            p.setLocation(p.getX(), (p.getY() - 10));
            if (printKeyPresses) {
                System.out.println("W Pressed");
            }
        }
        else if (key == 2) {
            p.setLocation(p.getX() - 10, p.getY());
            if (printKeyPresses) {
                System.out.println("A Pressed");
            }
        }
        else if (key == 3) {
            p.setLocation(p.getX(), (p.getY() + 10));
            if (printKeyPresses) {
                System.out.println("S Pressed");
            }
        }
        else if (key == 4) {
            p.setLocation(p.getX() + 10, (p.getY()));
            if (printKeyPresses) {
                System.out.println("D Pressed");
            }
        }
        else {
            System.out.println("Something broke with keypresses!");
            System.exit(0);
        }

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

class Hero{
    static int x = 100;
    static int y = 400;
    static int dx = 2;
    static int dy = 2;
    public static BufferedImage image;
    public static String hero = "src\\Sprites\\Hero.png";
    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
    public static BufferedImage getImage() throws IOException{
         image = ImageIO.read(new File(hero));
         return image;
    }
    

}

