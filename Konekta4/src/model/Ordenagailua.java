package model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Ordenagailua extends Jokalaria{
	public Ordenagailua(boolean pFitxa){
		//jokalariarekin lotzea falta
		super(pFitxa);
		this.jokalariarenPosibleak = new ArrayList<>();
		this.ordenagiluarenPosibleak = new ArrayList<>();
	}
	
	private class Koordenatua{
		private int col;
		private int row;
		
		
		
		public Koordenatua(int prow, int pcol){
			row = prow;
			col = pcol;
		}
		
		public int getCol(){
			return col;
		}
		
		public int getRow(){
			return row;
		}
	}
	
	
	private ArrayList<Koordenatua> ordenagiluarenPosibleak;
	private ArrayList<Koordenatua> jokalariarenPosibleak;
	
	
	
	/**
	 * Ordenagailuak fitxa bat sartzeko duen metodo nagusia. Fitxa sartzeko tokirik hoberena bilatzen du.
	 */
	
	public void jokatu(){
		ezabatuZerrendatik(row, col, ordenagiluarenPosibleak);
		//ezabatuZerrendatik(row, col, jokalariarenPosibleak);
		int non = ordenagailuak4();
		if(non==-1){
			kalkulatuJokalariarenAzkena();
			non = jokalariak4();
			if(non==-1){
				boolean egokia = false;
				non = Math.random()*Tablero.column;
				int hasiera = non;
				while(!egokia){
					non = (non+1) % Tablero.column;
					if(Tablero.getNireTablero().azkenaLortuLibre(non)!=-1){
						egokia = hurrengoanJokalariakEzIrabazi(non);
						if(!egokia){
							if(non == hasiera){
								egokia = true;
							}
						}
					}
				}
			}
		}
		
		this.fitxaSartu(non);
		int row =Tablero.getNireTablero().azkenaLortuLibre(non);
		//ezabatuZerrendatik(row,non,ordenagiluarenPosibleak);
		ezabatuZerrendatik(row,non,jokalariarenPosibleak);
		kalkulatuOrdenagailuarenAzkena(row, non);
	}

	/**Ordenagiluak zein posiziotan fitxa bat sartuta 4 lerrokatu dezakeen kalkulatzen du eta ordenagailuarenPosibleak zerrendan sartzen ditu.
	 * @param row Ordenagailuak sartu duen azken fitxaren lerroa 
	 * @param col Ordenagailuak sartu duen azken fitxaren zutabea
	 */

	private void kalkulatuOrdenagailuarenAzkena(int row, int col) {
		kalkulatu4nonEginPosible(row, col, this.getFitxa(), ordenagiluarenPosibleak);	
	}

	private void kalkulatuJokalariarenAzkena() {
		kalkulatu4nonEginPosible(row, col, !this.getFitxa(), jokalariarenPosibleak);
		
	}

	/**
	 * Ordenagailuak col parametroan dioen zutabean fitxa bat sartuz gero jokalariak bere txandan 4 egin dezakeen itzultzen du.
	 * @param col Ordenagailuak fitxa sartuko duen zutabearen zenbakia.
	 * @return Jokalariak hurrengo txandan irabazteko aukera duen 
	 */
	private boolean hurrengoanJokalariakEzIrabazi(int col) {
		int hurrengoa = Tablero.getNireTablero().azkenaLortuLibre(col);	
		return !bilatuKoordenatua(col, hurrengoa+1, jokalariarenPosibleak);
	}
	
	/**
	 * Jokalariak fitxa bat sartuz gero 4 lerrokatu dezakeen zutabearen zenbakia itzultzen du.
	 * @return 4 lerrokatzeko zutabearen zenbakia
	 */
	private int jokalariak4() {
		int erantzuna = -1;
		for (Koordenatua koordenatua : jokalariarenPosibleak) {
			int col = koordenatua.getCol();
			int row = koordenatua.getRow();
			int hurrengoRow = Tablero.getNireTablero().azkenaLortuLibre(col);
			if(hurrengoRow==row){
				erantzuna = col;
			}
		}
		return erantzuna;
	}

	/**
	 * Ordenagailuak fitxa bat sartuz gero 4 lerrokatu dezakeen zutabearen zenbakia itzultzen du.
	 * @return 4 lerrokatzeko zutabearen zenbakia
	 */
	private int ordenagailuak4() {
		int erantzuna = -1;
		for (Koordenatua koordenatua : ordenagiluarenPosibleak) {
			int col = koordenatua.getCol();
			int row = koordenatua.getRow();
			int hurrengoRow = Tablero.getNireTablero().azkenaLortuLibre(col);
			if(hurrengoRow==row){
				erantzuna = col;
			}
		}
		return erantzuna;
	}
	
	private void kalkulatu4nonEginPosible(int row, int col, boolean mota, ArrayList<Koordenatua> zerrenda){
		kalkulatuGoitikBehera(row, col, mota, zerrenda);
		kalkulatuEzkerEskuin(row, col, mota, zerrenda);
		kalkulatuDiagonalEzkerGoi(row, col, mota, zerrenda);
		kalkulatuDiagonalEzkerBehe(row, col, mota, zerrenda);
	}

	private void kalkulatuDiagonalEzkerBehe(int row, int col, boolean mota, ArrayList<Koordenatua> zerrenda) {
		int momentukoCol = col;
		int momentukoRow = row;
		int kopurua = 0;
		int hutsaCol = -1;
		int hutsaRow = -1;
		boolean irten =false;
		while(momentukoCol> col -4 && !irten){ //sartutakotik ezkerrerantz lau
			if(Tablero.getNireTablero().tableroBarruan(momentukoRow, momentukoCol)){
				Boolean norena = Tablero.getNireTablero().getNorena(momentukoRow, momentukoCol);
				if(norena==null){
					if(hutsaCol!=-1){
						irten =true;
					}else{
						hutsaCol = momentukoCol;
						hutsaRow = momentukoRow;
						kopurua++;
					}
				}else{
					if(norena!=mota){
						irten = true;
					}
					else{
						kopurua++;
					}
				}
			}
			else{
				irten=true;
			}
			momentukoCol--;
			momentukoRow++;
		}
		int begiratutakoColTxikiena = momentukoCol +1;
		//int begiratutakoRowTxikiena = momentukoRow +1;
		if(kopurua==4 && hutsaCol!=-1){
			sartuKoordenatuaEzBadago(hutsaCol, hutsaRow, zerrenda);
		}
		momentukoCol = col+1;
		momentukoRow = row -1;
		while (momentukoCol< col +4 && !irten){
			//4 posizio arinago dagoena kendu
			if((momentukoCol-4)>=begiratutakoColTxikiena){
				if(Tablero.getNireTablero().tableroBarruan(momentukoRow+4, momentukoCol-4)){
					Boolean norena = Tablero.getNireTablero().getNorena(momentukoRow+4, momentukoCol-4);
					if(norena==null){
						if(hutsaCol==momentukoCol-4){
							kopurua--;
							hutsaCol =-1;
							hutsaRow = -1;
						}
					}else{
						if(norena==mota){
							kopurua--;
						}
					}
				}
			}
			if(Tablero.getNireTablero().tableroBarruan(momentukoRow, momentukoCol)){
				Boolean norena = Tablero.getNireTablero().getNorena(momentukoRow, momentukoCol);
				if(norena==null){
					if(hutsaCol!=-1){
						irten =true;
					}else{
						hutsaCol = momentukoCol;
						hutsaRow = momentukoRow;
						kopurua++;
					}
				}else{
					if(norena!=mota){
						irten = true;
					}
					else{
						kopurua++;
					}
				}
			}
			else{
				irten=true;
			}
			if(kopurua==4 && hutsaCol!=-1){
				sartuKoordenatuaEzBadago(hutsaCol, hutsaRow, zerrenda);
			}
			momentukoCol++;
			momentukoRow--;
		}
		
	}

	private void kalkulatuDiagonalEzkerGoi(int row, int col, boolean mota, ArrayList<Koordenatua> zerrenda) {
		int momentukoCol = col;
		int momentukoRow = row;
		int kopurua = 0;
		int hutsaCol = -1;
		int hutsaRow = -1;
		boolean irten =false;
		while(momentukoCol> col -4 && !irten){ //sartutakotik ezkerrerantz lau
			if(Tablero.getNireTablero().tableroBarruan(momentukoRow, momentukoCol)){
				Boolean norena = Tablero.getNireTablero().getNorena(momentukoRow, momentukoCol);
				if(norena==null){
					if(hutsaCol!=-1){
						irten =true;
					}else{
						hutsaCol = momentukoCol;
						hutsaRow = momentukoRow;
						kopurua++;
					}
				}else{
					if(norena!=mota){
						irten = true;
					}
					else{
						kopurua++;
					}
				}
			}
			else{
				irten=true;
			}
			momentukoCol--;
			momentukoRow--;
		}
		int begiratutakoColTxikiena = momentukoCol +1;
		//int begiratutakoRowTxikiena = momentukoRow +1;
		if(kopurua==4 && hutsaCol!=-1){
			sartuKoordenatuaEzBadago(hutsaCol, hutsaRow, zerrenda);
		}
		momentukoCol = col+1;
		momentukoRow = row +1;
		while (momentukoCol< col +4 && !irten){
			//4 posizio arinago dagoena kendu
			if((momentukoCol-4)>=begiratutakoColTxikiena){
				if(Tablero.getNireTablero().tableroBarruan(momentukoRow-4, momentukoCol-4)){
					Boolean norena = Tablero.getNireTablero().getNorena(momentukoRow-4, momentukoCol-4);
					if(norena==null){
						if(hutsaCol==momentukoCol-4){
							kopurua--;
							hutsaCol =-1;
							hutsaRow = -1;
						}
					}else{
						if(norena==mota){
							kopurua--;
						}
					}
				}
			}
			if(Tablero.getNireTablero().tableroBarruan(momentukoRow, momentukoCol)){
				Boolean norena = Tablero.getNireTablero().getNorena(momentukoRow, momentukoCol);
				if(norena==null){
					if(hutsaCol!=-1){
						irten =true;
					}else{
						hutsaCol = momentukoCol;
						hutsaRow = momentukoRow;
						kopurua++;
					}
				}else{
					if(norena!=mota){
						irten = true;
					}
					else{
						kopurua++;
					}
				}
			}
			else{
				irten=true;
			}
			if(kopurua==4 && hutsaCol!=-1){
				sartuKoordenatuaEzBadago(hutsaCol, hutsaRow, zerrenda);
			}
			momentukoCol++;
			momentukoRow++;
		}
		
	}

	private void kalkulatuGoitikBehera(int row, int col, boolean mota, ArrayList<Koordenatua> zerrenda) {
		boolean amaitu = false;
		int momentukoRow = row;
		int kont = 0;
		while(!amaitu){
			if(Tablero.getNireTablero().tableroBarruan(momentukoRow, col)){
				if(Tablero.getNireTablero().getNorena(momentukoRow, col)){
					kont++;
				}else{
					amaitu=true;
				}
			}else{
				amaitu=true;
			}
		}
		int hurrengoRow =Tablero.getNireTablero().azkenaLortuLibre(col);
		if(kont>=3 && hurrengoRow!=-1){
			this.sartuKoordenatuaEzBadago(col, hurrengoRow, zerrenda);
		}
	}

	private void kalkulatuEzkerEskuin(int row, int col, boolean mota, ArrayList<Koordenatua> zerrenda) {
		int momentukoCol = col;
		int kopurua = 0;
		int hutsaCol = -1;
		boolean irten =false;
		while(momentukoCol> col -4 && !irten){ //sartutakotik ezkerrerantz lau
			if(Tablero.getNireTablero().tableroBarruan(row, momentukoCol)){
				Boolean norena = Tablero.getNireTablero().getNorena(row, momentukoCol);
				if(norena==null){
					if(hutsaCol!=-1){
						irten =true;
					}else{
						hutsaCol = momentukoCol;
						kopurua++;
					}
				}else{
					if(norena!=mota){
						irten = true;
					}
					else{
						kopurua++;
					}
				}
			}
			else{
				irten=true;
			}
			momentukoCol--;
		}
		int begiratutakoColTxikiena = momentukoCol +1;
		if(kopurua==4 && hutsaCol!=-1){
			sartuKoordenatuaEzBadago(hutsaCol, row, zerrenda);
		}
		momentukoCol = col+1;
		while (momentukoCol< col +4 && !irten){
			//4 posizio arinago dagoena kendu
			if((momentukoCol-4)>=begiratutakoColTxikiena){
				if(Tablero.getNireTablero().tableroBarruan(row, momentukoCol-4)){
					Boolean norena = Tablero.getNireTablero().getNorena(row, momentukoCol-4);
					if(norena==null){
						if(hutsaCol==momentukoCol-4){
							kopurua--;
							hutsaCol =-1;
						}
					}else{
						if(norena==mota){
							kopurua--;
						}
					}
				}
			}
			if(Tablero.getNireTablero().tableroBarruan(row, momentukoCol)){
				Boolean norena = Tablero.getNireTablero().getNorena(row, momentukoCol);
				if(norena==null){
					if(hutsaCol!=-1){
						irten =true;
					}else{
						hutsaCol = momentukoCol;
						kopurua++;
					}
				}else{
					if(norena!=mota){
						irten = true;
					}
					else{
						kopurua++;
					}
				}
			}
			else{
				irten=true;
			}
			if(kopurua==4 && hutsaCol!=-1){
				sartuKoordenatuaEzBadago(hutsaCol, row, zerrenda);
			}
			momentukoCol++;
		}
	}

	private void sartuKoordenatuaEzBadago(int col, int row, ArrayList<Koordenatua> zerrenda) {		
		if(!bilatuKoordenatua(col, row, zerrenda)){
			zerrenda.add(new Koordenatua(row, col));
		}	
	}
	private boolean bilatuKoordenatua(int col, int row, ArrayList<Koordenatua> zerrenda){
		boolean aurkitua=false;
		for (Koordenatua koordenatua : zerrenda) {
			int kcol = koordenatua.getCol();
			int krow = koordenatua.getRow();
			if(kcol==col && krow==row){
				aurkitua = true;
			}
		}
		return aurkitua;
	}
	private void ezabatuZerrendatik(int row, int col, ArrayList<Koordenatua> zerrenda) {
		for (Koordenatua koordenatua : zerrenda) {
			int kcol = koordenatua.getCol();
			int krow = koordenatua.getRow();
			if(kcol==col && krow==row){
				zerrenda.remove(koordenatua);
			}
		}	
	}
}
