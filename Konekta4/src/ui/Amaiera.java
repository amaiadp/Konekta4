package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import kud.LanguagesController;

public class Amaiera extends JDialog {

	private String mezua;
	private String titulua;
	private LanguagesController hiztegi = Hizkuntza.getHiztegi();
	private Font fuente = new Font("Lucida Grande", Font.BOLD, 18);
	private Border border = BorderFactory.createEmptyBorder(10,10,10,10);
	
	public void bistaratu(int modua, Boolean irabazlea, int denbora){
		setLayout(new BorderLayout());
		setModal(true);
		JButton berriroHasi = new JButton(hiztegi.getWord("BerriroJokatu"));
		JButton ranking = new JButton(hiztegi.getWord("BRanking"));
		JButton irten = new JButton(hiztegi.getWord("Irten"));
		JPanel botoiak = new JPanel();
		botoiak.setBorder(border);
		ranking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RankingTab();
			}
		});
		irten.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		berriroHasi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Nagusia.getnireNagusia().hasieratu();
				Nagusia.getnireNagusia().setVisible(false);
				main.getMain().setVisible(true);
				dispose();
				
			}
		});
		botoiak.add(irten, BorderLayout.WEST);
		botoiak.add(ranking, BorderLayout.CENTER);
		botoiak.add(berriroHasi, BorderLayout.EAST);
		
		JPanel printzipala = new JPanel(new BorderLayout());
		printzipala.setBorder(border);
		if(modua==0){
			titulua = hiztegi.getWord("BJvsj")+": ";
			if (irabazlea==null){
				mezua = hiztegi.getWord("BerdinketaJokvsJok");
				titulua = titulua + hiztegi.getWord("BerdinketaJokvsJok");
			}
			else{
				if(!irabazlea){
					mezua = "<html><font color='blue'>"+hiztegi.getWord("Jok2")+"</font>";
					titulua = titulua + hiztegi.getWord("Jok2");
				}
				else{
					titulua = titulua + hiztegi.getWord("Jok1");
					mezua = "<html><font color='red'>"+hiztegi.getWord("Jok1")+"</font>";
				}
				mezua = mezua + hiztegi.getWord("JokvsJok")+ "</html>";
			}
			JLabel mez = new JLabel(mezua, JLabel.CENTER);
			mez.setFont(fuente);
			printzipala.add(mez, BorderLayout.CENTER);
		}
		else{
			ImageIcon image;
			String denb;
			if(modua==1){
				titulua = hiztegi.getWord("BErraza")+": ";
			}
			else{
				titulua = hiztegi.getWord("BZaila")+": ";
			}
			if(irabazlea==null){
				image= new ImageIcon("images/drawn.gif");
				titulua = titulua + hiztegi.getWord("BerdinketaOrd");
				mezua = hiztegi.getWord("BerdinketaOrd");
				denb = null;
			}
			else{
				if(irabazlea){
					mezua = hiztegi.getWord("OrdIrabazi");
					denb = Integer.toString(denbora);
					titulua = titulua + hiztegi.getWord("Irabazi");
					image = new ImageIcon("images/winner.gif");
				}
				else{
					mezua = hiztegi.getWord("OrdGaldu");
					denb= null;
					titulua = titulua + hiztegi.getWord("Galdu");
					image = new ImageIcon("images/loser.gif");
				}
			}
			JLabel irudia = new JLabel(image, JLabel.CENTER);
			if (denb!=null){
				JLabel den = new JLabel(hiztegi.getWord("Denb1")+" "+denb+" "+ hiztegi.getWord("Denb2"), JLabel.CENTER);
				den.setFont(fuente);
				printzipala.add(den, BorderLayout.SOUTH);
			}
			JLabel mez = new JLabel(mezua, JLabel.CENTER);
			mez.setFont(fuente);;
			printzipala.add(mez, BorderLayout.NORTH);
			printzipala.add(irudia, BorderLayout.CENTER);
		}
		setTitle(titulua);
		getContentPane().add(botoiak, BorderLayout.SOUTH);
		getContentPane().add(printzipala, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
