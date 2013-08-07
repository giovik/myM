package ch.m;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class MyTableModelListener implements TableModelListener {
    
	TableModel model;
	JTable table;
	
    public MyTableModelListener(JTable table, MyTableModel model) {
        
    	this.model = model;
    	this.table = table;
        table.getModel().addTableModelListener(this);
       
    }
    
	@Override
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        Object id = model.getValueAt(row, 0);
        table.repaint();
        /*
        System.out.println(id);
        System.out.println(row);
        System.out.println(column);
        System.out.println(columnName);
        System.out.println(data);
        */
	}
    
}