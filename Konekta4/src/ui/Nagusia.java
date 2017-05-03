package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.TableView.TableRow;

import model.Jokalaria;
import model.Jokoa;
import model.Ordenagailua;
import model.Tablero;

public class Nagusia extends JFrame{
	private int row=6;
	private int column=9;
	private JLabel[][] tablero;
	private static Nagusia nagusia;
	
	
	private Nagusia(){
		
	}
	
	public static Nagusia getnireNagusia(){
		if(nagusia==null){
			nagusia = new Nagusia();
		}
		return nagusia;
	}
	
	public void hasieratu(){
				//ZENBAKIAK ALDATU tableroaren tamainarekin
		tablero = new JLabel[row][column];
		JPanel panelTablero = new JPanel();
		GridLayout glayout = new GridLayout(row+1, column);
		panelTablero.setLayout(glayout);
		this.add(panelTablero);
		for(int col=0; col<column; col++){
			int zutabe = col;
			JButton botoia = new JButton();
			panelTablero.add(botoia);
			botoia.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!Jokoa.getNireJokoa().amaituta()){
						Jokalaria j = Jokoa.getNireJokoa().lortuJokalaria();
						boolean sartuta = j.fitxaSartu(zutabe);
						if(sartuta){
							Jokoa.getNireJokoa().txandaGehitu();
							if(!Jokoa.getNireJokoa().amaituta()){
								if(Jokoa.getNireJokoa().getModua()==1){
									Ordenagailua o = (Ordenagailua) Jokoa.getNireJokoa().lortuJokalaria();
									o.jokatuErraza();
									Jokoa.getNireJokoa().txandaGehitu();
								}else if(Jokoa.getNireJokoa().getModua()==2){
			
										Ordenagailua o = (Ordenagailua) Jokoa.getNireJokoa().lortuJokalaria();
										o.jokatuZaila();
										Jokoa.getNireJokoa().txandaGehitu();
									
								}
							}
						}else{
							//TODO
						}
					}
				}
			});
		}
		for(int r=0; r<row;r++){
			for(int col=0; col <column;col++){
				JLabel lauki = new JLabel();
				tablero[r][col] = lauki;
				panelTablero.add(lauki);
				lauki.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}
		
		
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Nagusia n = Nagusia.getnireNagusia();
		n.hasieratu();
		n.pack();
		n.setVisible(true);
	}

	public void fitxaJarri(int row, int col, boolean fitxa) {
		String kolorea;
		if (fitxa){
			kolorea = "gorria";
		}else{
			kolorea = "urdina";
		}
		ImageIcon image = new ImageIcon("images/"+kolorea+".png");

		tablero[row][col].setIcon(image);;
	}
}
