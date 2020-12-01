
public class PositiveInteger {
	
	private int num;
	
	public PositiveInteger(int num) {
		this.num = num;
	}
	
	
	/**
	 * Helper method, 
	 * @return
	 */
	private int sumOfFactors() {
		int sumOfFactors = 0;
		int currentFactor = 1;
		
		while (currentFactor != num) {
			if(num / currentFactor == num / (double) currentFactor) {
				sumOfFactors += currentFactor;
			}
			currentFactor++;
		}
		return sumOfFactors;
	}
	
	public boolean isPerfect() {
		if (sumOfFactors() == num) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isAbundant() {
		if (num < sumOfFactors()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isNarcissistic() {
		String numAsString = String.valueOf(num); //convert to string to get length;
		
		double numLength = numAsString.length();
		
		int sumOfPowers = 0;
		
		for(int i = 0; i < numLength; i++) {
			String oneChar = "" + numAsString.charAt(i);
			Integer digit = Integer.parseInt(oneChar);
			double x = Math.pow(digit, numLength);
			sumOfPowers += x;		
		}
		
		if (num == sumOfPowers) {
			return true;
		} else {
			return false;
		}

	}
	
	
	

}
