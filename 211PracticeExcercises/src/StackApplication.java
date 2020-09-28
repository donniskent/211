import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class StackApplication {

	// get file from user
	// while file has next line {
	// for each char in the line {
	// if (char == "{ || ( || [ " )
	// push char to stack }
	// if ( char is not same type as top of stack, but is closing {
	// throw error }
	// if (char == closing char && top of stack = opening char (of same type char) )
	// {
	// pop top of stack }
	//
	// }} out of while loop
	// if (stack is not empty) {
	// throw error }
	//

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackApplication obj = new StackApplication();
		obj.go();
	}

	public void go() {
		Stack<Character> stack = new StackImplementation<Character>();
		File file = getFile();
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to open file");
		}

		Character currentChar = ' ';
		int counter = 0;
	String answer = "";
		boolean stop = false;
		while (fileScan.hasNextLine()) {
			counter+=1;
			String line = fileScan.nextLine();
			for(int i = 0; i < line.length(); i++) {
				currentChar = line.charAt(i);
			if(checkCharOpening(currentChar) == true) {
					stack.push(currentChar);
					continue;
			}
		
				if(checkCharClosing(currentChar) == true) {
					if(stack.isEmpty()) {
						answer = "Missing an opening to " + currentChar + "recognized on line " + counter; 
					stop = true;
					break;
					}
				boolean compare = compareOpenClose(currentChar,stack);
					if(compare == true) {
						continue;
					}
					if(compare == false) {
						answer = "Missing closing to "+ stack.getData(stack.length()-1)+ " or opening to " 
								+ currentChar + ". Recognized on line " + counter;
					stop = true;
					break;
					}
				
				
				}
				
				
				
			}
		
			System.out.println("line " + counter + " " + stack.length());
			if(stop == true) {
				break;
			}
		
		}
		if (!answer.equals("")) {
			System.out.println(answer);
			
		}
		else if (answer.equals("") && !stack.isEmpty()) {
			System.out.println("Missing a closing for ");
			stack.print();
			System.out.println("Reconized at line " + counter);
		}
		
		else {
			System.out.println("No issues reported");
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
		if (currentChar.equals('{') || currentChar.equals('(') || currentChar.equals('[')) {
			return true;
		}

		return false;

	}

	public boolean checkCharClosing(Character currentChar) {
		if (currentChar.equals('}') || currentChar.equals(')') || currentChar.equals(']')) {
			return true;
		}

		return false;
	}

	public boolean compareOpenClose(Character closing, Stack<Character> stack) {
		if (stack.length() < 1) {
			return false;
		}

		
			if (closing.equals('}') && stack.getData(stack.length() - 1).equals('{')) {
				stack.pop();
				return true;
			}
			if (closing.equals(')') && stack.getData(stack.length() - 1).equals('(')) {
				stack.pop();
				return true;

			}
			if (closing.equals(']') && stack.getData(stack.length() - 1).equals('[')) {
				stack.pop();
				return true;

			}
			if (closing.equals('}') && !stack.getData(stack.length() - 1).equals('{')) {

				return false;
			}
			if (closing.equals(')') && !stack.getData(stack.length() - 1).equals('(')) {

				return false;
			}
			if (closing.equals(']') && !stack.getData(stack.length() - 1).equals('[')) {

				return false;
			}

		

		return false;

	}

	


}
