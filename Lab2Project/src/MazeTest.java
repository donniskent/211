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
	public void resetMazeTest() {
		Maze maze = new Maze(6,5); 
		maze.set('.', 3, 4);
		maze.resetMaze();
		if(maze.get(3, 4) != ' ') {
			fail("Expected spot to be clear, got " + maze.get(3, 4));
		}
		
	}
	@Test 
	public void solveTest() {
		Maze maze = new Maze(5,6); 
		for(int i = 0; i < 5; i++) {
			maze.set('#', 0, i); 
			maze.set('#', 4, i);
	
		}
		maze.set('#', 1, 2);
		maze.set('#', 1, 4);
		maze.set('#', 2, 0);
		maze.set('#', 2, 2);
		maze.set('#', 2, 4);
		maze.set('#', 3, 0);
		maze.set('#', 3, 4);
		maze.set('#', 4, 0);
		maze.set('#', 4, 4);
		for(int row = 0; row < maze.getHeight(); row++) {
			for(int col = 0; col < maze.getWidth(); col++) {
			if(maze.get(row, col) != '#') {
				maze.set(' ', row, col);
				
			}
			
			}
			
		
		}
		String answer =	maze.solve(1, 0, 1, 3);
		MazeTextView view = new MazeTextView(maze);
		view.display();
		if(!answer.equals("1,1,3,1,3,3,1,3")) {
			System.out.println(answer);
			fail("didnt work");
		}
	
			String answer2 = maze.solve(0, 9, -3, 3); 
			if (answer2 != null) {
				fail("Start and end coordinates out of bounds. Expected null got " + answer2);
			}
	
			Maze maze2 = new Maze(5,5);
			for(int row2 = 0; row2 < maze.getHeight(); row2++) {
				for(int col2 = 0; col2 < maze.getWidth(); col2++) {
				
					maze.set(' ', row2, col2);
					
				
	}



}
			String answer3 = maze2.solve(1, 3, 0, 3);
			MazeTextView view2 = new MazeTextView(maze2);
			view2.display();
			
	
	
	}
	




}

