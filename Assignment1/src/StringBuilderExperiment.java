
public class StringBuilderExperiment {

	
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("Ali");
		System.out.println(str);
		
		str.append("sheikh");
		str.append("ihsan");
		System.out.println(str);
		str.delete(3, str.length());
		System.out.println(str);
		
		str.setCharAt(1,'f');
		System.out.println(str);
		
		str.setCharAt(1,'l');
		System.out.println(str);
		
		StringBuilder str2 = new StringBuilder("apple");
		
		for(int i = str2.length() - 1; i >= 0; i--) {
			str2.append(str2.charAt(i));
		}
		System.out.println(str2);
		
	}
	
	
}
