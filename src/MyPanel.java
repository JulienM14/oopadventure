package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import src.Hero;

import javax.swing.JPanel;

@SuppressWarnings("unused")
public class MyPanel extends JPanel{
    public Hero hero = new Hero(100,100);
    @Override
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        g2.drawRect(0, 0, 100, 100);
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, 100, 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            g.drawImage(hero.getImage(), 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
