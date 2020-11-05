import static org.junit.Assert.*;

import org.junit.Test;

public class BackRoadTest {

	@Test
	public void setMessageTest() {
		Model model = new Model();
		BackRoad backRoad = new BackRoad(model);
		backRoad.setMessage(backRoad.getMessage());
		if(backRoad.getMessage().contains("You quickly realize that these are the bodies of the people from the picture in the bedroom!")) {
			fail("Seeing picture should be false");
		}
		
		if(backRoad.getMessage().contains("You then remember the Glock you took off the pilots hip.")) {
			fail("Gun is false, shouldnt be in the message");
		}
		
		if(!backRoad.getMessage().contains("You lose")) {
			fail("Shouldve told user they lost");
		}		
	model.setHasGun(true);
	backRoad.setMessage(backRoad.getMessage());
	if(!backRoad.getMessage().contains("You then remember the Glock you took off the pilots hip.")) {
		fail("Shouldve had gun.");
	}
	
	model.setSeenPicture(true);
	backRoad.setMessage(backRoad.getMessage());
	if(!backRoad.getMessage().contains("You quickly realize that these are the bodies of the people from the picture in the bedroom!")) {
		fail("Seeing picture should be true");
	}
	}

}
