package com.ltztec.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.ltztec.main.Game;


public class UI {
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD,25));
		g.drawString("Score - " + (int)Game.score, 10, 30);
	}
	
}
