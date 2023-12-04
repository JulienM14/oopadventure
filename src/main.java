package src;

import java.util.*;

class main {
    public final static boolean debugMode = true;
    public static final String[] wordBankEasy = {"APPLE", "BANANA", "PEACH", "GRAPE", "HIGHWAY", "COMPUTER","SEESAW","PIANO","ROBOT","CARROT","SCHOOL","DOOR","DOCTOR","TEACHER","CODING","WALES", "SCHOOL"};
    public static final String[] wordBankMedium = {"BOOKBAG","HIGHSCHOOL","TEXTBOOK","CERTIFICATE","TRANSPARENCY","INFORMATION","TECHNOLOGY","GRADUATE","PERIODIC","ITERATE","FEATURE","COMPONENT","QUANTUM"};
    public static final String[] wordBankHard = {"CZECHOSLOVAKIA","HYPERTEXTTRANSFERPROTOCOL","ANTIDERIVATIVE","KAZAKHSTAN","FAMILIARIZE","FLIBBERTIGIBBET","UNBISEPTIUM","RUTHERFORDIUM"};
    public static Random rand = new Random();
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("Hello! Welcome to Hangman!");
        System.out.println("Which difficulty would you like?");
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
            case 3: return wordBankHard[rand.nextInt(0,10)]; 
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

    public static void game(String[] brokenWord) {
        for(int i = 0; i<= brokenWord.length; i++){
            System.out.println("_ ");   
        }
        
        
    }

}