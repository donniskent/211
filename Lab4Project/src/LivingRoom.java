import java.util.ArrayList;

public class LivingRoom extends State{

	public LivingRoom(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	
	TheState choice(int choice) {
		if(choice == 1) {
			return TheState.Save;
		}
		if (choice == 2) {
			return TheState.Kitchen;
		}
		if (choice == 3) {
			return TheState.Bedroom;
		}
		if (choice == 4) {
			return TheState.CabinPorch;
		}
		return TheState.CabinLivingRoom;
	}

	
	void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Walk through door 1");
		menu.add(". Walk through door 2");
		menu.add(". Go onto the porch");
		
	}

	
	void setMessage(ArrayList<String> message) {
		message.clear();
		message.add("The door is busted down. Stepping into the house, it seems that nobody has been home for a while.");
		message.add("It is freezing cold inside and the electricity has been shut off.");
		message.add("There are two doorways to walk through at opposite sides of the living room");
		
	}

}
