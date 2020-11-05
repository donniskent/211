import static org.junit.Assert.*;

import org.junit.Test;

public class KitchenTest {

	@Test
	public void choiceTest() {
		Model model = new Model();
		Kitchen kitchen = new Kitchen(model);
		Kitchen kitchen2 = new Kitchen(model);
		if(!kitchen.choice(1).equals(TheState.Kitchen)) {
			fail("Expected kitchen, got " + kitchen.choice(1));
		}
		if(!kitchen.choice(2).equals(TheState.CabinLivingRoom)) {
			fail("Expected Cabin Living Room , got " + kitchen.choice(2));
		}
		if(!kitchen.choice(3).equals(TheState.Kitchen)) {
			fail("Expected kitchen , got " + kitchen.choice(3));
		}
		if(!kitchen.choice(4).equals(TheState.Kitchen)) {
			fail("Expected kitchen , got " + kitchen.choice(4));
		}
		
	kitchen.choice(4);
	if(model.getHasSnowmobileKey() == false) {
		fail("Expected snowmobile key to be true");
	}
	kitchen.choice(3);
	if(model.getHasMap() == false) {
		fail("Expected map to be true");
	}
	kitchen2.choice(3);
	kitchen2.choice(3);
	if(model.getHasSnowmobileKey() == false) {
		fail("Expected key to be true");
	}
	}
	@Test
	public void menuTest() {
		Model model = new Model();
		Kitchen kitchen = new Kitchen(model);
		
		// map false key false
		kitchen.setMenu(kitchen.getMenu());
		String answer = "";
		for(int i = 0; i < kitchen.getMenu().size(); i ++) {
			answer += kitchen.getMenu().get(i);		
		}
		if(!answer.equals(". Save and quit" + ". Go into the living room" + ". Pick up the Map" + ". Grab the keys"))
		{
			fail("Expected different menu when all false. got " + answer);
		}
		
		model.setHasSnowmobileKey(true);
		model.setHasMap(true);
		answer = "";
		kitchen.setMenu(kitchen.getMenu());
		for(int i = 0; i < kitchen.getMenu().size(); i ++) {
			answer += kitchen.getMenu().get(i);		
		}
		if(!answer.equals(". Save and quit" + ". Go into the living room")) {
			fail("Expected differenty menu when both true. got" + answer);
		}
		
		
	}
	@Test
	public void messageTest() {
		Model model = new Model();
		Kitchen kitchen = new Kitchen(model);
		String answer = "";
		// false and false 
		kitchen.setMessage(kitchen.getMessage());
		for(int i = 0; i < kitchen.getMessage().size(); i ++) {
			answer += kitchen.getMessage().get(i);		
		}
		if(!answer.equals("Stepping into the kitchen, you notice there is no food in the fridge or pantry." + "You see a map setting on the counter."
		+ "There are keys hanging on the wall.")) {
			fail("when both are false expected different message. got " + answer);
			}
		// map true key false
		
	
		answer = "";
		model.setHasMap(true);
		kitchen.setMessage(kitchen.getMessage());
		for(int i = 0; i < kitchen.getMessage().size(); i ++) {
			answer += kitchen.getMessage().get(i);		
		}
		if(!answer.equals("There are keys hanging on the wall.")) {
			fail("When map is true, message is wrong, got " + answer);
		}
	// map false, keys true
		answer = "";
		model.setHasMap(false);
		model.setHasSnowmobileKey(true);
		kitchen.setMessage(kitchen.getMessage());
		for(int i = 0; i < kitchen.getMessage().size(); i ++) {
			answer += kitchen.getMessage().get(i);		
		}
		if(!answer.equals("You see a map setting on the counter.")) {
			fail("When haskeys is true, message is wrong, got " + answer);
		}
	
	// map true keys true
		answer = "";
		model.setHasMap(true);
		model.setHasSnowmobileKey(true);
		kitchen.setMessage(kitchen.getMessage());
		for(int i = 0; i < kitchen.getMessage().size(); i ++) {
			answer += kitchen.getMessage().get(i);		
		}
		if(!answer.equals("Nothing useful remains in the kitchen.")) {
			fail("When hasKeys is true, message is wrong, got " + answer);
		}
	
	
	
	
	}



}
