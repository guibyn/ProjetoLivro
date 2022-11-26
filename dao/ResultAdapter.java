package dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;


import javax.swing.table.DefaultTableModel;

public class ResultAdapter {
	
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
		        throws SQLException {

		    ResultSetMetaData metaData = rs.getMetaData();

		    // names of columns
		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
		    }

		    // data of the table
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    
		    Vector<Object> a = new Vector<Object>();
		    for (String name : columnNames) {
		    	a.add(name);
		    }
		    data.add(a);
		    
		    while (rs.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(rs.getObject(columnIndex));
		        }
		        data.add(vector);
		    }
		    
		    
		    
		    return new DefaultTableModel(data, columnNames) {
		    	@Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};}
	
	public static ArrayList<String> getColumns(ResultSet rs)
				throws SQLException {
		
		ResultSetMetaData metaData = rs.getMetaData();
		
		ArrayList<String> columnNames = new ArrayList<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }
	    
	    return columnNames;

	}


}


