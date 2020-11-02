import java.util.ArrayList;

public class Woodpile extends State {

	public Woodpile(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	TheState choice(int choice) {
		if (choice == 1) {
			getModel().setCurrentState(TheState.WoodPile);
			return TheState.WoodPile;
		}
		if (choice == 2) {
			getModel().setCurrentState(TheState.OutsidePlane);
			return TheState.OutsidePlane;
		}
		if (choice == 3) {
			getModel().setCurrentState(TheState.CabinPorch);
			return TheState.CabinPorch;
		}
		if (choice == 4) {
			getModel().setCurrentState(TheState.SnowMobile);
			return TheState.SnowMobile;
		}

		if (choice == 5) {
			if (getModel().getHasHatchet() == false) {
				getModel().setHasHatchet(true);
				getModel().setCurrentState(TheState.WoodPile);
				return TheState.WoodPile;
			}
			if (getModel().getHasHatchet() == true) {
				getModel().setHasGas(true);
				getModel().setCurrentState(TheState.WoodPile);
				return TheState.WoodPile;
			}

		}

		if (choice == 6 && getModel().getHasHatchet() == false) {
			getModel().setHasGas(true);
			getModel().setCurrentState(TheState.WoodPile);
			return TheState.WoodPile;
		}

		return TheState.WoodPile;
	}

	public void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Approach plane");
		menu.add(". Go to porch");
		menu.add(". Go to the snowmobile");
		if (getModel().getHasHatchet() == false) {
			menu.add(". Pick up the hatchet");
		}
		if (getModel().getHasGas() == false) {
			menu.add(". Pick up the gas can");
		}

	}

	public void setMessage(ArrayList<String> message) {
		message.clear();
		if (getModel().getHasGas() == false) {
			message.add("A can of gas sits beside the woodpile.");
		}
		if (getModel().getHasHatchet() == false) {
			message.add("There is a hatchet stuck in a rotten log.");
		}
		if (getModel().getHasHatchet() == true && getModel().getHasGas() == true) {
			message.add("Only the rotten wood remains in the area.");
		}
	}

}
