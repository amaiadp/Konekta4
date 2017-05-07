package ui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import kud.LanguagesController;


public class RankingTab extends JDialog{

	private LanguagesController hiztegia = Hizkuntza.getHiztegi();
	
	public RankingTab(){
		hasieratu();
	}
	
	private void hasieratu(){
		this.setTitle("RankingTab");
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		JTabbedPane tabPanel = new JTabbedPane(2);
		Ranking rErraza = new Ranking(1);
		Ranking rZaila = new Ranking(2);
		tabPanel.setTabPlacement(JTabbedPane.RIGHT);
		tabPanel.addTab(hiztegia.getWord("rErraza"), rErraza);
		tabPanel.addTab(hiztegia.getWord("rZaila"), rZaila);
		getContentPane().add(tabPanel, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		RankingTab rt = new RankingTab();
	}
}
