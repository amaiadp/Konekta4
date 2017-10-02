package model;

public class Tablero {
	private static Tablero nireTablero;
	public static int row=6;
	public static int column=9;
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
	
	public void setTablero(int row, int col, Boolean jok){
		this.lista[row][col]=jok;
		//tableroo...
		//tab
		
	}
	public int azkenaLortuLibre(int col) {
		int row=-1;
		boolean azkena=false;
		while(!azkena){
			if(tableroBarruan(row+1, col)){
				if(lista[row+1][col]!=null){
					azkena=true;
				}else{
					row++;
				}
			}else{
				azkena=true;
			}
		}
		return row;
		//row
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
						irabazi=diagonalEzkerBehe(nor, row+dif, col-dif);
					}
				}
			}
		
		return irabazi;
	}

	private boolean diagonalEzkerBehe(boolean nor, int row, int col) {
		boolean amaitu = false;
		int kont = 1;
		while(kont<4 && !amaitu){
			System.out.println("dEB: " +nor+" "+ kont);
			if(this.tableroBarruan(row-1, col+1)){
				if(lista[row-1][col+1]!= null &&lista[row-1][col+1]==nor){
					kont++;
					row--;
					col++;
				}
				else{
					amaitu=true;
				}
			}else{
				amaitu=true;
			}
		}
		return kont>=4;
	}
	private boolean diagonalEzkerGoi4(boolean nor, int row, int col) {
		int kont =1;
		boolean amaitu = false;
		while(kont<4 && !amaitu){
			System.out.println("dEG: " +nor+" "+ kont);
			if(this.tableroBarruan(row+1, col+1)){
				if(lista[row+1][col+1]!=null && lista[row+1][col+1]== nor){
					kont ++;
					row++;
					col++;
				}
				else{
					amaitu=true;
				}
			}else{
				amaitu=true;
			}
		}
		return kont>=4;
	}
	private boolean goitikBehera(boolean nor, int row, int col) {
		boolean amaitu = false;
		int kont = 1;
		while(kont<4 && !amaitu){
			System.out.println("GB: " +nor+" "+ kont);
			if(this.tableroBarruan(row+1, col)){ 
				if(lista[row+1][col]!=null && lista[row+1][col]==nor){
					kont ++;
					row++;
				}
				else{
					amaitu= true;
				}
			}else{
				amaitu=true;
			}
		}
		return kont>=4;
	}
	private boolean ezkerEskuin4(boolean nor, int row, int col) {
		boolean irabazi = false;
		boolean amaitu = false;
		int kont =1;
		while(kont<4 && !amaitu){
			System.out.println("EzEs: " +nor+" "+ kont);
			if(this.tableroBarruan(row, col+1)){
				if(lista[row][col+1]!=null && lista[row][col+1]==nor){
					kont ++;
					col++;
				}else{
					amaitu = true;
				}
			}else{
				amaitu=true;
			}
		}
		if(kont>=4){
			irabazi = true;
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
				System.out.println("lEz: " +nor+" "+ kont);
				if(this.tableroBarruan(row, col-1)){
					if(lista[row][col-1]!=null && lista[row][col-1]==nor){
						kont++;
						col--;
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
				System.out.println("lDEG: " +nor+" "+ kont);
				if(this.tableroBarruan(row-1, col-1)){
					if(lista[row-1][col-1]!=null &&lista[row-1][col-1]==nor){
						kont ++;
						row--;
						col--;
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
		if(col==0 || row==Tablero.row-1){
			return 0;
		}
		else{
			while(!amaitu && col>0 && row<Tablero.row-1){
				System.out.println("dlDEB: " +nor+" "+ kont);
				if(this.tableroBarruan(row+1, col-1)){	
					if(lista[row+1][col-1]!=null && lista[row+1][col-1]==nor){
						kont ++;
						row++;
						col--;
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
	public boolean tableroaBeteta() {
		boolean beteta = true;
		for(int i =0; i<Tablero.column;i++){
			if(lista[0][i]==null){
				beteta=false;
			}
		}
		return beteta;
	}
	
	public void inprimatu(){
		for (Boolean[] lerro : lista) {
			System.out.println("+---+---+---+---+---+---+---+---+---+");
			System.out.print("|");
			for (Boolean gela : lerro) {
				if(gela==null){
					System.out.print("   |");
				}else{
					if(gela==true){
						System.out.print(" J |");
					}else{
						System.out.print(" O |");
					}
				}
			}
			System.out.println();
		}
		System.out.println("+---+---+---+---+---+---+---+---+---+");
	}
}


	