import java.util.Scanner;

public class DiceGame {
	
	private Scanner sc = new Scanner (System.in);
	
	public void rollDice(Scanner sc, int target) {
		
		System.out.println("How many times would you like to roll?");
		int roll = sc.nextInt();
		
		System.out.println("Times to roll: " + roll);
		
		if(roll < 1) {
			roll = 10;
		}
		
		sc.nextLine();
		System.out.println();
		
		System.out.println("How many dice sides?");
		int sides = sc.nextInt();
		System.out.println("Sides on dice: " + sides);
		
		if(sides < 3) {
			sides = 6;
		}
		
		int sum = 0;
		for(int i = 0; i < roll; i++) {
			int userRoll = (int)((Math.random() * sides) + 1);
			System.out.println("rolled: " + userRoll );
			sum+= userRoll;
		}
		
		System.out.println("Sum of rolls: " + sum);
		
		if(sum > target) {
			System.out.println(target + " exceeded");
		} else if(sum > target) {
			System.out.println(target +  " not exceeded");
		} else {
			System.out.println(target + " equals " + sum);
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scd = new Scanner(System.in);
		
		DiceGame game = new DiceGame();
		
		game.rollDice(scd, 10);
	}

}
