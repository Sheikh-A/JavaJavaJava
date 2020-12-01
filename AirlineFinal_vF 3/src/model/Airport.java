/**
 * Author: Ali Sheikh
 * formatting complete
 */
package model;

//Model the data from the csv 
//Automatically get getters and setters for each

public class Airport {
	Integer airportID;
	public Integer numArrivals;
	public Integer numDepartures;

	public Airport(int id, int arr, int dep) {
		// index 5
		airportID = id;

		// index8
		numArrivals = arr;

		// index5 == increment counter
		numDepartures = dep;
	}

	public void setNumArrivals(Integer numArrivals) {
		this.numArrivals = numArrivals;
	}

	public void setNumDepartures(Integer numDepartures) {
		this.numDepartures = numDepartures;
	}

	public Integer getAirportID() {
		return airportID;
	}

	public Integer getNumArrivals() {
		return numArrivals;
	}

	public Integer getNumDepartures() {
		return numDepartures;
	}

}