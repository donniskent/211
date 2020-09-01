import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsolaBoardTest {

	@Test
	void testIsolaBoardConstructor() {
		IsolaBoard board = new IsolaBoard();
		if (board.getHeight() != 7 && board.getWidth() != 7) {
			fail("Expected height to be 7 got " + board.getHeight() + ". Expected width to be 7 got "
					+ board.getWidth());
		}
		IsolaBoard newBoard = new IsolaBoard(8, 8);
		newBoard.getHeight();
		newBoard.getWidth();
		if (newBoard.getHeight() != 8 && newBoard.getWidth() != 8) {
			fail("Expected height to be 8 got " + newBoard.getHeight() + ". Expected width to be 8 got "
					+ newBoard.getWidth());

		}
	}

	@Test
	void getTest() {

		IsolaBoard board = new IsolaBoard();
		board.get(0, 3);
		if (board.get(0, 3) != BoardSpace.Player1) {
			fail("Expected space to contain Player1, it contained " + board.get(0, 3));
		}
		if (board.get(6, 3) != BoardSpace.Player2) {
			fail("Expected space to contain Player2, it contained " + board.get(6, 3));

		}
		if (board.get(4, 3) != BoardSpace.Available) {
			fail("Expected space to be availible, it contained " + board.get(4, 3));

		}
	}

	@Test
	void movePlayerTest() {
		IsolaBoard board = new IsolaBoard();
		BoardSpace firstPlayer = BoardSpace.Player1;
		BoardPosition newPosition = new BoardPosition(1, 3);
		if (board.movePlayer(BoardSpace.Player1, newPosition) == false) {
			fail("Expected true, got " + board.movePlayer(BoardSpace.Player1, newPosition));
		}

		BoardSpace secondPlayer = BoardSpace.Player2;
		newPosition = new BoardPosition(4, 4);
		if (board.movePlayer(BoardSpace.Player2, newPosition) == true) {
			fail("Expected false, newPosition should be > 1 space away. Got "
					+ board.movePlayer(BoardSpace.Player2, newPosition));
		}

		newPosition = new BoardPosition(7, 3);
		if (board.movePlayer(BoardSpace.Player2, newPosition) == true) {
			fail("Expected false, newPosition is outside the bounds of the board. Got "
					+ board.movePlayer(BoardSpace.Player2, newPosition));

		}
		BoardSpace nonPlayer = BoardSpace.Available;
		if (board.movePlayer(nonPlayer, newPosition) == true) {
			fail("Expected false, tried to move an invalid player. Got " + board.movePlayer(nonPlayer, newPosition));

		}

		board.movePlayer(firstPlayer, new BoardPosition(2, 3));
		board.movePlayer(firstPlayer, new BoardPosition(3, 3));
		board.movePlayer(secondPlayer, new BoardPosition(5, 3));
		board.movePlayer(secondPlayer, new BoardPosition(4, 3));
		if (board.movePlayer(secondPlayer, new BoardPosition(3, 3)) == true) {
			fail("Spot should not be availible, expected false, got"
					+ board.movePlayer(secondPlayer, new BoardPosition(3, 3)));
		}

	}

	@Test
	void checkWinnerTest() {
		IsolaBoard board = new IsolaBoard();
		BoardSpace firstPlayer = BoardSpace.Player1;
		BoardSpace secondPlayer = BoardSpace.Player2;
		board.movePlayer(firstPlayer, new BoardPosition(1, 3));
		board.movePlayer(firstPlayer, new BoardPosition(1, 4));
		board.movePlayer(firstPlayer, new BoardPosition(1, 5));
		board.movePlayer(firstPlayer, new BoardPosition(1, 6));
		board.movePlayer(firstPlayer, new BoardPosition(0, 6));
		board.movePlayer(firstPlayer, new BoardPosition(0, 5));
		board.movePlayer(firstPlayer, new BoardPosition(0, 4));
		if (board.checkWinner() != secondPlayer) {
			fail("Player1 cant move, expected Player2 to return, got" + board.checkWinner());
		}
		IsolaBoard board2 = new IsolaBoard();

		board2.movePlayer(secondPlayer, new BoardPosition(5, 3));
		board2.movePlayer(secondPlayer, new BoardPosition(5, 2));
		board2.movePlayer(secondPlayer, new BoardPosition(5, 1));
		board2.movePlayer(secondPlayer, new BoardPosition(5, 0));
		board2.movePlayer(secondPlayer, new BoardPosition(6, 0));
		board2.movePlayer(secondPlayer, new BoardPosition(6, 1));
		board2.movePlayer(secondPlayer, new BoardPosition(6, 2));
		if (board2.checkWinner() != firstPlayer) {
			fail("Player2 cant move, expected Player1 to return, got" + board2.checkWinner());
		}
		IsolaBoard board3 = new IsolaBoard();

		if (board3.checkWinner() != BoardSpace.Available) {
			fail("Both players can move. Should return Available," + " got " + board3.checkWinner());
		}
		IsolaBoard board4 = new IsolaBoard();
		board4.movePlayer(secondPlayer, new BoardPosition(5, 3));
		board4.movePlayer(secondPlayer, new BoardPosition(5, 2));
		board4.movePlayer(secondPlayer, new BoardPosition(5, 1));
		board4.movePlayer(secondPlayer, new BoardPosition(5, 0));
		board4.movePlayer(secondPlayer, new BoardPosition(6, 0));
		board4.movePlayer(secondPlayer, new BoardPosition(6, 1));
		board4.movePlayer(secondPlayer, new BoardPosition(6, 2));
		board4.movePlayer(firstPlayer, new BoardPosition(1, 3));
		board4.movePlayer(firstPlayer, new BoardPosition(1, 4));
		board4.movePlayer(firstPlayer, new BoardPosition(1, 5));
		board4.movePlayer(firstPlayer, new BoardPosition(1, 6));
		board4.movePlayer(firstPlayer, new BoardPosition(0, 6));
		board4.movePlayer(firstPlayer, new BoardPosition(0, 5));
		board4.movePlayer(firstPlayer, new BoardPosition(0, 4));
		if (board4.checkWinner() != firstPlayer) {
			fail("Last player to move was first Player, therefore they should have won, should return Player1"
					+ " got " + board4.checkWinner());

		}

	}

}
