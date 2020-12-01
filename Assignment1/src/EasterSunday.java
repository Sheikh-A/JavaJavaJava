import java.util.Scanner;

public class EasterSunday {

	
	public static void main(String[] args) {
		System.out.println("input the year:");
		Scanner in = new Scanner(System.in);
		if (in.hasNextInt()) {
			int year = in.nextInt();
			if (year < 0) {
				System.out.println("Invalid input");
			}
			
			int a = year % 19;
			int b = year / 100;
			int c = year % 100;
			int d = b / 4;
			int e = b % 4;
			int f = (b + 8) / 25;
			int g = (b - f + 1) / 3;
			int h = (19* a + b - d - g + 15) % 30;
			int i = c / 4;
			int k = c % 4;
			int l = (32 + 2 * e + 2 * i - h - k) % 7;
			int m = (a + 11 * h + 22 * l) / 451;
			int month = (h + l - 7 * m + 114) / 31;
			int day = ((h + l - 7 * m + 114) % 31) + 1;
			
			
			String monthAsString = "";
			if(month == 1)
				monthAsString = "Jan";
			else if (month == 2)
				monthAsString = "Feb";
			else if (month == 3)
				monthAsString = "Mar";
			else if (month == 4)
				monthAsString = "Apr";
			else if (month == 5)
				monthAsString = "May";
			else if (month == 6)
				monthAsString = "Jun";
			else if (month == 7)
				monthAsString = "Jul";
			else if (month == 8)
				monthAsString = "Sep";
			else if (month == 9)
				monthAsString = "Oct";
			else if (month == 10)
				monthAsString = "Nov";
			else if (month == 11)
				monthAsString = "Dec";
			System.out.println("Easter Sunday for " + year + " is on " + monthAsString + " " + day);
			} else {
				System.out.println("Invalid input");
			
		}
	}
	
}
