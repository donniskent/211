import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Controller {

	public static void main(String [] args) {
		Controller controller = new Controller();
		controller.go();
		
		
		
	}

	public void go() {
		// maybe put values into an array list, clear the array list after getting recursive function answer
		//
		
	/*	File directory = readDirectory();
	// have to pull the first file in the directory and read in its values. 
		File [] allFiles = directory.listFiles();
		ArrayList<Integer> list;
		
		
		for(int i = 0; i < allFiles.length; i++) {
			// i establishes the file 
			// now need to take a look at whats in the file 
			
			
			
			
		
			
			
			*/
			
			
			
			
			
			
			
			
			
			
			
			
		//	System.out.println(i);
			
		
		
		
		Graph graph = new Graph(4);
		graph.setEdgeValue(0,0,1);
		graph.setEdgeValue(1,2,1);
		graph.setEdgeValue(2,1,1);
		graph.setEdgeValue(3,0,1);
		graph.setEdgeValue(3,1,1);
		
		
		
		
		
		
		
		
		
		// 1. input the directory 
		// 2. scan a single file 
		// 3. call recursive methods on the scanned ints 
		// 4. return whether the file is solvable or not 
		// 5. must establish separate graphs for each file 
		// 6. the constructor for each graph must consider the # of vertices, edges and specific paths
		// this can be accomplished through the use of a 2D array 
		
		
		// brain storm for what to do with file 
		// 1. need to initialize the size of the double array based on the first int (n) on line "0"
		// 2. Subsequent lines (1,2, 3, 4....n) are used to place values in the array. 
		// 3. If the line has a value, then the index at row "current line" column "value" is 1. 
		// More numbers in a file row means more "1's" in the matrix.
		// 4. Once the file is out of lines, which will be equal to the matrix height + 1, 
		// all vlaues are fully read in. At this point, the reursive method is called on the matrix, 
		// returning a string that reveals "solvable" or " not solvable". 
		
		
		
		
		
		
		
		
		
		// get directory 
		//
		// while ( directory still has files ) {
		//   scan file
		//  Initialize graph [][] with number of vertices from file
		//   while ( file has next int) {
		//	 
		//   
		//
		//        }
		//
		//
		//
		//
		//
	
	
	}
	
		// pull in directory 
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
