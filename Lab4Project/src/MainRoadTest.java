import static org.junit.Assert.*;

import org.junit.Test;

public class MainRoadTest {

	@Test
	public void setMessageTest() {
		Model model = new Model();
		MainRoad mainRoad = new MainRoad(model);
		mainRoad.setMessage(mainRoad.getMessage());
		if(!mainRoad.getMessage().contains("You lose.")) {
			fail("No gas, shouldnt have won");
		}
		model.setHasGas(true);
		mainRoad.setMessage(mainRoad.getMessage());
		if(!mainRoad.getMessage().contains("You win.")) {
			fail("Has gas, should have won");
		}
		
		
	}

}
