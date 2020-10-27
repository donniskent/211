import java.util.ArrayList;

public class MainRoad extends State{

	public MainRoad(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	TheState choice(int choice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void setMenu(ArrayList<String> menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setMessage(ArrayList<String> message) {
		message.add("You begin driving down the road.");
		if(getModel().getHasGas() == false) {
			message.add("Your gas gauge continues to dwindle down. You being to wonder if you should turn around.");
		}
		if(getModel().getHasGas() == true) {
			message.add("30 minutes into your ride you start seeing lights. It seems you have found a town.");
			message.add("Pulling into the town, you find the closest hospital and head in. You've made it.");
			message.add("You survived the plane crash. You shortly get the police to investigate the crash site.");
			message.add("You realize things are going to be okay. You decide it is time to catch up on sleep to help you recover.");
			message.add("You win.");
		}
	}

}
