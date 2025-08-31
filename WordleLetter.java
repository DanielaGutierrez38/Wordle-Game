public class WordleLetter {

	//Attributes
	private char letter;
	private String color;

	//Constructor
	public WordleLetter(char letterIn) {

		this.letter = letterIn;

	}

	//Getter (I implemented this to access letters in WordleGame)
	public char getLetter() {

		return this.letter;

	}

	//Setter
	public void setColor(String colorIn) {

		this.color = colorIn;

	}

	//Methods
	public boolean isColorSet() {

		if (this.color == null || this.color.equals("")) { //Checks if the values are null or blank
			return false;
		}

		return true;

	}

	public boolean isGreen() {

		if (this.color == null) { //Checks if the value has not been initizalized
			
			return false;

		}else if (this.color.equals("green")) { //Return true if the color is set to green, return false otherwise
			
			return true;
		}

		return false;

	}


	public String toString() {
 	// Determine the special characters to add
 	// at the beginning of the String
 	// to change the text color to the right color.
	 	String colorCode;
	 	if(color.equals("green")) {
	 		colorCode = "\u001B[32m";
	 	} else if(color.equals("yellow")) {
	 		colorCode = "\u001B[33m";
	 	} else {
	 		colorCode = "\u001B[31m";
	 	}
	
 	// These are the special character to add
 	// to the end of the String
 	// to signify the end of the color change.
	 	String resetCode = "\u001B[0m";
	
 	// Surround the letter with
 	// space characters and with
 	// the above color changing special characters.
	 	return String.format(
	 		"%s %s %s",
	 		colorCode, letter, resetCode);
	 }
}
