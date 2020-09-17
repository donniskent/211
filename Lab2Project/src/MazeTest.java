import static org.junit.Assert.*;

import org.junit.Test;

public class MazeTest {

	



	@Test 
	public void testConstructor() {
		Maze maze = new Maze(5,6); 
		if(maze.getWidth() != 6) {
			fail("Expected width to be 6. Got " + maze.getWidth());
		}
		if(maze.getHeight() != 5) {
			fail("Expected width to be 5. Got " + maze.getHeight());
		}
	}

	@Test 
	public void setTest() {
		Maze maze = new Maze(8,9);
		maze.set('#', 3 , 5 );
		if(maze.get(3, 5) != '#') {
			fail("Expected maze spot (3,5) to equal #, got " + maze.get(3, 5)); 
		}
		
	}
	@Test 
	public void moveNorthTest() {
		
	}



}
