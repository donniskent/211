public class IsolaTextView {
	private IsolaBoard board;

	IsolaTextView(IsolaBoard board) {
		this.board = board;
	}

	public void display() {
		// display the board

		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				BoardSpace boardSpot = (board.get(i, j));

				if (j == board.getWidth() - 1) {
					if (boardSpot == BoardSpace.Player1) {
						System.out.println("1 ");

					} else if (boardSpot == BoardSpace.Player2) {
						System.out.println("2 ");
					} else if (boardSpot == BoardSpace.Missing) {
						System.out.println("  ");
					} else {
						System.out.println("- ");
					}

				}  else {

					if (boardSpot == BoardSpace.Player1) {
						System.out.print("1 ");

					} else if (boardSpot == BoardSpace.Player2) {
						System.out.print("2 ");
					} else if (boardSpot == BoardSpace.Missing) {
						System.out.print("  ");
					} else {
						System.out.print("- ");
					} 
				}
			}
		}
	}	}

