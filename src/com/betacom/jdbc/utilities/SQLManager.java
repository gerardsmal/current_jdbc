package com.betacom.jdbc.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
