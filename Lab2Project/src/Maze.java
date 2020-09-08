
public class Maze {
	private int width; 
	private int height;
	private char [][] maze; 
	public Maze (int height, int width) {
		this.width = width; 
		this.height = height;
		maze = new char[height][width]; 
		
		
		
		// create maze array [height][width]
		
		
		
	}
	 
	
	
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void set(char character, int row, int col) {
		maze[row][col] = character; 
		
	}
	
	public char get(int row, int column) {
		return maze[row][column]; 
		
	}
	
	
	
	public String solve(int currentRow, int currentCol, int endRow, int endCol) {
		String result = "";
	
		
	maze[currentRow][currentCol] = '.';
	
	// must use recursion 
	// must return a string r,c,-r1,c1,-r2,c2,
		// base case 1: at the end 
		// return end coordinates
		if(currentRow == endRow && currentCol == endCol) {
			return endRow + "," + endCol ; 
		}
		
		
		
		
		// base case 2: at a dead end 
		// return null 
			
		// count num of clear spots
		
		// recursive case 
		// if only one way to go 
		// calc next spot coordinate
		// return solve(nextRow, nextCol, endRow,endCol)
		
		
		
		// multiple ways to go 
		
		
		// if we can move east
		// calculate spot to east
		// result = solve(eastRow,eastCol, endRow, endCol) 
		// if result != null 
		//  return eastRow + "," + eastCol + "," + result
		if(maze[currentRow][currentCol + 1] == ' ') {
		int	eastCol = moveEast(currentCol); 
			result = solve(currentRow, eastCol, endRow, endCol); 
			if (result != null) {
				return currentRow + "," + eastCol + "," + result; 
			}
		
		
		
		
		}
		
		
		
		
		//
		//
		//
		//
		
		// if we can move south
				// calculate spot to south
				// result = solve(southRow,southCol, endRow, endCol) 
				// if result != null 
				//  return southRow + "," + southCol + "," + result
		if(maze[currentRow + 1][currentCol] == ' ') {
			int	southRow = moveSouth(currentRow); 
				result = solve(southRow, currentCol, endRow, endCol); 
				if (result != null) {
					return southRow + "," + currentCol + "," + result; 
				}
				else {
					
				}
			
			
			
			
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		// if we can move West
				// calculate spot to west
				// result = solve(westRow,westCol, endRow, endCol) 
				// if result != null 
		//  return westRow + "," + westCol + "," + result
		if(maze[currentRow][currentCol - 1] == ' ') {
			int	westCol = moveWest(currentCol); 
				result = solve(currentRow, westCol, endRow, endCol); 
				if (result != null) {
					return currentRow + "," + westCol + "," + result; 
				}
			
			
			
			
			}
		
		
		
		
		
		// if we can move north
				// calculate spot to north
				// result = solve(northRow,northCol, endRow, endCol) 
				// if result != null 
				//  return nortRow + "," + northCol + "," + result
		if(maze[currentRow - 1][currentCol] == ' ') {
			int	northRow = moveNorth(currentRow); 
				result = solve(northRow, currentCol, endRow, endCol); 
				if (result != null) {
					return northRow + "," + currentCol + "," + result; 
				}
			
			
			
			
			}
		
		
		
		
		
		
		
	
		return result; 
	
	
	}
	
private int moveNorth(int col) {
	col-=1; 
	return col;
}


private int moveSouth(int col) {
	col+=1; 
	return col; 
}


private int moveEast(int row) {
	row+=1; 
	return row; 
}




private int moveWest(int row) {
	row-=1; 
	return row; 
}








}

