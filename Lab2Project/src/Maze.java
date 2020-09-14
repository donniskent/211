
public class Maze {
	private int width;
	private int height;
	private char[][] maze;

	public Maze(int height, int width) {
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
		if ((endRow >= 0 && endRow < height) && (endCol >= 0 && endCol < width)) {

			// while (currentCol <= width ) {
			String result = "";

			maze[currentRow][currentCol] = '.';

			// must use recursion
			// must return a string r,c,-r1,c1,-r2,c2,
			// base case 1: at the end
			// return end coordinates

			if (currentRow == endRow && currentCol == endCol) {
				return endRow + "," + endCol;
			}

			int countNumSpots = 0;

			if (currentCol < (width - 1) && maze[currentRow][currentCol + 1] == ' ') {
				countNumSpots += 1;
			}
			if (currentCol > 0 && maze[currentRow][currentCol - 1] == ' ') {
				countNumSpots += 1;
			}
			if (currentRow < (height - 1) && maze[currentRow + 1][currentCol] == ' ') {
				countNumSpots += 1;
			}
			if (currentRow > 0 && maze[currentRow - 1][currentCol] == ' ') {
				countNumSpots += 1;
			}

			// base case 2: at a dead end

			if (countNumSpots == 0) {
				return null;

			}

			if (countNumSpots == 1) {

				if (moveEast(currentCol) <= (width - 1) && maze[currentRow][moveEast(currentCol)] == ' ') {

					int eastCol = moveEast(currentCol);
					result = solve(currentRow, eastCol, endRow, endCol);

					if (result != null) {

						return currentRow + "," + eastCol + "," + result;
					}

				}

				if (moveSouth(currentRow) <= (height - 1) && maze[moveSouth(currentRow)][currentCol] == ' ') {
					int southRow = moveSouth(currentRow);

					result = solve(southRow, currentCol, endRow, endCol);
					if (result != null) {

						return southRow + "," + currentCol + "," + result;
					}

				}

				if (moveWest(currentCol) >= 0 && maze[currentRow][moveWest(currentCol)] == ' ') {
					int westCol = moveWest(currentCol);

					result = solve(currentRow, westCol, endRow, endCol);
					if (result != null) {

						return currentRow + "," + westCol + "," + result;
					}

				}

				if (moveNorth(currentRow) >= 0 && maze[moveNorth(currentRow)][currentCol] == ' ') {
					int northRow = moveNorth(currentRow);
					result = solve(northRow, currentCol, endRow, endCol);
					if (result != null) {

						return northRow + "," + currentCol + "," + result;
					}

				}

			}

			if (moveEast(currentCol) <= (width - 1) && maze[currentRow][moveEast(currentCol)] == ' ') {

				int eastCol = moveEast(currentCol);

				result = solve(currentRow, eastCol, endRow, endCol);

				if (result != null) {
					return currentRow + "," + eastCol + "," + result;
				}

			}

			if (moveSouth(currentRow) <= (height - 1) && maze[moveSouth(currentRow)][currentCol] == ' ') {
				int southRow = moveSouth(currentRow);
				result = solve(southRow, currentCol, endRow, endCol);
				if (result != null) {
					return southRow + "," + currentCol + "," + result;
				}
			}

			if (moveWest(currentCol) >= 0 && maze[currentRow][moveWest(currentCol)] == ' ') {
				int westCol = moveWest(currentCol);
				result = solve(currentRow, westCol, endRow, endCol);
				if (result != null) {
					return currentRow + "," + westCol + "," + result;
				}

			}

			if (moveNorth(currentRow) >= 0 && maze[moveNorth(currentRow)][currentCol] == ' ') {
				int northRow = moveNorth(currentRow);
				result = solve(northRow, currentCol, endRow, endCol);
				if (result != null) {
					return northRow + "," + currentCol + "," + result;
				}

			}
		}

		return null;

	}

	private int moveNorth(int row) {
		row -= 1;
		return row;
	}

	private int moveSouth(int row) {
		row += 1;
		return row;
	}

	private int moveEast(int col) {

		col += 1;
		return col;
	}

	private int moveWest(int col) {
		col -= 1;
		return col;
	}

	public void resetMaze() {
		// for each spot in maze
		// if maze spot = " ."
		// maze spot now equals " "
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (maze[row][col] == '.') {
					maze[row][col] = ' ';
				}
			}

		}

	}

}
