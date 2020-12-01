import java.util.Random;

/**
	 * The dice class creates dice with 6 faces and contains a method to roll the dice
	 */

	public class Dice {

		private int[] possibleRolls = {1,2,3,4,5,6};
		
		public Dice() {	
		}
		
		/**
		 * rollDice returns a random number between 1 and 6
		 */
		public int rollDice() {
			Random r = new Random();
			int roll = r.nextInt(5);
			return possibleRolls[roll];
		}

	
	}
	
	


