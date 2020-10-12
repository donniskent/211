import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;



public class TwoPlayerControllerTest {

	@Test
	public void checkGameOverTest() {
		TwoPlayerController controller = new TwoPlayerController();
		Board board = new Board();
		if(controller.checkGameOver(board, BoardSpace.Red) != false) {
			fail("Game hasn't even startes, didn't expect it to be over");
			
		}
		
		
			for(int i = 0; i < board.getHeight(); i++) {
				for(int j = 0; j < board.getWidth(); j++) {
				if(	board.getList(i, j).get(0) == BoardSpace.Red){
					board.getList(i, j).clear();
					board.getList(i, j).add(BoardSpace.Available);
				}
					
					
				}
				
			}
			if(controller.checkGameOver(board, BoardSpace.Red) != true) {
			fail("Expected for all red pieces to be off the board. Therefore game over");
			
		}
		
		
		
		
	}

	





}
