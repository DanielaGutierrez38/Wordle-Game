import java.io.FileNotFoundException;

public class Tester {
  public static void main(String[] args) throws FileNotFoundException {
    
    System.out.println(WordBank.checkInDictionary("hello"));  // true
    System.out.println(WordBank.checkInDictionary("asdfg"));  // false

    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(1)); // plumb

    //Tests
    WordleLetter letter = new WordleLetter('b');//Initialize WordleLetter

    letter.setColor("yellow");

    System.out.println(letter.isColorSet()); //true

    System.out.println(letter.isGreen());//false

    WordleGame game = new WordleGame(3); //scold

    System.out.println(game.isGameWin());//false

    System.out.println(game.getNumberGuessesSoFar());//0

    game.guess("cream");

    for (int i = 0; i < 5; i ++) {//Print guess 0 

      System.out.print(game.getGuess(0)[i]);

    }

    System.out.println();

    System.out.println(game.isGameOver()); //false

    game.guess("abbey");

    System.out.println(game.isGameWin());//false

    System.out.println();

    System.out.println(game.getNumberGuessesSoFar());//2

    game.guess("decoy");

    System.out.println(game.getNumberGuessesSoFar());//3

    game.guess("elder");

    System.out.println(game.isGameWin());//false

    System.out.println(game.getNumberGuessesSoFar());//4

    game.guess("fable");

    game.guess("abers");

    System.out.println(game.isGameOver());//true

    System.out.println(game.isGameWin()); //false

    //Print all remaining guesses
    for (int i = 0; i < 5; i ++) {

      System.out.print(game.getGuess(1)[i]);

    }

    System.out.println();

    for (int i = 0; i < 5; i ++) {

      System.out.print(game.getGuess(2)[i]);

    }

    System.out.println();

    for (int i = 0; i < 5; i ++) {

      System.out.print(game.getGuess(3)[i]);

    }

    System.out.println();

    for (int i = 0; i < 5; i ++) {

      System.out.print(game.getGuess(4)[i]);

    }

    //Tests for main

    WordleGame game2 = new WordleGame(0);

    /*while(!game2.isGameOver()) {

    String guessWord = "";

            boolean check = false;

            while(!check) {

                guessWord = "cream";

                check = WordBank.checkInDictionary(guessWord);

            }

            game2.guess(guessWord);

            System.out.println(game2.toString());
      }*/

    }


}
