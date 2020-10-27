
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.go();

	}

	public void go() {
		Model model = new Model();
		State [] states = new State[11];
		MiddlePlane middlePlane = new MiddlePlane(model);
		Cockpit cockpit = new Cockpit(model);
		OutsidePlane outsidePlane = new OutsidePlane(model);
		CabinPorch cabinPorch = new CabinPorch(model);
		Snowmobile snowmobile = new Snowmobile(model);
		LivingRoom livingRoom = new LivingRoom(model);
		Woodpile woodPile = new Woodpile(model);
		Kitchen kitchen = new Kitchen(model);
		Bedroom bedroom = new Bedroom(model);
		MainRoad mainRoad = new MainRoad(model);
		BackRoad backRoad = new BackRoad(model);
		states[0] = middlePlane;
		states[1] = cockpit;
		states[2] = outsidePlane;
		states[3] = cabinPorch;
		states[4] = snowmobile;
		states[5] = livingRoom;
		states[6] = woodPile;
		states[7] = kitchen;
		states[8] = bedroom;
		states[9] = mainRoad;
		states[10] = backRoad;
		TheState currentState = model.getCurrentState();
		TheState saveState = TheState.MiddlePlane;
		while(!currentState.equals(TheState.Solved)) {
			
			if(currentState.equals(TheState.MiddlePlane)) {
				currentState = makeMove(states[0]);
				saveState = TheState.MiddlePlane;
			} 
			
			if(currentState.equals(TheState.CockPit)) {
				currentState = makeMove(states[1]);
			}
			if(currentState.equals(TheState.OutsidePlane)) {
				currentState = makeMove(states[2]);
			}
			if(currentState.equals(TheState.CabinPorch)) {
				currentState = makeMove(states[3]);
			}
			if(currentState.equals(TheState.SnowMobile)) {
				currentState = makeMove(states[4]);
			}
			if(currentState.equals(TheState.CabinLivingRoom)) {
				currentState = makeMove(states[5]);
			}
			if(currentState.equals(TheState.WoodPile)) {
				currentState = makeMove(states[6]);
			}
			if(currentState.equals(TheState.Kitchen)) {
				currentState = makeMove(states[7]);
			}
		
			if(currentState.equals(TheState.Bedroom)) {
				currentState = makeMove(states[8]);
			}

			if(currentState.equals(TheState.MainRoad)) {
				currentState = makeMove(states[9]);
			}

			if(currentState.equals(TheState.OffRoad)) {
				currentState = makeMove(states[10]);
			}
			
		
		
		
		
		
			}
	
	
	
	}
		
		
		
		
		
		
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
	
	
	
	
	
	
	
	public TheState makeMove(State state) {
		
		state.setMenu(state.getMenu());
		state.setMessage(state.getMessage());
		View view = new View(state);
		view.printCurrentMessage();
		view.printMenu();
		int answer = input(1,state.getMenu().size());
		if(state.choice(answer) == TheState.Save ) {
		
		
		}
		
		
		TheState currentState = state.choice(answer);
		return currentState;
	}
	
	
	
	
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
