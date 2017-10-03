package model;

import ui.Nagusia;

public class Jokalaria {
	private boolean fitxa;
	public Jokalaria(boolean pFitxa){
		fitxa=pFitxa;
	}
	public boolean fitxaSartu(int col){
		boolean sartuta = false;
		int row=0;
		Tablero t= Tablero.getNireTablero();
		boolean daude = false;
		row = tableroanSartu(col);
		if(row!=-1){
			Jokoa.getNireJokoa().setAzkenCol(col);
			Jokoa.getNireJokoa().setAzkenRow(row);
			Nagusia.getnireNagusia().fitxaJarri(row, col, fitxa);
			sartuta = true;
			daude =t.konprobatu(fitxa, row, col);		
		}
		if(daude){
			System.out.println("Irabazlea: " +fitxa);
			Jokoa.getNireJokoa().setIrabazlea(this);
			Jokoa.getNireJokoa().amaitu();
		}else{
			if(Tablero.getNireTablero().tableroaBeteta()){
				Jokoa.getNireJokoa().amaitu();
			}
		}
		return sartuta;
		
	}

	private int tableroanSartu(int col) {
		Tablero t= Tablero.getNireTablero();
		int row =t.azkenaLortuLibre(col);
		if (row !=-1){
			t.setTablero(row,col,this.fitxa);
		}
		return row;
	}
	
	public boolean getFitxa(){
		return this.fitxa;
	}
}
