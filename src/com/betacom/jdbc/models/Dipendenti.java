package com.betacom.jdbc.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Dipendenti {
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
	
	private Integer idDipenti;
	private String 	nome;
	private String 	cognome;
	private LocalDate dataAssunzione;
	private String 	telefono;
	private String 	manzione;
	private Double 	stipendio;
	private Integer idUfficio;
	private String 	comuneNascita;
	
	public Dipendenti() {
		super();
	}

	
	public Dipendenti(Integer idDipenti, String nome, String cognome, LocalDate dataAssunzione, String telefono,
			String manzione, Double stipendio, Integer idUfficio, String comuneNascita) {
		super();
		this.idDipenti = idDipenti;
		this.nome = nome;
		this.cognome = cognome;
		this.dataAssunzione = dataAssunzione;
		this.telefono = telefono;
		this.manzione = manzione;
		this.stipendio = stipendio;
		this.idUfficio = idUfficio;
		this.comuneNascita = comuneNascita;
	}

	
	public Integer getIdDipenti() {
		return idDipenti;
	}
	public void setIdDipenti(Integer idDipenti) {
		this.idDipenti = idDipenti;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione(LocalDate dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getManzione() {
		return manzione;
	}
	public void setManzione(String manzione) {
		this.manzione = manzione;
	}
	public Double getStipendio() {
		return stipendio;
	}
	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}
	public Integer getIdUfficio() {
		return idUfficio;
	}
	public void setIdUfficio(Integer idUfficio) {
		this.idUfficio = idUfficio;
	}
	public String getComuneNascita() {
		return comuneNascita;
	}
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}


	@Override
	public String toString() {
		return "Dipendenti [idDipenti=" + idDipenti + ", nome=" + nome + ", cognome=" + cognome + ", dataAssunzione="
				+ dataAssunzione + ", telefono=" + telefono + ", manzione=" + manzione + ", stipendio=" + stipendio
				+ ", idUfficio=" + idUfficio + ", comuneNascita=" + comuneNascita + "]";
	}


}
