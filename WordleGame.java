import java.io.FileNotFoundException;

public class WordleGame {

  private int puzzleNumber;
  private WordleLetter [][] guesses = new WordleLetter[6][5]; //6 x 5 Array that will store all the guesses 
  private int guessRow = 0; //To keep track of what row we're at

  //Constructor
  public WordleGame(int puzzleNumberIn) {

    this.puzzleNumber = puzzleNumberIn;

  }

  //Getter that returns the answer for the puzzle
  public String getAnswer() throws FileNotFoundException {

    return WordBank.getAnswerForPuzzleNumber(this.puzzleNumber);

  }  

  public void guess(String guessWord) throws FileNotFoundException {

      //Traverse the whole word for a certain guess
      for (int j = 0; j < this.guesses[0].length; j ++) {

        //Create a WordleLetter for each character of the word
        WordleLetter letter = new WordleLetter(guessWord.charAt(j));

        //Check if the letter is the same as the letter in the same position in the answer
        if (letter.getLetter() == this.getAnswer().charAt(j)) {

          letter.setColor("green");//Set color to green if true

        }else {//If the letters do not match exactly:

          for (int k = 0; k < this.guesses[0].length; k ++) { //Traverse guessWord again

            //Check if color has been set to determine if it will procede 
            if (letter.isColorSet() == false) { 

              //Check if the letter is at any other position in the guessWord
              if (letter.getLetter() == this.getAnswer().charAt(k)) {

                  letter.setColor("yellow");//Set color to yellow if true

              }//end of if statement

            }//end of if statement 


          }//end of 2nd for loop

          if (letter.isColorSet() == false) { //If color has not been set...

            letter.setColor("red");//Set to red

          }//end of if  

        }//end of if else

      this.guesses[this.guessRow][j] = letter; //Store letter values in array

    }//end of first for loop

    this.guessRow++;//Keep track of what row the array is currently storing the letters at

  }

  public int getNumberGuessesSoFar() {

    int numGuesses = 0;//Initialize counter variable that will be returned

    for (int i = 0; i < this.guesses.length; i ++) {//Traverse through rows of 2D array

      //Checks if there is a value stored at the first space of each row. If there is a value already,
      //that means a guess has been made
      if (guesses[i][0] != null) { 
        numGuesses++; //Counts how many rows have already been filled with a value
      }

    }

    return numGuesses;

  }

  public WordleLetter[] getGuess(int guessNumber) {

    if (guessNumber >= 0 && guessNumber <= 5) { //Check if guessNumber is a valid number

      return this.guesses[guessNumber]; //Return guesses at whatever index has been requested

    }else {

      //Print this otherwise and return guesses[0]
      System.out.println("Invalid number. Please enter a number between 0 and 5");
      return this.guesses[0];

    }

  }

  public boolean isGameOver() throws FileNotFoundException{

    int counter = 0; //Variable to count the amount of guesses that are stored

    //If the first value of the first position of the array is empty, that means no guesses are stored 
    //Consequently, the game has not started and it is not over 
    if (this.guesses[0][0] == null) {  
      return false;
    }

    if (this.isGameWin()) { //If the game has been won, the game is over
      return true;
    }else {

      //Traverse guesses array
      for(int i = 0; i < this.guesses.length; i ++) {

        for (int j = 0; j < this.guesses[i].length; j ++) {

          if (this.guesses[i][j] != null) { //Check if there is a value at guesses[i][j]

            counter ++;//Count the guesses

          }

        }

      }

      }

    //30 means that all guesses have been made and no win, return true
    if (counter == 30) {
      return true;
    }else {
      return false;//Return false otherwise
    }

  }

  public boolean isGameWin() throws FileNotFoundException { 

    //If the first value of the first position of the array is empty, that means no guesses are stored 
    //Consequently, the game has not started and it is not over 
    if (this.guesses[0][0] == null) { 
      return false;
    }

    int greenCounter = 0; //Count how many letters are green

    WordleLetter[] currentWord = this.guesses[guessRow - 1]; //Create array to represent the row

    for (int i = 0; i < currentWord.length; i ++) { //Traverse the current row

        WordleLetter letter = currentWord[i]; //Create a new WordleLetter for each letter in the guess

        if (letter.isGreen()) { //Check if letter is set to be green
          greenCounter ++; //Count green letters
        }

    }

    if (greenCounter == 5) { //If there are 5 green letters, the game is won 
        return true;
    }else {

      return false;//Otherwise, there is not a win yet

    }

  }

  public String toString() {
    // result will be used to build the full answer String
    String result = "";
    // for each word guessed so far
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
     // get each letter of each word
       for (int j = 0; j < 5; j++) {
         // concatenate it to the result
         // WordleLetter's toString() is automatically invoked here.
         result += getGuess(i)[j];
       }
       // new line separator between each word
       result += "\n";
     }
    return result;
  }
}
