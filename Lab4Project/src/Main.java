import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.go();

	}

	public void go() {
		Model model = new Model();
		State [] states = new State[9];
		MiddlePlane middlePlane = new MiddlePlane(model);
		Cockpit cockpit = new Cockpit(model);
		states[0] = middlePlane;
		states[1] = cockpit;
		int answer;
		TheState currentState = model.getCurrentState();
		while(!currentState.equals(TheState.Solved)) {
			
			if(currentState.equals(TheState.MiddlePlane)) {
				states[0].setMenu(states[0].getMenu());
				states[0].setMessage(states[0].getMessage());
			View middlePlaneView = new View(states[0]);
			middlePlaneView.printCurrentMessage();
			middlePlaneView.printMenu();
			answer = input(1,3);
			currentState = states[0].choice(answer); } 
			
			if(currentState.equals(TheState.CockPit)) {
				states[1].setMenu(states[1].getMenu());
				states[1].setMessage(states[1].getMessage());
				View cockPitView = new View(states[1]);
				cockPitView.printCurrentMessage();
				cockPitView.printMenu();
				answer = input(1,4);
				currentState = states[1].choice(answer);
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
			}}
		
		
		
		
		
		
		// general algorithm 
		// 1. Identify which subclass we are working out of 
		// 2. display the appropriate menu for that subclass
		// 3. Get the users input for their move 
		// 4.
		
	
		//while(!dead || !escaped)
		
		// while theState =  "middle plane" 
		// { 
		//   1. Print message for the state. 
		//   2. Print out the menu 
		//	 3. Get the users input 
		//	 4. Return the changed or same enum theState
		//   5. Update the model class
		//}
	
	
	
	
	
	
	

	public int input (int start, int end) {
		Scanner scan = new Scanner(System.in);
		int answer = -1; 
		try {
			answer = scan.nextInt();
			if(start < end && answer >= start && answer <= end ) {
			return answer; }
			else {
				System.out.println("Answer must be within bounds.");
			return input(start, end);
			}
		}
	catch(Exception e) {
		System.out.println("Invalid input. please enter a valid input.");
		return input(start, end);
		
	}
	
	
	}



}
