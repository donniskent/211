import static org.junit.Assert.*;

import org.junit.Test;

public class OutsidePlaneTest {

	@Test
	public void choiceTest() {
	Model model = new Model();
	OutsidePlane outsidePlane = new OutsidePlane(model);
	if(!outsidePlane.choice(1).equals(TheState.OutsidePlane)) {
		fail("When 1 expected outside plane, got " + outsidePlane.choice(1));
	}
	if(!outsidePlane.choice(2).equals(TheState.CabinPorch)) {
		fail("When 2 expected porch, got " + outsidePlane.choice(2));
	}
	if(!outsidePlane.choice(3).equals(TheState.SnowMobile)) {
		fail("When 3 expected porch, got " + outsidePlane.choice(3));
	}
	
	if(!outsidePlane.choice(4).equals(TheState.WoodPile)) {
		fail("When 4 expected woodpile, got " + outsidePlane.choice(4));
	}
	if(!outsidePlane.choice(5).equals(TheState.MiddlePlane)) {
		fail("When 5 expected middleplane, got " + outsidePlane.choice(5));
	}
	}
	@Test
	public void menuTest() {
		Model model = new Model();
		OutsidePlane outsidePlane = new OutsidePlane(model);
		String answer = "";
		
		outsidePlane.setMenu(outsidePlane.getMenu());
		for(int i = 0; i < outsidePlane.getMenu().size(); i ++) {
			answer += outsidePlane.getMenu().get(i);
		}
		if(!answer.equals(". Save and quit" + ". Go to house " + ". Go to snowmobile" + ". Go to woodpile" + ". Go into Plane")) {
			fail("Message should only set 1 way. failed. got " + answer);
		}
	
	
	}
	@Test
	public void messageTest() {
		Model model = new Model();
		OutsidePlane outsidePlane = new OutsidePlane(model);
		String answer = "";
		
		outsidePlane.setMessage(outsidePlane.getMessage());
		for(int i = 0; i < outsidePlane.getMessage().size(); i ++) {
			answer += outsidePlane.getMessage().get(i);
		}
		if(!answer.equals("You're just outside the plane." + "There is a cabin no more than " + "100 yards from the plane. In front of the cabin is a snow covered snowmobile, and " 
		+ "beside the cabin lays some chopped wood and a hatchet. Behind the cabin is an icy road.")) {
			fail("Only 1 possible message to set. failed. got " + answer); 
		}
		
		
	}
 	
	
	
}
