package com.flightinformation.model;




import java.io.Serializable;
import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//ANOTACOES
//FAZER COMPONETIZACAO DA ENTIDADE COM EMBEDED PILOTS, AERONAVES, SOLICITOR. ex: CLASSE ENDERECO <<embeddable>> --> TEM A CAPICIDADE DE INCORPORAR OUTRA CLASSElErI070707

//A estrategia EAGER LOADING é padrao para A associacao X-ToOne 
//A estrategia TOLAZY é aplicada para a Associacao X-ToMany (Lazy carregamento por por demanda)


@Entity
@Table(name="logbook")
public class Logbook implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="id", unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(nullable = false) //SO USAR SE NAO FEZ O DDL NO DB
	private Long flightNumber;
	
	//usei o date util, pois o date sql nao estava buscandp
	private Date initDate;
	//private Date year;
	

	private String tailNumber;
	private int logbookPage;
	private String crew1;
	private String crew2;
	private String crew3;
	private String pf;
	private String aptFrom;
	private String aptTo;
	private Time startupTime;
	private Time toTime;
	private Time landTime;
	private Time shutdownTime;
	private Time blockTime;
	private Time flightTime;
	private Time dayTime;
	private Time nightTime;
	private Time ifrTime;
	private Time vfrTime;
	private Long dayLand;
	private Long nightLand;
	private Long cicle;
	private Long paxNumber;
	private Long initialFuel;
	private Long finalFuel;
	
	@Column(name="fuel_used")
	private Long usedFuel;
	private String fuelPlace;
	private String fuelCia;
	private Long fuelReceiptNumber;	
	private Long uplifted_fuel_liters;
	private Long uplifted_fuel_kg;
	private Long airDist;
	private Long gndDist;
	private String Solicitor;
	private Double taxasApt;
	private Double taxasNav;
	private Double tripSupport;
	private Double fboHandlerName;
	
	@Column(name="fbo_handler")
	private Double fboHandler;
	private Double catering;
	private Double crewHotel;
	private Double engCostPerEngine;
	
	private Double gastoVariavelTotal;
	
	private String obs;
	private boolean completionStatus;
	private Date endDate;
	private Instant moment;
	private Double fuelPrice;
	
	// --------------- FARA PARTE DA PAG LOGBOOK (Incorporando colunas do AIRCRAFT, assim fica uma classe so (logbook))
	private Long engCicle;
	private Long apuCicle;
	private Time totalHour;
	private Long totalCicle;
	private Date nextMx;
	private Time horasDispMx;
	//------------------------------------------------------------------------------------------------------------------
	
	// ----------------------- REGULAMENTACAO -------------------------------------------------------------------------
	private Time journeyTime;
	//------------------------------------------------------------------------------------------------------------------
	
//	@CreationTimestamp
//	@Column(nullable = false) //sem precisao no datetime -> columnDefinition = "datetime" // a VALUE do SQL para dataCadastro e dataAtualizacao utc_timestamp, utc_timestamp
//	private LocalDateTime dataCadastro;
//	
//	@UpdateTimestamp
//	@Column(nullable = false) //, columnDefinition = "datetime"
//	private LocalDateTime dataAtualizacao;
//	
	
//	@ManyToOne
//	private Aircraft aircraft;
	
//	private Pilot pilot;
//	private Solicitor solicitor;
//	private Aircraft aircraft; (POPULAR CLASSE)
	
	//Essa classe é uma parte da classe Logboo , é uma incorporacao **************** nao se aplica para agregar pois gera uma linha de custo fixo para cada voo
//	@Embedded
//	private CustoFixo custoFixo;
	
	// NAO PRECISA USAR TABELAS DE ASSOCIACAO PARA LOGBOOK/PILOT/SOLICIOR PARA O ESCOPO DESTE PROJETO	
	//----MANY TO MANY---------------------------------------------------------------------------------
		
