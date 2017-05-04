package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import kud.LanguagesController;
import model.Jokoa;


public class RankingTab extends JFrame{


//	private LanguagesController hiztegia = Nagusia.getNagusia().getHiztegia();
	private LanguagesController hiztegia = new LanguagesController("Español");
	
	public RankingTab(){
		hasieratu();
	}
	
	private void hasieratu(){
		this.setTitle("RankingTab");
		getContentPane().setLayout(new BorderLayout());
		JTabbedPane tabPanel = new JTabbedPane(2);
		Ranking rErraza = new Ranking(1);
		Ranking rZaila = new Ranking(2);
		tabPanel.setTabPlacement(JTabbedPane.RIGHT);
		tabPanel.addTab(hiztegia.getWord("rErraza"), rErraza);
		tabPanel.addTab(hiztegia.getWord("rZaila"), rZaila);
		getContentPane().add(tabPanel, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		RankingTab rt = new RankingTab();
	}
}
