
public class Player {
	
	private int currentLocation;
	
	//Players start at 1
	public Player() {
		currentLocation = 1;
	}
	
	/**
	 * Get the set current Location
	 */
	
	public int getCurrentLocation() {
		return currentLocation;
	}
	
	public void setCurrentLocation(int newLocation) {
		currentLocation = newLocation;
	}

}
