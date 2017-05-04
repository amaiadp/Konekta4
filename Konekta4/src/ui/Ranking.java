package ui;


import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import kud.LanguagesController;

public class Ranking extends JPanel{
	private LanguagesController hiztegia = Hizkuntza.getHiztegi();
	
	public Ranking(int zailtasun){
		this.setLayout(new BorderLayout());
		Table taula = new Table(zailtasun);
		JLabel labela = new JLabel();
//		LanguagesController hiztegia = Nagusia.getNagusia().getHiztegia();
		if (zailtasun==1){
			labela.setText(hiztegia.getWord("rErraza"));
		}
		else{
			if (zailtasun==2){
				labela.setText(hiztegia.getWord("rZaila"));
			}
		}
		labela.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		this.add(labela, BorderLayout.NORTH);
		this.add(taula, BorderLayout.CENTER);
	}
	
	
	
	public static void main(String[] args) {
		new Ranking(1);
		new Ranking(2);
	}
	
}
