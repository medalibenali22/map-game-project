package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	
	private static final char SPACE = ' ';
	
	public static char[][] loadMap(String filePath) throws IOException {
		try {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            sb.append(line+"\n");
        }

        reader.close();

        String[] rows = sb.toString().split("\n");
        int numRows = rows.length;
        int numCols = rows[0].length();
        char[][] map = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                map[i][j] = rows[i].charAt(j);
            }
        }

        return map;
        }
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
    }

    public static String[] loadMovement(String filePath) throws IOException {
    	try {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String[] movement = new String[2];

        movement[0] = reader.readLine(); // Read initial position
        movement[1] = reader.readLine(); // Read movement directions

        reader.close();

        return movement;
    	}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
    }

    public static int[] parseCoordinates(String coordinates) {
        String[] parts = coordinates.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        return new int[]{x, y};
    }

    public static int[] calculateNewPosition(int x, int y, char direction) {
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'N':
                newY--;
                break;
            case 'S':
                newY++;
                break;
            case 'E':
                newX++;
                break;
            case 'O':
                newX--;
                break;
        }

        return new int[]{newX, newY};
    }

    public static boolean isValidMove(char[][] map, int x, int y) {
        int numRows = map.length;
        int numCols = map[0].length;

        if (x < 0 || x >= numCols || y < 0 || y >= numRows) {
            return false; // Out of bounds
        }

        char cell = map[y][x];

        return cell == SPACE;
    }
}
