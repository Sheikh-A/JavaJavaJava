import java.util.Random;

public class Deck {
	
	private Card[] deck = new Card[30];
	
	public Deck() {
		String[] colors = {"yellow", "blue", "pink", "green", "red"};
		Random rand1 = new Random();
		Random rand2 = new Random();
		
		
		for (int i = 0; i < deck.length; i++) {
			Card card = null;
			int randomColor = rand1.nextInt(4);
			int oneOrTwoSquares = rand2.nextInt(2);
			String color = colors[randomColor];
			boolean character;
			if (i%5 ==0) {
				character = true;
			} else {character = false;}
			card = new Card(oneOrTwoSquares + 1, color, character);
		}
	}

}
