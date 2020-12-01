/*
 * Author: Ali Sheikh
 * Formatting complete: done
 */

package dataloader;

import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

import driver.FormattedOutput;
import model.Airport;

//This file does all the data manipulation to answer all 9 questions from the assignment
public class DataManipulation {
	private static FormattedOutput fo = new FormattedOutput();

	// Constructor for this file
	public static void getAllAnswers(String path) {

		AirportDataReader adr = airportDataLoader(path);

		cancelAirLines();
		cancelflightReason();
		LongestFligtTailNumber();
		busiestAirport(adr.getAirportMap());
		biggestSourceOfPlanes(adr.getAirportMap());
		biggestSinkOfPlanes(adr.getAirportMap());
		americanAirlines();
		largestDelay();
		longestCarrierDistnace();
		fo.writeAnswers();
	}

	private static AirportDataReader airportDataLoader(String path) {
		AirportDataReader adr = new AirportDataReader(path);
		return adr;
	}

	// Question 1 - Which carrier has the highest percentage of cancelled flights?
	// Output the 2-letter
	// Carrier ID and the chance of a cancelled flight, as a percentage (Example:
	// AA,1.22%).
	// This percentage is defined as the number of canceled flights over the total
	// number of
	// flights.

	private static void cancelAirLines() {
		HashMap<String, int[]> cancelAirLines = new HashMap<String, int[]>();
		String uniqueCarrier = null;
		String delay = null;
		String Highiest = null;
		Double percentage = Double.MIN_VALUE; // constant
		// use for loop to go through the data
		for (int index : StaticDataLoader.flightMap.keySet()) {
			int[] data = new int[2];
			uniqueCarrier = StaticDataLoader.flightMap.get(index).getUniqueCarrier();
			delay = StaticDataLoader.flightMap.get(index).getCancelled();

			if (cancelAirLines.containsKey(uniqueCarrier)) {
				data = cancelAirLines.get(uniqueCarrier);
				data[0] = data[0] += 1;
				if (delay.equalsIgnoreCase("1")) {
					data[1] = data[1] += 1;
				}
			} else {
				data[0] = 1;
				if (delay.equalsIgnoreCase("1"))
					data[1] = 1;
				else
					data[1] = 0;
			}
			cancelAirLines.put(uniqueCarrier, data);
		}

		for (String carrier : cancelAirLines.keySet()) {

			Integer numFlight = cancelAirLines.get(carrier)[0];
			Double cancels = (double) cancelAirLines.get(carrier)[1];
			Double percent = cancels / (numFlight);
			if (percent > percentage) {
				percentage = percent;
				Highiest = carrier;
			}
		}

		System.out.println(Highiest + "," + percentage.doubleValue() * 100 + "%");
		fo.addAnswer(1, Highiest + "," + percentage.doubleValue() * 100 + "%");
	}

	// Question: 2 What’s the most common cause of cancellations?
	private static void cancelflightReason() {
		HashMap<String, Integer> cancelReason = new HashMap<String, Integer>();
		String cancelCode = null;

		for (int index : StaticDataLoader.flightMap.keySet()) {
			cancelCode = StaticDataLoader.flightMap.get(index).getCancellationCode();
			if (!cancelCode.isEmpty()) {
				if (cancelReason.containsKey(cancelCode)) {
					cancelReason.put(cancelCode, cancelReason.get(cancelCode) + 1);
				} else {
					cancelReason.put(cancelCode, 1);
				}
			}
		}
		// use .filter and .collect method to go through the data to get the answer for
		// the common cause of calculation
		String str = (cancelReason.entrySet().stream()
				.filter(entry -> entry.getValue() == Collections.max(cancelReason.values()))
				.collect(Collectors.toList())).toString();

		System.out.println(str.substring(1, str.indexOf("=")));
		fo.addAnswer(2, str.substring(1, str.indexOf("=")));
	}

	// Question: 3 Which plane (tail number) flew the furthest (most miles)? Output
	// the complete tailnumber
	// https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
	// Stream Classes to support functional-style operations on streams of elements,
	// such as map-reduce transformations on collections.
	private static void LongestFligtTailNumber() {
		HashMap<String, Integer> longestFlight = new HashMap<String, Integer>();
		String tailNumber = null;
		String cancelled = null;
		String distance = null;

		for (int index : StaticDataLoader.flightMap.keySet()) {
			tailNumber = StaticDataLoader.flightMap.get(index).getTailNum();
			cancelled = StaticDataLoader.flightMap.get(index).getCancelled();
			distance = StaticDataLoader.flightMap.get(index).getDistance();

			if (!tailNumber.isEmpty() && cancelled.equalsIgnoreCase("0")) {
				if (!longestFlight.containsKey(tailNumber)) {
					longestFlight.put(tailNumber, 0);
				} else if (!distance.isEmpty()) {
					longestFlight.put(tailNumber, (longestFlight.get(tailNumber) + Integer.parseInt(distance)));
				}
			}
		}

		String str = (longestFlight.entrySet().stream()
				.filter(entry -> entry.getValue() == Collections.max(longestFlight.values()))
				.collect(Collectors.toList())).toString();

		System.out.println(str.substring(1, str.indexOf("=")));
		fo.addAnswer(3, str.substring(1, str.indexOf("=")));
	}

	// Question: 4 Which airport is the busiest by total number of flights in and
	// out? Use the number
	// OriginAirportID

	private static void busiestAirport(HashMap<Integer, Airport> airportMap) {
		int maxPort = 0;
		int maxCount = 0;

		for (int airport : airportMap.keySet()) {
			int total = airportMap.get(airport).numArrivals + airportMap.get(airport).numDepartures;
			if (total > maxCount) {
				maxCount = total;
				maxPort = airport;
			}
		}

		System.out.println(maxPort);
		fo.addAnswer(4, maxPort);
	}

