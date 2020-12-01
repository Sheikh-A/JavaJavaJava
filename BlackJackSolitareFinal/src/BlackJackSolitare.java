
import java.util.Scanner;
import java.util.*;

public class BlackJackSolitare {
	public String[][] board;
	public String[] discard;
	public int cardcount;
	
	//constructor to set up board
	public BlackJackSolitare(){
		this.board = new String[][] {{" "," ","||","||"},{" "," "," "," "},{" "," "," "," "},{" "," "," "," "},{" "," ","||","||"}};
		this.discard = new String[] {" "," "," "," "};
		this.cardcount = 0;

		
	}
	
//main method for playing game	
	public void play() {
		//intializes variables
		int score = 0;
		List<Integer> BoardFill = new ArrayList<Integer>();
		String newCard = "  ";
		int position=0;
		Deck newDeck = new Deck();
		Card playerCard = new Card();
		
		System.out.print("Welcome to BlackJack Solitaire");
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		
		//prints the board and obtains user input until all spots are full board
		while(printBoard.checkBoardFull(this.board)) {
			
			//sets up variables and board
			printBoard.printCompleteBoard(this.board, this.discard);
			System.out.println();
			System.out.print("Please select a position of the card:  ");
			
			//gets new card from getCard method
			newCard = playerCard.getCard(newDeck.getDeck(), playerCard.getCardPosition());
			System.out.println(newCard);

			//position input from user
			position = userInput.nextInt();
			
			//checks to see if user used that spot already
			while(BoardFill.contains(position)) {
				System.out.println("You cannot replace a card, try again");
				position = userInput.nextInt();
			}
			
			//adds used position to arraylist
			BoardFill.add(position);
			//sets card placement on board
			printBoard.setCardPlacement(position, newCard, board, discard);

			//keeps track of card counts
			this.cardcount++;
		
		}
		
		userInput.close();
		
		score = printBoard.ScoreCalc(board, newDeck.deckArray, newDeck.pointsA1, newDeck.pointsA11);
		System.out.println();
		System.out.println("Your Score is:" + score);
	}
	
	
	
	
	
}