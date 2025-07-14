package com.betacom.jdbc.simgletone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.betacom.jdbc.exception.AcademyException;
import com.betacom.jdbc.utilities.SQLManager;

public class SQLConfiguration {
	private static SQLConfiguration instance = null;
	private static Properties prop = new Properties();
	
	private Connection con = null;
	
	
	private SQLConfiguration() {}
	
	public static SQLConfiguration getInstance() throws AcademyException{
		if (instance == null) {
			instance = new SQLConfiguration();
			loadConfiguration();
		}
		return instance;
	}
	
	private static void loadConfiguration() throws AcademyException{
		try {
			InputStream input = new FileInputStream("./sql.properties");
			prop.load(input);
			
		} catch (FileNotFoundException e) {
			throw new AcademyException(e.getMessage());
		}  catch (IOException e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	public String getProperty(String p) {
		return prop.getProperty(p);
	}

	public Connection getConnection() throws AcademyException{
		if (con == null) {
			con = new SQLManager().getConnection();
		}
		return con;
	}
	
	
}
