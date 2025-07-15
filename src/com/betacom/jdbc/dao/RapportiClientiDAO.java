package com.betacom.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.betacom.jdbc.models.RapportiClienti;
import com.betacom.jdbc.simgletone.SQLConfiguration;
import com.betacom.jdbc.utilities.SQLManager;

public class RapportiClientiDAO {

	private SQLManager db = new SQLManager();
	
	public int insert(String qryName, Object[] parameters) throws Exception{
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);
		
		numero = db.update(qry, parameters, true);
		
		return numero;
	}

	 /*
	   * id_rapporto
	   * descrizione
	   * id_cliente
	   * id_dipendenti
	   */

	public List<RapportiClienti> findAll() throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery("rapporto_clienti");
		System.out.println("Query:" + qry);
		
		List<Map<String, Object>> lR = db.list(qry);
	
		return lR.stream()
				.map(row -> new RapportiClienti(
						(Integer)row.get("id_rapporto"), 
						(String)row.get("descrizione"), 
						(Integer)row.get("id_cliente"), 
						(Integer)row.get("id_dipendenti"))).collect(Collectors.toList());
		
	}

	
}
