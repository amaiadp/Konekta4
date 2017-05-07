package model;

import javax.swing.JOptionPane;

import kud.LanguagesController;
import kud.RankingKud;
import ui.Amaiera;
import ui.Hizkuntza;
import ui.IzenaSartu;

public class Jokoa {
	
	private static Jokoa nireJokoa;
	private int txanda=0;
	private Jokalaria jokalariak[]= new Jokalaria [2];
	private int modua;
	private Jokalaria irabazlea=null;
	private int azkenRow;
	private int azkenCol;
	private boolean kronHasi;
	private LanguagesController hiztegi = Hizkuntza.getHiztegi();
	
	public static Jokoa getNireJokoa() {
		if (nireJokoa == null) {
			nireJokoa = new Jokoa();
		}
		return nireJokoa;
	}
	
	public Jokalaria lortuJokalaria() {
		if(txanda%2==0){
			return jokalariak[0];
		}
		else{
			return jokalariak[1];
		}
	}
	
	public void hasieratuJokJok() {
		irabazlea=null;
		modua=0;
		txanda = 0;
		azkenCol = -1;
		azkenRow = -1;
		Jokalaria j2= new Jokalaria(false);
		Jokalaria j1= new Jokalaria(true);
		jokalariak[0]=j1;
		jokalariak[1]=j2;
		Tablero.getNireTablero().hasieratu();
		kronHasi=false;	
	}
	
	public void hasieratuErreza() {
		irabazlea=null;
		modua=1; 
		txanda = 0;
		azkenCol = -1;
		azkenRow = -1;
		Ordenagailua ord= new Ordenagailua(false);
		Jokalaria j= new Jokalaria(true);
		jokalariak[1]=ord;
		jokalariak[0]=j;
		Tablero.getNireTablero().hasieratu();
		kronHasi=false;
		
	}
	
	public void hasieratuZaila() {
		irabazlea=null;
		modua=2;
		txanda=0;
		azkenCol = -1;
		azkenRow = -1;
		Ordenagailua ord= new Ordenagailua(false);
		Jokalaria j= new Jokalaria(true);
		jokalariak[1]=ord;
		jokalariak[0]=j;
		Tablero.getNireTablero().hasieratu();
		kronHasi=false;
		
	}
	
	public void txandaGehitu() {
		txanda++;
		
	}
	
	public int getModua() {
		return modua;
	}
	
	public int getAzkenRow(){
		return azkenRow;
	}
	
	public int getAzkenCol(){
		return azkenCol;
	}
	
	public void setAzkenCol(int azkenCol) {
		this.azkenCol = azkenCol;
	}
	
	public void setAzkenRow(int azkenRow) {
		this.azkenRow = azkenRow;
	}
	
	public void setIrabazlea(Jokalaria irabazlea) {
		this.irabazlea = irabazlea;
	}
	
	public void amaitu() {
		int denbora = -1;
		Boolean irab = null;
		if(irabazlea!=null){
			irab = irabazlea.getFitxa();
		}
		if (modua!=0){
			if(!(irabazlea instanceof Ordenagailua)){
				denbora = (int)Kronometro.getKronometro().getDenboraTartea();
				System.out.println("Irabazi: " +Long.toString(denbora));
				if (RankingKud.getInstantzia().sartuDa(modua, denbora)){
					String izena = null;
					while(izena==null){
						izena = IzenaSartu.showInputDialog(hiztegi.getWord("SartuIzena"),new String[]{hiztegi.getWord("OK")});
						if(izena==null){
							JOptionPane.showMessageDialog(null,
								    hiztegi.getWord("ErroreaIzena"),
								    hiztegi.getWord("Izena"),
								    JOptionPane.ERROR_MESSAGE);
						}
					}
					RankingKud.getInstantzia().rankingGehitu(izena, denbora, modua);
					System.out.println(hiztegi.getWord("OrdIrabazi"));
				}
			}
		}
		Amaiera amaiera = new Amaiera();
		amaiera.bistaratu(modua, irab, denbora);
		System.out.println("Jokoa amaituta dago");
	}
	
	public boolean amaituta() {
		return irabazlea!=null || Tablero.getNireTablero().tableroaBeteta();
	}
	
	public boolean kronHasita() {
		return kronHasi;
	}
	
	public void kronHasi(){
		kronHasi=true;
		Kronometro.getKronometro().hasieratu();
	}
	
	public int getTxanda() {
		return txanda;
	}
	
}
