import java.io.IOException;
import java.util.Scanner;

public class PositiveIntegerTester {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number: ");
		int input = sc.nextInt();
		PositiveInteger x;
		try {
			x = new PositiveInteger(input);
			System.out.println("the pos int is " + x.number);
		} catch (IOException e) {
			System.out.println("negative or 0 input not allowed");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
