import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsolaBoardTest {

	@Test
	void testIsolaBoardConstrcutor() {
		IsolaBoard board = new IsolaBoard(); 
		board.getHeight();
		board.getWidth();
		if(board.getHeight() != 7 && board.getWidth() != 7) {
			fail("Expected height to be 7 got " + board.getHeight() + 
				 ". Expected width to be 7 got " + board.getWidth());
		}
			IsolaBoard newBoard = new IsolaBoard(8, 8); 
			newBoard.getHeight();
			newBoard.getWidth();
			if(newBoard.getHeight() != 8 && newBoard.getWidth() != 8) {
				fail("Expected height to be 8 got " + newBoard.getHeight() + 
					 ". Expected width to be 8 got " + newBoard.getWidth());
		
		 
			}
}
	@Test 
	void getTest() {
		
		IsolaBoard board = new IsolaBoard();
		board.get(0, 3); 
		if(board.get(0, 3) != BoardSpace.Player1) {
			fail("Expected space to contain Player1, it contained " + board.get(0,3)); 
		}
		if(board.get(6, 3) != BoardSpace.Player2) {
			fail("Expected space to contain Player2, it contained " + board.get(6,3));
			
		}
		if(board.get(4, 3) != BoardSpace.Available) {
			fail("Expected space to be availible, it contained " + board.get(4,3));
		
		
		
	}
	} 
	
		@Test 
		void findPositionTest() {
			IsolaBoard board = new IsolaBoard(); 
			
			board.findPosition(BoardSpace.Player1); 
			board.findPosition(BoardSpace.Player2); 
			if(board.findPosition(BoardSpace.Player1) != new BoardPosition(0,3)) {
				fail("Expected player 1 to be at (0,3). Got " 
			+ board.findPosition(BoardSpace.Player1));
			}
		}





}
