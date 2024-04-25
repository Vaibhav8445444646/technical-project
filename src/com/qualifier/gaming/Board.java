package com.qualifier.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.qualifier.gaming.sprites.enemy;
import com.qualifier.gaming.sprites.player;

public class Board extends JPanel {
	Timer timer;
	BufferedImage backgroundImage;
	player player;
	enemy enemies[] = new enemy[4];
public Board() {
	setSize(1500,920);
	loadBackgroundImage();
	player =new player();
	loadEnemies();
	gameLoop();

	bindEvents();
	setFocusable(true);
}
private void gameOver(Graphics pen) {
	if(player.outOfScreen()) {
		pen.setFont(new Font("times", Font.BOLD, 30));
		pen.setColor(Color.RED);
	    pen.drawString("Game Win ",1500/2,900/2);	
	    timer.stop();
	    return;
	}
	for(enemy Enemy: enemies) {
		if(isCollide(Enemy)) {
			pen.setFont(new Font("times", Font.BOLD, 30));
			pen.setColor(Color.RED);
		    pen.drawString("Game Over",1500/2,900/2);	
		    timer.stop();
		}
	}
}
private boolean isCollide(enemy Enemy) {
	 int xDistance = Math.abs(player.x- Enemy.x);
	 int yDistance = Math.abs(player.y- Enemy.y);
	 int maxH = Math.max(player.h,Enemy.h);
	 int maxW = Math.max(player.w,Enemy.w);
	 return xDistance <= maxW-150 && yDistance<=maxH-70;
}
private void bindEvents() {
	addKeyListener(new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.speed =5;
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				player.speed = -5;
			}
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			player.speed =0;
			// TODO Auto-generated method stub
			
		}
	});
		
}
private void loadEnemies() {
	int x=200;
	int gap =300;
	int speed = 5;
	for(int i=0;i<enemies.length;i++) {
		enemies[i]=new enemy(x,speed);
		x=x+gap;
		speed = speed + 5;
	}
}
private void gameLoop() {
	timer = new Timer(50,(e)->repaint());
	timer.start();
}
private void loadBackgroundImage() {
	try{
		backgroundImage = ImageIO.read(Board.class.getResource("hello.png"));
	} catch(IOException e) {
		System.out.println("no img found");
		System.exit(1);
		e.printStackTrace();
	}
}
private void printEnemies(Graphics pen) {
	for(enemy Enemy:enemies) {
		Enemy.draw(pen);
		Enemy.move();
	}
}
@Override
public void paintComponent(Graphics pen) {
	super.paintComponent(pen);//clean up
	//start painting from here
	pen.drawImage(backgroundImage,0,0,1500,920,null);
	player.draw(pen);
	player.move();
	printEnemies(pen);
	gameOver(pen);
	
}
}
