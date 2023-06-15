package jeucarte;

import java.io.IOException;

import util.Utils;

public class Application {
	
	public static void main(String[] args) {
        String mapFilePath = "./resources/carte.txt";
        String movementFilePath = "./resources/movement.txt";

        try {
            char[][] map = Utils.loadMap(mapFilePath);
            String[] movement = Utils.loadMovement(movementFilePath);

            int[] initialPosition = Utils.parseCoordinates(movement[0]);
            int x = initialPosition[0];
            int y = initialPosition[1];

            for (char direction : movement[1].toCharArray()) {
                int[] newPosition = Utils.calculateNewPosition(x, y, direction);

                if (Utils.isValidMove(map, newPosition[0], newPosition[1])) {
                    x = newPosition[0];
                    y = newPosition[1];
                }
            }

            System.out.println("The character's final position is (" + x + "," + y + ")");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