//		@ManyToMany
//		(cascade = {
//			    CascadeType.PERSIST,
//			    CascadeType.MERGE
//			})
//			@JoinTable(
//			    name = "logbook_pilot",
//			    joinColumns = @JoinColumn(name = "logbook_flightNumber"),
//			    inverseJoinColumns = @JoinColumn(name = "pilot_id")
//			)
//			Set<Pilot> pilots = new HashSet<>();
		//--------------------------------------------------------------------------------------
	
	
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="aircraft_flight_number", nullable=false)
	
	//---------------------------------------------------------------------------------------------
//	@ManyToOne
//	@JoinColumn(name = "flightNumber", nullable = false)
//	private Aircraft aircraft;
	
	  
	
	//--------------Comentei por ultimo 10:30 10/01/21
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pilot_id", nullable = false)
//    @JsonIgnore
//	private Pilot pilot;
	//----------------------------------------------
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	private Aircraft aircraft;
	
//	public Pilot getPilot() {
//		return pilot;
//	}
//
//	public void setPilot(Pilot pilot) {
//		this.pilot = pilot;
//	}

	public Logbook() {
	}
	
	public Logbook(Integer id, Long flightNumber, Date initDate, String tailNumber, int logbookPage, String crew1,
			String crew2, String crew3, String pf, String aptFrom, String aptTo, Time startupTime, Time toTime,
			Time landTime, Time shutdownTime, Time blockTime, Time flightTime, Time dayTime, Time nightTime,
			Time ifrTime, Time vfrTime, Long dayLand, Long nightLand, Long cicle, Long paxNumber, Long initialFuel,
			Long finalFuel, Long usedFuel, String fuelPlace, String fuelCia, Long fuelReceiptNumber,
			Long uplifted_fuel_liters, Long uplifted_fuel_kg, Long airDist, Long gndDist, String solicitor,
			Double taxasApt, Double taxasNav, Double tripSupport, Double fboHandlerName, Double fboHandler,
			Double catering, Double crewHotel, Double engCostPerEngine, Double gastoVariavelTotal, String obs, boolean completionStatus,
			Date endDate, Instant moment, Double fuelPrice, Long apuCicle, Time totalHour, Long totalCicle, Date nextMx, Time horasDispMx, Time journeyTime) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.initDate = initDate;
		//this.year = year;
		this.tailNumber = tailNumber;
		this.logbookPage = logbookPage;
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.crew3 = crew3;
		this.pf = pf;
		this.aptFrom = aptFrom;
		this.aptTo = aptTo;
		this.startupTime = startupTime;
		this.toTime = toTime;
		this.landTime = landTime;
		this.shutdownTime = shutdownTime;
		this.blockTime = blockTime;
		this.flightTime = flightTime;
		this.dayTime = dayTime;
		this.nightTime = nightTime;
		this.ifrTime = ifrTime;
		this.vfrTime = vfrTime;
		this.dayLand = dayLand;
		this.nightLand = nightLand;
		this.cicle = cicle;
		this.paxNumber = paxNumber;
		this.initialFuel = initialFuel;
		this.finalFuel = finalFuel;
		this.usedFuel = usedFuel;
		this.fuelPlace = fuelPlace;
		this.fuelCia = fuelCia;
		this.fuelReceiptNumber = fuelReceiptNumber;
		this.uplifted_fuel_liters = uplifted_fuel_liters;
		this.uplifted_fuel_kg = uplifted_fuel_kg;
		this.airDist = airDist;
		this.gndDist = gndDist;
		Solicitor = solicitor;
		
		this.taxasApt = taxasApt;
		this.taxasNav = taxasNav;
		this.tripSupport = tripSupport;
		this.fboHandlerName = fboHandlerName;
		this.fboHandler = fboHandler;
		this.catering = catering;
		this.crewHotel = crewHotel;
		this.engCostPerEngine = engCostPerEngine;
		this.gastoVariavelTotal = gastoVariavelTotal;
		this.obs = obs;
		this.completionStatus = completionStatus;
		this.endDate = endDate;
		this.moment = moment;
		this.fuelPrice = fuelPrice;
		
		this.apuCicle = apuCicle;
		this.totalHour = totalHour;
		this.totalCicle = totalCicle;
		this.nextMx = nextMx;
		this.horasDispMx = horasDispMx;
		this.journeyTime = journeyTime;
	}
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}
//
//	public Date getYear() {
//		return year;
//	}
//
//	public void setYear(Date year) {
//		this.year = year;
//	}
	public String getTailNumber() {
		return tailNumber;
	}

	public void setTailNumber(String tailNumber) {
		this.tailNumber = tailNumber;
	}

	public int getLogbookPage() {
		return logbookPage;
	}

	public void setLogbookPage(int logbookPage) {
		this.logbookPage = logbookPage;
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

	public String getCrew3() {
		return crew3;
	}

	public void setCrew3(String crew3) {
		this.crew3 = crew3;
	}

	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getAptFrom() {
		return aptFrom;
	}

	public void setAptFrom(String aptFrom) {
		this.aptFrom = aptFrom;
	}

	public String getAptTo() {
		return aptTo;
	}

	public void setAptTo(String aptTo) {
		this.aptTo = aptTo;
	}

	public Time getStartupTime() {
		return startupTime;
	}

	public void setStartupTime(Time startupTime) {
		this.startupTime = startupTime;
	}

	public Time getToTime() {
		return toTime;
	}

	public void setToTime(Time toTime) {
		this.toTime = toTime;
	}

	public Time getLandTime() {
		return landTime;
	}

	public void setLandTime(Time landTime) {
		this.landTime = landTime;
	}

	public Time getShutdownTime() {
		return shutdownTime;
	}

	public void setShutdownTime(Time shutdownTime) {
		this.shutdownTime = shutdownTime;
	}

	public Time getBlockTime() {
		return blockTime;
	}

	public void setBlockTime(Time blockTime) {
		this.blockTime = blockTime;
	}

	public Time getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Time flightTime) {
		this.flightTime = flightTime;
	}

	public Time getDayTime() {
		return dayTime;
	}

	public void setDayTime(Time dayTime) {
		this.dayTime = dayTime;
	}

	public Time getNightTime() {
		return nightTime;
	}

	public void setNightTime(Time nightTime) {
		this.nightTime = nightTime;
	}

	public Time getIfrTime() {
		return ifrTime;
	}

	public void setIfrTime(Time ifrTime) {
		this.ifrTime = ifrTime;
	}

	public Time getVfrTime() {
		return vfrTime;
	}

	public void setVfrTime(Time vfrTime) {
		this.vfrTime = vfrTime;
	}

	public Long getDayLand() {
		return dayLand;
	}

	public void setDayLand(Long dayLand) {
		this.dayLand = dayLand;
	}

	public Long getNightLand() {
		return nightLand;
	}

	public void setNightLand(Long nightLand) {
		this.nightLand = nightLand;
	}

	public Long getCicle() {
		return cicle;
	}

	public void setCicle(Long cicle) {
		this.cicle = cicle;
	}

	public Long getPaxNumber() {
		return paxNumber;
	}

	public void setPaxNumber(Long paxNumber) {
		this.paxNumber = paxNumber;
	}

	public Long getInitialFuel() {
		return initialFuel;
	}

	public void setInitialFuel(Long initialFuel) {
		this.initialFuel = initialFuel;
	}

	public Long getFinalFuel() {
		return finalFuel;
	}

	public void setFinalFuel(Long finalFuel) {
		this.finalFuel = finalFuel;
	}

	public Long getUsedFuel() {
		return usedFuel;
	}

	public void setUsedFuel(Long usedFuel) {
		this.usedFuel = usedFuel;
	}

	public String getFuelPlace() {
		return fuelPlace;
	}

	public void setFuelPlace(String fuelPlace) {
		this.fuelPlace = fuelPlace;
	}

	public String getFuelCia() {
		return fuelCia;
	}

	public void setFuelCia(String fuelCia) {
		this.fuelCia = fuelCia;
	}

	public Long getFuelReceiptNumber() {
		return fuelReceiptNumber;
	}

	public void setFuelReceiptNumber(Long fuelReceiptNumber) {
		this.fuelReceiptNumber = fuelReceiptNumber;
	}

	public Long getUplifted_fuel_liters() {
		return uplifted_fuel_liters;
	}

	public void setUplifted_fuel_liters(Long uplifted_fuel_liters) {
		this.uplifted_fuel_liters = uplifted_fuel_liters;
	}

	public Long getUplifted_fuel_kg() {
		return uplifted_fuel_kg;
	}

	public void setUplifted_fuel_kg(Long uplifted_fuel_kg) {
		this.uplifted_fuel_kg = uplifted_fuel_kg;
	}

	public Long getAirDist() {
		return airDist;
	}

	public void setAirDist(Long airDist) {
		this.airDist = airDist;
	}

	public Long getGndDist() {
		return gndDist;
	}

	public void setGndDist(Long gndDist) {
		this.gndDist = gndDist;
	}

	public String getSolicitor() {
		return Solicitor;
	}

	public void setSolicitor(String solicitor) {
		Solicitor = solicitor;
	}

	public Double getTaxasApt() {
		return taxasApt;
	}

	public void setTaxasApt(Double taxasApt) {
		this.taxasApt = taxasApt;
	}

	public Double getTaxasNav() {
		return taxasNav;
	}

	public void setTaxasNav(Double taxasNav) {
		this.taxasNav = taxasNav;
	}

	public Double getTripSupport() {
		return tripSupport;
	}

	public void setTripSupport(Double tripSupport) {
		this.tripSupport = tripSupport;
	}

	public Double getFboHandlerName() {
		return fboHandlerName;
	}

	public void setFboHandlerName(Double fboHandlerName) {
		this.fboHandlerName = fboHandlerName;
	}

	public Double getFboHandler() {
		return fboHandler;
	}

	public void setFboHanlder(Double fboHanlder) {
		this.fboHandler = fboHanlder;
	}

	public Double getCatering() {
		return catering;
	}

	public void setCatering(Double catering) {
		this.catering = catering;
	}

	public Double getCrewHotel() {
		return crewHotel;
	}

	public void setCrewHotel(Double crewHotel) {
		this.crewHotel = crewHotel;
	}

	public Double getEngCostPerEngine() {
		return engCostPerEngine;
	}

	public void setEngCostPerEngine(Double engCostPerEngine) {
		this.engCostPerEngine = engCostPerEngine;
	}
	
	

	public Double getGastoVariavelTotal() {
		return gastoVariavelTotal;
	}

	public void setGastoVariavelTotal(Double gastoVariavelTotal) {
		
		this.gastoVariavelTotal = gastoVariavelTotal;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public boolean isCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(boolean completionStatus) {
		this.completionStatus = completionStatus;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Double getFuelPrice() {
		return fuelPrice;
	}

	public void setFuelPrice(Double fuelPrice) {
		this.fuelPrice = fuelPrice;
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

	public void setFboHandler(Double fboHandler) {
		this.fboHandler = fboHandler;
	}
	
	public Double gastoVariavelTotal () {

		
		gastoVariavelTotal = taxasApt + taxasNav + catering;
		
		return gastoVariavelTotal;
	}
	
	
	
	

//	public Aircraft getAircraft() {
//		return aircraft;
//	}
//
//	public void setAircraft(Aircraft aircraft) {
//		this.aircraft = aircraft;
//	}

	public Time getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(Time journeyTime) {
		this.journeyTime = journeyTime;
	}

	@Override
	public String toString() {
		return "Logbook [id=" + id + ", flightNumber=" + flightNumber + ", initDate=" + initDate + ", tailNumber="
				+ tailNumber + ", logbookPage=" + logbookPage + ", crew1=" + crew1 + ", crew2=" + crew2 + ", crew3="
				+ crew3 + ", pf=" + pf + ", aptFrom=" + aptFrom + ", aptTo=" + aptTo + ", startupTime=" + startupTime
				+ ", toTime=" + toTime + ", landTime=" + landTime + ", shutdownTime=" + shutdownTime + ", blockTime="
				+ blockTime + ", flightTime=" + flightTime + ", dayTime=" + dayTime + ", nightTime=" + nightTime
				+ ", ifrTime=" + ifrTime + ", vfrTime=" + vfrTime + ", dayLand=" + dayLand + ", nightLand=" + nightLand
				+ ", cicle=" + cicle + ", paxNumber=" + paxNumber + ", initialFuel=" + initialFuel + ", finalFuel="
				+ finalFuel + ", usedFuel=" + usedFuel + ", fuelPlace=" + fuelPlace + ", fuelCia=" + fuelCia
				+ ", fuelReceiptNumber=" + fuelReceiptNumber + ", uplifted_fuel_liters=" + uplifted_fuel_liters
				+ ", uplifted_fuel_kg=" + uplifted_fuel_kg + ", airDist=" + airDist + ", gndDist=" + gndDist
				+ ", Solicitor=" + Solicitor + ", taxasApt=" + taxasApt + ", taxasNav=" + taxasNav + ", tripSupport="
				+ tripSupport + ", fboHandlerName=" + fboHandlerName + ", fboHanlder=" + fboHandler + ", catering="
				+ catering + ", crewHotel=" + crewHotel + ", engCostPerEngine=" + engCostPerEngine
				+ ", gastoVariavelTotal=" + gastoVariavelTotal + ", obs=" + obs + ", completionStatus="
				+ completionStatus + ", endDate=" + endDate + ", moment=" + moment + ", fuelPrice=" + fuelPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Solicitor == null) ? 0 : Solicitor.hashCode());
		result = prime * result + ((airDist == null) ? 0 : airDist.hashCode());
		result = prime * result + ((aptFrom == null) ? 0 : aptFrom.hashCode());
		result = prime * result + ((aptTo == null) ? 0 : aptTo.hashCode());
		result = prime * result + ((blockTime == null) ? 0 : blockTime.hashCode());
		result = prime * result + ((catering == null) ? 0 : catering.hashCode());
		result = prime * result + ((cicle == null) ? 0 : cicle.hashCode());
		result = prime * result + (completionStatus ? 1231 : 1237);
		result = prime * result + ((crew1 == null) ? 0 : crew1.hashCode());
		result = prime * result + ((crew2 == null) ? 0 : crew2.hashCode());
		result = prime * result + ((crew3 == null) ? 0 : crew3.hashCode());
		result = prime * result + ((crewHotel == null) ? 0 : crewHotel.hashCode());
		result = prime * result + ((dayLand == null) ? 0 : dayLand.hashCode());
		result = prime * result + ((dayTime == null) ? 0 : dayTime.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((engCostPerEngine == null) ? 0 : engCostPerEngine.hashCode());
		result = prime * result + ((fboHandlerName == null) ? 0 : fboHandlerName.hashCode());
		result = prime * result + ((fboHandler == null) ? 0 : fboHandler.hashCode());
		result = prime * result + ((finalFuel == null) ? 0 : finalFuel.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((flightTime == null) ? 0 : flightTime.hashCode());
		result = prime * result + ((fuelCia == null) ? 0 : fuelCia.hashCode());
		result = prime * result + ((fuelPlace == null) ? 0 : fuelPlace.hashCode());
		result = prime * result + ((fuelPrice == null) ? 0 : fuelPrice.hashCode());
		result = prime * result + ((fuelReceiptNumber == null) ? 0 : fuelReceiptNumber.hashCode());
		result = prime * result + ((gastoVariavelTotal == null) ? 0 : gastoVariavelTotal.hashCode());
		result = prime * result + ((gndDist == null) ? 0 : gndDist.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ifrTime == null) ? 0 : ifrTime.hashCode());
		result = prime * result + ((initDate == null) ? 0 : initDate.hashCode());
		result = prime * result + ((initialFuel == null) ? 0 : initialFuel.hashCode());
		result = prime * result + ((landTime == null) ? 0 : landTime.hashCode());
		result = prime * result + logbookPage;
		result = prime * result + ((moment == null) ? 0 : moment.hashCode());
		result = prime * result + ((nightLand == null) ? 0 : nightLand.hashCode());
		result = prime * result + ((nightTime == null) ? 0 : nightTime.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((paxNumber == null) ? 0 : paxNumber.hashCode());
		result = prime * result + ((pf == null) ? 0 : pf.hashCode());
		result = prime * result + ((shutdownTime == null) ? 0 : shutdownTime.hashCode());
		result = prime * result + ((startupTime == null) ? 0 : startupTime.hashCode());
		result = prime * result + ((tailNumber == null) ? 0 : tailNumber.hashCode());
		result = prime * result + ((taxasApt == null) ? 0 : taxasApt.hashCode());
		result = prime * result + ((taxasNav == null) ? 0 : taxasNav.hashCode());
		result = prime * result + ((toTime == null) ? 0 : toTime.hashCode());
		result = prime * result + ((tripSupport == null) ? 0 : tripSupport.hashCode());
		result = prime * result + ((uplifted_fuel_kg == null) ? 0 : uplifted_fuel_kg.hashCode());
		result = prime * result + ((uplifted_fuel_liters == null) ? 0 : uplifted_fuel_liters.hashCode());
		result = prime * result + ((usedFuel == null) ? 0 : usedFuel.hashCode());
		result = prime * result + ((vfrTime == null) ? 0 : vfrTime.hashCode());
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
		Logbook other = (Logbook) obj;
		if (Solicitor == null) {
			if (other.Solicitor != null)
				return false;
		} else if (!Solicitor.equals(other.Solicitor))
			return false;
		if (airDist == null) {
			if (other.airDist != null)
				return false;
		} else if (!airDist.equals(other.airDist))
			return false;
		if (aptFrom == null) {
			if (other.aptFrom != null)
				return false;
		} else if (!aptFrom.equals(other.aptFrom))
			return false;
		if (aptTo == null) {
			if (other.aptTo != null)
				return false;
		} else if (!aptTo.equals(other.aptTo))
			return false;
		if (blockTime == null) {
			if (other.blockTime != null)
				return false;
		} else if (!blockTime.equals(other.blockTime))
			return false;
		if (catering == null) {
			if (other.catering != null)
				return false;
		} else if (!catering.equals(other.catering))
			return false;
		if (cicle == null) {
			if (other.cicle != null)
				return false;
		} else if (!cicle.equals(other.cicle))
			return false;
		if (completionStatus != other.completionStatus)
			return false;
		if (crew1 == null) {
			if (other.crew1 != null)
				return false;
		} else if (!crew1.equals(other.crew1))
			return false;
		if (crew2 == null) {
			if (other.crew2 != null)
				return false;
		} else if (!crew2.equals(other.crew2))
			return false;
		if (crew3 == null) {
			if (other.crew3 != null)
				return false;
		} else if (!crew3.equals(other.crew3))
			return false;
		if (crewHotel == null) {
			if (other.crewHotel != null)
				return false;
		} else if (!crewHotel.equals(other.crewHotel))
			return false;
		if (dayLand == null) {
			if (other.dayLand != null)
				return false;
		} else if (!dayLand.equals(other.dayLand))
			return false;
		if (dayTime == null) {
			if (other.dayTime != null)
				return false;
		} else if (!dayTime.equals(other.dayTime))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (engCostPerEngine == null) {
			if (other.engCostPerEngine != null)
				return false;
		} else if (!engCostPerEngine.equals(other.engCostPerEngine))
			return false;
		if (fboHandlerName == null) {
			if (other.fboHandlerName != null)
				return false;
		} else if (!fboHandlerName.equals(other.fboHandlerName))
			return false;
		if (fboHandler == null) {
			if (other.fboHandler != null)
				return false;
		} else if (!fboHandler.equals(other.fboHandler))
			return false;
		if (finalFuel == null) {
			if (other.finalFuel != null)
				return false;
		} else if (!finalFuel.equals(other.finalFuel))
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
		if (fuelCia == null) {
			if (other.fuelCia != null)
				return false;
		} else if (!fuelCia.equals(other.fuelCia))
			return false;
		if (fuelPlace == null) {
			if (other.fuelPlace != null)
				return false;
		} else if (!fuelPlace.equals(other.fuelPlace))
			return false;
		if (fuelPrice == null) {
			if (other.fuelPrice != null)
				return false;
		} else if (!fuelPrice.equals(other.fuelPrice))
			return false;
		if (fuelReceiptNumber == null) {
			if (other.fuelReceiptNumber != null)
				return false;
		} else if (!fuelReceiptNumber.equals(other.fuelReceiptNumber))
			return false;
		if (gastoVariavelTotal == null) {
			if (other.gastoVariavelTotal != null)
				return false;
		} else if (!gastoVariavelTotal.equals(other.gastoVariavelTotal))
			return false;
		if (gndDist == null) {
			if (other.gndDist != null)
				return false;
		} else if (!gndDist.equals(other.gndDist))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ifrTime == null) {
			if (other.ifrTime != null)
				return false;
		} else if (!ifrTime.equals(other.ifrTime))
			return false;
		if (initDate == null) {
			if (other.initDate != null)
				return false;
		} else if (!initDate.equals(other.initDate))
			return false;
		if (initialFuel == null) {
			if (other.initialFuel != null)
				return false;
		} else if (!initialFuel.equals(other.initialFuel))
			return false;
		if (landTime == null) {
			if (other.landTime != null)
				return false;
		} else if (!landTime.equals(other.landTime))
			return false;
		if (logbookPage != other.logbookPage)
			return false;
		if (moment == null) {
			if (other.moment != null)
				return false;
		} else if (!moment.equals(other.moment))
			return false;
		if (nightLand == null) {
			if (other.nightLand != null)
				return false;
		} else if (!nightLand.equals(other.nightLand))
			return false;
		if (nightTime == null) {
			if (other.nightTime != null)
				return false;
		} else if (!nightTime.equals(other.nightTime))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (paxNumber == null) {
			if (other.paxNumber != null)
				return false;
		} else if (!paxNumber.equals(other.paxNumber))
			return false;
		if (pf == null) {
			if (other.pf != null)
				return false;
		} else if (!pf.equals(other.pf))
			return false;
		if (shutdownTime == null) {
			if (other.shutdownTime != null)
				return false;
		} else if (!shutdownTime.equals(other.shutdownTime))
			return false;
		if (startupTime == null) {
			if (other.startupTime != null)
				return false;
		} else if (!startupTime.equals(other.startupTime))
			return false;
		if (tailNumber == null) {
			if (other.tailNumber != null)
				return false;
		} else if (!tailNumber.equals(other.tailNumber))
			return false;
		if (taxasApt == null) {
			if (other.taxasApt != null)
				return false;
		} else if (!taxasApt.equals(other.taxasApt))
			return false;
		if (taxasNav == null) {
			if (other.taxasNav != null)
				return false;
		} else if (!taxasNav.equals(other.taxasNav))
			return false;
		if (toTime == null) {
			if (other.toTime != null)
				return false;
		} else if (!toTime.equals(other.toTime))
			return false;
		if (tripSupport == null) {
			if (other.tripSupport != null)
				return false;
		} else if (!tripSupport.equals(other.tripSupport))
			return false;
		if (uplifted_fuel_kg == null) {
			if (other.uplifted_fuel_kg != null)
				return false;
		} else if (!uplifted_fuel_kg.equals(other.uplifted_fuel_kg))
			return false;
		if (uplifted_fuel_liters == null) {
			if (other.uplifted_fuel_liters != null)
				return false;
		} else if (!uplifted_fuel_liters.equals(other.uplifted_fuel_liters))
			return false;
		if (usedFuel == null) {
			if (other.usedFuel != null)
				return false;
		} else if (!usedFuel.equals(other.usedFuel))
			return false;
		if (vfrTime == null) {
			if (other.vfrTime != null)
				return false;
		} else if (!vfrTime.equals(other.vfrTime))
			return false;
		return true;
	}

	
	


	
	
	
	
	
	
	
	
}
