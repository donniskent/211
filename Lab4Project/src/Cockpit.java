import java.util.ArrayList;

public class Cockpit extends State {

	public Cockpit(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	public TheState choice(int choice) {

		if (choice == 1) {
			return TheState.CockPit;
		}
		if (choice == 2) {
		
			return TheState.MiddlePlane;
		}

		if (choice == 3) {
			if ((getModel().getDoorKeys() == false )) {
				getModel().setHasDoorKeys(true);
			

				return TheState.CockPit;
			}

			if (getModel().getDoorKeys() == true && getModel().getHasGun() == false) {
				getModel().setHasGun(true);
			
				return TheState.CockPit;
			}

		}
		if (choice == 4) {
			getModel().setHasGun(true);
			return TheState.CockPit;
		}
		return TheState.CockPit;
	}

	public void setMenu(ArrayList<String> menu) {
		if (getModel().getDoorKeys() == true && getModel().getHasGun() == false) {
			menu.clear();
			menu.add(". Save and quit.");
			menu.add(". Go to the middle of the plane.");
			menu.add(". Grab the gun and hollster.");

		}
		if (getModel().getDoorKeys() == false && getModel().getHasGun() == true) {
			menu.clear();
			menu.add(". Save and quit.");
			menu.add(". Go to the middle of the plane.");
			menu.add(". Pull the keys from the ignition.");

		}
		if (getModel().getDoorKeys() == true && getModel().getHasGun() == true) {
			menu.clear();
			menu.add(". Save and quit.");
			menu.add(". Go to the middle of the plane.");

		}
		if (getModel().getDoorKeys() == false && getModel().getHasGun() == false) {
			menu.clear();
			menu.add(". Save and quit.");
			menu.add(". Go to the middle of the plane.");
			menu.add(". Pull the keys from the ignition.");
			menu.add(". Grab the gun and hollster.");
		}

	}

	public void setMessage(ArrayList<String> message) {
		message.clear();
		if (getModel().getDoorKeys() == false && getModel().getHasGun() == false) {

			message.add("You're in the cockpit. You quickly notice the pilot is dead and the keys");
			message.add("are still in the ignition. You also notice his Glock 20 is still in its hollster");
			message.add("on his side. ");
		}
		if (getModel().getDoorKeys() == true && getModel().getHasGun() == false) {

			message.add("You're still in the cockpit. The gun still lays on the hip of the deceased pilot.");

		}
		if (getModel().getDoorKeys() == false && getModel().getHasGun() == true) {

			message.add(
					"You're still in the cockpit. The Glock is now strapped to your side, the keys still stuck in the ignition.");

		}
		if (getModel().getDoorKeys() == true && getModel().getHasGun() == true) {

			message.add(
					"With the keys in your pocket and Glock on your hip, nothing but the pilot's body remain in the cockpit");

		}
	}

}
