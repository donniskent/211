import java.util.ArrayList;

public class OutsidePlane extends State{

	public OutsidePlane(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TheState choice(int choice) {
		if(choice == 1) {
			return TheState.Save; 
		} 
		if (choice == 2) {
			return TheState.CabinPorch;
		}
		if (choice == 3) {
			return TheState.SnowMobile;
		}
		if(choice == 4) {
			return TheState.WoodPile;
			
		}
		if(choice == 5) {
			return TheState.MiddlePlane;
		}
		
	return TheState.OutsidePlane;
	}

	@Override
	public void setMenu(ArrayList<String> menu) {
		menu.clear();
		menu.add(". Save and quit");
		menu.add(". Go to house ");
		menu.add(". Go to snowmobile");
		menu.add(". Go to woodpile");
		menu.add(". Go into Plane");
		
	}

	@Override
	public void setMessage(ArrayList<String> message) {
		message.clear();
		message.add("The brightness of the sun blinds you momentarily.");
		message.add("As they readjust you notice 3 things. Firstly, there is a cabin no more than ");
		message.add("100 yards from the plane. In front of the cabin is a snow covered snowmobile, and");
		message.add(" beside the house lays some chopped wood and a hatchet. in front of the house is an icy road.");
		
		
		
	}

}
