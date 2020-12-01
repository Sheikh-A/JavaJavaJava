import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanningException {


	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			
			try {
			int x = scanner.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("did not enter a number");
				scanner.nextLine();
			}
			
		}
	}
	
}
