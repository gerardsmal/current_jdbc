package com.betacom.jdbc.utilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.jdbc.exception.AcademyException;
import com.betacom.jdbc.simgletone.SQLConfiguration;

public class SQLManager {

	public Connection getConnection() throws AcademyException{
		Connection con = null;
		
		try {
			
			Class.forName(SQLConfiguration.getInstance().getProperty("driver")); // Load driver with reflection
			/*
			 * open connection with Driver Manager
			 * 	url
			 *  user
			 *  pwd
			 */
			con = DriverManager.getConnection(
					SQLConfiguration.getInstance().getProperty("url"),
					SQLConfiguration.getInstance().getProperty("user"),
					SQLConfiguration.getInstance().getProperty("pwd")
					);
			
			
			return con;
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
	}
	/*
	 * Table list
	 */
	public List<String> listOfTable(String dbName) throws AcademyException {
		List<String> lT = new ArrayList<String>();
		try {
			DatabaseMetaData dbMD = SQLConfiguration.getInstance().getConnection().getMetaData(); // retrieve metadata from database
			
			ResultSet res = dbMD.getTables(dbName, null, null, null); // load result into resultset
			
			/*
			 * build result
			 */
			while (res.next()) {
				lT.add(res.getString("TABLE_NAME"));   // res.get.... legge parametri della riga
			}
			
			
		} catch (SQLException e) {
			throw new AcademyException(e.getMessage());
		}
		return lT;
	}
	
	/*
	 * execute select with JDBC without parameters
	 */
	public List<Map<String, Object>> list(String qry) throws AcademyException{
		try {
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(qry);  // statement compilation
			
			
			ResultSet res = cmd.executeQuery();
			
			return resultsetToList(res);
			
		} catch (Exception e) {
			throw new AcademyException(e.getMessage());
		}
		
		
	}
	
	
	/*
	 * transform resultset in list<map>
	 * 		map: key -> column name
	 * 		     value -> column value
	 */
	private List<Map<String, Object>> resultsetToList(ResultSet rs) throws SQLException{
		ResultSetMetaData md = rs.getMetaData();   // retrieve metadata resulset
		int columns = md.getColumnCount();         // retrieve query column number
		
		
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>(); // init result
		
		
		while(rs.next()) {
			Map<String, Object> row = new HashMap<String, Object>(); // init row
			for (int i=1;i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i)); // load map with key = query metadata 
															   //               value = reultset value
			}
			rows.add(row);
		}
		
		return rows;
		
	}
	
	
}
