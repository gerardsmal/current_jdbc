package com.betacom.jdbc.process.implementations;

import com.betacom.jdbc.process.interfaces.SQLProcess;
import com.betacom.jdbc.simgletone.SQLConfiguration;

public class ProcessUpdate implements SQLProcess{

	@Override
	public boolean execute() {
		boolean rc = true;
	
		try {
			
			SQLConfiguration.getInstance().setAutoCommit();   // autocommit settato

			
		
			
			} catch (Exception e) {
				System.out.println("Error :" + e.getMessage());
				rc = false;
			}
			
		return rc;
	}

}
