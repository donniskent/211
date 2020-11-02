import java.util.ArrayList;

public class MainRoad extends State {

	public MainRoad(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	public TheState choice(int choice) {
		// TODO Auto-generated method stub
		return TheState.Solved;
	}

	public void setMenu(ArrayList<String> menu) {
		// TODO Auto-generated method stub

	}

	public void setMessage(ArrayList<String> message) {
		message.add("You begin driving down the road.");
		if (getModel().getHasGas() == false) {
			message.add(
					"Your gas gauge continues to dwindle down. You being to wonder if you should've filled up before you left.");
			message.add("A few miles into your journey, the snowmobile spits, stutters and shuts off.");
			message.add("You've run out of gas. You hop off the snowmobile and begin walking");
			message.add(
					"You don't pass another person the entire walk. A couple hours pass and you begin to feel week and tired");
			message.add(
					"You decide to lay down and rest for a little bit. A heavy snow falls from the dark Alaskan sky.");
			message.add(
					"You fall asleep and never wake up. You froze to death in your sleep, your body covered in the  evening's snow.");
			message.add("Your body is never found.");
			message.add("Game over.");
			message.add("You lose.");
		}
		if (getModel().getHasGas() == true) {
			message.add("A few hours into your ride, you start seeing lights. It seems you have found a town.");
			message.add("Pulling into the town, you find the closest hospital and head in. You've made it.");
			message.add("You survived the plane crash. You get the police to investigate the crash site.");
			message.add(
					"You realize things are going to be okay. You decide it is time to catch up on sleep to help you recover.");
			message.add("You reminsice over the nightmare of a trip. You miss your dad, you miss your family.");
			message.add(
					"Vowing to dedicate your life to their wellbeing, you know the will of your father has been done.");
			message.add("Game over.");
			message.add("You win.");
		}
	}

}
