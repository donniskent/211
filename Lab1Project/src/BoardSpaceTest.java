import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardSpaceTest {

	@Test
	void testPlayer1() {
		if (!BoardSpace.Player1.toString().equals("Player 1")) {

			fail("Expected Player 1, got " + BoardSpace.Player1.toString());

		}
	}

	@Test
	void testPlayer2() {
		if (!BoardSpace.Player2.toString().equals("Player 2")) {

			fail("Expected Player 2, got " + BoardSpace.Player2.toString());

		}

	}

}
