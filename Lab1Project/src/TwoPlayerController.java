import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoPlayerController {

	public static void main(String[] args) {
		TwoPlayerController controller = new TwoPlayerController();
		 controller.go();

	}

	public void go() {
		//create view
		IsolaBoard board = new IsolaBoard();
		IsolaTextView view = new IsolaTextView(board);
		
		
		
		int counter = 0;
		ArrayList<String> inputHold = new ArrayList<String>();
		System.out.println("-------Welcome to IsolaBoard-----------");
		 while (true) {
			
			BoardPosition player1 = board.findPosition(BoardSpace.Player1);
			BoardPosition player2 = board.findPosition(BoardSpace.Player2);
			BoardSpace currentPlayer;
			BoardPosition currentPosition;
			if (counter % 2 == 0) {
				currentPosition = player1;
				currentPlayer = BoardSpace.Player1;

			} else {
				currentPosition = player2;
				currentPlayer = BoardSpace.Player2;

			}
		   	System.out.println(currentPlayer + ("'s turn:"));
			view.display();
			int row = currentPosition.getRow();
			int col = currentPosition.getColumn();
			BoardPosition newPosition = null;

	 		Scanner scan = new Scanner(System.in);
			String input = scan.next();
			// ask player for move with scanner
			// store input in string "input"

			if (counter % 2 == 0) {
				currentPosition = player1;
				currentPlayer = BoardSpace.Player1;
			} else {
				currentPosition = player2;
				currentPlayer = BoardSpace.Player2;

			}

			if (input.equals("N")) {

				row = moveNorth(row);

			} else if (input.equals("S")) {

				row = moveSouth(row);

			} else if (input.equals("E")) {

				col = moveEast(col);

			} else if (input.equals("W")) {

				col = moveWest(col);

			} else if (input.equals("NE")) {

				row = moveNorth(row);
				col = moveEast(col);

			} else if (input.equals("NW")) {

				row = moveNorth(row);
				col = moveWest(col);

			} else if (input.equals("SE")) {

				row = moveSouth(row);
				col = moveEast(col);

			} else if (input.equals("SW")) {

				row = moveSouth(row);
				col = moveWest(col);

			} else {
				System.out.println("Please enter a vaild direction");
				continue;
			}
			newPosition = new BoardPosition(row, col);

			if (board.movePlayer(currentPlayer, newPosition) == false) {
				System.out.println("Invalid move. Try again");

				counter--;

			} else {

				board.movePlayer(currentPlayer, newPosition);
				inputHold.add(input);

			}

			counter++;

			BoardSpace over = board.checkWinner();
			boolean end = checkGameOver(over, view);
			if (!end) {
				break;
			}

			/*
			 * if (over == BoardSpace.Player1) { view.display();
			 * 
			 * System.out.println("Player1 wins!"); System.out.println(inputHold);
			 * 
			 * 
			 * game = false; } else if (over == BoardSpace.Player2) { view.display();
			 * 
			 * System.out.println("Player2 wins!"); System.out.println(inputHold);
			 * 
			 * 
			 * 
			 * game = false; } else if (over == BoardSpace.Available) { continue;
			 * 
			 * }
			 */

		} // loop
		
		writeFile(inputHold);
	} // go

	// display board
	// ask current player for move
	// write move to output.dat
	// make move
	// switch player }
	// display board
	// close output.dat

	public int moveNorth(int row) {

		int newRow = row - 1;

		return newRow;
	}

	public int moveSouth(int row) {

		int newRow = row + 1;

		return newRow;

	}

	public int moveEast(int col) {
		int newCol = col + 1;

		return newCol;

	}

	public int moveWest(int col) {
		int newCol = col - 1;

		return newCol;
	}

	public void writeFile(ArrayList<String> direction) {
		File newFile = new File("output.dat");
		PrintWriter writer;
		try {
			writer = new PrintWriter(newFile);
		} catch (FileNotFoundException e) {
			System.out.println("Could not open output.dat");
			return;
		}
		for (int i = 0; i < direction.size(); i++) {

			writer.println(direction.get(i));

		}
		writer.close();
	}

	public boolean checkGameOver(BoardSpace over, IsolaTextView view) {

		if (over == BoardSpace.Player1) {
			view.display();

			System.out.println("Player1 wins!");

			return false;
		} else if (over == BoardSpace.Player2) {
			view.display();

			System.out.println("Player2 wins!");

			 return false;

		}

		 return true;
	}
}
// check check