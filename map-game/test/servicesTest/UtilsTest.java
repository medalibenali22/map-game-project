package servicesTest;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import services.Utils;

public class UtilsTest {

	@Test
	public void testLoadMap() throws IOException {
		try {
			char[][] expectedMap = { { '#', '#', '#' },
									 { '#', ' ', '#' },
									 { '#', '#', '#' } };

			char[][] map = Utils.loadMap("./resources/carteTest.txt");

			Assertions.assertArrayEquals(expectedMap, map);
		} catch (IOException e) {
			// Handle or log the exception
			e.printStackTrace();
			Assertions.fail("Exception occurred while loading map");
		}
	}

	@Test
	public void testLoadMovement() throws IOException {
		try {
			String[] expectedMovement = { "1,2", "NSE" };

			String[] movement = Utils.loadMovement("./resources/movementTest.txt");

			Assertions.assertArrayEquals(expectedMovement, movement);
		} catch (IOException e) {
			// Handle or log the exception
			e.printStackTrace();
			Assertions.fail("Exception occurred while loading map");
		}
	}

	@Test
	public void testParseCoordinates() {
		String coordinates = "1,2";
		int[] expectedCoordinates = { 1, 2 };

		int[] parsedCoordinates = Utils.parseCoordinates(coordinates);

		Assertions.assertArrayEquals(expectedCoordinates, parsedCoordinates);
	}

	@Test
	public void testCalculateNewPosition() {
		int x = 1;
		int y = 2;
		char direction = 'N';
		int[] expectedNewPosition = { 1, 1 };

		int[] newPosition = Utils.calculateNewPosition(x, y, direction);

		Assertions.assertArrayEquals(expectedNewPosition, newPosition);
	}

	@Test
	public void testIsValidMove() {
		char[][] map = { { 'X', 'X', 'X' }, { 'X', ' ', 'X' }, { 'X', 'X', 'X' } };
		int x = 1;
		int y = 1;
		boolean expectedIsValidMove = true;

		boolean isValidMove = Utils.isValidMove(map, x, y);

		Assertions.assertEquals(expectedIsValidMove, isValidMove);
	}
}
