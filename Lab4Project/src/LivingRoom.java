import java.util.ArrayList;

public class LivingRoom extends State {

	public LivingRoom(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	public TheState choice(int choice) {
		if (choice == 1) {
			return TheState.Save;
		}
		if (choice == 2) {
			getModel().setCurrentState(TheState.Kitchen);
			return TheState.Kitchen;
		}
		if (choice == 3) {
			getModel().setCurrentState(TheState.Bedroom);

			return TheState.Bedroom;
		}
		if (choice == 4) {
			getModel().setCurrentState(TheState.CabinPorch);

			return TheState.CabinPorch;
		}
		return TheState.CabinLivingRoom;
	}

	public void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Walk through door 1");
		menu.add(". Walk through door 2");
		menu.add(". Go onto the porch");

	}

	public void setMessage(ArrayList<String> message) {
		message.clear();
		if (getModel().getHasSnowmobileKey() == false && getModel().getHasSnowmobileKey() == false) {
			message.add("The house is empty. Two doors lay at opposite ends of the living room.");
			message.add("Pieces of the door are scattered around the room.");

		} else {
			message.add("You stand in the living room");
		}

	}

}
