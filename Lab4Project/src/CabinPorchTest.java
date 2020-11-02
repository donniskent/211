import static org.junit.Assert.*;

import org.junit.Test;

public class CabinPorchTest {

	@Test
	public void choiceTest() {
	Model model = new Model();
	CabinPorch porch = new CabinPorch(model);
	int i = 1;
	if(!porch.choice(i).equals(TheState.CabinPorch)) {
		fail("Expected to return porch, got " + porch.choice(i));
	}
	i+=1;
	if(!porch.choice(i).equals(TheState.OutsidePlane)) {
		fail("Expected to return outside plane, got " + porch.choice(i));
	}
	i+=1;
	if(!porch.choice(i).equals(TheState.SnowMobile)) {
		fail("Expected to return snowmobile, got " + porch.choice(i));
	}
	i+=1;
	if(!porch.choice(i).equals(TheState.CabinPorch)) {
		fail("Should return porch because there is no hatchet to break down door."); 
	}
	model.setHasHatchet(true);
	
	if(!porch.choice(i).equals(TheState.CabinLivingRoom)) {
		fail("Should return living room, door is busted down. got " + porch.choice(i)); 
	}
	
	if(!model.getDoorBroken()) {
		fail("Door should be broken after entering the house");
	}
	i+=1;
	if(!porch.choice(i).equals(TheState.WoodPile)) {
		fail("Expected to return woodpile, got " + porch.choice(i));
	}
	
	
	
	}
	@Test
	public void setMenuTest() {
		Model model = new Model();
		CabinPorch porch = new CabinPorch(model);
		porch.setMenu(porch.getMenu());
		if(!porch.getMenu().get(0).equals(". Save and quit")) {
			fail("Expected . Save and quit , got " + porch.getMenu());
		}
	
	}


}
