import java.util.Scanner;

public class TwoPlayerController {
	public static void main (String [] args) {
		TwoPlayerController control = new TwoPlayerController(); 
		control.go();
	}


public void go() {
	// make a board 
	Board board = new Board(); 
	BoardTextView view = new BoardTextView(board); 
	System.out.println(board.getHeight());
	System.out.println(board.getWidth());

	view.display();
	
	// make a view 
	
	// while (game on) {
	// ask player to pick a piece to move (r,c)
	
	
	
	
	
	System.out.println("Red, enter coordinate of piece you want to move and coordinate of new position.");
	
	Scanner scan = new Scanner(System.in); 
	while(true) {
	System.out.println("Red, enter coordinate of piece you want to move and coordinate of new position.");

	int currentRow = scan.nextInt();
	int currentCol = scan.nextInt();
	int endRow = scan.nextInt();
	int endCol = scan.nextInt();
	boolean moved; 
	

		 moved = board.movePlayer(currentRow, currentCol, endRow, endCol, BoardSpace.Red);
	
	
	
	
	if(moved == false) {
		System.out.println("Invalid move. Please enter a valid move.");
		
	}
	view.display();
	// ask player for move as coordinates 
	
	
	// move player 
	// update stack 
	// check winner 
	// switch player
	// }
	// say winner/loser
	
	}
}



}
