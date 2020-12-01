//Hungry Rabbit Assignment

public class Garden {
    //Set instance variables
    
    private final static int N = 4; // ROW Assumption for Matrix size from above (can also change to ((int)Math.random * 9 +1) to generate random matrix row)
    private final static int M = 5; // COL Assumption for Matrix size from above
    
    private int carrots; //variable to keep track of the carrot count
    private int RabbitX; //variable to keep track of X poisition in matrix[X][Y]
    private int RabbitY; //variable to keep track of Y poisition in matrix[X][Y]
    private int [][] matrix; //this is the garden matrix
    
    //Constructor for Class Garden
    public Garden() {
        matrix = new int[N][M];
        initialize(); //this is a helper function used to initialize the matrix
        carrots = 0;
    }
    
    /*Play function takes in a matrix and (1) Figures out where to place the rabbit (odd , even) (2) While loop
    //to continually run until shouldSleep = false; (3) Rabbit Choice comes from IntegerChoice function which finds the
    //square with the maximum carrot count
    */
    private int play(int[][] matrix) {
		
		placeRabbit(matrix);
		
		while(shouldSleep()) {
			
			
			int choice = IntegerChoice();
			if(choice == 2) {
				down();
				
			} else if (choice == 8) {
				up();
				
			} else if (choice == 4) {
				left();
				
			} else if (choice == 6) {
				right();
			}
//			displayMatrix(matrix);
//			System.out.println("***");
			
		}
		
		
		return getCarrots();
		
	}
    
    /*Step 1: We need to place the Rabbit in the matix, odd = middle of matrix, even = find max around the center
    */
    private void placeRabbit(int[][] matrix) {
        //Odd Case i.e. 5 X 5 = 25
        if(getRows() >= 3 && getColumns() >= 3 && getRows() % 2 != 0 && getColumns() % 2 != 0) {
            //Set rabbit at middle of grid
            RabbitX = getRows() / 2; // INTEGER 5 / 2 = 2 in row index starts at 0 this is the center for Rows
            RabbitY = getColumns() / 2;
            
            carrots += matrix[RabbitX][RabbitY]; //add the carrots at this position to the carrots count
            matrix[RabbitX][RabbitY] = 0; //set the value to 0 (so Rabbit will not double count)
            
        } else {
            //Even case - i.e. 3 X 4; 4 X 4; 4 X 3; we need to find the highest carrot count close to the center, I am assuming
            // max(center, top, down, left , right)
            
            int highestCarrotCount = -1;
            int highestRowIndex = -1;
            int highestColIndex = -1;
            
            //Center case
            highestRowIndex = getRows() / 2;
            highestColIndex = getColumns() / 2;
            RabbitX = highestRowIndex;
            RabbitY = highestColIndex;
            
            highestCarrotCount = matrix[RabbitX][RabbitY];
            
            //Test other cases around center
            //Case 1 - up, X coordinate
            if(highestRowIndex -1 != -1) { //Check out of bounds min
                if(matrix[highestRowIndex-1][highestColIndex] > highestCarrotCount) {
                    RabbitX = highestRowIndex-1;
                    highestCarrotCount = matrix[highestRowIndex+1][highestColIndex];
                }
            }
            
            //Case 2 - down; X coordinate
            if(highestRowIndex +1 != getRows()) { //Check out of bounds max
                if(matrix[highestRowIndex+1][highestColIndex] > highestCarrotCount) {
                    RabbitX = highestRowIndex+1;
                    highestCarrotCount = matrix[highestRowIndex+1][highestColIndex];
                }
            }
            
            //Case 3 //Y coordinate left
             if(highestColIndex -1 != -1) { //Check out of bounds min
                if(matrix[highestRowIndex][highestColIndex-1] > highestCarrotCount) {
                    RabbitY = highestColIndex-1;
                    highestCarrotCount = matrix[highestRowIndex][highestColIndex-1];
                }
            }
            //Case 4 //Y coordinate right
              if(highestColIndex +1 != getColumns()) { //Check out of bounds min
                if(matrix[highestRowIndex][highestColIndex+1] > highestCarrotCount) {
                    RabbitY = highestColIndex+1;
                    highestCarrotCount = matrix[highestRowIndex][highestColIndex+1];
                }
            }
            
            //Now max is established add to carrots and set square = 0
            
            carrots+= matrix[RabbitX][RabbitY];
            matrix[RabbitX][RabbitY] = 0;
        }
    }
    
    //Helper functions - Define the Rabbits moves; check if out of bounds, set coordinate in up,down,left,right, add carrots, set square to 0;
    
    private void up() {
        if(RabbitX - 1 != -1) {
            RabbitX = RabbitX -1;
            carrots += matrix[RabbitX][RabbitY];
            matrix[RabbitX][RabbitY] = 0;
        }
    }
    
