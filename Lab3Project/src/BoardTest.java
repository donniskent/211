import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BoardTest {

	@Test
	public void BoardTest() {
		Board newBoard = new Board();
		if(newBoard.getHeight() != 7) {
			fail("Expected board height to be 7, got" + newBoard.getHeight());
		}
		if(newBoard.getWidth() != 7) {
			fail("Expected board width to be 7, got" + newBoard.getWidth());
		}
		
	}
		@Test
	public void getListTest() {
		Board newBoard = new Board();
		List<BoardSpace> red = new ArrayList<BoardSpace>();
		red.add(BoardSpace.Red);
		List<BoardSpace> black = new ArrayList<BoardSpace>();
		black.add(BoardSpace.Black);
		List<BoardSpace> availible = new ArrayList<BoardSpace>();
		availible.add(BoardSpace.Available);
		
		
		if(!newBoard.getList(0, 0).equals(red) ) {
			fail("Expected spot to contain Red, got" + newBoard.getList(0, 0));
		}
		if(!newBoard.getList(0, 1).equals(availible) ) {
			fail("Expected spot to contain Availible, got" + newBoard.getList(0, 1));
		}
		if(!newBoard.getList(6, 0).equals(black) ) {
			fail("Expected spot to contain black, got" + newBoard.getList(6, 0));
		}
		
		}
		
		
		
		@Test 
		public void movePlayerTest() {
			Board board = new Board();
			
			if (board.movePlayer(20, 19, 69, 420, BoardSpace.Red) != false) {
				fail("Expected false, positions were out of bounds.");
				
			}
			if (board.movePlayer(2, 0, 3, 1, BoardSpace.Black) != false) {
				fail("Expected false,space contains a red player, not a black ");
				
			}
		
			if (board.movePlayer(0, 0, 1, 1, BoardSpace.Red) != false) {
				fail("Expected false, end coordinate is taken. ");
				
			}
			if (board.movePlayer(0, 0, 1, 2, BoardSpace.Red) != false) {
				fail("Expected false, end coordinate is more than 1 spot away ");
				
			}
			board.movePlayer(2, 0, 3, 1, BoardSpace.Red);
			if(board.movePlayer(4, 2, 2, 0, BoardSpace.Black) != true) {
				fail("Expected true, this was a valid jump by Black from (4,2) to (2,0)");
			}
		

			if(board.movePlayer(2,4,4,2, BoardSpace.Red) != false) {
				fail("Expected false, no player to jump, therfore shouldnt move 2 spots.");
			}
			// need to test a jump move up right, up left, down right, down left. 
			Board board2 = new Board();
			//tests jump left up and right down
			board2.movePlayer(2, 0, 3, 1, BoardSpace.Red);
			if(board2.movePlayer(4, 2, 2, 0, BoardSpace.Black) != true) {
				fail("Expected true, should have been valid jump move in the north west direction");
			}
			board2.movePlayer(2, 2, 3, 1, BoardSpace.Red);
			if(board2.movePlayer(2, 0, 4, 2, BoardSpace.Black) != true) {
				fail("Expected true, should have been valid jump move in the south east direction");
			}
			
			
			Board board3 = new Board();
			board3.movePlayer(2, 6, 3, 5, BoardSpace.Red);
			if(board3.movePlayer(4, 4, 2, 6, BoardSpace.Black) != true) {
				fail("Expected true, should have been valid jump move in the North East direction");
			}
			
			
			
			
			board3.movePlayer(2, 4, 3, 5, BoardSpace.Red);
			if(board3.movePlayer(2, 6, 4, 4, BoardSpace.Black) != true) {
				fail("Expected true, should have been valid jump move in the South West direction");
			}
			
			
		
		
		
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
	









}
