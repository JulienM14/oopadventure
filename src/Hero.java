package src;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hero {
    int x;
    int y;
    int dx = 2;
    int dy = 2;
    public static BufferedImage image;
    public static String hero = "src\\Sprites\\Hero.png";

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            this.image = ImageIO.read(new File(hero));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public BufferedImage getImage() throws IOException{
        System.out.println(image);
        return image;
    }
    

}

