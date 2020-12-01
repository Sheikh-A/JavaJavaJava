import java.util.HashMap;

public class ExampleOne {

	
	public static void main(String[] args) {
		
		HashMap<String, Integer> myMap = new HashMap<>();
		
		myMap.put("ABC",25);
		myMap.put("DEF",50);
		myMap.put("SSS",25);
		myMap.put("AAA",75);
		myMap.put("DDD",100);
		myMap.put("RRR",150);
		myMap.put("QQQ",200);
		myMap.put("CCC",250);
		
		System.out.println(myMap);
		
		System.out.println(myMap.keySet());
		
		for (String str : myMap.keySet()) {
			System.out.println(str + ": " + myMap.get(str));
		}
		
		
		  
		
	}
}
