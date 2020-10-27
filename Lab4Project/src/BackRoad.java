import java.util.ArrayList;

public class BackRoad extends State {

	public BackRoad(Model model) {
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
		message.add("You begin your path throught the woods. It is extremely dark, you can only see 10 feet in front of yourself.");
		if(getModel().getHasGas() == false) {
			message.add("Your gas gauge is moving closer and closer to E. You think once more if you should turn around.");
		}
		if(getModel().getHasGas() == true) {
			message.add("You're moving right along when something catches your attention out of the corner of your eye.");
			message.add("You turn around and shine your lights in the direction of the object your saw.");
			message.add("You walk up to the figure and realize it is a dead body. You see another no more than 20 feet from there.");
			message.add("You flip the bodies over and realize that they have been mauled by a bear");
			if(getModel().getSeenPicture() == true) {
			message.add("You quickly realize that these are the bodies of the people from the picture in the bedroom!");
			message.add("This freaks you out, you turn around to get back on the snowmobile but you are quickly hit by what feels like a car.");
			message.add("A 10 feet grizzly bear towers over you. He begins mauling you and tossing you like a ragdoll");
			if(getModel().getHasGun() == true) {
				message.add("You pull the pistol from its holster and fire the entire magazine into the Grizzly.");
				message.add("He continues to pounce on you for what seems like an eternity, before falling down without movement.");
				message.add("You lay in the cold blood soaked snow. Some time passes and you crawl back to the snowmobile.");
				message.add("You turn the key and continue on the trail to find civilzation.");
				message.add("You finally make it into town and collapse in the ER.");
				message.add("You awake the next day in a hospital gown laying in bed. A nuse walks in explains that you had emergency surgery to close your wounds.");
				message.add("You explain to both the police and doctors what had happened to you and they head to the crash site to investigate.");
				message.add("You lay in bed, thinking about how the fate of the old couple could have easily been yours.");
				message.add("Thankful to be alive, you vow to never fly again.");
				message.add("Game over.");
				message.add("You win.");
			}
			}
		}
	
	}

}
