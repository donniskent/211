import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class MazeController {

	public static void main(String[] args) {
		MazeController controller = new MazeController();
		controller.go();
	}

	public void go() {
		Maze maze = readMazeFromFile();
		MazeTextView view = new MazeTextView(maze);
		view.display();

		// read maze from file

		// for each start, end pair {
		// solve maze
		// output the answer }
		//
		//

	}

	public Maze readMazeFromFile() {
		// get file from user
		File file = getFile();
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int width = fileScan.nextInt();
		int height = fileScan.nextInt();
		fileScan.nextLine();
		System.out.println(width + " width");
		System.out.println(height + " height");
		Maze maze = new Maze(height, width);

		for (int row = 0; row < height; row++) {
			String characters = fileScan.nextLine();
			for (int column = 0; column < width; column++) {

				char character = characters.charAt(column);
				maze.set(character, row, column);
			}
			// char character;
			// maze.set(character, row, column);
		}
		return maze;
	}
	// while has next
	// read start coordinate, add to list
	// read end coordinate, add to list

	public File getFile() {

		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			File file = chooser.getSelectedFile();

			return file;

		}

		return null;

	}

}
