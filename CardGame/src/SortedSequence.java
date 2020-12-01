import java.util.Arrays;
import java.util.Random;

public class SortedSequence
{

	public int[] generateRandom(int n) {
		int[] tosses = new int[n];
		Random generator = new Random();
		for (int i = 0; i < n; i++) {
			tosses[i] = generator.nextInt(100);
		}
		return tosses;
	}
	
	public void printArray(int[] values) {
		for(int i =0; i < values.length; i++) {
			System.out.println(values[i] + " " + i);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		SortedSequence util = new SortedSequence();
		
		//System.out.println(util);
		
		int[] values = util.generateRandom(20);
		util.printArray(values);
		Arrays.sort(values);
		util.printArray(values);
		
	}
	

}
