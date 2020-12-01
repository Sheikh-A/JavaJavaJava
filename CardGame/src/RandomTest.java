import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomTest {
	
	

	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		String[] friends = new String[5];
		
		for(int i =0; i < friends.length; i++) {
			friends[i] = "Abcdefghisdes";
		}
		
		for(String s : friends) {
			System.out.println(s);
			
		}
		
		System.out.println(Arrays.toString(friends));
		
		boolean[] rows = new boolean[friends.length];
		
		for(int i = 0; i < friends.length; i++) {
			if(friends[i].toCharArray().length > 10) {
				rows[i] = true;
			} else {
				rows[i] = false;
			}
		}
		
		System.out.println(Arrays.toString(rows));
		
		
		ArrayList<String> testFriend = new ArrayList<String>();
		
		testFriend.add("Alaidfjaksdjfalkdf");
		testFriend.add("Allkdf");
		testFriend.add("Aladjfalkdf");
		testFriend.add("Alaidfjkdf");
		
		
		
		
		for(int i =0; i < testFriend.size(); i++) {
			System.out.println(testFriend.get(i).length());
		}
		
		
		//System.out.println(r.nextInt());
		

		
		
	}
	
}
