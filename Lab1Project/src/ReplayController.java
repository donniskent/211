import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReplayController {
	public static void main(String[] args) {
		ReplayController controller = new ReplayController();
		controller.go();
	}

	public void go() {

		
		IsolaBoard replayBoard = new IsolaBoard();
		IsolaTextView replayView = new IsolaTextView(replayBoard);

		
		int counter = 0;
		ArrayList<String> moves = readMovesIn();
		System.out.println(" Game Start ");
		BoardSpace currentPlayer = BoardSpace.Player1;
		BoardPosition currentPosition;
		replayView.display();
		System.out.println(" Board Start ");
		for (int i = 0; i < moves.size(); i++) {
			
			String input = moves.get(i);

			BoardPosition player1 = replayBoard.findPosition(BoardSpace.Player1);
			BoardPosition player2 = replayBoard.findPosition(BoardSpace.Player2);
			if (counter % 2 == 0) {
				currentPosition = player1;
				currentPlayer = BoardSpace.Player1;

			} else {
				currentPosition = player2;
				currentPlayer = BoardSpace.Player2;

			}
			

			int row = currentPosition.getRow();
			int col = currentPosition.getColumn();
			BoardPosition newPosition = null;

			

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

			}

			newPosition = new BoardPosition(row, col);

			replayBoard.movePlayer(currentPlayer, newPosition);
		
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
			
			
			System.out.println("                          ");
			
			replayView.display();
			counter++;
			System.out.println(currentPlayer + " moved " + input);
			
		} // while
		replayView.display();
		if(currentPlayer == BoardSpace.Player1)
		System.out.println("Game over. " + BoardSpace.Player2 + " wins");
		else {
			System.out.println("Game over. " + BoardSpace.Player1 + " wins");
		}
	
	} // go

	

	public ArrayList<String> readMovesIn() {
		File file = new File("output.dat");
		Scanner input;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {

			System.out.println("output.dat not found");
			return null;
		}
		ArrayList<String> allInputs = new ArrayList<String>();
		while (input.hasNext()) {
			allInputs.add(input.next());

		}

		System.out.println(allInputs);
		input.close();
		return allInputs;

	}

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