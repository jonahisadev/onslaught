package me.jonahisadev.onslaught;

import com.amittaigames.engine.graphics.Rect;

public class Entity {

	private Rect bg;
	private Rect fg;
	private float border;
	
	public Entity(float x, float y, float width, float height, float border) {
		this.border = border;
		this.bg = new Rect(x, y, width, height);
		this.bg.setColor(0, 0, 0);
		this.fg = new Rect(bg.getX() + border, bg.getY() + border, 
				bg.getWidth() - (border * 2), bg.getHeight() - (border * 2));
		this.fg.setColor(255, 255, 255);
	}
	
	public void setRotation(float angle) {
		this.bg.setAngle(angle);
		this.fg.setAngle(angle);
	}
	
	public void setColor(int r, int g, int b) {
		this.fg.setColor(r, g, b);
	}
	
	public Rect getBG() {
		return bg;
	}
	
	public Rect getFG() {
		return fg;
	}
	
}