import static org.junit.Assert.*;

import org.junit.Test;

public class CabinPorchTest {

	@Test
	public void choiceTest() {
	Model model = new Model();
	CabinPorch porch = new CabinPorch(model);
	
	if(!porch.choice(1).equals(TheState.CabinPorch)) {
		fail("Expected to return porch, got " + porch.choice(1));
	}
	
	if(!porch.choice(2).equals(TheState.OutsidePlane)) {
		fail("Expected to return outside plane, got " + porch.choice(2));
	}
	
	if(!porch.choice(3).equals(TheState.SnowMobile)) {
		fail("Expected to return snowmobile, got " + porch.choice(3));
	}
	
	if(!porch.choice(4).equals(TheState.CabinPorch)) {
		fail("Should return porch because there is no hatchet to break down door."); 
	}
	model.setHasHatchet(true);
	
	if(!porch.choice(4).equals(TheState.CabinLivingRoom)) {
		fail("Should return living room, door is busted down. got " + porch.choice(4)); 
	}
	
	if(!model.getDoorBroken()) {
		fail("Door should be broken after entering the house");
	}
	
	if(!porch.choice(5).equals(TheState.WoodPile)) {
		fail("Expected to return woodpile, got " + porch.choice(5));
	}
	
	
	
	}
	@Test
	public void setMenuTest() {
		Model model = new Model();
		CabinPorch porch = new CabinPorch(model);
		porch.setMenu(porch.getMenu());
		String answer = "";
		for(int i = 0; i < porch.getMenu().size(); i++) {
			answer += porch.getMenu().get(i);
			
		}
		if(!answer.equals(". Save and quit" + ". Approach the Plane" + ". Get on Snowmobile" 
		+ ". Enter Cabin" + ". Go to woodpile")) {
			fail("Menu didn't set correctly, got" + answer);
			
		} 
		}
	
	@Test 
	public void setMessage() {
		Model model = new Model();
		CabinPorch porch = new CabinPorch(model);
		porch.setMessage(porch.getMessage());
		String answer = "";
		for(int i = 0; i < porch.getMessage().size(); i++) {
			answer += porch.getMessage().get(i);
			
		}
		if(!answer.equals("You step on the porch and knock on the door. Nobody answers." + "You try to open the door. It is locked." 
		+ "You check the porch for a key, however you can't find one." + "Still nobody answers the cabin door. You think of ways to get in.")) {
			fail("Menu didnt set correctly when hatchet, doorknock and doorbroke are false. got " + answer);
			
		}
	
		
		model.setHasHatchet(true);
		answer = "";
		porch.setMessage(porch.getMessage());
		
		for(int i = 0; i < porch.getMessage().size(); i++) {
			answer += porch.getMessage().get(i);
			
		}
		
		if (!answer.equals("Standing on the porch with the hatchet in your hand, " + "you ponder once more if you should enter the house by force."
		+ "If the home owner were to catch you, you would likely be killed.")) {
			fail("When hatchet is true and door is not broke, message is wrong. got " + answer);
		}
		model.setDoorBroken(true);
		answer = "";
		porch.setMessage(porch.getMessage());
		for(int i = 0; i < porch.getMessage().size(); i++) {
			answer += porch.getMessage().get(i);
			
		}
		if(!answer.equals("You're on the porch, pieces of the busted door laying around you")) {
			fail("When door is broke, message is wrong. Got " + answer);
		}
	
	
	
	
	}





}
