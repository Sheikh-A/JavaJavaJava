import java.util.Scanner;

/**
	 * Controls game play
	 * Play game is ture until a player reached the end
	 * Ali Sheikh
	 */
	
	public class SnakesAndLadders {
		private boolean playGame;
		
		public SnakesAndLadders() {
			playGame = true;
		}
		
		
		/**
		 * Play contains a while loop which continues the game until a player reaches 
		 * the end It takes use input when it is time to roll the dice.
		 */
		
		public void play() {
			//intiate objects
			Grid newGrid = new Grid();
			Dice dice = new Dice();
			Player player1 = new Player();
			Player player2 = new Player();
			Scanner s = new Scanner(System.in);
			
			
			while(playGame) {
				if (player1.getCurrentLocation() == 100 || player2.getCurrentLocation() == 100) {
					playGame = false;
				}
				else {
					System.out.println("Player 1 press any key to roll");
					s.nextLine();
					int roll1 = dice.rollDice();
					System.out.println("Player 1 rolled " + Integer.toString(roll1));
					player1.setCurrentLocation(newGrid.movePlayer(player1.getCurrentLocation(), roll1));
					System.out.println("Player 1 is on spot " + player1.getCurrentLocation());
					System.out.println("Player 2 press any key to roll");
					s.nextLine();
					int roll2 = dice.rollDice();
					System.out.println("Player 2 rolled " + Integer.toString(roll2));
					player2.setCurrentLocation(newGrid.movePlayer(player2.getCurrentLocation(), roll2));
				}
			}
			
		}
		
		public static void main(String[] args) {
			SnakesAndLadders s = new SnakesAndLadders();
			s.play();
		}
		
		
	}


