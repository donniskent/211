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
		
		
		
		// read maze from file 
		
		
		// for each start, end pair {
		//  solve maze 
		//  output the answer }
		//                
		//
		
		
		
		
		
		
		JFileChooser chooser = new JFileChooser();
		  int returnVal = chooser.showOpenDialog(null); 
		    
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       
		        File file =  chooser.getSelectedFile();
		    Scanner input = null; 
		        
		        
		    try {
				input = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("Could not find the file " + file.getName()); 
				
			}
		    
		    
		    
		    }
		
	}
	
	public Maze readMazeFromFile() {
		// get file from user 
		File file = getFile(); 
		Scanner fileScan = new Scanner(file);
		int widthFile = fileScan.nextInt();
		int heightFile = fileScan.nextInt(); 
		
		
		// read width
		// read height
		
		
		Maze maze = new Maze(widthFile, heightFile); 
		
		for(int row = 0; row < height.; row++) {
			for(int col = 0; col < width; col++) {
				maze.set(character, row, col);
				
			}
		} 
		
		
		return maze; 
	
	}
	public File getFile() {
	
		
		JFileChooser chooser = new JFileChooser();
		  int returnVal = chooser.showOpenDialog(null); 
		    
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       
		        File file =  chooser.getSelectedFile();
		    
		        
		        	return file; 
		    
		    
		    }
		    
		    
		    
		
		
		
		return null; 
	
	
	}


}
