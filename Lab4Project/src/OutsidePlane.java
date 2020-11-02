import java.util.ArrayList;

public class OutsidePlane extends State {

	public OutsidePlane(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	public TheState choice(int choice) {
		if (choice == 1) {
			return TheState.Save;
		}
		if (choice == 2) {
			getModel().setCurrentState(TheState.CabinPorch);
			return TheState.CabinPorch;
		}
		if (choice == 3) {
			getModel().setCurrentState(TheState.SnowMobile);

			return TheState.SnowMobile;
		}
		if (choice == 4) {
			getModel().setCurrentState(TheState.WoodPile);

			return TheState.WoodPile;

		}
		if (choice == 5) {
			getModel().setCurrentState(TheState.MiddlePlane);

			return TheState.MiddlePlane;
		}

		return TheState.OutsidePlane;
	}

	public void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Go to house ");
		menu.add(". Go to snowmobile");
		menu.add(". Go to woodpile");
		menu.add(". Go into Plane");

	}

	public void setMessage(ArrayList<String> message) {

		message.add("You're just outside the plane.");
		message.add("There is a cabin no more than ");
		message.add("100 yards from the plane. In front of the cabin is a snow covered snowmobile, and ");
		message.add("beside the cabin lays some chopped wood and a hatchet. Behind the cabin is an icy road.");

	}

}
