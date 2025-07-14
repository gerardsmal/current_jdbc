package com.betacom.jdbc.dao;

import java.util.Map;

import com.betacom.jdbc.simgletone.SQLConfiguration;
import com.betacom.jdbc.utilities.SQLManager;

public class ClientiDAO {
	private SQLManager db = new SQLManager();
	
	/*
	 * id_cliente
	 * denominazione
	 * p_iva
	 * inidirizzo
	 * telefono
	 */
	
	public int insert(String qryName,Map<Integer, Object> parameters) throws Exception{
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);
		
//		numero = db.update(qry, parameters);
		
		return numero;
	}
}
