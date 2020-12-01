import java.security.SecureRandom;

public class DeckOfCards {

	private Card[] deck;
	private int currentCard;
	
	
	public DeckOfCards() {
		
		String[] faces = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		String[] suits = {"Spades","Diamonds","Clubs","Hearts"};
		
		deck = new Card[52];
		currentCard = 0;
		
		for(int suit = 0; suit < 4; suit++) {
			for(int faceNum = 0; faceNum < 13; faceNum++) {
				deck[(faceNum + (suit*13))] = new Card(suits[suit], faces[faceNum],faceNum+2);
			}
		}
	}
	
	public void displayDeck() {
		for (Card card : deck) {
			System.out.println(card);
		}
	}
	
	//Deal a card
	public Card dealCard() {
		if(currentCard < deck.length) {
			return deck[currentCard++];
		} else {
			return null;
		}
	}
	
	public void shuffle() {
		currentCard = 0;
		SecureRandom randomNumber = new SecureRandom();
		
		for(int first = 0; first < deck.length; first++) {
			//select a random card
			int second = randomNumber.nextInt(52);
			//swap the cards
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
		
	}
	
	public int length() {
		return deck.length;
	}
	
	
	public static void main(String[] args) {
		
		DeckOfCards theDeck = new DeckOfCards();
		
		theDeck.displayDeck();
		
		theDeck.shuffle();
		System.out.println("After shuffle**************************");
		theDeck.displayDeck();
		
		System.out.println("After shuffle**************************");
		System.out.println(theDeck.dealCard());
		
		
		
		
		
	}
	
	
		
		
	
	
	
}
