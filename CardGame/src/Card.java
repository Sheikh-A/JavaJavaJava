import java.awt.image.BufferedImage;

public class Card {
	
	private String faceName;
	private String suit;
	private int faceValue;
	//private BufferedImage cardImage;
	
	public Card(String suit, String face, int value) {
		this.suit = suit;
		faceName = face;
		faceValue = value;	
	}
	
	
	public String toString() {
		return faceName + " " + suit;
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public static void main(String[] args) {
		
		Card aceOfSpades = new Card("Spades", "Ace", 14);
		Card queenOfHearts = new Card("Queens", "Hearts", 12);
		
		
		System.out.println(aceOfSpades.toString());
		System.out.println(aceOfSpades.getFaceValue());
		
		System.out.println(queenOfHearts.toString());
		System.out.println(queenOfHearts.getFaceValue());
		
		
	}

}
