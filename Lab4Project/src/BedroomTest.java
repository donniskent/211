import static org.junit.Assert.*;

import org.junit.Test;

public class BedroomTest {

	@Test
	public void choiceTest() {
		Model model = new Model();
		Bedroom bedroom = new Bedroom(model);
		if (!bedroom.choice(1).equals(TheState.Bedroom)) {
			fail("Expected for choice 1 to return Bedroom, got " + TheState.Bedroom);
		}
		if (!bedroom.choice(2).equals(TheState.CabinLivingRoom)) {
			fail("Expected for choice 1 to return living room, got " + TheState.CabinLivingRoom);
		}
		
		
	}

	@Test 
	public void setMenuTest() {
		Model model = new Model();
		Bedroom bedroom = new Bedroom(model);
		bedroom.setMenu(bedroom.getMenu());
		if(!bedroom.getMenu().get(0).equals(". Save and quit")) {
			fail("Menu's first string is wrong. Got" + bedroom.getMenu().get(0));
		}
		if(!bedroom.getMenu().get(1).equals(". Exit the bedroom.")) {
			fail("Menu's first string is wrong. Got" + bedroom.getMenu().get(1));
		}
		
	}
		@Test
		public void setMessageTest() {
			Model model = new Model();
			Bedroom bedroom = new Bedroom(model);
			bedroom.setMessage(bedroom.getMessage());
			if(!bedroom.getMessage().get(0).equals("Stepping into the bedroom, you see a neatly made bed.")) {
				fail("Expected different message for index 0, got" + bedroom.getMessage().get(0));
			}
			if(!bedroom.getMessage().get(1).equals("On the night stand, there is a picture of an elderly couple.")) {
				fail("Expected different message for index 1, got" + bedroom.getMessage().get(1));
			}
			if(!bedroom.getMessage().get(2).equals("The man had a large beard and the lady was blonde.")) {
				fail("Expected different message for index 2, got" + bedroom.getMessage().get(2));
			}
			if(!bedroom.getMessage().get(3).equals("Looking around the room, you don't see anything important or useful.")) {
				fail("Expected different message for index 3, got" + bedroom.getMessage().get(3));
			}
			if(model.getSeenPicture() == false) {
				fail("Expected setMenu to set picture to true, got false");
			}
			
		}


}
