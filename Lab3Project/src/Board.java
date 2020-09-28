
public class Board {
// each piece on board needs an arraylist to accompany it 
	
	
	
	private BoardSpace[][] board = new BoardSpace[7][7];
    private BoardSpace lastPlayer = BoardSpace.Red;
	
	
	public Board() {
	createBoard(7,7); 
		
	}
	




public int getWidth ()
{	 return board[0].length;
   
}

public int getHeight ()
{ return board.length; 
    
}


private void createBoard(int width, int height){
	board = new BoardSpace[height][width];
    //every game starts the same way
	
	// set up the spaces 
	for (int row = 0; row < height; row ++) {
		for(int col = 0; col < width; col++) {
			// if even row < 3: even cols = red 
			if(row > 3 && row %2 == 0 && col %2 == 0) {
				board[row][col] = BoardSpace.Black; 
			}
		
			else if(row < 3 && row %2 == 0 && col %2 == 0) {
			board[row][col] = BoardSpace.Red; 
		}
			else if(row > 3 && row %2 != 0 && col %2 != 0) {
				board[row][col] = BoardSpace.Black; 
			}
			else if(row < 3 && row %2 != 0 && col %2 != 0) {
				board[row][col] = BoardSpace.Red; 
			}
		
		
		else {
			board[row][col] = BoardSpace.Available;
		}
		
		
		
		
		}
			
			
			
			
	}}


public BoardSpace get(int row, int col) {
	return board[row][col]; 
}
	
public boolean movePlayer(int currentRow, int currentCol, int endRow, int endCol, BoardSpace currentPlayer) {
	BoardSpace notCurrent = null; 
	//return true if player moved, false if not
	//if not jumping a piece
	// check that the math.abs(currentrow-newrow = 1) and math.abs(currentrow-newrow = 1)
	//if jumping, math.abs(currentrow- newrow = 2) 

	// false returns if: not a player, spot is taken by own piece, spot is outside range, spot not on board
	if(currentPlayer == BoardSpace.Red) {
		notCurrent = BoardSpace.Black;
	}
	if(currentPlayer == BoardSpace.Black) {
		notCurrent = BoardSpace.Red;
	}
	
	// make sure it is a player
	if(currentPlayer != BoardSpace.Red && currentPlayer != BoardSpace.Black) {
		System.out.println("Not a player");
		return false;
	}
	// make sure move is 1 away 
	if(Math.abs(currentRow - endRow) + Math.abs(currentCol- endCol) != 2  ){
		System.out.println("Move isnt diagonal.");
		return false; 
	
	}
	// make sure position is on board
	if(illegalBoardPosition(currentRow, currentCol) || illegalBoardPosition(endRow, endCol)) {
		System.out.println("NOt on board ");
		return false; 
	}
	if(board[endRow][endCol] == notCurrent && board[endRow+1][endCol+1] == BoardSpace.Available) {
		board[currentRow][currentCol] = BoardSpace.Available; 
		
	
	}
	
	
	board[endRow][endCol] = currentPlayer; 
	board[currentRow][currentCol] = BoardSpace.Available; 
	return true; 
	


}
	
	
	
	



private void checkValidMove() 
{
	
 



}

private boolean illegalBoardPosition (int row, int column)
{
    return (row < 0 || row >= board.length || column < 0 || column >= board[0].length);
}



}
