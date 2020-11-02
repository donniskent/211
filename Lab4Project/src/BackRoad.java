import java.util.ArrayList;

public class BackRoad extends State {

	public BackRoad(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	TheState choice(int choice) {
		// TODO Auto-generated method stub

		return TheState.Solved;
	}

	public void setMenu(ArrayList<String> menu) {

	}

	public void setMessage(ArrayList<String> message) {
		message.add(
				"You begin your path throught the woods. It is extremely dark, you can only see 10 feet in front of yourself.");
		message.add("You're moving right along when something catches your attention out of the corner of your eye.");
		message.add("You turn around and shine your lights in the direction of the object your saw.");
		message.add(
				"With the light of the moon shining over top of the forrest, you see a set of eyes staring back at you.");
		message.add("Horrified, your eyes readjust and you realize that you are looking at a mutilated body");
		message.add(
				"You find another body further up the road. You think the bodies were likely victims of a Grizzly bear attack. ");

		if (getModel().getSeenPicture() == true) {
			message.add("You quickly realize that these are the bodies of the people from the picture in the bedroom!");

		}
		message.add(
				"The thought no more than enters your mind when you are swept off your feet. You are the grizzly bear's next victim.");
		message.add(
				"It thrashes and mauls you, throwing you around like a rag-doll. You feel the blood soaking up imside your shirt. ");
		message.add(
				"For what seems like an eternity, the bear continues to eat you alive. You plead with God to kill you.");
		message.add("You think of your dad, this nightmare of a trip and how you will deeply miss your family...");

		if (getModel().getHasGun() == true) {
			message.add("You then remember the Glock you took off the pilots hip.");
			message.add(
					"If you could get the bear off of you long enough to unholster the gun, you could make the living hell cease.");
			message.add(
					"You play dead and minutes later the bear turns away from you. This seems like the perfect time to try.");
			message.add("Slowly, you unholster the gun and click off the saftey.");
			message.add(
					"You fire the entire magazine into the Grizzly, it calls out into the dark Alaskan night, then");
			message.add(
					" begins to pounce on you for what seems like an eternity, before falling down without movement.");
			message.add("The stillness of the forest is eery. There is no more chaos.");
			message.add("You lay in the cold blood soaked snow. Your body aches and burns.");
			message.add("You sheepishly crawl back to the snowmobile, wincing in pain as you climb back on the seat.");
			message.add("You turn the key and continue on the trail to find civilzation.");
			message.add("You finally make it into town and collapse in the ER.");
			message.add(
					"You awake the next day in a hospital gown laying in bed. A nuse walks in explains that you had emergency surgery to close your wounds.");
			message.add(
					"You explain to both the police and doctors what had happened to you and they head to the crash site to investigate.");
			message.add("You lay in bed, thinking about how the fate of the old couple could have easily been yours.");
			message.add(
					"Thankful to be alive, you vow to never fly again. The trauma of this trip will stay with you forever");
			message.add("Game over.");
			message.add("You win.");

		}
		if (getModel().getHasGun() == false) {

			message.add("Game over.");
			message.add("You lose");
		}

	}

}