	// Question: 5 You need planes to put people on! Which airport is the biggest
	// “source” of airplanes?
	// Use the difference between arrivals and departures to compute this value.
	// Output the
	// OriginAirportID
	// Set inital value to see if we are getting an error i.e. 0;

	private static void biggestSourceOfPlanes(HashMap<Integer, Airport> airportMap) {
		int maxPort = 0;
		int maxSource = 0;

		for (int airport : airportMap.keySet()) {
			int departures = airportMap.get(airport).numDepartures;
			int arrivals = airportMap.get(airport).numArrivals;
			int source = departures - arrivals;
			if (source > maxSource) {
				maxSource = source;
				maxPort = airport;
			}
		}

		System.out.println(maxPort);
		fo.addAnswer(5, maxPort);

	}

	// Question: 6 Which airport is the biggest “sink” of airplanes?
	// Set inital value of max port and sink = 0 to see if error
	// Use a hashmap as the parameter to find biggest sink

	private static void biggestSinkOfPlanes(HashMap<Integer, Airport> airportMap) {
		int maxPort = 0;
		int maxSink = 0;

		for (int airport : airportMap.keySet()) {
			int departures = airportMap.get(airport).numDepartures;
			int arrivals = airportMap.get(airport).numArrivals;
			int sink = arrivals - departures;
			if (sink > maxSink) {
				maxSink = sink;
				maxPort = airport;
			}
		}

		System.out.println(maxPort);
		fo.addAnswer(6, maxPort);

	}

	// Question: 7 How many American Airlines (Unique Carrier ID ‘AA’) flights were
	// delayed by 60 minutes
	// or more?
	// Set initialized values, with count = 0; count each flight that has longer
	// than 60 min delay

	private static void americanAirlines() {
		int count = 0;
		String tail = null;
		String diverted = null;
		String cancelled = null;
		String delay = null;
		String depDelay = null;

		for (int index : StaticDataLoader.flightMap.keySet()) {
			tail = StaticDataLoader.flightMap.get(index).getUniqueCarrier();
			diverted = StaticDataLoader.flightMap.get(index).getDiverted();
			cancelled = StaticDataLoader.flightMap.get(index).getCancelled();
			delay = StaticDataLoader.flightMap.get(index).getArrDelay();
			depDelay = StaticDataLoader.flightMap.get(index).getDepDelay();

			// Find if flight delayed > 60 minutes or more

			if ((tail.equalsIgnoreCase("AA") && diverted.equalsIgnoreCase("0") && cancelled.equalsIgnoreCase("0"))) {
				if (delay != null && depDelay != null)
					if (!delay.equalsIgnoreCase("") && !depDelay.equalsIgnoreCase(""))
						if (Integer.parseInt(delay) >= 60 || Integer.parseInt(depDelay) >= 60)
							count++;
			}
		}

		System.out.println(count);

		fo.addAnswer(7, count);
	}

	// Question: 8 What was the largest delay that was made up (arrived early/on
	// time)?
	// Initialize variables by setting them to null OR constants
	// Use for loop to go through the data (and use KeySet) to keep track

	private static void largestDelay() {
		String arrDelay = null;
		String depDelay = null;
		int maxValue = Integer.MIN_VALUE;
		int value = Integer.MIN_VALUE;
		String tail = null;
		String day = null;

		for (int index : StaticDataLoader.flightMap.keySet()) {
			if (StaticDataLoader.flightMap.get(index).getCancelled().equalsIgnoreCase("0")) {
				depDelay = StaticDataLoader.flightMap.get(index).getDepDelay();
				arrDelay = StaticDataLoader.flightMap.get(index).getArrDelay();

				if (!depDelay.isEmpty() && !arrDelay.isEmpty()) {
					if (Integer.parseInt(depDelay) > 0 && Integer.parseInt(arrDelay) <= 0) {
						value = Integer.parseInt(depDelay);
					} else {
						value = -1;
					}

					if (value > maxValue) {
						maxValue = value;
						day = StaticDataLoader.flightMap.get(index).getDayofMonth();
						tail = StaticDataLoader.flightMap.get(index).getTailNum();
					}
				}
			}
		}

		System.out.println(day + "," + maxValue + "," + tail);
		fo.addAnswer(8, day + "," + maxValue + "," + tail);
	}

	// Question: 9 which Carrier has the longest distance flown?

	private static void longestCarrierDistnace() {
		HashMap<String, Integer> longestFlightCarrier = new HashMap<String, Integer>();
		String uniqueCarrier = null;
		String distance = null;

		for (int index : StaticDataLoader.flightMap.keySet()) {
			uniqueCarrier = StaticDataLoader.flightMap.get(index).getUniqueCarrier();
			distance = StaticDataLoader.flightMap.get(index).getDistance();

			if (!uniqueCarrier.isEmpty()) {
				if (!longestFlightCarrier.containsKey(uniqueCarrier)) {
					longestFlightCarrier.put(uniqueCarrier, 0);
				} else if (!distance.isEmpty()) {
					longestFlightCarrier.put(uniqueCarrier,
							(longestFlightCarrier.get(uniqueCarrier) + Integer.parseInt(distance)));
				}
			}
		}

		String str = (longestFlightCarrier.entrySet().stream()
				.filter(entry -> entry.getValue() == Collections.max(longestFlightCarrier.values()))
				.collect(Collectors.toList())).toString();

		System.out.println("Longest Distance of carrier ?  [CarrierName , Distance]" + str);
		fo.addAnswer(9, "Longest Distance of carrier ?  [CarrierName , Distance]" + str);
	}
}
