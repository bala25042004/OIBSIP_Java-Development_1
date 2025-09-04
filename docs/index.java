import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 1000;
        int maxAttempts = 10;
        int rounds = 0;
        int totalScore = 0;
        
        System.out.println("--- Welcome to the Number Guessing Game! ---");

        boolean playAgain = true;
        while (playAgain) {
            rounds++;
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            
            System.out.printf("\n--- Round %d ---\n", rounds);
            System.out.printf("I have generated a number between %d and %d.\n", minRange, maxRange);
            System.out.printf("You have a maximum of %d attempts to guess it.\n", maxAttempts);

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.printf("Attempt %d/%d: Enter your guess: ", (attempts + 1), maxAttempts);
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); 
                    continue; 
                }
                
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    int points = (maxAttempts - attempts + 1) * 10; 
                    totalScore += points;
                    System.out.printf("Congratulations! You guessed the number %d correctly in %d attempts.\n", numberToGuess, attempts);
                    System.out.printf("You earned %d points. Your total score is now %d.\n", points, totalScore);
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.printf("Sorry, you've used all %d attempts. The number was %d.\n", maxAttempts, numberToGuess);
            }
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        
        System.out.println("\nGame Over! Thank you for playing.");
        System.out.printf("You played %d round(s) and your final score is %d.\n", rounds, totalScore);
        
        scanner.close();
    }
}
