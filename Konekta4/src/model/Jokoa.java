package model;

public class Jokoa {
	private static Jokoa nireJokoa;
	private int txanda=0;
	private Jokalaria jokalariak[]= new Jokalaria [2];
	private int modua;
	private Jokalaria irabazlea=null;
	private int azkenRow;
	private int azkenCol;
	private boolean kronHasi;
	
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
		Tablero t = Tablero.getNireTablero().hasieratu();
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
		Tablero t = Tablero.getNireTablero().hasieratu();
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
		Tablero t = Tablero.getNireTablero().hasieratu();
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
		// TODO Auto-generated method stub
		if (modua==0){
			if(irabazlea==null){
				//Ez du inork irabazi :(
			}
			else{
				//X Jokalariak irabazi du
			}
		}
		else{
			
		}
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
	
}
