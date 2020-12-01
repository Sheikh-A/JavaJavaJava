
public class Game {

	public static void main(String[] args) {
		
		//Card newCards = new Card(suit, face, value)
		
		DeckOfCards deck1 = new DeckOfCards();
		DeckOfCards deck2 = new DeckOfCards();
		
		deck1.shuffle();
		deck2.shuffle();
		

		
		int Player1 = 0;
		int Player2 = 0;
		int count = 0;
		
				
		
		for (int i = 0; i < deck1.length(); i++) {
			int score1 = deck1.dealCard().getFaceValue();
			int score2 = deck2.dealCard().getFaceValue();
			
			System.out.println("p1. " + score1);
			System.out.println("p2. " + score2);
			System.out.println();
			
			if(score1 > score2) {
				Player1++;
			} else if (score2 > score1) {
				Player2++;
			}
			count++;
			
		}
		
		if(Player1 > Player2) {
			System.out.println("Player 1 wins!" + count);
		} else if (Player1 < Player2) {
			System.out.println("Player 2 wins!" + count);
		} else if (Player1 == Player2) {
			System.out.println("Tie game" + count);
		}
		
	}
	
}
