package com.betacom.jdbc.process;

import com.betacom.jdbc.exception.AcademyException;
import com.betacom.jdbc.process.implementations.ProcessQuery;
import com.betacom.jdbc.process.implementations.ProcessUpdate;
import com.betacom.jdbc.process.interfaces.SQLProcess;
import com.betacom.jdbc.simgletone.SQLConfiguration;

public class ProcessJDBC {

	public boolean execute() {
		System.out.println("Begin ProcessJDBC");
		SQLProcess pro = null;
		try {
			SQLConfiguration.getInstance().getConnection();
			System.out.println("Connection with db ok");

			System.out.println("Process QUERY ****************************");
			pro = new ProcessQuery();		
			pro.execute();
			
			System.out.println("Process UPDATE ****************************");
			pro = new ProcessUpdate();
			pro.execute();
			
		} catch (AcademyException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
}
