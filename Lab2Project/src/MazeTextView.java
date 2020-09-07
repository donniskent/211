
public class MazeTextView {
private Maze maze; 
	MazeTextView(Maze maze) {
		this.maze = maze; 
		
	}
		public void display() {
			for (int i = 0; i < maze.getWidth(); i++) {
				for (int j = 0; j < maze.getHeight(); j++) {
					char mazeSpot = maze.get(i, j);
					if (j == maze.getWidth() - 1) {
						System.out.println(mazeSpot);

					}  else {

						System.out.print(mazeSpot);
						} 
		}

			
			
			
	}
			
		
	}


}
