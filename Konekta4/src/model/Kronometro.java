package model;

import ui.Nagusia;

public class Kronometro{
	
	private static long hasieraDenb = 0;
	private static long geldituDenb = 0;
	private static boolean martxan = false;
	private static Kronometro myKro;

	private Kronometro(){}

	public static Kronometro getKronometro(){
		if(myKro==null){
			myKro=new Kronometro();
		}
		return myKro;
	}

	private void hasi(){
		hasieraDenb = System.currentTimeMillis();
		martxan = true;
	}
	
	private void gelditu(){
		geldituDenb = System.currentTimeMillis();
		martxan = false;
	}
	
	public long getDenboraTartea(){
		long tarte;
		if(martxan){
			tarte = ((System.currentTimeMillis() - hasieraDenb) / 1000);
		}
		else{
			tarte = ((geldituDenb - hasieraDenb) / 1000);
		}
		return tarte;
	}

	public void hasieratu(){
		Thread t = new Thread(){
			public void run (){
				long aur=0,une;
				hasi();
				//TODO
				while(!Jokoa.getNireJokoa().amaituta()&&Jokoa.getNireJokoa().kronHasita()){
					une=getDenboraTartea();
					if(aur!=une){
					Nagusia.getnireNagusia().kronEguneratu(une);
					}
					aur=une;
				}
				gelditu();
			}
		};
		t.start();
	}

}
