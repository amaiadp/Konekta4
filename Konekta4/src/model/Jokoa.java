package model;

public class Jokoa {
	private static Jokoa nireJokoa;
	private int txanda=0;
	private Jokalaria jokalariak[]= new Jokalaria [2];
	private int modua;
	private Jokalaria irabazlea=null;
	private int azkenRow;
	private int azkenCol;
	public static Jokoa getNireJokoa() {
		if (nireJokoa == null) {
			nireJokoa = new Jokoa();
		}
		return nireJokoa;
	}
	public Jokalaria lortuJokalaria() {
		if(txanda%2==0){
			return jokalariak[1];
		}
		else{
			return jokalariak[2];
		}
	}
	public void hasieratuJokJok() {
		irabazlea=null;
		modua=0;
		txanda = 0;
		Jokalaria j1= new Jokalaria(false);
		Jokalaria j2= new Jokalaria(true);
		jokalariak[0]=j1;
		jokalariak[1]=j2;
		Tablero t = Tablero.getNireTablero().hasieratu();
		
		
	}
	public void hasieratuErreza() {
		irabazlea=null;
		modua=1; 
		txanda = 0;
		Ordenagailua ord= new Ordenagailua(false);
		Jokalaria j= new Jokalaria(true);
		jokalariak[0]=ord;
		jokalariak[1]=j;
		Tablero t = Tablero.getNireTablero().hasieratu();
		
	}
	public void hasieratuZaila() {
		irabazlea=null;
		modua=2;
		txanda=0;
		Ordenagailua ord= new Ordenagailua(false);
		Jokalaria j= new Jokalaria(true);
		jokalariak[0]=ord;
		jokalariak[1]=j;
		Tablero t = Tablero.getNireTablero().hasieratu();
		
	}
	
	

}
