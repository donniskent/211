import static org.junit.Assert.*;

import org.junit.Test;

public class SnowmobileTest {

	@Test
	public void choiceTest() {
		Model model = new Model();	
		Snowmobile snowmobile = new Snowmobile(model);
		if(!snowmobile.choice(1).equals(TheState.SnowMobile)) {
			fail("When 1, should get snowmobile. Got " + snowmobile.choice(1));
		}
		if(!snowmobile.choice(2).equals(TheState.CabinPorch)) {
			fail("When 2, should get porch. Got " + snowmobile.choice(2));
		}
		if(!snowmobile.choice(3).equals(TheState.WoodPile)) {
			fail("When 3, should get woodpile. Got " + snowmobile.choice(3));
		}
		if(!snowmobile.choice(4).equals(TheState.OutsidePlane)) {
			fail("When 4, should get OutsidePlane. Got " + snowmobile.choice(4));
		}
		if(!snowmobile.choice(5).equals(TheState.SnowMobile)) {
			fail("When 5 and doesnt have key, , should get SnowMobile. Got " + snowmobile.choice(5));
		}
		model.setHasSnowmobileKey(true);
		if(!snowmobile.choice(5).equals(TheState.MainRoad)) {
			fail("When 5 and does have key, , should get mainroad. Got " + snowmobile.choice(5));
		}
		if(!snowmobile.choice(6).equals(TheState.SnowMobile)) {
			fail("When 6 and does have key, but doesnt have map , should get snowmobile. Got " + snowmobile.choice(6));
		}
		model.setHasMap(true);
		if(!snowmobile.choice(6).equals(TheState.OffRoad)) {
			fail("When 6 and does have key and map , should get offroad. Got " + snowmobile.choice(6));
		}
		model.setHasSnowmobileKey(false);
		if(!snowmobile.choice(6).equals(TheState.SnowMobile)) {
			fail("When 6 and doesnt have key but has map , should get snowmobile. Got " + snowmobile.choice(6));
		}
	}
	 @Test
	public void menuTest() {
		Model model = new Model();	
		Snowmobile snowmobile = new Snowmobile(model);
		String answer = "";
		
		// false and false 
		
		snowmobile.setMenu(snowmobile.getMenu());
		for(int i = 0; i < snowmobile.getMenu().size(); i ++) {
			answer += snowmobile.getMenu().get(i);
		}
		
		if(!answer.equals(". Save and quit" + ". Go to house " + ". Go to woodpile" + ". Approach plane")) {
			fail("When keys and map are false expected a different menu. got " + answer);
		}
		
		// true keys and false map
			answer = "";
			model.setHasSnowmobileKey(true);
				snowmobile.setMenu(snowmobile.getMenu());
				for(int i = 0; i < snowmobile.getMenu().size(); i ++) {
					answer += snowmobile.getMenu().get(i);
				}
				
				if(!answer.equals(". Save and quit" + ". Go to house " + ". Go to woodpile" + ". Approach plane" + ". Drive down the road")) {
					fail("When keys and map are false expected a different menu. got " + answer);
				}
				// false keys and true map
				answer = "";
				model.setHasSnowmobileKey(false);
				model.setHasMap(true);
					snowmobile.setMenu(snowmobile.getMenu());
					for(int i = 0; i < snowmobile.getMenu().size(); i ++) {
						answer += snowmobile.getMenu().get(i);
					}
					
					if(!answer.equals(". Save and quit" + ". Go to house " + ". Go to woodpile" + ". Approach plane" )) {
						fail("When keys are false  and map is false expected a different menu. got " + answer);
					}
					// true keys and true map
					answer = "";
					model.setHasSnowmobileKey(true);
					model.setHasMap(true);
						snowmobile.setMenu(snowmobile.getMenu());
						for(int i = 0; i < snowmobile.getMenu().size(); i ++) {
							answer += snowmobile.getMenu().get(i);
						}
						
						if(!answer.equals(". Save and quit" + ". Go to house " + ". Go to woodpile" + ". Approach plane" + ". Drive down the road" + ". Drive down the wooded path.")) {
							fail("When keys are true  and map is true expected a different menu. got " + answer);
						}
		
		
	}
	 @Test
	 public void messageTest() {
		 Model model = new Model();	
			Snowmobile snowmobile = new Snowmobile(model);
			String answer = "";
		 // false false false 
			snowmobile.setMessage(snowmobile.getMessage());
			for(int i = 0; i < snowmobile.getMessage().size(); i ++) {
				answer += snowmobile.getMessage().get(i);
			}
			if(!answer.equals("You hop on the Snowmobile." + "You thought this would be your great escape, however there's no key in the ignition." 
			+ "You decide the key is probably somewhere in the house")) {
				fail("With no key, gas or map expected a different message. Got " + answer);
			}
			
			 // true key false false 
			answer = "";
			model.setHasSnowmobileKey(true);
			snowmobile.setMessage(snowmobile.getMessage());
			for(int i = 0; i < snowmobile.getMessage().size(); i ++) {
				answer += snowmobile.getMessage().get(i);
			}
			if(!answer.equals("You hop on the Snowmobile." + "You turn the key and the snowmobile cranks over. The gas gauge is low. "+ 
					"The main road is on your mind. You believe it can lead you to civilization.")) {
				fail("With the key, no gas, no map expected a different message. Got " + answer);
			}
			
			 // true key true gas false map
			answer = "";
			model.setHasSnowmobileKey(true);
			model.setHasGas(true);
			snowmobile.setMessage(snowmobile.getMessage());
			for(int i = 0; i < snowmobile.getMessage().size(); i ++) {
				answer += snowmobile.getMessage().get(i);
			}
			if(!answer.equals("You hop on the Snowmobile." + "You turn the key and the snowmobile cranks over. The gas gauge is low. "+ 
				"The main road is on your mind. You believe it can lead you to civilization." + "Luckily, you brought that gas can with you. You top the tank off.")) {
				fail("With the key and gas, no map expected a different message. Got " + answer);
			}
	 
			 // true key true gas false true
			answer = "";
			model.setHasSnowmobileKey(true);
			model.setHasGas(true);
			model.setHasMap(true);
			snowmobile.setMessage(snowmobile.getMessage());
			for(int i = 0; i < snowmobile.getMessage().size(); i ++) {
				answer += snowmobile.getMessage().get(i);
			}
			if(!answer.equals("You hop on the Snowmobile." + "You turn the key and the snowmobile cranks over. The gas gauge is low. "+ 
				"The main road is on your mind. You believe it can lead you to civilization." + "Luckily, you brought that gas can with you. You top the tank off." + 
				"You take a look at the map and realize there is a second shorter path to" + " civilization. It cuts through the thick pine forrest behind the house." + 
				"You ponder which route you should take (the short cut is a few miles shorter)")) {
				fail("With the key and gas, and map expected a different message. Got " + answer);
			}
	 
	 }





}
