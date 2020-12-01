/*
 * author: Ali Sheikh
 * formatting complete
 */
package driver;

import dataloader.DataManipulation;
import dataloader.StaticDataLoader;

//Constructor for main method
public class mainMethod {
	final private static String filePath = "flights.csv";

	public static void main(String[] args) {
		StaticDataLoader.readFromFile(filePath);
		DataManipulation.getAllAnswers(filePath);
	}
}
