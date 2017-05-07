package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
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
	private JLabel jok1;
	private JLabel jok2;
	
	private Nagusia(){
		
	}
	
	public static Nagusia getnireNagusia(){
		if(nagusia==null){
			nagusia = new Nagusia();
		}
		return nagusia;
	}
	
	public void hasieratu(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 480);
		kron.setText("0");
		JPanel panelNagusia =  (JPanel) this.getContentPane();
		panelNagusia.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		tablero = new JLabel[row][column];
		JPanel panelTablero = new JPanel();
		GridLayout glayout = new GridLayout(row+1, column);
		panelTablero.setLayout(glayout);
		getContentPane().removeAll();
		getContentPane().repaint();
		panelNagusia.add(panelTablero, BorderLayout.CENTER);
		JPanel goikoPanela = new JPanel(new BorderLayout());
		if (Jokoa.getNireJokoa().getModua()==0){
			jok1 = new JLabel(hiztegia.getWord("Jok1"));
			jok1.setForeground(Color.red);
			jok1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			jok2 = new JLabel(hiztegia.getWord("Jok2"));
			jok2.setForeground(Color.blue);
			jok2.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			goikoPanela.add(jok1, BorderLayout.WEST);
			goikoPanela.add(jok2, BorderLayout.EAST);
			jok1.setBorder(BorderFactory.createLineBorder(Color.red));
		}
		else{
			kron.setHorizontalTextPosition(SwingConstants.CENTER);
			kron.setHorizontalAlignment(SwingConstants.CENTER);
			kron.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			goikoPanela.add(kron, BorderLayout.CENTER);
			JLabel jok1 = new JLabel(hiztegia.getWord("Jok1"));
			jok1.setForeground(Color.red);
			jok1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			goikoPanela.add(jok1, BorderLayout.WEST);
		}
		goikoPanela.setBorder(BorderFactory.createEmptyBorder(0, 10, 15, 10));
		panelNagusia.add(goikoPanela, BorderLayout.NORTH);
		
		JPanel behekoPanela = new JPanel(new BorderLayout());
		JButton berriroJokatu = new JButton(hiztegia.getWord("BerriaHasi"));
		behekoPanela.add(berriroJokatu, BorderLayout.EAST);
		panelNagusia.add(behekoPanela, BorderLayout.SOUTH);
		berriroJokatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jokoa joko = Jokoa.getNireJokoa();
				if(joko.getModua()==0){
					joko.hasieratuJokJok();
				}else{
					if(joko.getModua()==1){
						joko.hasieratuErreza();
					}else{
						if(joko.getModua()==2){
							joko.hasieratuZaila();
						}
					}
				}
				dispose();
				Nagusia.getnireNagusia().hasieratu();
				
			}
		});

		ImageIcon arrow = new ImageIcon("images/arrow.png");
		for(int col=0; col<column; col++){
			final int zutabe = col;
			JButton botoia = new JButton();
			botoia.setIcon(arrow);
			botoia.setSize(45, 45);
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
									
								}else{
									if (Jokoa.getNireJokoa().getTxanda()%2==0){
										jok1.setBorder(BorderFactory.createLineBorder(Color.red));
										jok2.setBorder(null);
									}else{
										jok2.setBorder(BorderFactory.createLineBorder(Color.blue));
										jok1.setBorder(null);
									}
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
				lauki.setVerticalAlignment(JLabel.CENTER);
				lauki.setSize(45, 45);
				lauki.setHorizontalAlignment(JLabel.CENTER);
				tablero[r][col] = lauki;
				panelTablero.add(lauki);
				lauki.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}
		
		JMenuBar menuBar = new JMenuBar();
		JMenuItem nolaJokatuBotoia = new JMenuItem(hiztegia.getWord("nolaJokatuBotoia"));
		nolaJokatuBotoia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog(Nagusia.getnireNagusia(), hiztegia.getWord("nolaJokatuBotoia"), true);
				JTextPane testuPanela = new JTextPane();
				testuPanela.setContentType("text/html");
				testuPanela.setText(hiztegia.getWord("nolaJokatu"));
				dialog.add(testuPanela);
				testuPanela.setEditable(false);
				testuPanela.setBackground(null);
				testuPanela.setBorder(BorderFactory.createEmptyBorder(20, 20,20, 20));
				dialog.setSize(400, 500);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
				
				
			}
		});
		menuBar.add(nolaJokatuBotoia);
		this.setJMenuBar(menuBar);
		
		//this.pack();

		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Nagusia n = Nagusia.getnireNagusia();
		n.hasieratu();
		//n.pack();
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
