package TopperWorld;

import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        Scanner vaibhao = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5; // Limit the number of attempts to 5
        int rounds = 0;
        int totalAttempts = 0;
        int totalScore = 0;

        System.out.println("!.....Welcome to the Number Guessing Game.....!\n");

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            rounds++;

            System.out.println("Let's Start The Number Game Round " + rounds);
            System.out.println("\nYou Have Maximum 5 Attempt Limit");
            System.out.println("\nI Have picked a number between " + minRange + " and " + maxRange + ".\n");

            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("!.....Enter your guess: .....!\n");
                int userGuess = vaibhao.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number between " + minRange + " and " + maxRange + ".");
                } else if (userGuess < targetNumber) {
                    System.out.println("Your Guess Number Is Smaller");
                } else if (userGuess > targetNumber) {
                    System.out.println("Your Guess Number Is Greater");
                } else {
                    System.out.println(
                            "\nOOhhOO !...Your Number Is Correct.You Win The Game (" + targetNumber + ") in " + attempts
                                    + " attempts.\n");
                    guessedCorrectly = true;
                    totalScore += maxAttempts - attempts + 1; // Calculate the score based on attempts
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nSorry, you've reached the maximum number of attempts for this round.\n");
            }

            if (rounds < 5) { // Limit the game to 5 rounds
                System.out.print("\nDo you want to play another round? (yes/no): \n");
                System.out.println("\n=======================================================================\n");
                String playAgainChoice = vaibhao.next().toLowerCase();

                if (!playAgainChoice.equals("yes")) {
                    playAgain = false;
                }
            } else {
                playAgain = false; // End the game after 5 rounds
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("________________________________________________________________________\n");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Average Score per Round: " + (double) totalScore / rounds);
        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("\n_________________________________________________________________________n");
    }
}
