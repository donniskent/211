import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoPlayerControllerTest {

	@Test
	void goTest() {
		TwoPlayerController controller = new TwoPlayerController(); 
		IsolaBoard board = new IsolaBoard();
		IsolaTextView view = new IsolaTextView(board);
		int counter = 0;
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	void moveNorthTest() {
		TwoPlayerController controller = new TwoPlayerController();
		if (controller.moveNorth(3) != 2) {
			fail("Expected 4 got" + controller.moveNorth(3));
		}

	}

	void moveSouthTest() {
		TwoPlayerController controller = new TwoPlayerController();

		if (controller.moveSouth(3) != 4) {
			fail("Expected 2 got" + controller.moveSouth(3));

		}

	}

	void moveEastTest() {
		TwoPlayerController controller = new TwoPlayerController();
		if (controller.moveEast(3) != 4) {
			fail("Expected 4 got" + controller.moveEast(3));
		}

	}

	void moveWestTest() {
		TwoPlayerController controller = new TwoPlayerController();
		if (controller.moveWest(3) != 2) {
			fail("Expected 2 got" + controller.moveNorth(3));
		}

	}

	@Test
	void checkGameOverTest() {
		IsolaBoard board = new IsolaBoard();

		TwoPlayerController controller = new TwoPlayerController();
		IsolaTextView view = new IsolaTextView(board);
		BoardSpace over = board.checkWinner();

		if (controller.checkGameOver(over, view) != true) {
			fail("Expected true return, game is not over yet. Got" + controller.checkGameOver(over, view));
		}
		IsolaBoard board2 = new IsolaBoard();

		TwoPlayerController controller2 = new TwoPlayerController();
		IsolaTextView view2 = new IsolaTextView(board2);

		BoardSpace firstPlayer2 = BoardSpace.Player1;
		BoardSpace secondPlayer2 = BoardSpace.Player2;
		board2.movePlayer(firstPlayer2, new BoardPosition(1, 3));
		board2.movePlayer(secondPlayer2, new BoardPosition(5, 4));
		board2.movePlayer(firstPlayer2, new BoardPosition(1, 4));
		board2.movePlayer(secondPlayer2, new BoardPosition(4, 4));
		board2.movePlayer(firstPlayer2, new BoardPosition(1, 5));
		board2.movePlayer(secondPlayer2, new BoardPosition(3, 4));
		board2.movePlayer(firstPlayer2, new BoardPosition(1, 6));
		board2.movePlayer(secondPlayer2, new BoardPosition(3, 5));
		board2.movePlayer(firstPlayer2, new BoardPosition(0, 6));
		board2.movePlayer(secondPlayer2, new BoardPosition(3, 6));
		board2.movePlayer(firstPlayer2, new BoardPosition(0, 5));
		board2.movePlayer(secondPlayer2, new BoardPosition(4, 6));
		board2.movePlayer(firstPlayer2, new BoardPosition(0, 4));
		BoardSpace over2 = board2.checkWinner();
		if (controller2.checkGameOver(over2, view2) != false) {
			fail("1 Expected game to be over with a return of false, got " + controller2.checkGameOver(over2, view2));

		}

		IsolaBoard board3 = new IsolaBoard();

		TwoPlayerController controller3 = new TwoPlayerController();
		IsolaTextView view3 = new IsolaTextView(board3);
		BoardSpace secondPlayer3 = BoardSpace.Player2;

		board3.movePlayer(secondPlayer3, new BoardPosition(5, 3));
		board3.movePlayer(secondPlayer3, new BoardPosition(5, 4));
		board3.movePlayer(secondPlayer3, new BoardPosition(5, 5));
		board3.movePlayer(secondPlayer3, new BoardPosition(5, 6));
		board3.movePlayer(secondPlayer3, new BoardPosition(6, 6));
		board3.movePlayer(secondPlayer3, new BoardPosition(6, 5));
		board3.movePlayer(secondPlayer3, new BoardPosition(6, 4));
		BoardSpace over3 = board3.checkWinner();
		if (controller3.checkGameOver(over3, view3) != false) {
			fail("Expected game to be over with a return of false, got " + controller3.checkGameOver(over3, view3));

		}

	}

	

}
