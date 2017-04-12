package model;

public class Jokalaria {
	private boolean fitxa;

	public void fitxaSartu(int col){
		int row=0;
		Tablero t= Tablero.getNireTablero();
		boolean daude = false;
		row = tableroanSartu(col);
		if(row!=-1){
			daude =t.konprobatu(fitxa, row, col);
		}
		if(daude){
			//irabazlea markatu
			//partida amaitu
		}
		
	}

	private int tableroanSartu(int col) {
		Tablero t= Tablero.getNireTablero();
		Jokalaria j= Jokoa.getNireJokoa().lortuJokalaria();
		int row =t.azkenaLortuLibre(col);
		if (row !=-1){
			t.setTablero(row,col,j.fitxa);
		}
		return row;
	}
}
