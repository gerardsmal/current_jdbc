package com.betacom.jdbc.process.implementations;

import java.util.List;

import com.betacom.jdbc.dao.ClientiDAO;
import com.betacom.jdbc.models.Clienti;
import com.betacom.jdbc.process.interfaces.SQLProcess;
import com.betacom.jdbc.simgletone.SQLConfiguration;

public class ProcessUpdate implements SQLProcess{

	@Override
	public boolean execute() {
		boolean rc = true;
		ClientiDAO daoC = new ClientiDAO();
		try {
			
			SQLConfiguration.getInstance().setAutoCommit();   // autocommit settato

			Object[] params = new Object[] {
				"Insert by Java",
				"9999999999999999",
				"Via delle Rose, 39 Novara",
				"3455497538"
			};
			int id = daoC.insert("clienti.insert", params);
			
			System.out.println("PK del cliente inserito:" + id);
			
			List<Clienti> lC = daoC.findAll();
			lC.forEach(c -> System.out.println(c));
			
			
			
			
			
			
			
			
			
			
			
			int numero = daoC.delete("clienti.delete", new Object[] {id});
			System.out.println("Numero di righe cancellate:" + numero);
			
			
			} catch (Exception e) {
				System.out.println("Error :" + e.getMessage());
				rc = false;
			}
			
		return rc;
	}

}
