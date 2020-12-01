
public class CoatExperimentSimulator {

	private int numberOfPeople;

	public CoatExperimentSimulator(int numPpl) {
		numberOfPeople = numPpl;
	}

	/**
	 * determines the number of people who got thier coat back
	 */

	public int numPplWhoGotTheirCoat(int[] permutation) {

		int numPplWithCoat = 0;

		for (int i = 0; i < numberOfPeople; i++) {
			if(permutation[i] == i + 1) {
				numPplWithCoat++;
			}
		}
		return numPplWithCoat;
	}
	
	public int[] simulateCoatExperiment(int iterations) {
		
		int[] outcomes = new int[iterations];
		
		for(int i = 0; i < iterations; i++) {
			int[] randomOrder = RandomOrderGenerator.getRandomOrder(numberOfPeople);
			outcomes[i] = numPplWhoGotTheirCoat(randomOrder);
		}
		return outcomes;
	}
	
	public double answerToQuestionA(int[] results) {
		int numZero = 0;
		
		for(int i = 0; i < results.length; i++) {
			if(results[i] == 0) {
				numZero++;
			}
		}
		
		return numZero / (double) results.length;
	}
	
	public double answerToQuestionB(int[] results) {
		int sumResults = 0;
		
		for (int i = 0; i < results.length; i++) {
			sumResults += results[i];
		}
		
		return sumResults / (double) results.length;
	}
	
	public static void main(String[] args) {
		
		
		CoatExperimentSimulator simulation = new CoatExperimentSimulator(25);
		
		//run the simulation 100,000 times
		int[] experimentOutcomes = simulation.simulateCoatExperiment(100_000);
		
		//print probability of 0 people getting coats back
		
		double probZero = simulation.answerToQuestionA(experimentOutcomes);
		System.out.println(probZero);
		
		double avgHatReturn = simulation.answerToQuestionB(experimentOutcomes);
		System.out.println(avgHatReturn);
		
		double e = 1 / probZero;
		System.out.println(e);
		
				
		
	}
	
	
	
	
	


}
