import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoPlayerController {
	public static void main (String [] args) {
		TwoPlayerController control = new TwoPlayerController(); 
		control.go();
	}


public void go() {
	// make a board 
	Board board = new Board(); 
	// use strings to store whats on top and 
	BoardTextView view = new BoardTextView(board); 
	System.out.println(board.getHeight());
	System.out.println(board.getWidth());
	
	view.display();
	
	// make a view 
	
	// while (game on) {
	// ask player to pick a piece to move (r,c)
	
	
	
	
	
	
	Scanner scan = new Scanner(System.in); 
	int counter = 0; 
	BoardSpace currentPlayer = BoardSpace.Red;
	int currentRow = -1;
	int currentCol = -1 ;
	int endRow = -1; 
	int endCol = -1;
	boolean moved; 
	boolean gameOn = true;
	while(gameOn) {
		if(counter % 2 == 0) {
			currentPlayer = BoardSpace.Red;
				
			} 
			if(counter % 2 > 0) {
				currentPlayer = BoardSpace.Black;
			}
			//System.out.println(currentPlayer + " move: ");
	if(counter > 1) {
		boolean quit = checkQuit(currentPlayer, scan);
		if(quit == true) {
			System.out.println("Game over!");
			
			break; }
		checkPeek(board, currentPlayer, scan); 
		
		
		
		
	}
	
	
	
	System.out.println("Please enter your move " + currentPlayer + ":");
			
			
	
			
	try {
	currentRow = scan.nextInt();
	currentCol = scan.nextInt();
	endRow = scan.nextInt();
	endCol = scan.nextInt(); 
	moved = board.movePlayer(currentRow, currentCol, endRow, endCol, currentPlayer);
	}
	
	 
	catch(InputMismatchException e) {
		moved = false;
		scan.next(); // jumps scanner out of infinite loop 
	}
	
	

	
	
	
	
	
	
	
	
	if(moved == false) {
		System.out.println("Invalid move. Please enter a valid move.");
		counter-=1; 
	}
	view.display();
	counter+=1; 
	// ask player for move as coordinates 
	
	
	// move player 
	// update stack 
	// check winner 
	// switch player
	// }
	// say winner/loser
	
	}
	scan.close();
}
	public void checkPeek(Board board, BoardSpace currentPlayer, Scanner scan1) {
		
		
		System.out.println(currentPlayer + ", do you want to see a stack? (Y/N): ");
		String answer = scan1.next();
		
		if (answer.equals("Y")) {
			boolean b = true;
			
			while (b) {
				System.out.println("What is the location of the piece you want to peek at?");
			try {
				int peekRow = scan1.nextInt();
				int peekCol = scan1.nextInt();
				board.peek(peekRow, peekCol);
				 
				}
				
				 
				catch(InputMismatchException e) {
					System.out.println("Enter a valid coordinate");
					 checkPeek(board, currentPlayer, scan1);
					
				}
			
		}
			}
		
		else if (answer.equals("N")) {
			return; 
		}
		
		
		
		else {
			System.out.println("Invalid input. Please enter Y or N ");
			checkPeek(board, currentPlayer, scan1);
			
		}
		
		
	} 

	public boolean checkQuit(BoardSpace currentPlayer, Scanner scan2) {
		
		System.out.println(currentPlayer + ", do you want to quit? (Y/N)");
		String answer = scan2.next();
		if (answer.equals("Y")) {
			
			return true;
			
		}
		
		else if(answer.equals("N")) {
			
			return false;
		}
		
		
		else {
			System.out.println("Invalid input. Answer must be Y or N");
			checkQuit(currentPlayer, scan2);
		}
	
	return true;
	}
	
	
	
}
