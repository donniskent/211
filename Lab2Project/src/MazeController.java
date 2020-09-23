import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class MazeController {

	public static void main(String[] args) {
		MazeController controller = new MazeController();
		controller.go();
	}

	public void go() {

		Coordinates coordinate = new Coordinates();
		File inFile = getFile();
		Maze maze = readMazeFromFile(coordinate, inFile);
		MazeTextView view = new MazeTextView(maze);
		// view.display();
		File outFile = new File(inFile + ".out");
		// read maze from file
		ArrayList<String> answerArr = new ArrayList<String>();
		// for each start, end pair {
		// view.display();
		for (int i = 0; i < coordinate.length(); i += 4) {
			view.display();
			String answer = maze.solve(coordinate.get(i), coordinate.get(i + 1), coordinate.get(i + 2),
					coordinate.get(i + 3));
			if (answer != null) {
				answer = coordinate.get(i) + "," + coordinate.get(i + 1) + "," + answer;
			}
			System.out.println(answer);

			view.display();
			System.out.println("-----------------------");
			answerArr.add(answer);
			maze.resetMaze();
		}
		writeFile(answerArr, outFile);

		// solve maze
		// output the answer }
		//
		//

	}

	public Maze readMazeFromFile(Coordinates coordinate, File file) {
		// get file from user

		Scanner fileScan = null;
		try {
			fileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to open file.");
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

		// while has next
		// read start coordinate, add to list
		// read end coordinate, add to list

		while (fileScan.hasNext()) {
			coordinate.add(fileScan.nextInt());
		}

		return maze;
	}

	public File getFile() {

		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			File file = chooser.getSelectedFile();

			return file;

		}

		return null;

	}

	public void writeFile(ArrayList<String> answer, File file) {

		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + file);
			return;
		}
		for (int i = 0; i < answer.size(); i++) {
			if(answer.get(i) == null) {
				writer.println("Impossible");
			}
			else {
			writer.println(answer.get(i));}
		}
		writer.close();
	}

}
