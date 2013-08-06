package ch.m;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySql {

	private int sessionID;
	private Connection con;
	private final String URL = "jdbc:mysql://10.243.75.211:3306/simulation_reports?user=admin&password=admin";
	/**
	 * @param args
	 */
	public MySql(Integer sessionId){
		// TODO Auto-generated method stub
		//System.out.println(sessionId);
		this.sessionID = sessionId;	
		// ggf
	}


	public ResultSet readData() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con = DriverManager.getConnection(URL);

		
		PreparedStatement stmtIn = con.prepareStatement("SELECT * FROM ara_sensi WHERE session_id=? LIMIT 40");
		stmtIn.setInt(1, sessionID);
	
		ResultSet res = stmtIn.executeQuery();
		return res;

	}
	
}	