public class Card {
	
	public int totalCards;
	public int CardPosition;
	
	public Card(){
		this.totalCards = 52;
		this.CardPosition = 0;
		
		
	}
	//This gets a card from the deck and keeps track of the card position int he shuffled deckarray.
	public String getCard(String[] DeckArray, int cardPosition) {
//		System.out.println(Deck.NumOfCards);
//		System.out.println(DeckArray);
		String card = DeckArray[this.CardPosition];
		
		this.CardPosition++;
		return card;
	}
	
	public int getCardPosition() {
		return CardPosition;
	}
	


	

}