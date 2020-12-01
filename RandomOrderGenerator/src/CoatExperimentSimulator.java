
public class CoatExperimentSimulator {
	
	int numberOfPeople;
	
	
	CoatExperimentSimulator(int numPpl) {
		 numberOfPeople = numPpl;
		}
	
	
	public int numPplWhoGotTheirCoat(int[] permutation) {
		return 10;
	}; 
	
	public int[] simulateCoatExperiment(int iterations) {
		return null;
	}
	
	public double answerToQuestionA(int[] results) {
		return 10.8;
	};
	
	public double answerToQuestionB(int[] results) {
		return 10.8;
	};
	
	
	public static void main(String[] args) {
		
		//create a CoatExperimentSimulator with 25 people. This is 
		//where you will be using the constructor.
		
		CoatExperimentSimulator coat = new CoatExperimentSimulator(25);
		
		//run the simulation 100000 times
		
	
		
		
		
		//print the probability of 0 people getting their coats
		//back. Simply print the value of the variable. If the variable is
		//called probability, please just say System.println(probability)
		//as shown below.
		
		double probability = 10;
		
		System.out.println(probability);
		
		 //print the average number of people who get their coats back.
		
		
		double average = 10;
		
		System.out.println(average);
		
		 //print the estimate of the value of e that you got from
//		this procedure. Remember that the probability for 0 people
//		getting their coats back is 1/e as the number of people gets
//		sufficiently large (100000 is a reasonable threshold for large).
		
		double estimate = 10;
		System.out.println(estimate);
	}
	
	
}
