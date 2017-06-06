package me.jonahisadev.onslaught;

import com.amittaigames.engine.CoreGame;
import com.amittaigames.engine.graphics.Font;
import com.amittaigames.engine.graphics.Rect;
import com.amittaigames.engine.graphics.Render;
import com.amittaigames.engine.graphics.Window;
import com.amittaigames.engine.util.Mouse;

public class Game extends CoreGame {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private Player player;
	private Rect cursor;
	
	private Font debugFont;
	
	public static void main(String[] args) {
		Window.init("Onslaught", WIDTH, HEIGHT, false, new Game());
	}

	@Override
	public void init() {
		player = new Player((WIDTH / 2) - (Player.getWidth() / 2), (HEIGHT / 2) - (Player.getHeight() / 2));
		player.setColor(131, 214, 170);
		
		cursor = new Rect(0, 0, 5, 5);
		cursor.setColor(5, 5, 5);
		
		Font.load("/fonts/Monospaced", 1, 0.25f);
		debugFont = Font.get("Monospaced 1");
		debugFont.setColor(0, 0, 0);
		
		Window.setCursorHidden(true);
	}

	@Override
	public void render(Render render) {
		// BACKGROUND
		render.clear(250, 250, 250);
		
		// PLAYER
		render.drawRect(player.getBG());
		render.drawRect(player.getFG());
		
		// CURSOR
		render.drawRect(cursor);
	}

	@Override
	public void update(float v) {
		// MOUSE COORDS
		float mouseX = Window.getMouseX();
		float mouseY = Window.getMouseY();
		
		// CURSOR
		cursor.setPosition(mouseX - 2.5f, mouseY - 2.5f);
		
		// PLAYER ANGLE
		float dx = mouseX - (player.getBG().getX() + (player.getWidth() / 2));
		float dy = mouseY - (player.getBG().getY() + (player.getHeight() / 2));;
		float angle = (float)Math.toDegrees(Math.atan(dy/dx));
		player.setRotation(angle);
	}

	@Override
	public void cleanUp() {
		
	}
	
}