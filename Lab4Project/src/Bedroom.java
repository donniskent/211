import java.util.ArrayList;

public class Bedroom extends State{

	public Bedroom(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	
	TheState choice(int choice) {
		if(choice == 1) {
			return TheState.Save;
		} 
		if(choice == 2) {
			return TheState.CabinLivingRoom;
		}
	return TheState.Bedroom;
	}

	
	void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Exit the bedroom.");
		
	}

	
	void setMessage(ArrayList<String> message) {
		getModel().setSeenPicture(true);
		message.clear();
		message.add("Stepping into the bedroom, you see a neatly made bed.");
		message.add("On the night stand, there is a picture of an elderly couple.");
		message.add("The man had a large beard and the lady was blonde.");
		message.add("Looking around the room, you don't see anything important or useful.");
		
	}

}
