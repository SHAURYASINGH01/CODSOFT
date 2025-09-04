import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalWins = 0;
        int gamesPlayed = 0;
        boolean keepPlaying = true;
        
        System.out.println("Welcome to the Number Guess Game!");

        while(keepPlaying) {
            gamesPlayed++;
            System.out.println("\n-- Game " + gamesPlayed + "--");
            int secretNumber = rand.nextInt(100) + 1;
            int maxTries = 5;
            int tries = 0;
            boolean won = false;
            
            System.out.println("I picked a number between 1 and 100");
            System.out.println("You have " + maxTries + " tries to guess it!");
            while(tries < maxTries && !won) {
                tries++;
                System.out.print("Try " + tries + ": Enter your guess: ");
                int guess = sc.nextInt();
                
                // Check if guess is correct
                if(guess == secretNumber) {
                    won = true;
                    totalWins++;
                    System.out.println("YES! You got it right!");
                    System.out.println("The number was " + secretNumber);
                    System.out.println("You won in " + tries + " tries!");
                    
                    // Calculate score
                    int score = (maxTries - tries + 1) * 10;
                    System.out.println("Your score: " + score + " points");
                    
                } else if(guess < secretNumber) {
                    System.out.println("Too small! Try bigger number");
                    int left = maxTries - tries;
                    if(left > 0) {
                        System.out.println("You have " + left + " tries left");
                    }
                    
                } else {
                    System.out.println("Too big! Try smaller number");
                    int left = maxTries - tries;
                    if(left > 0) {
                        System.out.println("You have " + left + " tries left");
                    }
                }
            }
            
            // If player used all tries and didn't win.
            if(!won) {
                System.out.println("Game over! You used all tries");
                System.out.println("The correct number was: " + secretNumber);
            }
            
            // Show current stats report
            System.out.println("\nYour Stats:");
            System.out.println("Games played: " + gamesPlayed);
            System.out.println("Games won: " + totalWins);
            
            // Ask to play again if want
            System.out.print("Want to play again? (yes/no): ");
            sc.nextLine(); // clear buffer
            String answer = sc.nextLine();
            
            if(answer.equals("no") || answer.equals("n")) {
                keepPlaying = false;
            }
        }
        
        // Final results:
        System.out.println("\nThanks for playing!");
        System.out.println("Final Results:");
        System.out.println("Total games: " + gamesPlayed);
        System.out.println("Games won: " + totalWins);
        
        if(gamesPlayed > 0) {
            int winPercent = (totalWins * 100) / gamesPlayed;
            System.out.println("Win rate: " + winPercent + "%");
        }
        sc.close();
    }
}
