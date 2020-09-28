
public class Board {
// each piece on board needs an arraylist to accompany it 

	private BoardSpace[][] board = new BoardSpace[7][7];
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
		board = new BoardSpace[height][width];
		// every game starts the same way

		// set up the spaces
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				// if even row < 3: even cols = red
				if (row > 3 && row % 2 == 0 && col % 2 == 0) {
					board[row][col] = BoardSpace.Black;
				}

				else if (row < 3 && row % 2 == 0 && col % 2 == 0) {
					board[row][col] = BoardSpace.Red;
				} else if (row > 3 && row % 2 != 0 && col % 2 != 0) {
					board[row][col] = BoardSpace.Black;
				} else if (row < 3 && row % 2 != 0 && col % 2 != 0) {
					board[row][col] = BoardSpace.Red;
				}

				else {
					board[row][col] = BoardSpace.Available;
				}

			}

		}
	}

	public BoardSpace get(int row, int col) {
		return board[row][col];
	}

	public boolean movePlayer(int currentRow, int currentCol, int endRow, int endCol, BoardSpace currentPlayer) {
		BoardSpace notCurrent = null;
		// return true if player moved, false if not
		// if not jumping a piece
		// check that the math.abs(currentrow-newrow = 1) and math.abs(currentrow-newrow
		// = 1)
		// if jumping, math.abs(currentrow- newrow = 2)

		// false returns if: not a player, spot is taken by own piece, spot is outside
		// range, spot not on board
		// if move is of a player and it is on the board, must check if it is a jump
		// move or a single spot move

		if (currentPlayer == BoardSpace.Red) {
			notCurrent = BoardSpace.Black;
		}
		if (currentPlayer == BoardSpace.Black) {
			notCurrent = BoardSpace.Red;
		}

		// make sure it is a player that is moving by getting whats at boardpsace
		// current position
		if (get(currentRow, currentCol) != currentPlayer) {
			System.out.println("Not a player");
			return false;
		}
		// make sure position is on board
		if (illegalBoardPosition(currentRow, currentCol) || illegalBoardPosition(endRow, endCol)) {
			System.out.println("NOt on board ");
			return false;
		}

		// established that move is on board and a piece is moving
		// now we must decide if it is a jump move or a single move
		// first check if the abs value of row - row and col - col is 1 or 2.
		// if it is 1 then make sure the spot is open and move the piece
		// if it is two spots we must make sure there is an oposite color between the
		
		//before checking move space validity, it is important to make sure 
		//that the end coordinate is open. if not, there is no sense in checking
		// for space validity
		if (get(endRow, endCol) == BoardSpace.Available) {
		
		
		
		// check if final space is 1 move away
		if (Math.abs(currentRow - endRow) == 1 && Math.abs(currentCol - endCol) == 1) {
			
				board[endRow][endCol] = currentPlayer;
				board[currentRow][currentCol] = BoardSpace.Available;
				return true;
			}
			
	
		// check if move is 2 spots away
		if (Math.abs(currentRow - endRow) == 2 && Math.abs(currentCol - endCol) == 2) {
			// now must check if there is an opposite piece between the initial and final
			// coordinates
			
			// first check if the move is up or down 
			
			//check move down
				if (endRow > currentRow) {
					//now check if move is right or left 
					
					//check right move
					if (endCol > currentCol) {
						//check if the spot between initial and final is occupied by other color
						if (board[currentRow + 1][currentCol + 1] == notCurrent) {
							//at this point, move has passsed all conditions
							//therfore we can jump the piece. 
							board[endRow][endCol] = currentPlayer;
							// rearrange stack
							board[currentRow + 1][currentCol + 1] = BoardSpace.Available;
							board[currentRow][currentCol] = BoardSpace.Available;
							return true;
						}
					}
					
					// check move left
					if(endCol < currentCol) {
						//check spot between initial and final
						if (board[currentRow + 1][currentCol - 1] == notCurrent) {
							//at this point, move has passsed all conditions
							//therfore we can jump the piece. 
							board[endRow][endCol] = currentPlayer;
							// rearrange stack
							board[currentRow + 1][currentCol - 1] = BoardSpace.Available;
							board[currentRow][currentCol] = BoardSpace.Available;
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
						if (board[currentRow - 1][currentCol + 1] == notCurrent) {
							//at this point, move has passsed all conditions
							//therfore we can jump the piece. 
							board[endRow][endCol] = currentPlayer;
							// rearrange stack
							board[currentRow - 1][currentCol + 1] = BoardSpace.Available;
							board[currentRow][currentCol] = BoardSpace.Available;
							return true;
						}
					}
					
					// check move left
					if(endCol < currentCol) {
						//check spot between initial and final
						if (board[currentRow - 1][currentCol - 1] == notCurrent) {
							//at this point, move has passsed all conditions
							//therfore we can jump the piece. 
							board[endRow][endCol] = currentPlayer;
							// rearrange stack
							board[currentRow - 1][currentCol - 1] = BoardSpace.Available;
							
							board[currentRow][currentCol] = BoardSpace.Available;
							return true;
						}
						
						
					
					
					}
				
				
				
				
				}
		
		
		
		
		
		
		
		
		}

		}

		return false;

	}

	private void checkValidMove() {

	}

	private boolean illegalBoardPosition(int row, int column) {
		return (row < 0 || row >= board.length || column < 0 || column >= board[0].length);
	}

}
