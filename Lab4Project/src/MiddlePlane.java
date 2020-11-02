import java.util.ArrayList;

public class MiddlePlane extends State {

	public MiddlePlane(Model model) {
		super(model);

		// TODO Auto-generated constructor stub
	}

	public TheState choice(int choice) {

		if (choice == 1) {
			return TheState.MiddlePlane;
		}
		if (choice == 2 && (getModel().getDoorKeys() == true)) {
			getModel().setCurrentState(TheState.OutsidePlane);
			return TheState.OutsidePlane;

		}
		if (choice == 3) {
			getModel().setCurrentState(TheState.CockPit);
			return TheState.CockPit;
		}

		return TheState.MiddlePlane;

	}

	public void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save game and quit");
		menu.add(". Go outside");
		menu.add(". Go to cockpit");

	}

	public void setMessage(ArrayList<String> message) {
		message.clear();
		message.add("Standing in the middle of the plane, you see two doors.");
		message.add("The first door leads outside. The other to the cockpit.");
		if (getModel().getDoorKeys() == false) {
			message.add("The door leading outside is locked");
		}
		if (getModel().getDoorKeys() == true) {
			message.add("With the keys in your hand, you can unlock the door. ");
		}
	}

}
