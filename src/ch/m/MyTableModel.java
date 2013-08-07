package ch.m;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MyTableModel extends AbstractTableModel {
//public class MyTableModel extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	//private String[] columnNames;
    //private Object[][] data;

    String[] columnNames;// = {"First Name",
            //"Last Name",
            //"Sport",
            //"# of Years",
            //"Vegetarian"};
    Object[][] data;
    Vector<Vector> rdata;
    /*
	Object[][] data = {
	{"Kathy", "Smith",
	"Snowboarding", new Integer(5), new Boolean(false)},
	{"John", "Doe",
	"Rowing", new Integer(3), new Boolean(true)},
	{"Sue", "Black",
	"Knitting", new Integer(2), new Boolean(false)},
	{"Jane", "White",
	"Speed reading", new Integer(20), new Boolean(true)},
	{"Joe", "Brown",
	"Pool", new Integer(10), new Boolean(false)}
	};
*/
    public MyTableModel() {
    	
    	Vector<String> a = new Vector<String>();
    	a.add("id");
    	a.add("value");
    	a.add("value2");
    	
    	this.columnNames = a.toArray(new String[0]);
    	
    	Vector<Object> currentRow; 
    	currentRow = new Vector<Object>();
    	currentRow.addElement("1");
    	currentRow.addElement("dfasdf");
    	currentRow.addElement("mfmffm");
    	
    	
    	Vector<String> rowOne = new Vector<String>();
	    rowOne.addElement("Row1-Column1");
	    rowOne.addElement("Row1-Column2");
	    rowOne.addElement("Row1-Column3");
	    
	    Vector<String> rowTwo = new Vector<String>();
	    rowTwo.addElement("Row2-Column1");
	    rowTwo.addElement("Row2-Column2");
	    rowTwo.addElement("Row2-Column3");
	    
	    
	    Vector<String> rowEmpty = new Vector<String>();
	    rowEmpty.addElement(" ");
	    rowEmpty.addElement(" ");
	    rowEmpty.addElement(" ");
	   
	    //addRow(getEmptyRow());
	    
	    rdata = new Vector<Vector>();
	    rdata.addElement(rowOne);
	    rdata.addElement(rowTwo);
	    addRow(rowTwo);
	    addRow(rowEmpty);
   	
    }
    
    public void removeRow(int rowIndex){
    	rdata.remove(rowIndex);
    }
    
    public void addRow(Vector<String> newRow){
    	rdata.addElement(newRow);
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        //return data.length;
    	return rdata.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
    	return rdata.get(row).get(col);
        //return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        if (col < 1) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
    	Vector<String> editRow = new Vector<String>();
    	editRow = rdata.get(row);
    	editRow.setElementAt(value.toString(), col); 
    	
        rdata.setElementAt(editRow, row);
        
        System.out.println(row + " " + col);
        fireTableCellUpdated(row, col);
        if (row == rdata.size()-1){            
        	addRow(getEmptyRow());
        }        
    }
    
    private Vector<String> getEmptyRow(){    	
    	Vector<String> rowEmpty = new Vector<String>();    	
    	for (int i = 0; i < columnNames.length; i++){
    		rowEmpty.addElement(" ");
    	}
    	return rowEmpty;
    }
    
}