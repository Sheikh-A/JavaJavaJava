/**
 * Square method contains the squares that make up the game grid. If the sqaure contains a snake or ladder
 * the boolean values will be marked as true and the transport location will reflect the end of the 
 * snake or ladder.
 * @author alisheikh
 *
 */


public class Square {
	private boolean hasSnake;
	private boolean hasLadder;
	private int locationInGrid;
	//amount of spaces moved by the ladder or snake
	private int transportLocation;
	
	public Square(boolean snake, boolean ladder, int location, int transport) {
		hasSnake = snake;
		hasLadder = ladder;
		locationInGrid = location;
		setTransportLocation(transport);
	}

	
	//getter and setters
	
	public int getLocationInGrid() {
		return locationInGrid;
	}
	
	public int getTransportLocation() {
		return transportLocation;
	}

	public void setTransportLocation(int transportLocation) {
		this.transportLocation = transportLocation;
	}
	
	public boolean getHasSnake() {
		return hasSnake;
	}
	
	public boolean getHasLadder() {
		return hasLadder;
	}
	

}
