import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Controller {

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.go();

	}

	public void go() {
		

		File directory = readDirectory();
		// have to pull the first file in the directory and read in its values.
		File[] allFiles = directory.listFiles();
		String[] strings;
		int count = 0;
		Scanner stringScan;
		Scanner scan;
		for (int k = 0; k < allFiles.length; k++) {
			try {
				scan = new Scanner(allFiles[k]);
				int numNodes = scan.nextInt();
				strings = new String[numNodes]; // gets how many nodes there are
				Graph graph = new Graph(numNodes);
				scan.nextLine();
				while (scan.hasNextLine()) {
					strings[count] = scan.nextLine();
					count++;
				}

				for (int n = 0; n < strings.length; n++) {
					stringScan = new Scanner(strings[n]);
					while (stringScan.hasNextInt()) {
						graph.setEdgeValue(n, stringScan.nextInt(), 1);
					}

				}
				ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
				for(int i = 0; i < graph.getVertices(); i ++) {
				ArrayList<Integer> queue = new ArrayList<Integer>();
				queue.add(i);

				boolean result = graph.solve(queue, visitedNodes);
				System.out.print("File " + allFiles[k].getName() + " starting node " + i + " result is ");
				if (result == true) {
					System.out.print("solvable");
				} else {
					System.out.print("unsolvable");
				}

				System.out.println("");
				queue.clear();
				visitedNodes.clear();
				}
			} catch (Exception e) {
				System.out.println("Problem reading file " + allFiles[k] + " in the directory");

			}

			count = 0;

		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public File readDirectory() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int returnVal = chooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			File file = chooser.getSelectedFile();

			return file;

		}

		return null;

	}

}
