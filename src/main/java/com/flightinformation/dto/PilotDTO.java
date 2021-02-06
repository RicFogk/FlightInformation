package com.flightinformation.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.flightinformation.model.Pilot;

public class PilotDTO implements Serializable {

private static final long serialVersionUID = 1L;

private Long id;
private String name;
private String email;
private Date cmaExpDate;
private Date chtExpDate;
private Time totalFlighttime500;
private Long cnac;
private Long flightNumberId;

private List<LogbookDTO> list = new ArrayList<>();

public PilotDTO() {
}



public PilotDTO(Long id, String name, String email, Date cmaExpDate, Date chtExpDate, Time totalFlighttime500,
		Long cnac, Long flightNumberId) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.cmaExpDate = cmaExpDate;
	this.chtExpDate = chtExpDate;
	this.totalFlighttime500 = totalFlighttime500;
	this.cnac = cnac;
	this.flightNumberId = flightNumberId;
	
	
}



public PilotDTO(Pilot entity) {



id = entity.getId();
name = entity.getName();
email = entity.getEmail();
cmaExpDate = entity.getCmaExpDate();
chtExpDate = entity.getChtExpDate();
totalFlighttime500 = entity.getTotalFlighttime500();
cnac = entity.getCnac();
flightNumberId = entity.getFlightNumberId();

//list = entity.getFlightNumber().stream().map(x-> new logbookDTO(x)).collect(Collectors.toList());


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
	return flightNumberId;
}



public void setFlightNumberId(Long flightNumberId) {
	this.flightNumberId = flightNumberId;
}



public List<LogbookDTO> getList() {
	return list;
}



public void setList(List<LogbookDTO> list) {
	this.list = list;
}







}
