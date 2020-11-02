import static org.junit.Assert.*;

import org.junit.Test;

public class BackRoadTest {

	@Test
	public void setMessageTest() {
		Model model = new Model();
		BackRoad backRoad = new BackRoad(model);
		model.setSeenPicture(true);
		backRoad.setMessage(backRoad.getMessage());
		if(!backRoad.getMessage().get(6).equals("You quickly realize that these are the bodies of the people from the picture in the bedroom!")) {
			fail("Expected different print message at index 6 when the picture has been seen");
		}
		
		
		
	}

}
