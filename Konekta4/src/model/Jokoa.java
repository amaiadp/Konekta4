package model;

public class Jokoa {
	private static Jokoa nireJokoa;
	private int txanda=0;
	private Jokalaria jokalariak[]= new Jokalaria [2];
	private Boolean[][] lista;
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
	
	

}
