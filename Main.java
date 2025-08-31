import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static WordleGame startGame(Scanner scanner) throws FileNotFoundException {

        System.out.println("----------------------------------");
        System.out.println("      Welcome to Wordle!");
        //I put 0 to 2314 because there are 2315 games, so the indeces only go up to 2314 because of 0 indexing
        System.out.print("Please introduce a number between 0 and 2314 to start the game: ");
        int input = scanner.nextInt();

        scanner.nextLine(); 

        WordleGame game = new WordleGame(input); //Initizalize game with input number

        return game;  
    }

    public static void playGame(Scanner scanner, WordleGame game) throws FileNotFoundException {
        
        //Check if game is over to decide whether to procede or not 
        while(!game.isGameOver()) {

            String guessWord = ""; //Initialize guessWord

            boolean check = false; //Variable that will keep track if guessWord is valid

            while(!check) { //Prompt again and again until a valid word is entered

                System.out.println("Please introduce a 5 letter word written in ALL lowercase: ");
                guessWord = scanner.nextLine();

                //Check if word is valid and change value of check based on this 
                check = WordBank.checkInDictionary(guessWord);  

            }

            game.guess(guessWord); //Invoke guess method to change colors and store values

            System.out.println(game.toString()); //Print state of the game

        }

    }

    public static void reportGameOutcome(WordleGame game) throws FileNotFoundException {
        
        //Check if game has been won
        if (game.isGameWin()) {

            System.out.println("You won!");

        }else {

            System.out.println("The answer was " + game.getAnswer());//Print answer otherwise

        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in); //Initialize scanner
        WordleGame game = startGame(scanner); //Start game
        playGame(scanner, game); //Play game
        reportGameOutcome(game); //Print result
    }
}
