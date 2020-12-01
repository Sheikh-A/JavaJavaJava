import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading {

	
	public static void main(String[] args) {
		File myFile = new File("randomtext");
		try {
			Scanner scanner = new Scanner(myFile);
			int count = 0;
			while(scanner.hasNext()) {
				String nextWord = scanner.next();
				count++;
			}
			System.out.println("the number of words is " + count);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
