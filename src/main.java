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

class Main {
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
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
                    case 87: p.setLocation(p.getX(), (p.getY() - 10)); break;
                    case 65: p.setLocation(p.getX() - 10, p.getY()); break;
                    case 83: p.setLocation(p.getX(), (p.getY() + 10)); break;
                    case 68: p.setLocation(p.getX() + 10, (p.getY())); break;
                    default: break;
                }
            }
        });
        window.setVisible(true);
    }
    public static void Draw(){  
        c = window.getContentPane();    
        // set the LayoutManager
        c.setLayout(new BorderLayout());        
        p = new MyPanel();    
        // add MyPanel object into container    
        c.add(p);    
        // sets close behavior; EXIT_ON_CLOSE invokes System.exit(0) on closing the JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    public static void Image() throws IOException{
         Graphics g = p.getGraphics();
         g.drawImage(Hero.getImage(), Hero.getX(), Hero.getY(), p);
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

class SoundPlayer implements LineListener {
    boolean isPlaybackCompleted;
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("src\\music\\music1.mp3");
    

    @Override
    public void update(LineEvent event) {
        if (LineEvent.Type.START == event.getType()) {
            System.out.println("Playback Started");
        }
        else if (LineEvent.Type.STOP == event.getType()) {
            isPlaybackCompleted = true;
            System.out.println("Playback Completed.");
        }
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

