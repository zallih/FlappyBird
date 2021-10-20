package com.ltztec.world;

import com.ltztec.entities.Entity;
import com.ltztec.entities.Pipe;
import com.ltztec.main.Game;

public class GeneratePipe {
	
	public int time = 0;
	public int targetTime = 60*2; 
	
	
	public void tick() {
		time++;
		if(time == targetTime) {
			int length1 = Entity.rand.nextInt((60 - 30) + 30);
			Pipe pipe1 = new Pipe(Game.WIDTH, 0, 30, length1, 1, Game.spritesheet.getSprite(16, 16, 16, 32));
			
			int length2 = Entity.rand.nextInt((60 - 30) + 30);
			Pipe pipe2 = new Pipe(Game.WIDTH, Game.HEIGHT - length2, 30, length2, 1,  Game.spritesheet.getSprite(0, 16, 16, 32));
			
			
			Game.entities.add(pipe1);
			Game.entities.add(pipe2);
			time = 0;
		}
	}
}
