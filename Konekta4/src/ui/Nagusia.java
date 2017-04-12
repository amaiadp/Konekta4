package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.TableView.TableRow;

public class Nagusia extends JFrame{

	private Laukia[][] tablero = new Laukia[6][9];
	
	public void hasieratu(){
				//ZENBAKIAK ALDATU tableroaren tamainarekin
		JPanel panelTablero = new JPanel();
		panelTablero.setLayout(new GridLayout(7, 9));
		this.add(panelTablero);
		for(int col=0; col<9; col++){
			JButton botoia = new JButton();
			panelTablero.add(botoia);
			botoia.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		for(int row=0; row<6;row++){
			for(int col=0; col <9;col++){
				Laukia lauki = new Laukia(row, col);
				tablero[row][col] = lauki;
				panelTablero.add(lauki);
			}
		}
	}
	
	public static void main(String[] args) {
		Nagusia n = new Nagusia();
		n.hasieratu();
		n.setVisible(true);
	}
}
