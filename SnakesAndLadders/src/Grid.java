import java.util.Arrays;

/**
 * The class Grid holds the game board as an array containing Squares
 * @author alisheikh
 *
 */


public class Grid {
	
	private Square[] grid;
	
	/**
	 * Consturctor forms the grid by creating new squares for each of the 100 spots in the grid if the
	 * square number is in the list of snakes or ladders the boolean indication a ladder
	 * will be assigned as true adn the corresponding landing spot will be assigned
	 */
	
	public Grid() {
		grid = new Square[100];
		Integer[] snakes = {17,52,57,62,88,95,98};
		Integer[] ladders = {3,8,28,58,75,80,90};
		Integer[] snakesLandingSpot = {15,29,40,22,18,51,79};
		Integer[] laddersLandingSpot = {21,30,84,77,86,100,91};
		
		for (int i=0; i < grid.length; i++) {
			Square square = null;
			if(Arrays.asList(snakes).contains(i+1)) {
				square = new Square(true, false, i+1, snakesLandingSpot[Arrays.asList(snakes).indexOf(i+1)]);
			} else if (Arrays.asList(ladders).contains(i+1)) {
				square = new Square(false, true, i+1, laddersLandingSpot[Arrays.asList(ladders).indexOf(i+1)]);
			} else {
				square = new Square(false, false, i+1, i+1);
			}
			grid[i] = square;
		}
	}
	
	
	/**
	 * Print the grid for reference the players location will not be updated during game play.
	 * 
	 */
	
	public void displayGrid() {
		for (int i =0; i<grid.length; i++) {
			System.out.println(grid[i].getLocationInGrid() + "		");
			if((i+1)%5 ==0) {
				System.out.println("");
			}
		}
	}
	
	/**
	 * Move hte playet to the new location including the amount of the ladder or slide
	 */
	
	public int movePlayer(int currentLocation, int roll) {
		if(grid[currentLocation+roll-1].getHasSnake()) {
			System.out.println("Oh no you hit a snake");
			return grid[currentLocation+roll-1].getTransportLocation();		
		}
		if (grid[currentLocation+roll-1].getHasLadder()) {
			System.out.println("Yay you hit a ladder!");
			return grid[currentLocation+roll-1].getTransportLocation();
		}
		else {
			return currentLocation + roll;
		}
	}
	
	public static void main(String[] args) {
		Grid g = new Grid();
	}
	
	

}
