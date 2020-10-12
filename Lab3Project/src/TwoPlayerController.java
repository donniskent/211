
import java.util.Scanner;

public class TwoPlayerController {
	public static void main(String[] args) {
		TwoPlayerController control = new TwoPlayerController();
		control.go();
	}

	public void go() {
		// make a board
		System.out.println("Welcome to Lasca");
		System.out.println("Player 1 will be Red (R). Player 2 will be Black (B)");
		System.out.println("To enter a move, first input the row (space) column of the piece you "
				+ "want to move, ");
		System.out.println("then the row (space) column of where you want to move to. ");
		
		Board board = new Board();
		BoardTextView view = new BoardTextView(board);
		

		view.display();

		

		Scanner scan = new Scanner(System.in);
		int counter = 0;
		BoardSpace currentPlayer = BoardSpace.Red;
		BoardSpace notCurrentPlayer = BoardSpace.Black;
		int currentRow = -1;
		int currentCol = -1;
		int endRow = -1;
		int endCol = -1;
		boolean moved;
		// boolean gameOn = true;
		while (true) {
			if (counter % 2 == 0) {
				currentPlayer = BoardSpace.Red;
				notCurrentPlayer = BoardSpace.Black;
			}
			if (counter % 2 > 0) {
				currentPlayer = BoardSpace.Black;
				notCurrentPlayer = BoardSpace.Red;
			}
			// System.out.println(currentPlayer + " move: ");
			if (checkGameOver(board, currentPlayer) == true) {
				System.out.println("Game over! " + currentPlayer + " has not more moves!");
				System.out.println(notCurrentPlayer + " wins!");
				break;
			}

			if (counter > 1) {
				boolean quit = checkQuit(currentPlayer, scan);
				if (quit == true) {
					System.out.println("Game over! " + currentPlayer + " quits!");
					System.out.println(notCurrentPlayer + " wins!");

					break;
				}

				checkPeek(board, currentPlayer, scan);

			}

			System.out.println("Please enter your move " + currentPlayer + ":");

			try {
				currentRow = scan.nextInt();
				currentCol = scan.nextInt();
				endRow = scan.nextInt();
				endCol = scan.nextInt();
				moved = board.movePlayer(currentRow, currentCol, endRow, endCol, currentPlayer);
			}

			catch (Exception e) {
				moved = false;
				scan.next(); // jumps scanner out of infinite loop
			}

			if (moved == false) {
				System.out.println("Invalid move. Please enter a valid move.");
				counter -= 1;
			}
			view.display();
			counter += 1;
			// ask player for move as coordinates

			// move player
			// update stack
			// check winner
			// switch player
			// }
			// say winner/loser

		}
		scan.close();
	}

	public void checkPeek(Board board, BoardSpace currentPlayer, Scanner scan1) {
		while (true) {
			System.out.println(currentPlayer + ", do you want to see a stack? (Y/N): ");
			String answer = scan1.next();
			if (answer.equals("Y")) {
				System.out.println("What is the cooridnate of the stack you want to peek at?");
				try {
					int row = scan1.nextInt();
					int col = scan1.nextInt();
					peek(row, col, board);
				} catch (Exception e) {
					System.out.println("Error. Enter valid coordinates");
					scan1.nextLine();
					continue;

				}

			}
			if (answer.equals("N")) {
				break;

			}

			else if (!answer.equals("Y") && !answer.equals("N")) {
				System.out.println("Error. Enter Y for yes and N for no");

			}
		}

	}

	public boolean checkQuit(BoardSpace currentPlayer, Scanner scan2) {
		while (true) {
			System.out.println(currentPlayer + ", do you want to quit? (Y/N)");
			String answer = scan2.next();
			if (answer.equals("Y")) {

				return true;

			}

			else if (answer.equals("N")) {

				return false;
			}

			else {
				System.out.println("Invalid input. Answer must be Y or N");
				continue;
			}

		}

	}

	public boolean checkGameOver(Board board, BoardSpace currentPlayer) {
		// loop though the board
		// check each spot, if atleast 1 spot contains a top piece of current player,
		// game is not over
		// if no spots contain a top piece of current player, game is over

		for (int row = 0; row < board.getHeight(); row++) {
			for (int col = 0; col < board.getWidth(); col++) {
				if (board.getList(row, col).get(0) == currentPlayer) {
					return false;

				}

			}

		}
		return true;

	}

	public void peek(int row, int col, Board board) {
		System.out.println(board.getList(row, col));

	}









}
