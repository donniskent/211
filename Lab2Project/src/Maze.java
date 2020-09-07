
public class Maze {
	private int width; 
	private int height;
	private char [][] maze; 
	public Maze (int width, int height) {
		this.width = width; 
		this.height = height;
		// create maze array [height][width]
		
		
		
	}
	 
	
	
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void set(char character, int row, int col) {
		
		
	}
	
	
	public String solve(int startRow, int startCol, int endRow, int endCol) {
		String result = "";
	// must use recursion 
	// must return a string r,c,-r1,c1,-r2,c2,
		// base case 1: at the end 
		// return coordinates
		// base case 2: at a dead end 
		// return null 
		
		
		// recursive case 
		// if only one way to go 
		// calc next spot coordinate
		// return solve(currentRow, currentCol, endRow,endCol)
		
		
		// multiple ways to go 
		// if we can move east
		// calculate spot to east
		// result = solve(eastRow,eastCol, endRow, endCol) 
		// if result != null 
		//  return eastRow + "," + eastCol + "," + result
		//
		//
		//
		//
		//
		
		// if we can move south
				// calculate spot to south
				// result = solve(southRow,southCol, endRow, endCol) 
				// if result != null 
				//  return southRow + "," + southCol + "," + result
		
		// if we can move West
				// calculate spot to west
				// result = solve(westRow,westCol, endRow, endCol) 
				// if result != null 
		//  return westRow + "," + westCol + "," + result
		// if we can move north
				// calculate spot to north
				// result = solve(northRow,northCol, endRow, endCol) 
				// if result != null 
				//  return nortRow + "," + northCol + "," + result
		
		
		
		
	
		return null; 
	
	
	}
	
}
