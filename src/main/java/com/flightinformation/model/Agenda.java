package com.flightinformation.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agenda {
	
	@Column(name="id", unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Id
	private Long flightNumber;
	
	private String airportFrom;
	private String airportTo;
	private Time depLocal;
	private Time arrLocal;
	//private Solicitor solicitor;
	private String secretaria;
	private String crew1;
	private String crew2;
	private String obs;
	
	public Agenda() {
	}

	public Agenda(Long id, Long flightNumber, String airportFrom, String airportTo, Time depLocal, Time arrLocal,
			 String secretaria, String crew1, String crew2, String obs) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.airportFrom = airportFrom;
		this.airportTo = airportTo;
		this.depLocal = depLocal;
		this.arrLocal = arrLocal;
		
		this.secretaria = secretaria;
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.obs = obs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirportFrom() {
		return airportFrom;
	}

	public void setAirportFrom(String airportFrom) {
		this.airportFrom = airportFrom;
	}

	public String getAirportTo() {
		return airportTo;
	}

	public void setAirportTo(String airportTo) {
		this.airportTo = airportTo;
	}

	public Time getDepLocal() {
		return depLocal;
	}

	public void setDepLocal(Time depLocal) {
		this.depLocal = depLocal;
	}

	public Time getArrLocal() {
		return arrLocal;
	}

	public void setArrLocal(Time arrLocal) {
		this.arrLocal = arrLocal;
	}

	
	

	public String getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(String secretaria) {
		this.secretaria = secretaria;
	}

	public String getCrew1() {
		return crew1;
	}

	public void setCrew1(String crew1) {
		this.crew1 = crew1;
	}

	public String getCrew2() {
		return crew2;
	}

	public void setCrew2(String crew2) {
		this.crew2 = crew2;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", flightNumber=" + flightNumber + ", airportFrom=" + airportFrom + ", airportTo="
				+ airportTo + ", depLocal=" + depLocal + ", arrLocal=" + arrLocal + ", solicitor=" + ", secretaria=" + secretaria + ", crew1=" + crew1 + ", crew2=" + crew2 + ", obs=" + obs + "]";
	}
	
	

}
