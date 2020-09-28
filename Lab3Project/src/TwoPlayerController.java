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
	
	
	
	
	
	
	Scanner scan = new Scanner(System.in); 
	int counter = 0; 
	BoardSpace currentPlayer = BoardSpace.Red;
	while(true) {
		if(counter % 2 == 0) {
			currentPlayer = BoardSpace.Red;
				
			} 
			if(counter % 2 > 0) {
				currentPlayer = BoardSpace.Black;
			}
			System.out.println(currentPlayer + " move: ");
	int currentRow = scan.nextInt();
	int currentCol = scan.nextInt();
	int endRow = scan.nextInt();
	int endCol = scan.nextInt();
	boolean moved; 
	
	
	
	moved = board.movePlayer(currentRow, currentCol, endRow, endCol, currentPlayer);
	
	
	
	
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
}



}
