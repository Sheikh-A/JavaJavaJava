import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Cindy/Ali/Hengyan
 *
 */
public class getDictwords {
	public getDictwords() {
		
	}
	/**
	 * get all the words in dictionary for faster access later
	 * @return HashMap of dictionary words
	 */
	public HashMap<Integer, String> getDictwords(String filename){
		// generate the ArrayList of all the words in engDictionary
		HashMap<Integer, String> dictWords = new HashMap<Integer, String>();
		//File dict_f  = new File("engDictionary.txt");
		File dict_f  = new File(filename);
		Scanner dict_s;
		int index = 0;
		try {
			dict_s = new Scanner(dict_f);
			while(dict_s.hasNext()) {
				String word = dict_s.next();
				dictWords.put(index, word);
				index += 1;
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return dictWords;
	}
}
