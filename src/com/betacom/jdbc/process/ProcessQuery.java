package com.betacom.jdbc.process;

import java.util.List;

import com.betacom.jdbc.dao.DipendentiDAO;
import com.betacom.jdbc.models.Dipendenti;
import com.betacom.jdbc.utilities.SQLManager;

public class ProcessQuery {
	
	private SQLManager db = new SQLManager();
	DipendentiDAO daoD = new DipendentiDAO();
	
	
	public boolean execute() {
		boolean rc = true;
		try {
		
		List<String> lT = db.listOfTable("current_academy");
		lT.forEach(t -> System.out.println(t));

		List<Dipendenti> lD = daoD.findAll();
		
		lD.forEach(d -> System.out.println(d));
		
		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			rc = false;
		}
		
		return rc;
	}

}
