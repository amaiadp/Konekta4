package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.text.TableView.TableRow;

import kud.LanguagesController;
import model.Jokalaria;
import model.Jokoa;
import model.Ordenagailua;
import model.Tablero;

public class Nagusia extends JFrame{
	private int row=6;
	private int column=9;
	private JLabel[][] tablero;
	private static Nagusia nagusia;
	private LanguagesController hiztegia = Hizkuntza.getHiztegi();
	private JLabel kron = new JLabel("0", JLabel.CENTER);
	
	
	private Nagusia(){
		
	}
	
	public static Nagusia getnireNagusia(){
		if(nagusia==null){
			nagusia = new Nagusia();
		}
		return nagusia;
	}
	
	public void hasieratu(){
		kron.setText("0");
				//ZENBAKIAK ALDATU tableroaren tamainarekin
		tablero = new JLabel[row][column];
		JPanel panelTablero = new JPanel();
		GridLayout glayout = new GridLayout(row+1, column);
		panelTablero.setLayout(glayout);
		getContentPane().removeAll();
		getContentPane().repaint();
		getContentPane().add(panelTablero, BorderLayout.CENTER);
		JPanel panela = new JPanel();
		if (Jokoa.getNireJokoa().getModua()==0){
			JLabel jok1 = new JLabel(hiztegia.getWord("Jok1"), JLabel.CENTER);
			jok1.setForeground(Color.red);
			jok1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			JLabel jok2 = new JLabel(hiztegia.getWord("Jok2"), JLabel.CENTER);
			jok2.setForeground(Color.blue);
			jok2.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			panela.add(jok1, BorderLayout.WEST);
			panela.add(jok2, BorderLayout.EAST);
		}
		else{
			kron.setHorizontalTextPosition(SwingConstants.CENTER);
			kron.setHorizontalAlignment(SwingConstants.CENTER);
			kron.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			panela.add(kron, BorderLayout.CENTER);
		}
		getContentPane().add(panela, BorderLayout.NORTH);
		for(int col=0; col<column; col++){
			final int zutabe = col;
			JButton botoia = new JButton();
			panelTablero.add(botoia);
			botoia.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Jokoa.getNireJokoa().getModua()!=0){
						if(!Jokoa.getNireJokoa().kronHasita()){
							Jokoa.getNireJokoa().kronHasi();
						}
							
					}
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
				lauki.setHorizontalAlignment(JLabel.CENTER);
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

	public void kronEguneratu(long une) {
		kron.setText(Long.toString(une));
		
	}
}
