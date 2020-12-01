import java.util.ArrayList;
import java.util.*;
import javax.swing.JFrame;

/**
 * 
 * @author Cindy/Ali/Hengyan
 *
 */

/**
 * Helper function for Spell checker
 * @return None
 */
public class SpellCheckerHelpers {
	public SpellCheckerHelpers() {

	}
	
	/**
	 * Print Helper function
	 * @return whole string to be printed
	 */
	public String prettyPrint(HashMap<Integer, String> suggestedWords) {
		String retString = null;
		int i = 1;
		for(Integer key:suggestedWords.keySet()) {
//			System.out.println(i + ". " + suggestedWords.get(key));
			retString += Integer.toString(i) + ". " + suggestedWords.get(key) + "\n";
			i++;
		}

		return retString;
	}
	
	/**
	 * Get Similarity for two words
	 * @return Similarity for two words
	 */
	public double getSimilarityMetric(String word1, String word2) {
		// given two words, this function computes two measures of similarity
		// and returns the average
		int l1 = word1.length();
		int l2 = word2.length();
		int lmin = Math.min(l1, l2);
		int leftSimilarity = 0;
		int rightSimilarity = 0;

		// calculate leftSimilarity
		for(int i = 0; i < lmin; i++) {
			if(word1.charAt(i) == word2.charAt(i)) {
				leftSimilarity += 1;
			}
		}

		// calculate rightSimilarity
		for(int j = 0; j < lmin; j++) {
			if(word1.charAt(l1-j-1) == word2.charAt(l2-j-1)) {
				rightSimilarity += 1;
			}
		}
		return (leftSimilarity + rightSimilarity)/2.0;
	}
	
	/**
	 * Get commonPercent for two words
	 * @return commonPercent for two words
	 */
	public double getcommonPercent(String word1, String word2){
		// Numerator = letters in common
		// Denominator = all the letters
		// Common percent = Numerator/Denominator
		int Numerator = 0;
		double Denominator = 0.0;
		double commonPercent = 0.0;

		ArrayList<Character> myNset = new ArrayList<Character>();
		myNset = getNumeratorset(word1, word2);
		Numerator = myNset.size();

		ArrayList<Character> myDset = new ArrayList<Character>();
		myDset = getDenominatorset(word1, word2);
		Denominator = myDset.size();

		// calculate Numerator and Denominator
		commonPercent = Numerator/Denominator;

		return commonPercent;
	}
	
	/**
	 * Get Numerator for two words
	 * @return Numerator for two words
	 */
	public ArrayList<Character> getNumeratorset(String word1, String word2) {
		ArrayList<Character> myNumeratorset = new ArrayList<Character>();
		ArrayList<Character> myS1set = new ArrayList<Character>();
		ArrayList<Character> myS2set = new ArrayList<Character>();

		for(int i = 0; i < word1.length(); i++) {
			if(!myS1set.contains(word1.charAt(i))) {
				myS1set.add(word1.charAt(i));
			}
		}

		for(int i = 0; i < word2.length(); i++) {
			if(!myS2set.contains(word2.charAt(i))) {
				myS2set.add(word2.charAt(i));
			}
		}

		if(myS1set.size() < myS2set.size()) {
			for(Character item:myS1set) {
				if(myS2set.contains(item)) {
					myNumeratorset.add(item);
				}
			}
		} else {
			for(Character item:myS2set) {
				if(myS1set.contains(item)) {
					myNumeratorset.add(item);
				}
			}
		}
		return myNumeratorset;
	}
	
	/**
	 * Get Denominator for two words
	 * @return Denominator for two words
	 */
	public ArrayList<Character> getDenominatorset(String word1, String word2) {
		ArrayList<Character> myDenominatorset = new ArrayList<Character>();
		ArrayList<Character> myS1set = new ArrayList<Character>();
		ArrayList<Character> myS2set = new ArrayList<Character>();

		for(int i = 0; i < word1.length(); i++) {
			if(!myS1set.contains(word1.charAt(i))) {
				myS1set.add(word1.charAt(i));
			}
		}

		for(int i = 0; i < word2.length(); i++) {
			if(!myS2set.contains(word2.charAt(i))) {
				myS2set.add(word2.charAt(i));
			}
		}

		// Denominatorset have all the letters in word1 and word2 without repeat
		if(myS1set.size() < myS2set.size()) {
			myDenominatorset = myS2set;
			for(Character item:myS1set) {
				if(!myS2set.contains(item)) {
					myDenominatorset.add(item);
				}
			}
		} else {
			myDenominatorset = myS1set;
			for(Character item:myS2set) {
				if(!myS1set.contains(item)) {
					myDenominatorset.add(item);
				}
			}
		}
		return myDenominatorset;
	}
}
