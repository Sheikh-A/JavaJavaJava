import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryData {
	
	private ArrayList<Country> countries = new ArrayList<Country>();
	
	
	private String findSubstring(String str, String c) {
		int index1 = str.indexOf(c); // find the first instance
		String remaining = str.substring(index1+1);
		String remainingFinal = remaining.substring(0, remaining.indexOf(c));
		return remainingFinal;
	}
	
	
	public long computeTotalPop() {
		long total = 0;
		for(Country country : countries) {
			total += country.getPopulation();
		}
		return total;
	}
	
	public CountryData(String countryDataFileName) {
		File f = new File(countryDataFileName);
		Scanner scanner;
		
		try {
			scanner = new Scanner(f);
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				System.out.println(row);
				
				String countryName = findSubstring(row, ",");
				String pop = findSubstring(row, "\"");
				pop = pop.replace(",", ""); // replace 1,000,000 with 1000000;
				
				
				Country country = new Country(countryName, Integer.parseInt(pop));
				countries.add(country);
				
				
			}
			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CountryData cd = new CountryData("population.csv");
		long totalPop = cd.computeTotalPop();
		long indoChina = (long)cd.countries.get(0).getPopulation() + (long)cd.countries.get(1).getPopulation();
		System.out.println(indoChina);
		System.out.println(totalPop);
		System.out.println(indoChina * 1.0 / totalPop);
 		
		
	}
	
	
	

}
