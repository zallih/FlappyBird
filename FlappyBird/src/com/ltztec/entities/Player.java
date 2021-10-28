package com.ltztec.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ltztec.main.Game;
import com.ltztec.world.Camera;
import com.ltztec.world.World;

public class Player extends Entity {
	private int frames = 0, maxFrames = 8, index = 0, maxIndex = 2;
	private BufferedImage[] sprites;
	public boolean isPressed = false;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		sprites = new BufferedImage[3];
		sprites[0] = Game.spritesheet.getSprite(0, 0, 16, 16);
		sprites[1] = Game.spritesheet.getSprite(16, 0, 16, 16);
		sprites[2] = Game.spritesheet.getSprite(32, 0, 16, 16);
	}

	public void tick() {

		if (!isPressed) {
			y += 2;
		} else {
			if (y > 0) {
				y -= 2;
			}
		}

		if (y > Game.HEIGHT) {
			World.restartGame();
			return;
		}

		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e != this) {
				if (Entity.isColidding(this, e)) {
					World.restartGame();
					return;
				}
			}
		}

		frames++;
		if (frames == maxFrames) {
			frames = 0;
			index++;
			if (index > maxIndex) {
				index = 0;
			}

		}

	}

	public void render(Graphics g) {
		super.render(g);
		g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);

	}
}