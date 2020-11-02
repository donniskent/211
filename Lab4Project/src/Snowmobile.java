import java.util.ArrayList;

public class Snowmobile extends State {

	public Snowmobile(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	public TheState choice(int choice) {
		if (choice == 1) {
			getModel().setCurrentState(TheState.SnowMobile);
			return TheState.SnowMobile;
		}
		if (choice == 2) {
			getModel().setCurrentState(TheState.CabinPorch);

			return TheState.CabinPorch;
		}
		if (choice == 3) {
			getModel().setCurrentState(TheState.WoodPile);

			return TheState.WoodPile;
		}
		if (choice == 4) {
			getModel().setCurrentState(TheState.OutsidePlane);

			return TheState.OutsidePlane;
		}
		if (choice == 5 && getModel().getHasSnowmobileKey() == true) {
			getModel().setCurrentState(TheState.MainRoad);

			return TheState.MainRoad;
		}
		if (choice == 6 && getModel().getHasSnowmobileKey() == true && getModel().getHasMap() == true) {
			getModel().setCurrentState(TheState.OffRoad);

			return TheState.OffRoad;
		}
		return TheState.SnowMobile;
	}

	public void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Go to house ");
		menu.add(". Go to woodpile");
		menu.add(". Approach plane");
		if (getModel().getHasSnowmobileKey() == true) {
			menu.add(". Drive down the road");
		}
		if (getModel().getHasMap() == true) {
			menu.add(". Drive down the wooded path.");
		}
	}

	public void setMessage(ArrayList<String> message) {
		message.clear();
		message.add("You hop on the Snowmobile.");
		if (getModel().getHasSnowmobileKey() == false) {
			message.add("You thought this would be your great escape, however there's no key in the ignition.");
			message.add("You decide the key is probably somewhere in the house");

		}
		if (getModel().getHasSnowmobileKey() == true) {
			message.add("You turn the key and the snowmobile cranks over. The gas gauge is low. ");
			message.add("The main road is on your mind. You believe it can lead you to civilization.");
		}
		if (getModel().getHasGas() == false && getModel().getHasSnowmobileKey() == true) {
			message.add("you hope that you have enough gas to find someone to help you");
		}

		if (getModel().getHasGas() == true && getModel().getHasSnowmobileKey() == true) {
			message.add("Luckily, you brought that gas can with you. You top the tank off.");
		}

		if (getModel().getHasSnowmobileKey() == true && getModel().getHasMap() == true) {
			message.add("You take a look at the map and realize there is a second shorter path to");
			message.add(" civilization. It cuts through the thick pine forrest behind the house.");
			message.add("You ponder which route you should take (the short cut is 10 miles quicker)");
		}

	}

}
