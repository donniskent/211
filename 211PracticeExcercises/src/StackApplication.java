import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class StackApplication{

	// get file from user 
	// while file has next line {
	//	for each char in the line {
	//  if (char == "{ || ( || [ " )
	//    push char to stack }
	//  if ( char is not same type as top of stack, but is closing {
	//  						throw error  }
	// if (char == closing char && top of stack = opening char (of same type char) ) {     
	// pop top of stack        }
	//   
	// }} out of while loop 
	// if (stack is not empty) { 
	//			throw error }
	// 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackApplication obj = new StackApplication(); 
		obj.go();
	}
		public void go() {
			Stack<Character> stack = new StackImplementation<Character> ();
			File file = getFile(); 
			Scanner fileScan = null;
			try {
				fileScan = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to open file");
			}
			
			Character currentChar;
			int counter = 0; 
			//boolean loop = fileScan.hasNextLine();
			boolean b;
			while(fileScan.hasNextLine()) {
				
				counter+=1; 
				String currentLine = fileScan.nextLine();
				for(int i = 0; i < currentLine.length(); i++) {
				
				currentChar = currentLine.charAt(i);
				
			if (checkCharOpening(currentChar) == true) {
				stack.push(currentChar);
				
			}
			if (checkCharClosing(currentChar) == true) {
				if(stack.isEmpty()) {
					System.out.println("Error, missing opening to " + currentChar+ ". Recognized at " + counter);
					b = false;
					break;
				}
				
				if (compareOpenClose(currentChar, stack, counter) == true) {
					
					continue; 
				}
				else {
					
					break; 
					
				}
				
			}
			
			}
			
				
			
				
				
				
				}
				
			
			
			
			
				if(!stack.isEmpty()) {
				
					System.out.print("Missing the closing bracket to a " 
					+ stack.getData(stack.length()-1) + ". Recognized at " + counter);
				}
				
		
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
		
			
			
		public boolean checkCharOpening(Character currentChar) {
			if (currentChar.equals('{')  || currentChar.equals('(') || currentChar.equals('[')) {
				return true; 
			}
			
			return false; 
		
		}
			
		public boolean checkCharClosing(Character currentChar) {
			if (currentChar.equals('}')  || currentChar.equals(')') || currentChar.equals(']')) {
				return true; 
			}
			
			return false; 
		}



		public boolean compareOpenClose(Character closing, Stack<Character> stack, int counter) {
			if(stack.length() > 0) {
			if(closing.equals('}') && stack.getData(stack.length()-1).equals('{')) {
				stack.pop();
				return true;
			}
			if(closing.equals(')') && stack.getData(stack.length()-1).equals('(')) {
				stack.pop();
				return true;
		
		
			}if(closing.equals(']') && stack.getData(stack.length()-1).equals('[')) {
				stack.pop();
				return true;
		
		
			} 
			if(closing.equals('}') && !stack.getData(stack.length()-1).equals('{')) {
			
				return false; 
			}
			if(closing.equals(')') && !stack.getData(stack.length()-1).equals('(')) {
				

				return false; 
			}
			if(closing.equals(']') && !stack.getData(stack.length()-1).equals('[')) {
				

				return false; 
			}
			
			
			
			
			
			} 
			
			
			
			
			
			
			
			if (stack.length() < 1) {
			System.out.println("Error, missing opening to " + closing + ". Recognized at " + counter);
				return false; 
			}
			
		
		return false; 
		
		}


}
		
		
		
		
		
		

