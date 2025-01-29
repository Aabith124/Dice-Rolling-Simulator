package com.abith.wordgame;
import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String WordToGuess;
    private char[] guessedletters;
    private int attempts;

    public WordGuessingGame(String[] wordlist, int maxAttempts){
        Random rand=new Random();
        this.WordToGuess=wordlist[rand.nextInt(wordlist.length)];
        this.guessedletters=new char[this.WordToGuess.length()];
        for (int i=0;i<this.guessedletters.length;i++){
            this.guessedletters[i]='_';
        }
        this.attempts=maxAttempts;

    }
public String play(){

    Scanner in=new Scanner(System.in);

    while(attempts>0 ){
        displayState();
        System.out.println("you have "+attempts+" attempts left...");
        System.out.println("Guess a letter: ");
      char guess= in.nextLine().toLowerCase().charAt(0);
       if(processGuess(guess)) {
           System.out.println("correct!");
           if(new String(guessedletters).equals(WordToGuess)){
               System.out.println("you have guessed the word! you win!");
            return "win";
           }
       }else{
           System.out.println("that guess was incorrect!");
           attempts--;
       }
    }
   return "lost";
    }

    private boolean processGuess(char letter){
        boolean letterFound=false;
        for(int i=0;i<WordToGuess.length();i++){
            if(WordToGuess.charAt(i)==letter){
                guessedletters[i]=letter;
                letterFound=true;
            }
        }
        return letterFound;
    }
    private void displayState(){
        System.out.println("guessed letters "+new String(guessedletters));
    }
}
public class App {
       public static void main(String[] args){
           String[] words={"java","programming","class","computer","methods"};
           WordGuessingGame game=new WordGuessingGame(words, 10);
           Scanner scan=new Scanner(System.in);
           boolean shouldPlayAgain=false;
           int wins=0;
           int losses=0;
           do {
               String result = game.play();
               if (result.equals("win")) {
                   wins += 1;
               } else {
                   losses += 1;
               }
               System.out.println("wins: " + wins + ", lossses: " + losses);
               System.out.print("would you like to play again? (y/n): ");
               char playAgain = scan.nextLine().toLowerCase().charAt(0);
               shouldPlayAgain = playAgain == 'y';
           }while(shouldPlayAgain);
           game.play();
       }
   }

