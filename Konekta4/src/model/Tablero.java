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
	private Tablero() {
		this.lista = new Boolean[row][column];
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
			int dif= lortuEzkerrekoena(nor, row, col);
			irabazi=ezkerEskuin4(nor, row, col-dif);
			if(!irabazi){
				irabazi=goitikBehera(nor, row, col);
				if(!irabazi){
					dif= lortuDiagonalEzkerGoi(nor, row, col);
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
		boolean amaitu = false;
		int kont = 0;
		while(kont<3 && irabazi && !amaitu){
			if(this.tableroBarruan(row-1, col-1)){
				if(lista[row-1][col-1]==nor){
					kont++;
				}
				else{
					irabazi = false;
				}
			}else{
				amaitu=true;
			}
		}
		return irabazi;
	}
	private boolean diagonalEzkerGoi4(boolean nor, int row, int col) {
		boolean irabazi = true;
		int kont =0;
		boolean amaitu = false;
		while(kont<3 && irabazi && !amaitu){
			if(this.tableroBarruan(row+1, col+1)){
				if(lista[row+1][col+1]== nor){
					kont ++;
				}
				else{
					irabazi = false;
				}
			}else{
				amaitu=true;
			}
		}
		return irabazi;
	}
	private boolean goitikBehera(boolean nor, int row, int col) {
		boolean irabazi = true;
		boolean amaitu = false;
		int kont = 0;
		while(kont<3 && irabazi && !amaitu){
			if(this.tableroBarruan(row+1, col)){ 
				if(lista[row+1][col]==nor){
					kont ++;
				}
				else{
					irabazi = false;
				}
			}else{
				amaitu=true;
			}
		}
		return irabazi;
	}
	private boolean ezkerEskuin4(boolean nor, int row, int col) {
		boolean irabazi = true;
		boolean amaitu = false;
		int kont =0;
		while(kont<3 && irabazi && !amaitu){
			if(this.tableroBarruan(row, col+1)){
				if(lista[row][col+1]==nor){
					kont ++;
				}else{
					irabazi = false;
				}
			}else{
				amaitu=true;
			}
		}
		return irabazi;
		
	}
	private int lortuEzkerrekoena(boolean nor, int row, int col) {
		int kont=0;
		boolean amaitu=false;
		if(col<=0){
			return 0;
		}else{
			while(!amaitu && col>0){
				if(this.tableroBarruan(row, col-1)){
					if(lista[row][col-1]==nor){
						kont++;
					}else{
						amaitu=true;
					}
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
		if(col<=0|| row <=0){
			return 0;
		}
		else{
			while(!amaitu && 0<col && 0<row){ 
				if(this.tableroBarruan(row-1, col-1)){
					if(lista[row-1][col-1]==nor){
						kont ++;
					}
					else{
						amaitu = true;
					}
				}else{
					amaitu=true;
				}
			}
			
		}
		return kont;
	}
	private int lortuDiagonalEzkerBehe(boolean nor, int row, int col) {
		int kont=0;
		boolean amaitu = false;
		if(col==this.column-1 || row==this.row-1){
			return 0;
		}
		else{
			while(!amaitu && col<this.column-1 && row<this.row-1){
				if(this.tableroBarruan(row+1, col+1)){	
					if(lista[row+1][col+1]==nor){
						kont ++;
					}
					else{
						amaitu = true;
					}
				}else{
					amaitu=true;
				}
			}
		}
		return kont;
	}
	
	public boolean tableroBarruan(int prow, int pcol){
		return (prow>=0 && prow<row && pcol>=0 && pcol<column);
	}
	
	public Boolean getNorena(int prow, int pcol){
		return lista[prow][pcol];
	}
	public Tablero hasieratu() {
		return this.nireTablero = new Tablero();
	}
}


	