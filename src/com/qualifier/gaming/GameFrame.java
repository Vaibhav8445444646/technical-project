package com.qualifier.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	public GameFrame() {
		Board board = new Board();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Road Rash");
		setSize(1500,920);
		setResizable(false);
		setLocationRelativeTo(null);
		add(board);
		setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 new GameFrame();
		
	}

}
