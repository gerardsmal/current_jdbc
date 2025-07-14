package com.betacom.jdbc.process.implementations;

import java.util.List;

import com.betacom.jdbc.dao.DipendentiDAO;
import com.betacom.jdbc.models.Dipendenti;
import com.betacom.jdbc.process.interfaces.SQLProcess;
import com.betacom.jdbc.simgletone.SQLConfiguration;
import com.betacom.jdbc.utilities.SQLManager;
public class ProcessQuery implements SQLProcess{
	
	private SQLManager db = new SQLManager();
	DipendentiDAO daoD = new DipendentiDAO();
	
	
	public boolean execute() {
		boolean rc = true;
		try {
			
			SQLConfiguration.getInstance().setAutoCommit();   // autocommit settato
			
			List<String> lT = db.listOfTable("current_academy");
			lT.forEach(t -> System.out.println(t));
	
			List<Dipendenti> lD = daoD.findAll();
			
			lD.forEach(d -> System.out.println(d));
			
			System.out.println("Select with 1 parameters");
			
			
			lD = daoD.findGeneric("dipenenti.manzione", new Object[] {"impiegato"})  ;
			lD.forEach(d -> System.out.println(d));
			
			System.out.println("Select with 2 parameters");		
			lD = daoD.findGeneric("dipendenti.mansione-and-salary", new Object[] {"impiegato" , 1500})  ;
			lD.forEach(d -> System.out.println(d));
			
			System.out.println("findById");		
			Dipendenti dip = daoD.findById(new Object[] {5});	
			System.out.println(dip);
			
			System.out.println("count with 2 parameters");		
			Long c = daoD.count("dipendenti.mansione-and-salary", new Object[] {"impiegato" , 1500});
			System.out.println("Count response:" + c);
		
		
		
		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			rc = false;
		}
		
		return rc;
	}

}
