package ui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import kud.RankingKud;

public class Table extends JPanel{

	JPanel panela = new JPanel();
	MyTableModel model = new MyTableModel();
	JTable table = new JTable(model);
	
	public Table(int zailtasun){
		kargatu(zailtasun);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
		
		
	}
	
	private void kargatu(int zailtasun){
		model.kargatu(zailtasun);
	}
}
