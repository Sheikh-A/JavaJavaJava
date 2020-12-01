/**
 * Card class creates candland card with number of sqaures on the card a string for the color
 * and boolean if there is a candy character
 * 
 * @author alisheikh
 *
 */
public class Card {
	
	private int numberOfSquares;
	private String color;
	private String person;
	private boolean candyCharacter;
	
	public Card(int squares, String squareColor, boolean character) {
		numberOfSquares = squares;
		color = squareColor;
		candyCharacter = character;
		person = "Candy Card";
		//deck[0].getPerson();
	}

}
