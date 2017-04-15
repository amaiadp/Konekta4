package model;

public class Tablero {
	private static Tablero nireTablero;
	private int row=6;
	private int column=9;
	private Boolean[][] lista;
	public static Tablero getNireTablero() {
		if (nireTablero == null) {
			nireTablero = new Tablero();
		}
		return nireTablero;
	}
	public Tablero() {
		this.lista = new Boolean[row][column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				this.lista[i][j] = null;
			}
		}
	}
	
	public void setTablero(int row, int col, boolean jok){
		this.lista[row][col]=jok;
	}
	public int azkenaLortuLibre(int col) {
		int row=-1;
		boolean azkena=false;
		while(!azkena){
			if(lista[row+1][col]!=null){
				azkena=true;
			}else{
				row++;
			}
		}
		return row;
	}
	public boolean konprobatu(boolean nor, int row, int col) {
		boolean irabazi=false;
		int columna= lortuEzkerrekoena(nor, row, col);
		irabazi=ezkerEskuin4(nor, row, columna);
		if(!irabazi){
			irabazi=goitikBehera(nor, row, col);
			if(!irabazi){
				int dif= lortuDiagonalEzkerGoi(nor, row, col);
				irabazi=diagonalEzkerGoi4(nor, row-dif, col-dif);
				if(!irabazi){
					dif=lortuDiagonalEzkerBehe(nor, row, col);
					irabazi=diagonalEzkerBehe(nor, row+dif, col+dif);
				}
			}
		}
		return irabazi;
	}
	private boolean diagonalEzkerBehe(boolean nor, int row, int col) {
		boolean irabazi = true;
		int kont = 0;
		while(kont<4 && irabazi){
			if(lista[row-1][col-1]==nor){
				kont++;
			}
			else{
				irabazi = false;
			}
		}
		return irabazi;
	}
	private boolean diagonalEzkerGoi4(boolean nor, int row, int col) {
		boolean irabazi = true;
		int kont =0;
		while(kont<4&& irabazi){
			if(lista[row+1][col+1]== nor){
				kont ++;
			}
			else{
				irabazi = false;
			}
		}
		return irabazi;
	}
	private boolean goitikBehera(boolean nor, int row, int col) {
		boolean irabazi = true;
		int kont = 0;
		while(kont<4&& irabazi){
			if(lista[row+1][col]==nor){
				kont ++;
			}
			else{
				
				irabazi = false;
			}
		}
		return irabazi;
	}
	private boolean ezkerEskuin4(boolean nor, int row, int col) {
		boolean irabazi = true;
		int kont =0;
		while(kont<4&& irabazi){
			if(lista[row][col+1]==nor){
				kont ++;
			}else{
				
				irabazi = false;
			}	
		}
		return irabazi;
		
	}
	private int lortuEzkerrekoena(boolean nor, int row, int col) {
		int kont=0;
		boolean amaitu=false;
		if(col==0){
			return 0;
		}else{
			while(!amaitu && col>0){
				if(lista[row][col-1]==nor){
					kont++;
				}else{
					amaitu=true;
				}
			}	
		}
		//mientras la columna sea mayor que 0 y menos que 8 y ademas la fitxa sea igual sumar uno al kont 
		return kont;
	}
	
	private int lortuDiagonalEzkerGoi(boolean nor, int row, int col) {
		int kont =0;
		boolean amaitu = false;
		if(col==0|| row ==0){
			return 0;
		}
		else{
			while(!amaitu && 0<col && 0<row){
				if(lista[row-1][col+1]==nor){
					kont ++;
				}
				else{
					amaitu = true;
				}
			}
		}
		return kont;
	}
	private int lortuDiagonalEzkerBehe(boolean nor, int row, int col) {
		int kont=0;
		boolean amaitu = false;
		if(col==8 || row==5){
			return 0;
		}
		else{
			while(!amaitu && col<8 && row<5){
				if(lista[row+1][col+1]==nor){
					kont ++;
				}
				else{
					amaitu = true;
				}
			}
		}
		return kont;
	}
}


	