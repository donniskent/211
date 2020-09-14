
public class MazeTextView {
private Maze maze; 
	MazeTextView(Maze maze) {
		this.maze = maze; 
		
	}
		public void display() {
			
			for(int row = 0; row < maze.getHeight(); row++) {
			for(int col = 0; col < maze.getWidth(); col++) {
				char mazeSpot = maze.get(row, col); 
				if(col == maze.getWidth()-1) {
					System.out.print(mazeSpot);

					System.out.println("");
				}
				else {
					
				
				System.out.print(mazeSpot);
				}
			
			}
			
			
			
			
			}
			
		
		
		}

			
			
			
	
			
		
	}



