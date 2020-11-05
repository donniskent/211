import static org.junit.Assert.*;

import org.junit.Test;

public class CockpitTest {

	@Test
	public void choiceTest() {
		Model model = new Model();
		Cockpit cockpit = new Cockpit(model);
		Cockpit cockpit2 = new Cockpit(model);
		if(!cockpit.choice(1).equals(TheState.CockPit)) {
			fail("when 1, expected cockpit. got " + cockpit.choice(1));
		}
		if(!cockpit.choice(2).equals(TheState.MiddlePlane)) {
			fail("when 2, expected middle plane. got " + cockpit.choice(2));
		}
		if(!cockpit.choice(3).equals(TheState.CockPit)) {
			fail("when 3, expected cockpit. got " + cockpit.choice(3));
		}
		if(!cockpit.choice(4).equals(TheState.CockPit)) {
			fail("when 4, expected cockpit. got " + cockpit.choice(4));
		}
		
		cockpit.choice(3);
		if(model.getDoorKeys() == false) {
			fail("Should have set door keys to true.");
		}
		cockpit.choice(3);
		if(model.getHasGun() == false) {
			fail("Should have set hasgun to true.");
		}
		cockpit2.choice(4);
		if(model.getHasGun() == false) {
			fail("Should have set hasgun to true.");
		}
	
	
	}

	@Test 
	public void menuTest() {
		Model model = new Model();
		Cockpit cockpit = new Cockpit(model);
	
	// door keys and gun false
		cockpit.setMenu(cockpit.getMenu());
	String answer = "";
	for(int i = 0; i < cockpit.getMenu().size(); i++) {
		answer += cockpit.getMenu().get(i);
	}
	if(!answer.equals(". Save and quit." + ". Go to the middle of the plane."+ ". Pull the keys from the ignition."
	+ ". Grab the gun and hollster.")) {
		fail("When both are fail, menu doesnt set right. got " + answer);	}
	
	
	// keys true gun false 
	model.setHasDoorKeys(true);
	cockpit.setMenu(cockpit.getMenu());
	answer = "";
	for(int i = 0; i < cockpit.getMenu().size(); i++) {
		answer += cockpit.getMenu().get(i);
	}
	if(!answer.equals(". Save and quit." + ". Go to the middle of the plane." + ". Grab the gun and hollster.")) {
		fail("When keys are true and gun is false menu doesnt set correctly. Got" + answer);
	}
	
	// keys false gun true
	model.setHasDoorKeys(false);
	model.setHasGun(true);
	cockpit.setMenu(cockpit.getMenu());
	answer = "";
	for(int i = 0; i < cockpit.getMenu().size(); i++) {
		answer += cockpit.getMenu().get(i);
	}
	if(!answer.equals(". Save and quit." + ". Go to the middle of the plane." + ". Pull the keys from the ignition.")) {
		fail("When gun is true and keys are false, menu sets incorrectly. got " + answer);
	}
	
	// both true
	model.setHasDoorKeys(true);
	model.setHasGun(true);
	cockpit.setMenu(cockpit.getMenu());
	answer = "";
	for(int i = 0; i < cockpit.getMenu().size(); i++) {
		answer += cockpit.getMenu().get(i);
	}
	if(!answer.equals(". Save and quit." + ". Go to the middle of the plane.")) {
		fail("When gun is true and keys are true, menu sets incorrectly. got " + answer);
	}

	}

	@Test
	public void messageTest() {
		Model model = new Model();
		Cockpit cockpit = new Cockpit(model);
		String answer = "";
		// false false
		cockpit.setMessage(cockpit.getMessage());
		for(int i = 0; i < cockpit.getMessage().size(); i++) {
			answer += cockpit.getMessage().get(i);
		}
	if(!answer.equals("You're in the cockpit. You quickly notice the pilot is dead and the keys" 
			+ "are still in the ignition. You also notice his Glock 20 is still in its hollster" 
			+ "on his side. ")) {
		fail("When both are false, message is incorrect. got " + answer);
	}
	
	// true keys false gun
			model.setHasDoorKeys(true);
			cockpit.setMessage(cockpit.getMessage());
			answer = "";
			for(int i = 0; i < cockpit.getMessage().size(); i++) {
				answer += cockpit.getMessage().get(i);
			}
		if(!answer.equals("You're still in the cockpit. The gun still lays on the hip of the deceased pilot.")) {
			fail("When door is true, message is incorrect. got " + answer);
		}
		
	
		// false keys true gun
					model.setHasDoorKeys(false);
					model.setHasGun(true);
					cockpit.setMessage(cockpit.getMessage());
					answer = "";
					for(int i = 0; i < cockpit.getMessage().size(); i++) {
						answer += cockpit.getMessage().get(i);
					}
				if(!answer.equals("You're still in the cockpit. The Glock is now strapped to your side, the keys still stuck in the ignition.")) {
					fail("When gun is true, message is incorrect. got " + answer);
				}
	
				// true true
				model.setHasDoorKeys(true);
				model.setHasGun(true);
				cockpit.setMessage(cockpit.getMessage());
				answer = "";
				for(int i = 0; i < cockpit.getMessage().size(); i++) {
					answer += cockpit.getMessage().get(i);
				}
			if(!answer.equals("With the keys in your pocket and Glock on your hip, nothing but the pilot's body remain in the cockpit")) {
				fail("When both are true, message is incorrect. got " + answer);
			}
	
	}










}
