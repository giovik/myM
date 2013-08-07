package ch.m;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wion {

	private JFrame frame;
	private JTable table;
	private JButton btnNewButton;
	MyTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wion window = new Wion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Wion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 613, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 597, 207);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		model = new MyTableModel();
		table.setModel(model);
		
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(Color.WHITE);
				
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() != -1){
					model.removeRow(table.getSelectedRow());
					table.repaint();
				}
			}
		});
		btnNewButton.setBounds(24, 239, 94, 23);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{scrollPane, table}));
		
		MyTableModelListener myTblListener = new MyTableModelListener(table, model);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
	}
	
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

       System.out.print(row + "  " + column);
    }
	
}
