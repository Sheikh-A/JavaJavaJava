
public class printBoard {
	
	public String[][] board;
	public String[] discard;
	public printBoard(String[][] board,String[] discard) {
		this.board = board;
		this.discard = discard;
		
	}
	
	//this method prints the board provided. 
	//checks to see if it is blank, or if it has a card, and prints respective value.
	
	public static void printCompleteBoard(String[][] board, String[] discard) {
		int boardCount=1;
		System.out.println("Board");
		System.out.println();
		for(int i=0; i<4; i++) {
			for(int j=0; j<5;j++) {
				if(board[j][i] == "||" ) {
					System.out.print("     ");
					
					continue;
				}else if(board[j][i] != " ") {
					System.out.print(board[j][i]+"    ");
					boardCount++;
				}else {
					System.out.print(boardCount+"    ");
					boardCount++;
					
				}
				
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println("Discard Pile");
		for(int k=0; k<4; k++) {
			if(k==2) {
				System.out.println();
				
			}
			if(discard[k] != " ") {
				System.out.print(discard[k]+"    ");
				boardCount++;
			}else {
				System.out.print(boardCount+"    ");
				boardCount++;
			}

			}
				
		}
	//This method palces user inputted cards into board
	public static void setCardPlacement(int position, String card, String[][] board, String[] discard) {
		//this handles the discard pile
		if(position>=17&&position<=20) {
			for(int i =17; i<=20; i++) {
				
				if(i==position) {
					discard[i-17] = card;
				
				}
			}
			//this handles the board
		}else if(position>=1 && position<=16) {
			
			if(position<=5) {
				position = position-1;
				board[position][0] = card;
//				System.out.print(board[position][0]);

			}else if(position>5&&position<=10) {
				position = position-5-1;
				board[position][1] = card;
			}else if(position>10&&position<=13) {
				position = position-10+1-1;
				board[position][2] = card;
			}else if(position>13&&position<=16) {
				position = position-13+1-1;
				board[position][3] = card;
			}else {
				System.out.print("you have entered an invalid number");
			}
			
			
		}
		
	}
	//This checks to see if the board is full,and tallys up the score if it is
	public static boolean checkBoardFull(String[][] board) {
		int countNotEmpty=16;
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {

				if(board[j][i] == " ") {
					countNotEmpty -= 1;
					
				}
			}
			
		}
		if(countNotEmpty == 16) {
			return false;
			
		}
			return true;
		
		
	}
	//This Determines the Score, and uses the three methods below it to calculate 
	public static int ScoreCalc(String[][] board, String[] originalDeckArray, int[] A1, int[] A11) {
		//sets temp variables
		int score=0;
		String cardVal;
		int tempScore1=0;
		int tempScore2=0;
		//caluclates score from board
		for(int i = 0; i<5; i++) {
			//for first and last columns only
			if(i==0 || i==5) {
				
				for(int j=0; j<2; j++) {
					cardVal = board[i][j];
					tempScore1 += searchCardVal(originalDeckArray, cardVal, A1);
					tempScore2 += searchCardVal(originalDeckArray, cardVal, A11);
					
				}
				score += ScoreTwoCards(tempScore1, tempScore2);
				tempScore1 = tempScore2 =0;
			//for middle columns
			}else {
				for(int j=0; j<4; j++) {
					cardVal = board[i][j];
					tempScore1 += searchCardVal(originalDeckArray, cardVal, A1);
					tempScore2 += searchCardVal(originalDeckArray, cardVal, A11);
					
				}
				score += ScoreMoreThanTwoCards(tempScore1, tempScore2);
				tempScore1 = tempScore2 =0;
			}
		}
		
		for(int i = 0; i<4; i++) {
			
			//for first two rows
			if(i<=1) {
				for(int j =0; j<5; j++) {
					cardVal = board[j][i];
					tempScore1 += searchCardVal(originalDeckArray, cardVal, A1);
					tempScore2 += searchCardVal(originalDeckArray, cardVal, A1);
				}
				score += ScoreMoreThanTwoCards(tempScore1, tempScore2);
				tempScore1 = tempScore2 =0;
				
			//for first last three rows
			}if(i>1) {
				for(int j =1; j<4; j++) {
					cardVal = board[j][i];
					tempScore1 += searchCardVal(originalDeckArray, cardVal, A1);
					tempScore2 += searchCardVal(originalDeckArray, cardVal, A1);
				}
				score += ScoreMoreThanTwoCards(tempScore1, tempScore2);
				tempScore1 = tempScore2 =0;
				
			}
			
			
		}
		return score;
	}
	
	//search for the usersCard in the ordered Deckarray, and matches the facecard 
	//value by element index in score arrays
	public static int searchCardVal(String[] originalDeckArray, String cardVal, int[] A) {
		int cardScore = 0;
		for(int i=0; i<52; i++) {
			if(cardVal == originalDeckArray[i]) {
				cardScore = A[i];
			}	
		}
		return cardScore;
	}
	
	//This determines the score for the first and last column which contains two cards.
	public static int ScoreTwoCards(int tempscore1, int tempscore2) {
		int score = 0;
		if(tempscore1==21 || tempscore2 == 21) {
			score=10;
		}else {
			tempscore1 = ScoreLessThan21(tempscore1);
			tempscore2 = ScoreLessThan21(tempscore2);
			if(tempscore1 > tempscore2) {
				score = tempscore1;
			}else {
				score = tempscore2;
			}
		}
		return score;
	}
	
	//This determines the score for all other colums and rows other than the first and last column
	public static int ScoreMoreThanTwoCards(int tempscore1, int tempscore2) {
		
		int score = 0;
			tempscore1 = ScoreLessThan21(tempscore1);
			tempscore2 = ScoreLessThan21(tempscore2);
			if(tempscore1 > tempscore2) {
				score = tempscore1;
			}else {
				score = tempscore2;
			}
		return score;
	}
	
	
	//this determines the scoreing for more than two cards.
	public static int ScoreLessThan21(int tempscore) {
		int score = 0;
		if(tempscore ==21) {
			score=7;
		}else if(tempscore==20) {
			score = 5;
		}else if(tempscore==19) {
			score = 4;
		}else if(tempscore==18) {
			score=3;
		}else if(tempscore==17) {
			score = 2;
		}else if(tempscore<=16) {
			score=1;
		}else {
			score = 0;
		}
	return score;		
	}
	
	
	}