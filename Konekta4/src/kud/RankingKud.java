package kud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RankingKud {
	
	private static final RankingKud RankingKud = new RankingKud();
	private DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
	
	public static RankingKud getInstantzia(){
		return RankingKud;
	}

	private RankingKud() {
		// Singleton patroia
	}
	
	public ArrayList<String[]> rankingLortu(int zailtasuntasun){
		ResultSet rs = dbkud.execSQL(String.format("SELECT * FROM irabazleak WHERE zailtasun=%d ORDER BY denbora LIMIT 10;", zailtasuntasun));
		ArrayList<String[]> emaitza = new ArrayList<String[]>();
		try{
			while (rs.next()){
				String[] lerro = new String[2];
				lerro[0] = rs.getString("izena");
				lerro[1] = rs.getString("denbora");
				emaitza.add(lerro);
			}
			return emaitza;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void rankingGehitu(String izena, String denbora, int zailtasun){
		dbkud.execSQL(String.format("INSERT INTO irabazleak VALUES (%s, %s, %d)",izena, denbora, zailtasun));
	}
	
	
	
}
