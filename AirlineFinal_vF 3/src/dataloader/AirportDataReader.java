/**
 * Author: Ali Sheikh
 * Data reader file to read data from csv and parse the data correctly using comma to split data
 * Formatting complete
 */

package dataloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import model.Airport;

public class AirportDataReader {

	// Instantiate hashmap
	private HashMap<Integer, Airport> airportMap;

	// Public constructor
	public HashMap<Integer, Airport> getAirportMap() {
		return airportMap;
	}

	// Data Reader method, using file name as String
	// Used try/catch default for data to read
	// Import a scanner and use the hasNextLine method // and while true loop
	public AirportDataReader(String fileName) {
		File f = new File(fileName);
		airportMap = new HashMap<Integer, Airport>();

		try {
			Scanner s = new Scanner(f);
			s.nextLine();
			while (s.hasNextLine()) {
				String[] l = s.nextLine().split(",");
				int depAir = Integer.parseInt(l[5]);
				int arrAir = Integer.parseInt(l[8]);

				if (!airportMap.containsKey(depAir)) {
					Airport d = new Airport(depAir, 0, 1);
					airportMap.put(depAir, d);
				} else {
					int d = airportMap.get(depAir).getNumDepartures();
					airportMap.get(depAir).setNumDepartures(d + 1);
				}

				if (!airportMap.containsKey(arrAir)) {
					Airport a = new Airport(arrAir, 1, 0);
					airportMap.put(arrAir, a);
				} else {
					int a = airportMap.get(arrAir).getNumArrivals();
					airportMap.get(arrAir).setNumArrivals(a + 1);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}