package ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Table extends JPanel{

	JPanel panela = new JPanel();
	MyTableModel model = new MyTableModel();
	JTable table = new JTable(model);
	
	public Table(int zailtasun){
		kargatu(zailtasun);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
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
