package com.qualifier.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class player extends sprite {
	
	public player() {
		w=150;
		h=150;
		x=0;
		y=400;
		image = new ImageIcon(player.class.getResource("players.gif"));
		
	}
	public void move() {
		x = x + speed;
	}
	public boolean outOfScreen() {
		return x > 1500;
	}
	
}
