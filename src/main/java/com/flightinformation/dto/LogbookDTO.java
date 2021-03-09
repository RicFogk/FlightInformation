package com.flightinformation.dto;

import java.io.Serializable;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;

import com.flightinformation.model.Logbook;
import com.flightinformation.model.Pilot;

public class LogbookDTO implements Serializable {

private static final long serialVersionUID = 1L;

private Integer id;
private Long flightNumber;
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
private Long engCicle;
private Long apuCicle;
private Time totalHour;
private Long totalCicle;
private Date nextMx;
private Time horasDispMx;
private Time journeyTime;
//private Pilot pilot;

public LogbookDTO() {
}



public LogbookDTO(Integer id,Long flightNumber, Date initDate, String tailNumber, int logbookPage, String crew1, String crew2,
		String crew3, String pf, String aptFrom, String aptTo, Time startupTime, Time toTime, Time landTime,
		Time shutdownTime, Time blockTime, Time flightTime, Time dayTime, Time nightTime, Time ifrTime, Time vfrTime,
		Long dayLand, Long nightLand, Long cicle, Long paxNumber, Long initialFuel, Long finalFuel, Long usedFuel,
		String fuelPlace, String fuelCia, Long fuelReceiptNumber, Long uplifted_fuel_liters, Long uplifted_fuel_kg,
		Long airDist, Long gndDist, String solicitor, Double taxasApt, Double taxasNav, Double tripSupport,
		Double fboHandlerName, Double fboHandler, Double catering, Double crewHotel, Double engCostPerEngine, Double gastoVariavelTotal,
		String obs, boolean completionStatus, Date endDate, Instant moment, Double fuelPrice, Long apuCicle, Time totalHour, Long totalCicle, Date nextMx, Time horasDispMx, Time journeyTime) {
	super();
	this.flightNumber = flightNumber;
	this.initDate = initDate;
	//this.year=year;
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



public LogbookDTO(Logbook entity) {
super();
//como nao ha mais ambiguidade pode apagar o this
//this.id = entity.getId();

id = entity.getId();
flightNumber = entity.getFlightNumber();
initDate = entity.getInitDate();
//year = entity.getYear();
tailNumber = entity.getTailNumber();
logbookPage = entity.getLogbookPage();
crew1  = entity.getCrew1();
crew2 = entity.getCrew2();
crew3 = entity.getCrew3();
pf = entity.getPf();
aptFrom = entity.getAptFrom();
aptTo = entity.getAptTo();
startupTime = entity.getStartupTime();
toTime = entity.getToTime();
landTime = entity.getLandTime();
shutdownTime = entity.getShutdownTime();
blockTime = entity.getBlockTime();
flightTime = entity.getFlightTime();
dayTime = entity.getDayTime();
nightTime = entity.getNightTime();
ifrTime = entity.getIfrTime();
vfrTime = entity.getVfrTime();
dayLand = entity.getDayLand();
nightLand = entity.getNightLand();
cicle = entity.getCicle();
paxNumber = entity.getPaxNumber();
initialFuel = entity.getInitialFuel();
finalFuel = entity.getFinalFuel();
usedFuel = entity.getUsedFuel();
fuelPlace = entity.getFuelPlace();
fuelCia = entity.getFuelCia();
fuelReceiptNumber = entity.getFuelReceiptNumber();
uplifted_fuel_liters = entity.getUplifted_fuel_liters();
uplifted_fuel_kg = entity.getUplifted_fuel_kg();
airDist = entity.getAirDist();
gndDist = entity.getGndDist();
Solicitor = entity.getSolicitor();
taxasApt = entity.getTaxasApt();
taxasNav = entity.getTaxasNav();
tripSupport = entity.getTripSupport();
fboHandlerName = entity.getFboHandlerName();
fboHandler = entity.getFboHandler();
catering = entity.getCatering();
crewHotel = entity.getCrewHotel();
engCostPerEngine = entity.getEngCostPerEngine();
gastoVariavelTotal = entity.getGastoVariavelTotal();
obs = entity.getObs();
completionStatus = entity.isCompletionStatus();
endDate = entity.getEndDate();
moment = entity.getMoment();
fuelPrice = entity.getFuelPrice();
apuCicle =  entity.getApuCicle();
totalHour =  entity.getTotalHour();
totalCicle = entity.getTotalCicle();
nextMx = entity.getNextMx();
horasDispMx = entity.getHorasDispMx();
journeyTime = entity.getJourneyTime();
//pilot = entity.getPilot();
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



//public Date getYear() {
//	return year;
//}
//
//
//
//public void setYear(Date year) {
//	this.year = year;
//}



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



//public Pilot getPilot() {
//	// TODO Auto-generated method stub
//	return pilot;
//}

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



public Time getJourneyTime() {
	return journeyTime;
}



public void setJourneyTime(Time journeyTime) {
	this.journeyTime = journeyTime;
}



}
