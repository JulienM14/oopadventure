import java.util.*;

class main {
    public final static boolean debugMode = true;
    public static final String[] wordBankEasy = {"APPLE", "BANANA", "PEACH", "GRAPE", "HIGHWAY", "COMPUTER","SEESAW","PIANO","ROBOT","CARROT","SCHOOL","DOOR","DOCTOR","TEACHER","CODING","WALES", "SCHOOL"};
    public static final String[] wordBankMedium = {"BOOKBAG","HIGHSCHOOL","TEXTBOOK","CERTIFICATE","TRANSPARENCY","INFORMATION","TECHNOLOGY","GRADUATE","PERIODIC","ITERATE","FEATURE","COMPONENT","QUANTUM"};
    public static final String[] wordBankHard = {"CZECHOSLOVAKIA","HYPERTEXTTRANSFERPROTOCOL","ANTIDERIVATIVE","KAZAKHSTAN","FAMILIARIZE","FLIBBERTIGIBBET","UNBISEPTIUM","RUTHERFORDIUM", "HIPPOPOTOMONSTROSESQUIPPEDALIOPHOBIA"};
    public static Random rand = new Random();
    public static Scanner input = new Scanner(System.in);
    public static int lives = 7;
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        clearScreen();
        System.out.println("Hello! Welcome to Hangman! By Julien and Derek");
        System.out.println("Which difficulty would you like?");
        System.out.println("Hard is a little broken : )");
        System.out.print("Easy (1), Medium (2), Hard (3) > ");
        int userChoice = input.nextInt();
        String word = wordSelector(userChoice);
        String[] brokenWord = wordBreaker(word);
        game(brokenWord);
    }

    public static String wordSelector(int difficulty) {
        switch (difficulty) {
            case 1: return wordBankEasy[rand.nextInt(0,10)];
            case 2: return wordBankMedium[rand.nextInt(0,10)];
            case 3: return wordBankHard[rand.nextInt(0,9)]; 
            default: return null;
        }
    }

    public static String[] wordBreaker(String word) {
        String[] brokenWord = new String[word.length()];
        for (int i = 0; i <= word.length() - 1; i++) {
            brokenWord[i] = word.substring(i,i+1);
        }
        if (debugMode) {
            for (int i = 0; i < brokenWord.length; i++) {
                System.out.println(brokenWord[i]);
            }
        }
        return brokenWord;
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
    }

    public static void draw(int lives) {
        if (lives == 6) {
            System.out.println("-----");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|______");
        }
        else if (lives == 5) {
            System.out.println("-----");
            System.out.println("|    |");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|______");
        }
        else if (lives == 4) {
            System.out.println("-----");
            System.out.println("|    |");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|______");
        }
        else if (lives == 3) {
            System.out.println("-----");
            System.out.println("|    |");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|    /");
            System.out.println("|______");
        }
        else if (lives == 2) {
            System.out.println("-----");
            System.out.println("|    |");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|    /\\");
            System.out.println("|______");
        }
        else if (lives == 1) {
            System.out.println("-----");
            System.out.println("|    |");
            System.out.println("|    O");
            System.out.println("|   /|");
            System.out.println("|    /\\");
            System.out.println("|______");
        }
        else if (lives == 0) {
            System.out.println("-----");
            System.out.println("|    |");
            System.out.println("|    O");
            System.out.println("|   /|\\");
            System.out.println("|    /\\");
            System.out.println("|______");
        }


    }

    public static void game(String[] brokenWord) {
        String[] output = new String[brokenWord.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = "_";
        }
        while (true) {
            boolean letterFound = false;
            clearScreen();
            draw(lives);
            if (debugMode) {
                System.out.println(lives);

            }
            for (int i = 0; i < brokenWord.length; i++){
                System.out.print(output[i]);   
            }
            System.out.println("");
            System.out.print("Type a letter to guess, and then press enter > ");
            String userInput = input.nextLine();
            for (int i = 0; i < brokenWord.length; i++) {
                if (userInput.equalsIgnoreCase(brokenWord[i])) {
                    output[i] = brokenWord[i];
                    letterFound = true;
                }
                else {
                    if (letterFound == false && i == brokenWord.length - 1 && i != 0) {
                        System.out.println("Wrong! Subtracting a Life :(");
                        lives -= 1;
                    }
                }
                
            }
            if (lives <= 0) {
                clearScreen();
                draw(0);
                for (int i = 0; i < brokenWord.length; i++){
                    System.out.print(brokenWord[i]);   
                }
                System.out.print("");
                System.out.println("You lost!");
                System.exit(0);
            }
            boolean gameWon = false;
            for (int i = 0; i < output.length; i++) {
                if (output[i] != "_") {
                    if (i == output.length - 1 && output[0] != "_" && output[1] != "_" && output[3] != "_" && output[output.length - 2] != "_" && output[output.length - 3] != "_") {
                        gameWon = true;
                    }
                }
                else {
                    continue;
                }
            }
            if (gameWon) {
                clearScreen();
                draw(lives);
                for (int i = 0; i < brokenWord.length; i++){
                    System.out.print(output[i]);   
                }
                System.out.println("");
                System.out.println("You won!! :)");
                System.exit(0);
            }
        }
        


        
    
    }

}