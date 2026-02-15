import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static int totalScore = 0;

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");

        boolean playAgain = true;
        int roundsPlayed = 0;

        while (playAgain) {

            roundsPlayed++;
            System.out.println("\n--- Round " + roundsPlayed + " ---");

            int score = startGame();
            totalScore += score;

            System.out.println("Round Score: " + score);
            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n========= GAME OVER =========");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thank you for playing!");
    }

    public static int startGame() {

        int maxAttempts;
        int upperLimit;

        System.out.println("Choose Difficulty Level:");
        System.out.println("1. Easy (1-50, 10 attempts)");
        System.out.println("2. Medium (1-100, 7 attempts)");
        System.out.println("3. Hard (1-200, 5 attempts)");
        System.out.print("Enter choice: ");

        int level;

        try {
            level = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input! Defaulting to Medium.");
            level = 2;
        }

        switch (level) {
            case 1:
                upperLimit = 50;
                maxAttempts = 10;
                break;
            case 3:
                upperLimit = 200;
                maxAttempts = 5;
                break;
            default:
                upperLimit = 100;
                maxAttempts = 7;
        }

        int numberToGuess = random.nextInt(upperLimit) + 1;
        int attempts = 0;

        while (attempts < maxAttempts) {

            System.out.print("Enter your guess (1-" + upperLimit + "): ");
            String input = sc.nextLine();

            int guess;

            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            attempts++;

            if (guess == numberToGuess) {
                System.out.println("Correct! You guessed the number.");
                return (maxAttempts - attempts + 1) * 10;
            } 
            else if (guess < numberToGuess) {
                System.out.println("Too Low!");
            } 
            else {
                System.out.println("Too High!");
            }

            System.out.println("Attempts Left: " + (maxAttempts - attempts));
        }

        System.out.println("You ran out of attempts!");
        System.out.println("The correct number was: " + numberToGuess);
        return 0;
    }
}

