import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Cindy/Ali/Hengyan
 *
 */
public class WordRecommender {
	// has a dictionary of words
	// which is engDictionary.txt in this assignment
	String filename;

	public WordRecommender(String fileName) {
		this.filename = fileName;
	}

	/**
	 * get suggested words list for the misspelled word
	 * @return ArrayList of suggested words 
	 */
	public HashMap<Integer, String> getWordSuggestions(String word, int n, double commonPercent, int topN) {
		SpellCheckerHelpers mySpellCheckerHelpers = new SpellCheckerHelpers();
		getDictwords mygetDictwords = new getDictwords();
		HashMap<Integer, String> recommwordlist = new HashMap<Integer, String>();
		ArrayList<String> possiblewordlist = new ArrayList<String>();
		HashMap<Integer, String> dictWords_new = new HashMap<Integer, String>();
		double mycommonPercent = 0.0;

		// get all words in dictionary
		dictWords_new = mygetDictwords.getDictwords(filename);

		int wlen = word.length();

		// list of candidate words two criteria:
		// 1. candidate word length is ​word​ length +/- ​n​ characters
		// 2. have at least commonPercent% of the letters in common
		for(int i = 0; i < dictWords_new.size(); i++) {
			mycommonPercent = mySpellCheckerHelpers.getcommonPercent(word, dictWords_new.get(i));
			if(Math.abs(dictWords_new.get(i).length() - wlen) <= n && mycommonPercent >= commonPercent) {
				possiblewordlist.add(dictWords_new.get(i));
			}
		}

		double similarityMax = 0.0;
		double similarityCurrent = 0.0;

		int count = 0;
		String maxSimilarityWord = null;
		int maxSimilarityWord_index = 0;
		while(count <= topN && possiblewordlist.size() > 0) {
			similarityMax = mySpellCheckerHelpers.getSimilarityMetric(word, possiblewordlist.get(0));
			maxSimilarityWord = possiblewordlist.get(0);
			maxSimilarityWord_index = 0;
			for(int i = 1; i < possiblewordlist.size(); i++) {
				similarityCurrent = mySpellCheckerHelpers.getSimilarityMetric(word, possiblewordlist.get(i));
				if(similarityCurrent > similarityMax) {
					similarityMax = similarityCurrent;
					maxSimilarityWord = possiblewordlist.get(i);
					maxSimilarityWord_index = i;
				}
			}
			// after the for loop we found the maxSimilarityWord
			recommwordlist.put(count, maxSimilarityWord);
			possiblewordlist.remove(maxSimilarityWord_index);
			count++;
		}

		return recommwordlist;
	}
}
