import java.util.ArrayList;
import java.util.List;

public class Board {
// each piece on board needs an arraylist to accompany it 
	
	private List<BoardSpace>[][] board = new List[7][7];
	private BoardSpace lastPlayer = BoardSpace.Red;
	
	
	public Board() {
		createBoard(7, 7);
		
		
		
	}

	public int getWidth() {
		return board[0].length;

	}

	public int getHeight() {
		return board.length;

	}
	
	private void createBoard(int width, int height) {
		board = new List[width][height];
		for(int row = 0; row < height; row++) {
			for(int col = 0; col < width; col++) {
				board[row][col] = new ArrayList<BoardSpace>();
				
				
			}
	}
		
		
		
		
		
		
		
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				// if even row < 3: even cols = red
				if (row > 3 && row % 2 == 0 && col % 2 == 0) {
					board[row][col].add(BoardSpace.Black);
				}

				else if (row < 3 && row % 2 == 0 && col % 2 == 0) {
					board[row][col].add(BoardSpace.Red);
				} else if (row > 3 && row % 2 != 0 && col % 2 != 0) {
					board[row][col].add(BoardSpace.Black);
				} else if (row < 3 && row % 2 != 0 && col % 2 != 0) {
					board[row][col].add(BoardSpace.Red);
				}

				else {
					board[row][col].add(BoardSpace.Available);				
					}

			}

		} 
	}

	public List<BoardSpace> getList(int row, int col) {
		return board[row][col];
	}

	 public boolean movePlayer(int currentRow, int currentCol, int endRow, int endCol, BoardSpace currentPlayer) {
		BoardSpace notCurrent = null;
		List<BoardSpace> placeHolder; 
		// we need to decide whose turn it is based on the 

		if (currentPlayer == BoardSpace.Red) {
			notCurrent = BoardSpace.Black;
		}
		if (currentPlayer == BoardSpace.Black) {
			notCurrent = BoardSpace.Red;
		}

		// make sure it is a player that is moving by getting Top of stack of space
		// current position
		if (illegalBoardPosition(currentRow, currentCol) || illegalBoardPosition(endRow, endCol)) {
			System.out.println("Not on board ");
			return false;
		}
		if (getList(currentRow, currentCol).get(0) != currentPlayer) {
			System.out.println("Spot doesn't contain your player");
			return false;
		}
		
		if (getList(endRow, endCol).get(0) == BoardSpace.Available) {
		
		
		
		// check if final space is 1 move away
		if (Math.abs(currentRow - endRow) == 1 && Math.abs(currentCol - endCol) == 1) {
				 placeHolder = board[endRow][endCol]; 
				board[endRow][endCol] = board[currentRow][currentCol];
				
				board[currentRow][currentCol] = placeHolder;  
				return true;
			}
			
	
		// check if move is 2 spots away
		if (Math.abs(currentRow - endRow) == 2 && Math.abs(currentCol - endCol) == 2) {
			//check up or down
				if (endRow > currentRow) {
				//moving down
					//now check if move is right or left 
					
					//check right move
					if (endCol > currentCol) {
						//check if the spot between initial and final is occupied by other color
						if (board[currentRow + 1][currentCol + 1].get(0) == notCurrent) {
							//at this point, move has passsed all conditions
							//therefore we can jump the piece. 
							placeHolder = board[endRow][endCol];
							board[endRow][endCol] = board[currentRow][currentCol];
							board[endRow][endCol].add(board[currentRow + 1][currentCol + 1].get(0));
							if(board[currentRow + 1][currentCol + 1].size() == 1) {
								
								board[currentRow + 1][currentCol + 1].clear();	
								board[currentRow + 1][currentCol + 1].add(BoardSpace.Available);
							}
							else {
							board[currentRow + 1][currentCol + 1].remove(board[currentRow + 1][currentCol + 1].get(board[currentRow + 1][currentCol + 1].size()-1));
							}
							board[currentRow][currentCol] = placeHolder;
							return true;
						}
					}
					
					// check move left
					if(endCol < currentCol) {
						//check spot between initial and final
						if (board[currentRow + 1][currentCol - 1].get(0) == notCurrent) {
							//at this point, move has passsed all conditions
							//therfore we can jump the piece. 
							placeHolder = board[endRow][endCol];
							board[endRow][endCol] = board[currentRow][currentCol];
							board[endRow][endCol].add(board[currentRow + 1][currentCol - 1].get(0));
							if(board[currentRow + 1][currentCol - 1].size() == 1) {
								board[currentRow + 1][currentCol - 1].clear();	
								board[currentRow + 1][currentCol - 1].add(BoardSpace.Available);
							}
							else {
							board[currentRow + 1][currentCol - 1].remove(board[currentRow + 1][currentCol - 1].get(board[currentRow + 1][currentCol - 1].size()-1));
							}
							board[currentRow][currentCol] = placeHolder;
							return true;
						
						
						
						}
						
						
					
					
					}
				
				
				
				
				}
			// do same thing, but this is when we are moving up instead of down 
				if (endRow < currentRow) {
					//now check if move is right or left 
					
					//check right move
					if (endCol > currentCol) {
						//check if the spot between initial and final is occupied by other color
						if (board[currentRow - 1][currentCol + 1].get(0) == notCurrent) {
							//at this point, move has passsed all conditions
							//therfore we can jump the piece. 
							placeHolder = board[endRow][endCol];
							board[endRow][endCol] = board[currentRow][currentCol];
							board[endRow][endCol].add(board[currentRow - 1][currentCol + 1].get(0));
							if(board[currentRow - 1][currentCol + 1].size() == 1) {
								board[currentRow - 1][currentCol + 1].clear();	
								board[currentRow - 1][currentCol + 1].add(BoardSpace.Available);
							}
							else {
							board[currentRow - 1][currentCol + 1].remove(board[currentRow - 1][currentCol + 1].get(board[currentRow - 1][currentCol + 1].size()-1));
							}
							board[currentRow][currentCol] = placeHolder;
							return true;
						}
					}
					
					// check move left
					if(endCol < currentCol) {
						//check spot between initial and final
						if (board[currentRow - 1][currentCol - 1].get(0) == notCurrent) {
							placeHolder = board[endRow][endCol];
							board[endRow][endCol] = board[currentRow][currentCol];
							board[endRow][endCol].add(board[currentRow - 1][currentCol - 1].get(0));
							if(board[currentRow - 1][currentCol - 1].size() == 1) {
								board[currentRow - 1][currentCol - 1].clear();	
								board[currentRow - 1][currentCol - 1].add(BoardSpace.Available);
							}
							else {
							board[currentRow - 1][currentCol - 1].remove(board[currentRow - 1][currentCol - 1].get(board[currentRow - 1][currentCol - 1].size()-1));
							}
							board[currentRow][currentCol] = placeHolder;
							return true;
						
						
						
						
						}
						
						
					
					
					}
				
				
				
				
				}
		
		
		
		
		
		
		
		
		}

		
		} 
		
		
	return false;
				
	} 



	private boolean illegalBoardPosition(int row, int column) {
		return (row < 0 || row >= board.length || column < 0 || column >= board[0].length);
	}
	
	public void peek(int row, int col) {
		System.out.println(board[row][col]);
		
	}
	
	
}
