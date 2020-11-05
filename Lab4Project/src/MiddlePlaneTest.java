import static org.junit.Assert.*;

import org.junit.Test;

public class MiddlePlaneTest {

	@Test
	public void choiceTest() {
		Model model = new Model();
		MiddlePlane middlePlane = new MiddlePlane(model);
		
		if(!middlePlane.choice(1).equals(TheState.MiddlePlane)) {
			fail("When 1, expected middleplane. Got " + middlePlane.choice(1));
		}
		// when keys is false
		if(!middlePlane.choice(2).equals(TheState.MiddlePlane)) {
			fail("When 2, expected middleplane. Got " + middlePlane.choice(2));
		}
		model.setHasDoorKeys(true);
		if(!middlePlane.choice(2).equals(TheState.OutsidePlane)) {
			fail("When 2, expected outside plane. Got " + middlePlane.choice(2));
		}
		if(!middlePlane.choice(3).equals(TheState.CockPit)) {
			fail("When 2, expected cockpit. Got " + middlePlane.choice(3));
		}
		}
	@Test
	public void menuTest() {
		Model model = new Model();
		MiddlePlane middlePlane = new MiddlePlane(model); 
		String answer = "";
		middlePlane.setMenu(middlePlane.getMenu());
		for(int i = 0; i < middlePlane.getMenu().size(); i++) {
			answer += middlePlane.getMenu().get(i);
		}
		if(!answer.equals(". Save game and quit" + ". Go outside" + ". Go to cockpit")) {
			fail("Expected 1 menu set up. failed. got " + answer);		}
		
	}

	@Test 
	public void messageTest() {
		Model model = new Model();
		MiddlePlane middlePlane = new MiddlePlane(model); 
		String answer = "";
		// keys false
		middlePlane.setMessage(middlePlane.getMessage());
		for(int i = 0; i < middlePlane.getMessage().size(); i++) {
			answer += middlePlane.getMessage().get(i);
		}
		if(!answer.equals("Standing in the middle of the plane, you see two doors." + "The first door leads outside. The other to the cockpit." 
		+ "The door leading outside is locked")) {
			fail("With keys false, got wrong message. got " + answer);
		}
	// keys true 
		answer = "";
		model.setHasDoorKeys(true);
		middlePlane.setMessage(middlePlane.getMessage());
		for(int i = 0; i < middlePlane.getMessage().size(); i++) {
			answer += middlePlane.getMessage().get(i);
		}
		if(!answer.equals("Standing in the middle of the plane, you see two doors." + "The first door leads outside. The other to the cockpit." 
		+ "With the keys in your hand, you can unlock the door. ")) {
			fail("With keys false, got wrong message. got " + answer);
		}
	
	
	}





}
