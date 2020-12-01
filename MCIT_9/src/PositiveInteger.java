import java.io.IOException;

public class PositiveInteger {

	int number;
	
	public PositiveInteger(int n) throws IOException{
		if(n <= 0) {
			throw new IOException("negative integer input");
		} else {
			number = n;
		}
		
	}
	
}
