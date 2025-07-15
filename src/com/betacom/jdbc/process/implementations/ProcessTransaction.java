package com.betacom.jdbc.process.implementations;

import java.util.List;
import java.util.Optional;

import com.betacom.jdbc.dao.ClientiDAO;
import com.betacom.jdbc.dao.DipendentiDAO;
import com.betacom.jdbc.dao.RapportiClientiDAO;
import com.betacom.jdbc.exception.AcademyException;
import com.betacom.jdbc.models.Dipendenti;
import com.betacom.jdbc.models.RapportiClienti;
import com.betacom.jdbc.process.interfaces.SQLProcess;
import com.betacom.jdbc.simgletone.SQLConfiguration;
import com.betacom.jdbc.utilities.SQLManager;

public class ProcessTransaction implements SQLProcess{

	private SQLManager db = new SQLManager();
	
	@Override
	public boolean execute() {
		boolean rc = true;
		ClientiDAO daoC = new ClientiDAO();
		DipendentiDAO daoD = new DipendentiDAO();
		RapportiClientiDAO daoR = new RapportiClientiDAO();
		
		try {
			SQLConfiguration.getInstance().setTransaction();
			
			
			Object[] params = new Object[] {
					"Santa Cruss",
					"9485619823684567",
					"Corso Francia, 3 Roma",
					"4591981842"
				};
			int idCliente = daoC.insert("clienti.insert", params);
				
			System.out.println("PK del cliente inserito:" + idCliente);
			
			
			Optional<Dipendenti> dip = daoD.findById(new Object[] { 5 });
			if(dip.isEmpty()) {
				System.out.println("Dipendenti non trovato .. execute rollback..");
				db.rollback();
			}
			
			
			params = new Object[] {
				"Rapporto dynamico",
				idCliente,
				dip.get().getIdDipenti()
			};
			
			int idRapporto = daoR.insert("rapporti-clienti.insert", params);
			
			List<RapportiClienti> lR = daoR.findAll();
			lR.forEach(r -> System.out.println(r));
			
			
			
			
			
			
			System.out.println("execute commit.....");
			db.commit();
	
		} catch (Exception e) {
			System.out.println("Error found:" +  e.getMessage());
			rc = false;
			try {
				System.out.println("execute rollback.....");
				db.rollback();
			} catch (AcademyException e1) {
				System.out.println("Error nel rollback :" + e1.getMessage());
			}
			
		}
		
		return rc;
	}

}
