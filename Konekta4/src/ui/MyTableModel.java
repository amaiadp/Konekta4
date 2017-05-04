package ui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import kud.LanguagesController;
import kud.RankingKud;

public class MyTableModel extends AbstractTableModel {

	private Vector<String[]> data = new Vector<String[]>();
	private Vector<String> columnNames = new Vector<String>();
	private RankingKud kud = RankingKud.getInstantzia();
	private LanguagesController hiztegia = Hizkuntza.getHiztegi();
	
	public MyTableModel(){
		hasieratuZutabeIzenak();
	}
	
	public void kargatu(int zailtasun){
		ArrayList<String[]> inf= kud.rankingLortu(zailtasun);
		datanSartu(inf);
	}
	
	private void datanSartu(ArrayList<String[]> inf){
		int luzera = 1;
		String[] lerroa;
		for(String[] lerro: inf){
			lerroa = new String[3];
			lerroa[0] = String.valueOf(luzera);
			lerroa[1] = lerro[0];
			lerroa[2] = lerro[1]+"seg.";
			data.add(lerroa);
			luzera++;
		}
		if (luzera<10){
			System.out.println("Luzera: "+(luzera-1));
		}
	}
	
	private void hasieratuZutabeIzenak(){
//		LanguagesController hiztegia = Nagusia.getNagusia().getHizkuntza();
		columnNames.add("#");
		columnNames.add(hiztegia.getWord("Izena"));
		columnNames.add(hiztegia.getWord("Denbora"));
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}
	
	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex)[columnIndex];
	}
	
	public String getColumnName(int i){
		return columnNames.elementAt(i);
	}
	
	public Class<?> getColumnClass(int col){
		return String.class;
	}
	
	public boolean isCellEditable(int row, int col){
		return false;
	}
	
	public void setValueAt(String value, int row, int col){
		data.get(row)[col] = value;
	}

}
