import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 7;
    private static int score = 0;

    public static void main(String[]args)
    {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        boolean playAgain;

        do{
            int targetNumber = random.nextInt(100) + 1;
            int attempts=0;
            boolean guessedCorrectly=false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100. You have"+ MAX_ATTEMPTS +"attempts to guess it" );

            while(attempts < MAX_ATTEMPTS && !guessedCorrectly)
            {
                System.out.println("Enter Your Guess");
                int userGuess=scanner.nextInt();
                attempts++;

                if(userGuess==targetNumber)
                {
                    guessedCorrectly=true;
                    System.out.println("Congratulations!You've guessed the correct number: "+targetNumber);
                    score+=(MAX_ATTEMPTS-attempts+1);
                }
                else if(userGuess<targetNumber)
                {
                    System.out.println("Too low! Try again");
                }
                else if(userGuess>targetNumber)
                {
                    System.out.println("Too high! Try again");
                }
            }
            if(!guessedCorrectly)
            {
                System.out.println("Sorry, You've used all your attempts. The correct number was: "+targetNumber);

            }
            System.out.println("Your Score for this round is "+score);
            System.out.println("Do you want to play again? (yes/no): ");
            String response= scanner.next().toLowerCase();
            playAgain=response.equals("yes");
        }while(playAgain);

        System.out.println("Thanks for playing! Your final score is: "+score);
        scanner.close();
    }
}