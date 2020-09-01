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
		TwoPlayerController control = new TwoPlayerController(); 
		
		IsolaBoard replayBoard = new IsolaBoard();
		IsolaTextView replayView = new IsolaTextView(replayBoard);

		
		int counter = 0;
		ArrayList<String> moves = readMovesIn();
		System.out.println(" Isola Game Replay ");
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

				row = control.moveNorth(row);

			} else if (input.equals("S")) {

				row = control.moveSouth(row);

			} else if (input.equals("E")) {

				col = control.moveEast(col);

			} else if (input.equals("W")) {

				col = control.moveWest(col);

			} else if (input.equals("NE")) {

				row = control.moveNorth(row);
				col = control.moveEast(col);

			} else if (input.equals("NW")) {

				row = control.moveNorth(row);
				col = control.moveWest(col);

			} else if (input.equals("SE")) {

				row = control.moveSouth(row);
				col = control.moveEast(col);

			} else if (input.equals("SW")) {

				row = control.moveSouth(row);
				col = control.moveWest(col);

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
			
		} // for
		replayView.display();
		System.out.println("End of game");
		if(moves.size() % 2 == 0) {
			System.out.println("Player 1 wins");
		} else {
			System.out.println("Player 2 wins");
		}
	
	} // go

	

	public ArrayList<String> readMovesIn() {
		File file = new File("game.dat");
		Scanner input;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {

			System.out.println("game.dat not found");
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

	

	

}