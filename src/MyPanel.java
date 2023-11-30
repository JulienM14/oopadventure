package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.drawRect(0, 0, 100, 100);
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, 100, 100);
    }
}
