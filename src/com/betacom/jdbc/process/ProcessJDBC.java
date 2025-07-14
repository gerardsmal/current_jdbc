package com.betacom.jdbc.process;

import com.betacom.jdbc.exception.AcademyException;
import com.betacom.jdbc.simgletone.SQLConfiguration;

public class ProcessJDBC {

	public boolean execute() {
		System.out.println("Begin ProcessJDBC");
		try {
			SQLConfiguration.getInstance().getConnection();
			System.out.println("Connection with db ok");
			
			ProcessQuery pro = new ProcessQuery();
			
			pro.execute();
		} catch (AcademyException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
}
