package me.jonahisadev.onslaught;

public class Player extends Entity {

	private static float width = 75;
	private static float height = 75;
	
	public Player(float x, float y) {
		super(x, y, width, height, 5);
	}

	public static float getWidth() {
		return width;
	}

	public static float getHeight() {
		return height;
	}
	
}
