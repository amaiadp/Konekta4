package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Jokoa;

public class main extends JFrame{
	public void hasieratu(){
	 this.setTitle("Aukeratu");
     this.setSize(600,75); //ancho, alto
     this.setLayout(new GridLayout(1,2));
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
      
 
        
         JPanel panelLetras = new JPanel();
         panelLetras.setLayout(new FlowLayout());
         panelLetras.setSize(500,117);         
         JButton  jokjok = new JButton("Jokalari vs Jokalari");
         JButton erreza = new JButton("Ordenagailu erreza");
         JButton  zaila = new JButton("Ordenagailu zaila");
         JButton rank = new JButton("Rankig-a ikusi");
         panelLetras.add(erreza);
         panelLetras.add(jokjok);
         panelLetras.add(zaila);
         panelLetras.add(rank);
      
         this.getContentPane().add(panelLetras); 
         
         jokjok.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Jokoa.getNireJokoa().hasieratuJokJok();
				Nagusia.getnireNagusia().hasieratu();
				
			}
		} );
         
         
         erreza.addActionListener( new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				Jokoa.getNireJokoa().hasieratuErreza();
 				Nagusia.getnireNagusia().hasieratu();
 			}
 		} );
         
         
         zaila.addActionListener( new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				Jokoa.getNireJokoa().hasieratuZaila();
 				Nagusia.getnireNagusia().hasieratu();
 				
 			}
 		} );
         
         rank.addActionListener( new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 			//	Jokoa.getNireJokoa().hasieratuRanking();
 				
 			}
 		} );
      
}
	public static void main(String[] args) {
		main n = new main();
		n.hasieratu();
		n.setVisible(true);
	}
}
