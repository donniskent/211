import java.util.ArrayList;

public class Woodpile extends State{

	public Woodpile(Model model) {
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
		menu.add(". Save and quit");
		menu.add(". Pick up the hatchet");
		menu.add(". Pick up the gas can");
		
	}

	@Override
	void setMessage(ArrayList<String> message) {
		message.clear();
		if(getModel().getHasGas() == false) {
		message.add("Coming up to the woodpile, you notice a can of gas sitting in the corner.");
		}
		if(getModel().getHasHatchet() == false) {
			message.add("There is also a hatchet stuck in a pile of old rotten wood.");
		}
		else {
			message.add("Only the rotten wood remains in the area.");
		}
	}

}
