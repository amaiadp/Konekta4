package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.TableView.TableRow;

import model.Tablero;

public class Nagusia extends JFrame{
	private int row=6;
	private int column=9;
	private Laukia[][] tablero = new Laukia[row][column];
	
	
	public void hasieratu(){
				//ZENBAKIAK ALDATU tableroaren tamainarekin
		JPanel panelTablero = new JPanel();
		panelTablero.setLayout(new GridLayout(row+1, column));
		this.add(panelTablero);
		for(int col=0; col<column; col++){
			JButton botoia = new JButton();
			panelTablero.add(botoia);
			botoia.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Tablero.getNireTablero().hasieratu();
					
				}
			});
		}
		for(int r=0; r<row;r++){
			for(int col=0; col <column;col++){
				Laukia lauki = new Laukia(r, col);
				tablero[r][col] = lauki;
				panelTablero.add(lauki);
				lauki.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}
	}
	
	public static void main(String[] args) {
		Nagusia n = new Nagusia();
		n.hasieratu();
		n.pack();
		n.setVisible(true);
	}
}
