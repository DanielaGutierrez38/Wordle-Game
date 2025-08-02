import java.io.File; //To read file
import java.io.FileNotFoundException; //Throw exception if file not found
import java.util.Scanner; //To initialize scanners

public class WordBank {

  // This first method implementation is completed for you already.
  // Do not modify the method signature.
  public static String getAnswerForPuzzleNumber(int puzzleNumber) throws FileNotFoundException {
    // Create a file scanner to read answers.txt.
    Scanner scanner = new Scanner(new File("answers.txt"));
    // Skip the first puzzleNumber number of words in the file.
    for (int i = 0; i < puzzleNumber; i++) {
      scanner.next();
    }
    // Return the very next word.
    return scanner.next();
  }

  // Do not modify the method signature.
  public static boolean checkInDictionary(String proposed) throws FileNotFoundException {

    //File scanner that will read dictionary.txt
    Scanner scanner = new Scanner(new File("dictionary.txt"));

    while(scanner.hasNext()) {//Traverse the words in dictionary.txt

      if (scanner.next().equals(proposed)) { //If the scanner finds a word that is the same as proposed...
        return true; //Return true
      }

    }

    return false; //Return false otherwise
  }
  
}
