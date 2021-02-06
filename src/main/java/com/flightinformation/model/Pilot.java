package com.flightinformation.model;


import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="pilot")
public class Pilot {
	
	@Id
	private Long id;
	private String name;
	private String email;
	private Date cmaExpDate;
	private Date chtExpDate;
	
	@Column(name="total_flighttime_500")
	private Time totalFlighttime500;
	private Long cnac;
	private Long flightNumber;

	
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="aircraft")
	//private List<Logbook> logbook;
	
//	@ManyToOne(fetch=FetchType.EAGER, mappedBy="logbook")
//	private List<Logbook> logbook;
	
	  //------------------------------------------------------------------------------------
	   // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pilot")
	    //private List<Logbook> logbook;
	    //-----------------------------------------------------------------------------------
	
//-----DEV SUPERIOR ANNOTATION	
//	@JoinTable(name="logbook_pilot",
//	joinColumns = @JoinColumn(name="pilot_id"),
//	inverseJoinColumns = @JoinColumn(name="logbook_flight_number"))
//	private Set<Logbook> products = new HashSet<>();
	
	//-------------------------------------------------------------------------------------
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
		@JoinTable(
		    name = "pilot_logbook",
		    joinColumns = @JoinColumn(name = "pilot_id"),
		    inverseJoinColumns = @JoinColumn(name = "flight_number")
		)
		Set<Logbook> logbok = new HashSet<>();
	//--------------------------------------------------------------------------------------
	
	public Long getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(Long flightNumber) {
			this.flightNumber = flightNumber;
		}

//		public List<Logbook> getLogbook() {
//			return logbook;
//		}
//
//		public void setLogbook(List<Logbook> logbook) {
//			this.logbook = logbook;
//		}

	public Pilot() {
	}

	public Pilot(Long id, String name, String email, Date cmaExpDate, Date chtExpDate, Time totalFlighttime500,
			Long cnac, Long flightNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cmaExpDate = cmaExpDate;
		this.chtExpDate = chtExpDate;
		this.totalFlighttime500 = totalFlighttime500;
		this.cnac = cnac;
		this.flightNumber = flightNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCmaExpDate() {
		return cmaExpDate;
	}

	public void setCmaExpDate(Date cmaExpDate) {
		this.cmaExpDate = cmaExpDate;
	}

	public Date getChtExpDate() {
		return chtExpDate;
	}

	public void setChtExpDate(Date chtExpDate) {
		this.chtExpDate = chtExpDate;
	}

	public Time getTotalFlighttime500() {
		return totalFlighttime500;
	}

	public void setTotalFlighttime500(Time totalFlighttime500) {
		this.totalFlighttime500 = totalFlighttime500;
	}

	public Long getCnac() {
		return cnac;
	}

	public void setCnac(Long cnac) {
		this.cnac = cnac;
	}

	public Long getFlightNumberId() {
		return flightNumber;
	}

	public void setFlightNumberId(Long flightNumberId) {
		this.flightNumber = flightNumberId;
	}
	

	public Set<Logbook> getLogbok() {
		return logbok;
	}

	public void setLogbok(Set<Logbook> logbok) {
		this.logbok = logbok;
	}
	
	

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", name=" + name + ", email=" + email + ", cmaExpDate=" + cmaExpDate
				+ ", chtExpDate=" + chtExpDate + ", totalFlighttime500=" + totalFlighttime500 + ", cnac=" + cnac
				+ ", flightNumber=" + flightNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chtExpDate == null) ? 0 : chtExpDate.hashCode());
		result = prime * result + ((cmaExpDate == null) ? 0 : cmaExpDate.hashCode());
		result = prime * result + ((cnac == null) ? 0 : cnac.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((totalFlighttime500 == null) ? 0 : totalFlighttime500.hashCode());
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
		Pilot other = (Pilot) obj;
		if (chtExpDate == null) {
			if (other.chtExpDate != null)
				return false;
		} else if (!chtExpDate.equals(other.chtExpDate))
			return false;
		if (cmaExpDate == null) {
			if (other.cmaExpDate != null)
				return false;
		} else if (!cmaExpDate.equals(other.cmaExpDate))
			return false;
		if (cnac == null) {
			if (other.cnac != null)
				return false;
		} else if (!cnac.equals(other.cnac))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (totalFlighttime500 == null) {
			if (other.totalFlighttime500 != null)
				return false;
		} else if (!totalFlighttime500.equals(other.totalFlighttime500))
			return false;
		return true;
	}
	
	
	

}

