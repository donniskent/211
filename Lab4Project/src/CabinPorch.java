import java.util.ArrayList;

public class CabinPorch extends State{

	public CabinPorch(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	
	TheState choice(int choice) {
		if(choice == 1) {
			return TheState.Save;
		}
	if (choice == 2) {
		return TheState.OutsidePlane;
		
	} 
	if(choice == 3) {
		return TheState.SnowMobile;
	}
	if(choice == 4 && getModel().getHasHatchet() == true) {
		return TheState.CabinLivingRoom;
	}
	if(choice == 5) {
		return TheState.WoodPile;
		
	}
	return TheState.CabinPorch;
	}

	
	void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Approach the Plane");
		menu.add(". Get on Snowmobile");
		menu.add(". Enter Cabin");
		menu.add(". Go to woodpile");
		
		
		
		
	}

	
	void setMessage(ArrayList<String> message) {
		if(getModel().getHasHatchet() == false) {
		message.clear();
		message.add("You step on the porch and knock on the door. Nobody answers.");
		message.add("You try to open the door. It is locked.");
		message.add("You check the porch for a key, however you can't find one.");
		message.add("You think of new ways to get into the house.");
		}
		if(getModel().getHasHatchet() == true) {
		message.clear();
		message.add("Standing on the porch with the hatchet in your hand, ");
		message.add("you ponder once more if you should enter the house by force.");
		message.add("If the home owner were to catch you, you would likely be killed.");
			
		}
	
	
	
	}

}
