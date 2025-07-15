package com.betacom.jdbc.dao;

import static com.betacom.jdbc.utilities.Utils.dateToLocalDate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.betacom.jdbc.models.Clienti;
import com.betacom.jdbc.models.Dipendenti;
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
	
	public int insert(String qryName, Object[] parameters) throws Exception{
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);
		
		numero = db.update(qry, parameters, true);
		
		return numero;
	}

	public int delete(String qryName, Object[] parameters) throws Exception{
		int numero = 0;
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);
		
		numero = db.update(qry, parameters);
		
		return numero;
	}

	
	
	public List<Clienti> findAll() throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery("clienti");
		System.out.println("Query:" + qry);
		
		List<Map<String, Object>> lD = db.list(qry);
	
		return lD.stream()
				.map(row -> new Clienti(
						(Integer)row.get("id_cliente"), 
						(String)row.get("denominazione"), 
						(String)row.get("p_iva"), 
						(String)row.get("inidirizzo"), 
						(String)row.get("telefono"))).collect(Collectors.toList());
		
	}
	
	public List<Clienti> findGeneric(String qryName,Object[] parameters) throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery(qryName);
		System.out.println("Query:" + qry);
		
		List<Map<String, Object>> lD = db.list(qry, parameters);
	
		return lD.stream()
				.map(row -> new Clienti(
						(Integer)row.get("id_cliente"), 
						(String)row.get("denominazione"), 
						(String)row.get("p_iva"), 
						(String)row.get("inidirizzo"), 
						(String)row.get("telefono"))).collect(Collectors.toList());
		
	}

	
	public Optional<Clienti>   findById(Object[] parameters) throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery("clienti.byId");
		System.out.println("Query:" + qry);
		
		Map<String, Object> row = db.get(qry, parameters);
		if (row == null)
			return Optional.empty();
		else {
			return  Optional.ofNullable(new Clienti(         //get an instance of this Optional class with the specified 
							(Integer)row.get("id_cliente"),  // value of the specified type.
							(String)row.get("denominazione"), 
							(String)row.get("p_iva"), 
							(String)row.get("inidirizzo"), 
							(String)row.get("telefono")));
		}
	}


}
