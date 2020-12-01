import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderT {
	
	
	public static void main(String[] args) {
		
		File myFile = new File("test.txt");
		ArrayList<Double> scores = new ArrayList<Double>();
		
		
		try {
			Scanner sc = new Scanner(myFile);
			
			while(sc.hasNextLine()) {
				String fileScores = sc.nextLine();
				double fileScoresDouble = Double.parseDouble(fileScores);
				scores.add(fileScoresDouble);
			}
			
			double sum = 0;
			
			for(double score : scores) {
				sum += score;
			}
			
			double average = (double) sum / scores.size();
			
			double stdDev = 0;
			
			for(double double1 : scores) {
				stdDev += Math.pow(double1 - average, 2);
			}
			stdDev = Math.sqrt(stdDev / (scores.size() -1));
			
			try {
				FileWriter fw = new FileWriter("test.txt", true);
				PrintWriter pw = new PrintWriter(fw);
				pw.println("Average is equal to " + average);
				pw.println("Standard deviation equals " + stdDev);
				pw.flush();
				
				
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
