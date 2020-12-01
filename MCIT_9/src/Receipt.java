import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Receipt {
	
	private ArrayList<String> receiptsAL = new ArrayList<String>();
	private String[] receiptsA = new String[25];
	private ArrayList<ReceiptItem> receiptsRI = new ArrayList<ReceiptItem>();
	
	
	public Receipt(String fileName) {
		
		if(fileName == null) {
			throw new IllegalArgumentException();
		}
		
		try {
			Scanner in = new Scanner(new FileReader(fileName));
			
			in.nextLine(); //SKIP FIRST LINE OF CSV
			
			int i = 0;
			
			while(in.hasNextLine()) {
				String line = in.nextLine();
				
				//Add ArrayList
				receiptsAL.add(line);
//				for(String rec : receiptsAL) {
//					System.out.println(rec);
//				}
				
				
				//Add to array
				receiptsA[i] = line;
				i++;
				
				//Add to ReceiptItem
				String[] lineSplit = line.split(",");
				double price = Double.parseDouble(lineSplit[2].substring(1, lineSplit[2].length()));
				
				int quantity = Integer.parseInt(lineSplit[3].substring(1,lineSplit[3].length()));
				
				ReceiptItem newRI = new ReceiptItem(lineSplit[0], lineSplit[1], price, quantity);
				receiptsRI.add(newRI);
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
		
	}


	public ArrayList<String> getReceiptsAL() {
		return receiptsAL;
	}


	public String[] getReceiptsA() {
		return receiptsA;
	}


	public ArrayList<ReceiptItem> getReceiptsRI() {
		return receiptsRI;
	}
	
	public HashMap<String, Double> getHowMuchSpent() {
		HashMap<String, Double> spent = new HashMap<String, Double>();
		
		for(ReceiptItem rI : receiptsRI) {
			String item = rI.getItem().toLowerCase();
			double amountSpent = rI.getPrice() * rI.getQuantity();
			
			if(spent.containsKey(item)) {
				double newAmountSpent = spent.get(item) + amountSpent;
				spent.put(item, newAmountSpent);
				
			} else {
				spent.put(item,amountSpent);
			}
			
		}
		return spent;
		
		
	}
	
	public String getLeastSpent() {
		HashMap <String, Double> spent = getHowMuchSpent();
		
		String minItem = "";
		double max = -1;
		int i = 0;
		
		for(String item:spent.keySet()) {
			if(spent.get(item) > max) {
				minItem = item;
				max = spent.get(item);
			}
		}
		return minItem;
	}

}
