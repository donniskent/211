import static org.junit.Assert.*;

import org.junit.Test;

public class LivingRoomTest {

	@Test
	public void choiceTest() {
	Model model = new Model();
	LivingRoom livingRoom = new LivingRoom(model);	
	if(!livingRoom.choice(1).equals(TheState.CabinLivingRoom)) {
		fail("When choice 1, expect living room, got" + livingRoom.choice(1)); 
	}
	if(!livingRoom.choice(2).equals(TheState.Kitchen)) {
		fail("When choice 2, expect Kitchen, got" + livingRoom.choice(2)); 
	}
	if(!livingRoom.choice(3).equals(TheState.Bedroom)) {
		fail("When choice 3, expect Kitchen, got" + livingRoom.choice(3)); 
	}
	if(!livingRoom.choice(4).equals(TheState.CabinPorch)) {
		fail("When choice 4, expect CabinPorch, got" + livingRoom.choice(4)); 
	}
	}
	@Test
	public void menuTest() {
		Model model = new Model();
		LivingRoom livingRoom = new LivingRoom(model);
		livingRoom.setMenu(livingRoom.getMenu());
		String answer = "";
		for(int i = 0; i < livingRoom.getMenu().size(); i++) {
			answer += livingRoom.getMenu().get(i);
		}
		if(!answer.equals(". Save and quit" + ". Walk through door 1" + ". Walk through door 2" + ". Go onto the porch")) {
			fail("Only 1 option for menu, got " + answer);
		}
	
	}
	@Test 
	public void messageTest() {
		Model model = new Model();
		LivingRoom livingRoom = new LivingRoom(model);
		String answer = "";
	
		//  both false
		livingRoom.setMessage(livingRoom.getMessage());
		for(int i = 0; i < livingRoom.getMessage().size(); i++) {
			answer += livingRoom.getMessage().get(i);
		}
		if(!answer.equals("The house is empty. Two doors lay at opposite ends of the living room." + "Pieces of the busted front door are scattered around the room.")){	
			fail("When both false, shouldve got different message. got " + answer);
		
		}
	model.setHasSnowmobileKey(true);
	livingRoom.setMessage(livingRoom.getMessage());
	answer = "";
	for(int i = 0; i < livingRoom.getMessage().size(); i++) {
		answer += livingRoom.getMessage().get(i);
	}
	if(!answer.equals("You stand in the living room")) {
		fail("Expected differnet message when key is true, got " + answer);
		
	}
	model.setHasSnowmobileKey(false);
	model.setHasMap(true);
	livingRoom.setMessage(livingRoom.getMessage());
	answer = "";
	for(int i = 0; i < livingRoom.getMessage().size(); i++) {
		answer += livingRoom.getMessage().get(i);
	}
	if(!answer.equals("You stand in the living room")) {
		fail("Expected differnet message when map is true, got " + answer);
		
	}
	
	
	}


}
