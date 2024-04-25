package com.qualifier.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class enemy extends sprite {
	
	public enemy(int x,int speed) {
		y=50;
		this.x=x;
		this.speed = speed;
		w=200;
		h=200;
		image = new ImageIcon(enemy.class.getResource("tank.gif"));
	}
public void move() {
	if(y>900) {
		y=0;
	}
		y=y+speed;
	}
	
}
