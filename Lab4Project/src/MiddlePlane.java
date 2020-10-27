import java.util.ArrayList;

public class MiddlePlane extends State{
	
	
	
	public MiddlePlane(Model model) {
		 super(model);
	
		 // TODO Auto-generated constructor stub
	}


	public TheState choice(int choice) {
		
		if(choice == 1 ) {
			return TheState.Save;
		}
		if(choice == 2 && (getModel().getDoorKeys() == true)) {
			return TheState.OutsidePlane;
			
		}
		if(choice == 3) {
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
		
	}
	
	
	

	//check answer method 
	
	
}
