/**
 * Ali Sheikh
 * Dataloader is the package witht he Airport data reader in it in the src folder
 * Formatting complete
 */
package dataloader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import model.Flight;

public class StaticDataLoader {

	// Initialize variables, make public so can be read in other files
	public static ArrayList<Flight> flightData = new ArrayList<Flight>();

	public static HashMap<Integer, Flight> flightMap;

	public static Stream<String> stream;
	private static final String regex = ",";
	private static String[] arr;
	private static int count;

	// shortcut for using static variables
	static {
		stream = null;
		flightData = null;
		arr = new String[22];
		flightMap = new HashMap<Integer, Flight>();
		count = 0;
	}

	public static void readFromFile(String filePath) {
		try {
			stream = Files.lines(Paths.get(filePath));
			stream.forEach(d -> {
				count++;
				StaticDataLoader.parseData(count, d); // count.getAndIncrement()
			});
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// parse data based on number of columns of data, could maybe use a for loop
	// instead of typing manually?
	private static void parseData(int index, String data) {
		arr = data.split(regex);
		flightMap.put(index,
				new Flight(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[10],
						arr[11], arr[12], arr[13], arr[14], arr[15], arr[16], arr[17], arr[18], arr[19], arr[20],
						arr[21]));
	}
}
