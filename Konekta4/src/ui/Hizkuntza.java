package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kud.LanguagesController;
import model.Jokoa;

public class Hizkuntza extends JFrame{

	private Hizkuntza hizkuntza = null;
	private static LanguagesController hiztegi; 
	
	public static LanguagesController getHiztegi(){
		if (hiztegi==null){
			hiztegi = new LanguagesController("Euskera");
		}
		return hiztegi;
	}
	
	public void hasieratu(){
		 this.setTitle("Language");
	     this.setSize(600,75); //ancho, alto
	     this.setLayout(new GridLayout(1,2));
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setVisible(true);
	      
	         JPanel hizkuntzak = new JPanel();
	         JButton  euskera = new JButton("Euskera");
	         JButton español = new JButton("Español");
	         hizkuntzak.add(euskera, BorderLayout.NORTH);
	         hizkuntzak.add(español, BorderLayout.SOUTH);
	      
	         setContentPane(hizkuntzak);
	         
	         euskera.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Hizkuntza.hiztegi = new LanguagesController("Euskera");
					main m = new main();
					m.hasieratu();
					m.setVisible(true);
					Hizkuntza.this.setVisible(false);
				}
			} );
	         
	         
	         español.addActionListener( new ActionListener() {
	 			
	 			@Override
	 			public void actionPerformed(ActionEvent arg0) {
	 				Hizkuntza.hiztegi = new LanguagesController("Español");
					main m = new main();
					m.hasieratu();
					m.setVisible(true);
					Hizkuntza.this.setVisible(false);
	 			}
	 		} );
	        pack();
	        setVisible(true);
	      
	}
	
	public static void main(String[] args) {
		Hizkuntza h = new Hizkuntza();
		h.hasieratu();
	}
}
