package src;

import java.util.*;

class main {
    public final static boolean debugMode = true;
    public static final String[] wordBankEasy = {"Apple", "Banana", "Peach", "Grape", "Highway", "Computer","Seesaw","Piano","Robot","Czecholslovakia","Carrot","School","Door","Doctor","Teacher","Coding","DrPepper","Wales", "High School", "School"};
    // public static final String[] wordBankMedium
    // public static final String[] wordBankHard 
    Random rand = new Random();
    public static void main(String[] args) {
        
    }

    public String wordSelector(int difficulty) {
        switch (difficulty) {
            case 1: return wordBankEasy[rand.nextInt(0,10)];
            // case 2: return wordBankMedium[rand.nextInt(0,10)]; break;
            // case 3: return wordBankHard[rand.nextInt(0,10)]; break;
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

    public void game(String word) {

    }

}