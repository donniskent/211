import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardPositionTest {

	@Test
	void BoardPositionConstructorTest() {
		BoardPosition position = new BoardPosition(3,6); 
		if(position.getColumn() != 6) {
		fail("Expected column to be 6 got " + position.getColumn()); 
		}
		
		if(position.getRow() != 3) {
			fail("Expected column to be 3 got " + position.getRow()); 
			}
	
	}
		@Test
		void toStringTest() {
			BoardPosition position = new BoardPosition(3,6);
			
		if(!position.toString().equals("BoardPosition [row=" + position.getRow() 
	+ ", column=" + position.getColumn() + "]")) {
		fail("Expected, BoardPosition [row = 3, column = 6 . Got " 
		+ "BoardPosition [row=" + position.getRow() + ", column=" + position.getColumn() + "]"); 
		
	}
		}
	
	



}
