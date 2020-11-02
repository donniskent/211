
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.go();

	}

	public void go() {
		Model model = new Model();
		System.out.println("Welcome!");
		System.out.println("1. New Game");
		System.out.println("2. Resume Game");
		Scanner scan = new Scanner(System.in);
		try {
			while (true) {
				String ans = scan.next();
				if (ans.equals("1")) {
					System.out.println("It was supposed to be a great weekend with your dad. ");
					System.out.println(
							"You have been saving for many years to fly to Alaska to go salmon fishing together.");
					System.out.println(
							"It had been his life dream to go on this trip, and it was your dream to make it happen.");
					System.out.println(
							"However, the dream quickly turned into a nightmare. Less than a mile away from the airport you were ");
					System.out.println(
							"supposed to land at, your plane hit heavy turbulence and created strucural damage to the wings.");
					System.out.println(
							"Before you knew it, the plane was falling quickly. The pilot told you and your dad to strap in.");
					System.out.println("The last thing you remember before impact was the look on your father's face.");
					System.out.println(
							"You woke up hours later. Your father was dead. You called out for help but got no response.");
					System.out.println(
							"You're all alone, stuck in the Alaskan wilderness. You spend some time sulking before ");
					System.out.println("realizing your father would want you to be strong and survive.");
					System.out.println(
							"You have a family at home to take care of, you have priorties and reasons to live.");
					System.out.println(
							"You unstrap your seatbelt and look out the window. By the grace of God, you see a cabin. ");
					System.out.println(
							"Your luck may not have completely run out. Your first task is to exit the mangled plane.");

					break;
				}
				if (ans.equals("2")) {
					loadFile(model);
					break;
				} else {
					System.out.println("enter 1 or 2");
					continue;
				}

			}

		} catch (Exception e) {

		}

		State[] states = new State[11];
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
		
		
		while (!currentState.equals(TheState.Solved)) {

			if (currentState.equals(TheState.MiddlePlane)) {

				currentState = makeMove(states[0], model);

			}

			if (currentState.equals(TheState.CockPit)) {

				currentState = makeMove(states[1], model);

			}
			if (currentState.equals(TheState.OutsidePlane)) {
				currentState = makeMove(states[2], model);

			}
			if (currentState.equals(TheState.CabinPorch)) {
				currentState = makeMove(states[3], model);

			}
			if (currentState.equals(TheState.SnowMobile)) {
				currentState = makeMove(states[4], model);

			}
			if (currentState.equals(TheState.CabinLivingRoom)) {
				currentState = makeMove(states[5], model);

			}
			if (currentState.equals(TheState.WoodPile)) {
				currentState = makeMove(states[6], model);

			}
			if (currentState.equals(TheState.Kitchen)) {
				currentState = makeMove(states[7], model);

			}

			if (currentState.equals(TheState.Bedroom)) {
				currentState = makeMove(states[8], model);

			}

			if (currentState.equals(TheState.MainRoad)) {
				states[9].setMessage(states[9].getMessage());
				View view = new View(states[9]);
				view.printCurrentMessage();
				currentState = TheState.Solved;
			}

			if (currentState.equals(TheState.OffRoad)) {
				states[10].setMessage(states[10].getMessage());
				View view = new View(states[10]);
				view.printCurrentMessage();
				currentState = TheState.Solved;

			}

		}
		System.out.println("out of loop");
		System.out.println(model.getCurrentState());

	}

	
	public TheState makeMove(State state, Model model) {

		state.setMenu(state.getMenu());
		state.setMessage(state.getMessage());
		View view = new View(state);
		view.printCurrentMessage();
		view.printMenu();
		int answer = input(1, state.getMenu().size());
		if (answer == 1) {
			writeFile(model);
			return TheState.Solved;
		}

		TheState currentState = state.choice(answer);
		return currentState;
	}

	public int input(int start, int end) {
		Scanner scan = new Scanner(System.in);
		int answer = -1;
		try {
			answer = scan.nextInt();
			if (start < end && answer >= start && answer <= end) {
				return answer;
			} else {
				System.out.println("Answer must be within bounds.");

				return input(start, end);
			}
		} catch (Exception e) {
			System.out.println("Invalid input. please enter a valid input.");
			return input(start, end);

		}

	}

	public void writeFile(Model model) {
		String saved = model.save();
		File newFile = new File("save.dat");
		PrintWriter writer;
		try {
			writer = new PrintWriter(newFile);
			writer.println(saved);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not write file");
			return;
		}

	}

	public void loadFile(Model model) {
		try {
			Scanner file = new Scanner(new File("save.dat"));
			model.load(file.nextLine());
			file.close();

		} catch (Exception e) {
			System.out.println("couldnt open");

		}
	}

}
