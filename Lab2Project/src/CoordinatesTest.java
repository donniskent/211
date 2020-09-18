import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinatesTest {
	@Test
	public void addTest() {
		Coordinates coordinates = new Coordinates(); 
		coordinates.add(7);
		if(coordinates.get(0) != 7) {
			fail("Expected index 0 to hold 7, got " + coordinates.get(0));
		}
	}
	@Test
	public void lengthTest() {
		Coordinates coordinates = new Coordinates(); 
		coordinates.add(7);
		coordinates.add(8);
		coordinates.add(0);
		coordinates.add(32);
		coordinates.add(6);
		coordinates.add(1);
		if(coordinates.length() != 6) {
			fail("Expected length to be 6. Got " + coordinates.length()); 
			
		}

	}
		

	
}

