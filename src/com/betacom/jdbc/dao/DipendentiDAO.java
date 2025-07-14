package com.betacom.jdbc.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.betacom.jdbc.models.Dipendenti;
import com.betacom.jdbc.simgletone.SQLConfiguration;
import com.betacom.jdbc.utilities.SQLManager;

public class DipendentiDAO {
	
	private SQLManager db = new SQLManager();

	
	/* nomi sulla tabella
	 * 
	 * 	id_dipendenti
	 *  nome
	 *  cognome
	 * 	data_assunzione
	 * 	telefono
	 * 	manzione
	 * 	stipendio
	 * 	id_ufficio
	 * 	comune_nascita
	 */
		
	public List<Dipendenti> findAll() throws Exception{
		
		String qry = SQLConfiguration.getInstance().getQuery("dipendenti");
		System.out.println("Query:" + qry);
		
		List<Map<String, Object>> lD = db.list(qry);
	
		return lD.stream()
				.map(row -> new Dipendenti(
						(Integer)row.get("id_dipendenti"), 
						(String)row.get("nome"), 
						(String)row.get("cognome"), 
						dateToLocalDate((Date)row.get("data_assunzione")), 
						(String)row.get("telefono"), 
						(String)row.get("manzione"), 
						((BigDecimal)row.get("stipendio")).doubleValue(), 
						(Integer)row.get("id_ufficio"), 
						(String)row.get("comune_nascita"))).collect(Collectors.toList());
		
	}
	
	
	private LocalDate dateToLocalDate(Object value) {
		try {
		    if (value == null) return null;

		    if (value instanceof java.sql.Date) {
		        return ((java.sql.Date) value).toLocalDate();
		    } else if (value instanceof java.util.Date) {
		        return ((java.util.Date) value).toInstant()
		                                       .atZone(ZoneId.systemDefault())
		                                       .toLocalDate();
		    } else if (value instanceof String) {
		        return LocalDate.parse((String) value); // assume formato yyyy-MM-dd
		    } else {
		        System.err.println("Tipo non gestito: " + value.getClass());
		        return null;
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
}
