import static org.junit.Assert.*;

import org.junit.Test;

public class WoodpileTest {

	@Test 
	public void choiceTest() {
		Model model = new Model();
		Woodpile woodPile = new Woodpile(model);
		if(!woodPile.choice(1).equals(TheState.WoodPile)) {
			fail("Expected woodPile to return, got " + woodPile.choice(1));
		}
		if(!woodPile.choice(2).equals(TheState.OutsidePlane)) {
			fail("Expected outsidePlane to return, got " + woodPile.choice(2));
			
		}
		if(!woodPile.choice(3).equals(TheState.CabinPorch)) {
			fail("Expected CabinPorch to return, got " + woodPile.choice(3));
			
		}
		if(!woodPile.choice(4).equals(TheState.SnowMobile)) {
			fail("Expected SnowMobile to return, got " + woodPile.choice(4));
			
		}
		// choice 5's menu relies on the boolean value of hatchet 
		if(!woodPile.choice(5).equals(TheState.WoodPile)) {
			fail("Expected woodpile to return, got " + woodPile.choice(5));
		}
		// need to check if hatchet is setting
		woodPile.choice(5);
		if(!model.getHasHatchet() == true) {
			fail("Hatchet should have set to true, got" + model.getHasHatchet());
		}
		// need to check if gas is picked up 
		woodPile.choice(5);
		if(!model.getHasGas() == true) {
			fail("Gas should have set to true, got" + model.getHasGas());
		}
	
		model.setHasGas(false);
		model.setHasHatchet(false);
		if(!woodPile.choice(6).equals(TheState.WoodPile)) {
			fail("Expected woodpile to return, got " + woodPile.choice(6));
		}
		if(model.getHasGas() == false) {
			fail("Should have set gas to true, got " + model.getHasGas());
		}
		
	
	
	
	}
	
	
	
	
	
	
	
	
	@Test 
	public void setMenuTest() {
		Model model = new Model();
		Woodpile woodPile = new Woodpile(model);
		
		// Hatchet and Gas are false
		woodPile.setMenu(woodPile.getMenu());
		String answer = "";
		for (int i = 0; i < woodPile.getMenu().size(); i++) {
			answer += woodPile.getMenu().get(i);
		}
		if(!answer.equals(". Save and quit" + ". Approach plane" + ". Go to porch" + ". Go to the snowmobile" 
		+ ". Pick up the hatchet" + ". Pick up the gas can")) {
			fail("When hatchet and gas are false, menu is wrong. Got " + answer);
		}
		
		
		// Hatchet is true, and Gas is false
		model.setHasHatchet(true);
		woodPile.setMenu(woodPile.getMenu());
		answer = "";
		
		for (int i = 0; i < woodPile.getMenu().size(); i++) {
			answer += woodPile.getMenu().get(i);
		}
		
		if(!answer.equals(". Save and quit" + ". Approach plane" + ". Go to porch" + ". Go to the snowmobile" 
				+ ". Pick up the gas can")) {
					fail("When hatchet is true and gas is false, menu is wrong. Got " + answer);
				}
	
	
		// Hatchet is false, and Gas is true
				model.setHasHatchet(false);
				model.setHasGas(true);
				woodPile.setMenu(woodPile.getMenu());
				answer = "";
				
				for (int i = 0; i < woodPile.getMenu().size(); i++) {
					answer += woodPile.getMenu().get(i);
				}
				
				if(!answer.equals(". Save and quit" + ". Approach plane" + ". Go to porch" + ". Go to the snowmobile" 
						+ ". Pick up the hatchet")) {
							fail("When hatchet is false and gas is true, menu is wrong. Got " + answer);
						}
			
				// Hatchet is true, and Gas is true
				model.setHasHatchet(true);
				model.setHasGas(true);
				woodPile.setMenu(woodPile.getMenu());
				answer = "";
				
				for (int i = 0; i < woodPile.getMenu().size(); i++) {
					answer += woodPile.getMenu().get(i);
				}
				
				if(!answer.equals(". Save and quit" + ". Approach plane" + ". Go to porch" + ". Go to the snowmobile")) {
							fail("When hatchet is true and gas is true, menu is wrong. Got " + answer);
						}
			
	
	
	
	
	}
	
	
	
	
	
	
	
	
	@Test
	public void setMessageTest() {
		Model model = new Model();
		Woodpile woodPile = new Woodpile(model);
		// gas and hatchet false first
		woodPile.setMessage(woodPile.getMessage());
		String answer = "";
		for (int i = 0; i < woodPile.getMessage().size(); i++) {
			answer += woodPile.getMessage().get(i);
			
		}
		if (!answer.equals("A can of gas sits beside the woodpile." + "There is a hatchet stuck in a rotten log.")) {
			fail("When gas and hatchet are false, message is not correct. Getting " + answer);
		}
		
	// gas false, hatchet true 
		answer = "";
		model.setHasHatchet(true);
		woodPile.setMessage(woodPile.getMessage());
		for (int i = 0; i < woodPile.getMessage().size(); i++) {
			answer += woodPile.getMessage().get(i);
			
		}
		if (!answer.equals("A can of gas sits beside the woodpile.")) {
			fail("When gas is false and hatchet is true, message is not correct. Getting " + answer);
		}
		// gas true, hatchet false 
		
		answer = "";
		model.setHasGas(true);
		model.setHasHatchet(false);
		woodPile.setMessage(woodPile.getMessage());
		for (int i = 0; i < woodPile.getMessage().size(); i++) {
			answer += woodPile.getMessage().get(i);
			
		}
		if (!answer.equals("There is a hatchet stuck in a rotten log.")) {
			fail("When gas is true and hatchet is false, message is not correct. Getting " + answer);
		}
	
		// gas true, hatchet true
		answer = "";
		model.setHasGas(true);
		model.setHasHatchet(true);
		woodPile.setMessage(woodPile.getMessage());
		for (int i = 0; i < woodPile.getMessage().size(); i++) {
			answer += woodPile.getMessage().get(i);
			
		}
		if (!answer.equals("Only the rotten wood remains in the area.")) {
			fail("When gas is true and hatchet is true, message is not correct. Getting " + answer);
		}
		
		
		
	
	}

}