    private void down() {
		if(RabbitX + 1 != getRows()) {
			RabbitX = RabbitX + 1;
			carrots += matrix[RabbitX][RabbitY];
			matrix[RabbitX][RabbitY] = 0;
		}
	}
	
	private void right() {
		if(RabbitY + 1 != getColumns()) {
			RabbitY = RabbitY + 1;
			carrots += matrix[RabbitX][RabbitY];
			matrix[RabbitX][RabbitY] =0;
		}
	}
	
	private void left() {
	    if(RabbitY -1 != -1) {
	        RabbitY = RabbitY +1;
	        carrots += matrix[RabbitX][RabbitY];
	        matrix[RabbitX][RabbitY] = 0;
	    }
	}
	
	/*IntegerChoice()
	//Rabbit choice to go up, down, left or right depending on highest carrot count, similar to PlaceRabbit function above
	//Depending on the highest carrot count, the function will return up (8), down (2), left (6) right (4)
	//number = direction choice
	*/
	
	private int IntegerChoice() {
		int number = -1;
		int highestRowIndex = -1;
		int highestColIndex = -1;
		int highestCarrotCount = -1;

		highestRowIndex = RabbitX;
		highestColIndex = RabbitY;
		
		if(highestRowIndex -1 != -1) {
			if(matrix[highestRowIndex-1][highestColIndex] > highestCarrotCount) {
				highestCarrotCount = matrix[highestRowIndex-1][highestColIndex];
				number = 8;
			}
		}
		
		if(highestRowIndex + 1 != getRows()) {
			if(matrix[highestRowIndex+1][highestColIndex] > highestCarrotCount) {
				highestCarrotCount = matrix[highestRowIndex+1][highestColIndex];
				number = 2;
			}
		}
		
		if(highestColIndex -1 != -1) {
			if(matrix[highestRowIndex][highestColIndex-1] > highestCarrotCount) {
				highestCarrotCount = matrix[highestRowIndex][highestColIndex-1];
				number = 4;
			}
		}
		if(highestColIndex +1 != getColumns()) {
			if(matrix[highestRowIndex][highestColIndex+1] > highestCarrotCount) {
				highestCarrotCount = matrix[highestRowIndex][highestColIndex+1];
				number = 6;
			}
		}
		
		return number;
	}
		
	/* shouldSleep() function used to keep running the game until this is set to false
	*/
	private boolean shouldSleep() {
		boolean check = true;
		
		if(RabbitX + 1 == getRows()) { //Out of bounds
			check = false;
		} else if (matrix[RabbitX+1][RabbitY] ==0) { //Square is 0 so rabbit cannot go here
			check = false;
			} else {
				return true;
			}
		
		
		if(RabbitX - 1 == -1) {
			check = false;
		} else if(matrix[RabbitX-1][RabbitY] == 0) {
			check = false;
			} else {
				return true;
		}
		
		if(RabbitY + 1 == getColumns()) {
			check = false;
		} else if(matrix[RabbitX][RabbitY+1] == 0) {
				check = false;
			} else {
				return true;
		}
		
		if(RabbitY - 1 == -1) {
			check = false;
		} else if(matrix[RabbitX][RabbitY-1] == 0) {
				check = false;
			} else {
				return true;
			
		}
		
		return check;
		
	}
	
	/* Iniitalize() - initializes the matrix with random values from 1 to 9, casting as int
	using a nested for loop
	*/
	private void initialize() {
	    int matrixNum = 0;
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[i].length; j++) {
	            matrixNum = (int) ((Math.random() * 9 + 1));
	            matrix[i][j] = matrixNum;
	        }
	    } 
	}
	
	//Display the matrix using nested for loop
	private void displayMatrix(int[][] matrix) {
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix.length; j++) {
	            System.out.print(matrix[i][j] +  " ");
	        }
	        System.out.println();
	    }
	}
	
	 //Generate Getters & Setter
    
    public static int getRows() {
        return N;
    }
    
    public static int getColumns() {
        return M;
    }
    
    public int getCarrots() {
        return carrots;
    }
    
    public int getRabbitX() {
        return RabbitX;
    }
    
    public int getRabbitY() {
        return RabbitY;
    }
    
    public int[][] getMatrix() {
        return matrix;
    }
	
	
	public static void main(String[] args) {
	    Garden garden = new Garden(); //initiatie the new class
	    
	    garden.displayMatrix(garden.getMatrix()); // display the initial matrix
	    garden.play(garden.getMatrix());
	    
	    int eatenCarrots = garden.getCarrots();
	    System.out.println(eatenCarrots); //Print out the number of carrots eaten
	    
	    
	}
	
    
    
    
    
}