import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest {

	@Test
	public void saveAndLoadTest() {
		Model model = new Model();
		model.setHasGas(true);
		model.setHasGun(true);
		String answer = model.save();
		if(!answer.equals("1 F F T F T F T F F F F") ) {
			fail("wrong saved string. got " + answer);
		}
		
		
		
		model.load(answer);
		if(model.getHasGun() != true) {
			fail("Gun should be true");
		}
		if(model.getHasGas() != true) {
			fail("Gas should be true");
		}
		if(model.getHasMap() != false) {
			fail("Map should be false");
		}
		
		
		
	}

}
