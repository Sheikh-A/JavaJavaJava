import java.util.*;

public class Deck {
	public int NumOfCards;
	public String[] deckArray;
	public int[] pointsA11;
	public int[] pointsA1;
	public String[] shuffledDeckArray;

	
	//constructor for deck
	public Deck() {
		this.NumOfCards = 52;
		this.deckArray = new String[this.NumOfCards];
		this.pointsA1 = new int[this.NumOfCards];
		this.pointsA11 = new int[this.NumOfCards];
		
		
		this.deckArray = setDeckCreation(this.deckArray);
		this.shuffledDeckArray = new String[this.NumOfCards];
		System.arraycopy(deckArray, 0 , this.shuffledDeckArray, 0 , this.deckArray.length);
		this.shuffledDeckArray = setShuffledDeck(this.shuffledDeckArray);
	}
	//method to create the deck
	public String[] setDeckCreation(String[] deckArray) {
		String[] DeckArray = deckArray;
		String number = " ";
		String suit;
		String cardsuit;
		int count = 0;
		//loops through creating for deck of cards
		//determines suit values
			for(int j=1; j<=4; j++) {
				if(j==1) {
					suit = "H";
				}else if(j==2){
					suit = "D";
				}else if(j==3) {
					suit = "S";
				}else {
					suit = "C";
				}
				//numeric values
				for(int k=2; k<=14; k++) {
					
					if(k>=2&&k<=10) {
						number =  Integer.toString(k);
						this.pointsA1[count] = k;
						this.pointsA11[count] = k;
						
					}else if(k>=11&&k<=13) {
						this.pointsA1[count] = 10;
						this.pointsA11[count] = 10;
						//face values
						if(k==11) {
							number = "J";
						}else if(k==12) {
							number = "Q";
						}else if(k==13) {
							number = "K";
					}
					}else {
						number = "A";
						this.pointsA1[count] = 1;
						this.pointsA11[count] = 11;
					};
					
					if(count<52) {
						cardsuit = number.concat(suit);
						
						DeckArray[count] = cardsuit;
						count++;
					}else {
						break;
					}
				}
			}
		
		return DeckArray;
	}
	//This method shuffles the deck created by the previous method
	public String[] setShuffledDeck(String[] orderedDeck) {
		List<String> DeckAsList = Arrays.asList(orderedDeck);
		String[] shuffledDeck = new String[52];
		Collections.shuffle(DeckAsList);
		shuffledDeck = DeckAsList.toArray(shuffledDeck);
		
		return shuffledDeck;
	}
	
	//this method is a getter for the shuffled deck
	public String[] getDeck() {
		return this.shuffledDeckArray;
		
	}

}