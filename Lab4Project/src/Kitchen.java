import java.util.ArrayList;

public class Kitchen extends State{

	public Kitchen(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	
	TheState choice(int choice) {
		if (choice == 1) {
			return TheState.Save;
		}
		if(choice == 2) {
			return TheState.CabinLivingRoom;
		}
 		
		if (choice == 3) {
			if (getModel().getHasMap() == false) {
				getModel().setHasMap(true);
				return TheState.Kitchen;
			}
			if (getModel().getHasMap() == true) {
				getModel().setHasSnowmobileKey(true);;
				return TheState.Kitchen;
			}
		}
		if(choice == 4 && getModel().getHasSnowmobileKey() == false) {
			getModel().setHasSnowmobileKey(true);
			
			return TheState.Kitchen;
			
		}
		return TheState.Kitchen;
	
	}

	
	void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Go into the living room");
		if(getModel().getHasMap() == false) {
		menu.add(". Pick up the Map"); }
		if(getModel().getHasSnowmobileKey() == false) {
		menu.add(". Grab the keys"); }
		
	}

	
	void setMessage(ArrayList<String> message) {
		message.clear();
		message.add("Stepping into the kitchen, you notice there is no food in the fridge or pantry.");
		if(getModel().getHasMap() == false) {
		message.add("You see a map setting on the counter."); }
		if(getModel().getHasSnowmobileKey() == false) {
		message.add("There are keys hanging on the wall. " ); }
		
	}

}
