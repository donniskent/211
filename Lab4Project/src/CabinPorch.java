import java.util.ArrayList;

public class CabinPorch extends State {

	public CabinPorch(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	public TheState choice(int choice) {
		if (choice == 1) {
			return TheState.CabinPorch;
		}
		if (choice == 2) {
			getModel().setCurrentState(TheState.OutsidePlane);
			return TheState.OutsidePlane;

		}
		if (choice == 3) {
			getModel().setCurrentState(TheState.SnowMobile);
			return TheState.SnowMobile;
		}
		if (choice == 4 && getModel().getHasHatchet() == true) {
			getModel().setCurrentState(TheState.CabinLivingRoom);
			getModel().setDoorBroken(true);
			return TheState.CabinLivingRoom;
		}
		if (choice == 5) {
			getModel().setCurrentState(TheState.WoodPile);

			return TheState.WoodPile;

		}
		return TheState.CabinPorch;
	}

	public void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Approach the Plane");
		menu.add(". Get on Snowmobile");
		menu.add(". Enter Cabin");
		menu.add(". Go to woodpile");

	}

	public void setMessage(ArrayList<String> message) {
		message.clear();
		if (getModel().getDoorKnock() == false && getModel().getDoorBroken() == false) {
			getModel().setDoorKnock(true);

			message.add("You step on the porch and knock on the door. Nobody answers.");
			message.add("You try to open the door. It is locked.");

			message.add("You check the porch for a key, however you can't find one.");
			if (getModel().getHasHatchet() == false) {
				message.add("You think of new ways to get into the house.");
			}
		}
		if (getModel().getDoorKnock() == true && getModel().getDoorBroken() == false) {

			if (getModel().getHasHatchet() == false) {
				message.add("You're on the porch.Still nobody answers the door. You think of ways to get in.");

			}

		}
		if (getModel().getHasHatchet() == true && getModel().getDoorBroken() == false) {
			message.add("Standing on the porch with the hatchet in your hand, ");
			message.add("you ponder once more if you should enter the house by force.");
			message.add("If the home owner were to catch you, you would likely be killed.");
		}

		if (getModel().getDoorBroken() == true) {
			message.add("You're on the porch, pieces of the busted door laying around you");

		}

	}

}
