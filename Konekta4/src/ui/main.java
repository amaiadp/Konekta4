package ui;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kud.LanguagesController;
import model.Jokoa;

public class main extends JFrame{
	
	private LanguagesController hiztegi = Hizkuntza.getHiztegi();
	private static main nireMain;
	
	private main(){
		hasieratu();
		setVisible(true);
	}
	
	public static main getMain(){
		if(nireMain==null){
			nireMain = new main();
		}
		return nireMain;
	}
	
	public void hasieratu(){
	 this.setTitle(hiztegi.getWord("Aukeratu"));
     this.setSize(600,75); //ancho, alto
     this.setLayout(new GridLayout(1,2));
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
      
 
        
         JPanel panelLetras = new JPanel();
         panelLetras.setLayout(new FlowLayout());
         panelLetras.setSize(500,117);         
         JButton  jokjok = new JButton(hiztegi.getWord("BJvsj"));
         JButton erreza = new JButton(hiztegi.getWord("BErraza"));
         JButton  zaila = new JButton(hiztegi.getWord("BZaila"));
         JButton rank = new JButton(hiztegi.getWord("BRanking"));
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
				setVisible(false);
			}
		} );
         
         
         erreza.addActionListener( new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				Jokoa.getNireJokoa().hasieratuErreza();
 				Nagusia.getnireNagusia().hasieratu();
 				setVisible(false);
 			}
 		} );
         
         
         zaila.addActionListener( new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				Jokoa.getNireJokoa().hasieratuZaila();
 				Nagusia.getnireNagusia().hasieratu();
 				setVisible(false);
 				
 			}
 		} );
         
         rank.addActionListener( new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				new RankingTab();
 			}
 		} );
      
         this.pack();

         setLocationRelativeTo(null);
         
	}
	public static void main(String[] args) {
		Hizkuntza h = new Hizkuntza();
		h.hasieratu();
	}
}
