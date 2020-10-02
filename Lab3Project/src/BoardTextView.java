
public class BoardTextView {
	private Board board;

	BoardTextView(Board board) {
		this.board = board;
	}

	public void display() {
		for (int row = 0; row < board.getHeight(); row++) {
			for (int col = 0; col < board.getWidth(); col++) {
				if (col == board.getWidth() - 1) {
					System.out.print(board.getList(row, col).get(0));
					System.out.println("");
				} else {
					System.out.print(board.getList(row, col).get(0));
				}

			}
		}

	}

}