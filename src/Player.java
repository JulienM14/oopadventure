package src;
public class Player {
    String name;
    String[] inventory = new String[15];
    int lives;

    public Player(String name) {
        this.name = name;
        inventory[0] = "Map";
    }
}
