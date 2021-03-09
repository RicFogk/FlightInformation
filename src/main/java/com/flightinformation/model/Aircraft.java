package com.flightinformation.model;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Aircraft {
	
	@Column(name="id", unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Id
	
	private Long flightNumber;
	
	private String tailNumber;
	private Date dataVoo;
	private Time flightTime;
	private Long engCicle;
	private Long apuCicle;
	private Time totalHour;
	private Long totalCicle;
	private Date nextMx;
	private Time horasDispMx;
	private String obs;
	
//	@OneToMany(mappedBy="aircraft")
//	@JoinColumn(name = "flight_number")
//	private Set<Logbook> logbook = new HashSet<>();
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="aircraft")
//	private List<Logbook> logbook;
	
	public Aircraft() {
	}

	public Aircraft(Long id, Long flightNumber, String tailNumber, Date dataVoo, Time flightTime, Long engCicle,
			Long apuCicle, Time totalHour, Long totalCicle, Date nextMx, Time horasDispMx, String obs) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.tailNumber = tailNumber;
		this.dataVoo = dataVoo;
		this.flightTime = flightTime;
		this.engCicle = engCicle;
		this.apuCicle = apuCicle;
		this.totalHour = totalHour;
		this.totalCicle = totalCicle;
		this.nextMx = nextMx;
		this.horasDispMx = horasDispMx;
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

	public String getTailNumber() {
		return tailNumber;
	}

	public void setTailNumber(String tailNumber) {
		this.tailNumber = tailNumber;
	}

	public Date getDataVoo() {
		return dataVoo;
	}

	public void setDataVoo(Date dataVoo) {
		this.dataVoo = dataVoo;
	}

	public Time getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Time flightTime) {
		this.flightTime = flightTime;
	}

	public Long getEngCicle() {
		return engCicle;
	}

	public void setEngCicle(Long engCicle) {
		this.engCicle = engCicle;
	}

	public Long getApuCicle() {
		return apuCicle;
	}

	public void setApuCicle(Long apuCicle) {
		this.apuCicle = apuCicle;
	}

	public Time getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(Time totalHour) {
		this.totalHour = totalHour;
	}

	public Long getTotalCicle() {
		return totalCicle;
	}

	public void setTotalCicle(Long totalCicle) {
		this.totalCicle = totalCicle;
	}

	public Date getNextMx() {
		return nextMx;
	}

	public void setNextMx(Date nextMx) {
		this.nextMx = nextMx;
	}

	public Time getHorasDispMx() {
		return horasDispMx;
	}

	public void setHorasDispMx(Time horasDispMx) {
		this.horasDispMx = horasDispMx;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) { 	 	
		this.obs = obs;
	}
	
	

//	public Set<Logbook> getLogbook() {
//		return logbook;
//	}
//
//	public void setLogbook(Set<Logbook> logbook) {
//		this.logbook = logbook;
//	}

	@Override
	public String toString() {
		return "Aircraft [id=" + id + ", flightNumber=" + flightNumber + ", tailNumber=" + tailNumber + ", dataVoo="
				+ dataVoo + ", flightTime=" + flightTime + ", engCicle=" + engCicle + ", apuCicle=" + apuCicle
				+ ", totalHour=" + totalHour + ", totalCicle=" + totalCicle + ", nextMx=" + nextMx + ", horasDispMx="
				+ horasDispMx + ", obs=" + obs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apuCicle == null) ? 0 : apuCicle.hashCode());
		result = prime * result + ((dataVoo == null) ? 0 : dataVoo.hashCode());
		result = prime * result + ((engCicle == null) ? 0 : engCicle.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((flightTime == null) ? 0 : flightTime.hashCode());
		result = prime * result + ((horasDispMx == null) ? 0 : horasDispMx.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nextMx == null) ? 0 : nextMx.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((tailNumber == null) ? 0 : tailNumber.hashCode());
		result = prime * result + ((totalCicle == null) ? 0 : totalCicle.hashCode());
		result = prime * result + ((totalHour == null) ? 0 : totalHour.hashCode());
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
		Aircraft other = (Aircraft) obj;
		if (apuCicle == null) {
			if (other.apuCicle != null)
				return false;
		} else if (!apuCicle.equals(other.apuCicle))
			return false;
		if (dataVoo == null) {
			if (other.dataVoo != null)
				return false;
		} else if (!dataVoo.equals(other.dataVoo))
			return false;
		if (engCicle == null) {
			if (other.engCicle != null)
				return false;
		} else if (!engCicle.equals(other.engCicle))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (flightTime == null) {
			if (other.flightTime != null)
				return false;
		} else if (!flightTime.equals(other.flightTime))
			return false;
		if (horasDispMx == null) {
			if (other.horasDispMx != null)
				return false;
		} else if (!horasDispMx.equals(other.horasDispMx))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nextMx == null) {
			if (other.nextMx != null)
				return false;
		} else if (!nextMx.equals(other.nextMx))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (tailNumber == null) {
			if (other.tailNumber != null)
				return false;
		} else if (!tailNumber.equals(other.tailNumber))
			return false;
		if (totalCicle == null) {
			if (other.totalCicle != null)
				return false;
		} else if (!totalCicle.equals(other.totalCicle))
			return false;
		if (totalHour == null) {
			if (other.totalHour != null)
				return false;
		} else if (!totalHour.equals(other.totalHour))
			return false;
		return true;
	}
	
	

}

