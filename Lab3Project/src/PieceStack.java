import java.util.ArrayList;

// each piece needs an arraylist assigned to it. 
// we will need a method for adding to, and taking away from the arraylist 
// each piece that is added must go to the bottom of the array list. 
// each piece being taken away must be taken from the top. 
// it will be an arraylist of BoardSpaces
// need a method that lets the user "peek" at a stacks list.


public class PieceStack {
	private ArrayList<BoardSpace> list = new ArrayList<BoardSpace>();


public void add(BoardSpace jumpedPiece) {
		list.add(jumpedPiece);
	
}
public void remove(BoardSpace topPiece) {
	list.remove(topPiece); 
}

public void peak() {
	
}





}
