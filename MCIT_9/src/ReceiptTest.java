import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;


public class ReceiptTest{
	private Receipt r = new Receipt("receipt.csv");
	private ArrayList<String> receiptExpectedResults = new ArrayList<String>();
	private ArrayList<String> receiptItemsExpected = new ArrayList<String>();
	private HashMap<String, Double> tMExpected = new HashMap<String, Double>();
	private final String itemMostSpent = "shoes";
	private final String itemLeastSpent = "pretzels";
	
	public ReceiptTest() {
		
	}
	
	


	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testReceiptsALConstructor() {
		ArrayList<String> a = r.getReceiptsAL();
		
		int i = 0;
		for(int i =0; i < a.size(); i++) {
			assertEquals(receiptExpectedResults.get(i), a.get(i));
			
		}
		
		}
	

}
