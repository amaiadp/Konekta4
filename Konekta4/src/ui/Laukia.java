package ui;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Laukia extends JLabel{
	
	private int col;
	private int row;
	
	public Laukia(int prow, int pcol) {
		col=pcol;
		row=prow;
	}
}
