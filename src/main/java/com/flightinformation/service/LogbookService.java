package com.flightinformation.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flightinformation.dto.LogbookDTO;
import com.flightinformation.model.Logbook;
import com.flightinformation.repository.LogbookRepository;
import com.flightinformation.services.exceptions.DatabaseException;
import com.flightinformation.services.exceptions.ResourceNotFoundException;

@Service
public class LogbookService {

@Autowired
private LogbookRepository repository;

@Autowired
private LogbookService logbookService;

//@Autowired
//private PilotRepository pilotRepository;

//@Autowired
//private LogbookRepository logbookRepository;

@Transactional(readOnly = true)
public List<LogbookDTO> findAll(){
List<Logbook> list = repository.findAll();
return list.stream().map(x -> new LogbookDTO(x)).collect(Collectors.toList());
}

@Transactional
public LogbookDTO insert(LogbookDTO dto) {
	Logbook logbook = new Logbook(
			dto.getId(),
			dto.getFlightNumber(),
			dto.getInitDate(),
			//dto.getYear(),
			dto.getTailNumber(),
			dto.getLogbookPage(),
			dto.getCrew1(),
			dto.getCrew2(),
			dto.getCrew3(),
			dto.getPf(),
			dto.getAptFrom(),
			dto.getAptTo(),
			dto.getStartupTime(),
			dto.getToTime(),
			dto.getLandTime(),
			dto.getShutdownTime(),
			dto.getBlockTime(),
			dto.getFlightTime(),
			dto.getDayTime(),
			dto.getNightTime(),
			dto.getIfrTime(),
			dto.getVfrTime(),
			dto.getDayLand(),
			dto.getNightLand(),
			dto.getCicle(),
			dto.getPaxNumber(),
			dto.getInitialFuel(),
			dto.getFinalFuel(),
			dto.getUsedFuel(),
			dto.getFuelPlace(),
			dto.getFuelCia(),
			dto.getFuelReceiptNumber(),
			dto.getUplifted_fuel_liters(),
			dto.getUplifted_fuel_kg(),
			dto.getAirDist(),
			dto.getGndDist(),
			dto.getSolicitor(),
			dto.getTaxasApt(),
			dto.getTaxasNav(),
			dto.getTripSupport(),
			dto.getFboHandlerName(),
			dto.getFboHandler(),
			dto.getCatering(),
			dto.getCrewHotel(),
			dto.getEngCostPerEngine(),
			//dto.getGastoVariavelTotal(),
			null,
			dto.getObs(),
			dto.isCompletionStatus(),
			dto.getEndDate(),
			dto.getMoment(),
			dto.getFuelPrice(),
			
			dto.getApuCicle(),
			dto.getTotalHour(),
			dto.getTotalCicle(),
			dto.getNextMx(),
			dto.getHorasDispMx(),
			dto.getJourneyTime()
			);
	logbook = repository.save(logbook);
	
	return new LogbookDTO(logbook);
			
}

//@RequestMapping(method=RequestMethod.POST, value="/logbook")
//public void addEntry(@RequestBody Logbook logbook) {
//	logbookService.addEntry(entry);
//}
@PostMapping("/logbook")
public Logbook addLogbook (@RequestBody Logbook newLogbook) {
	return logbookService.addLogbook(newLogbook);
}

@Transactional(readOnly = true)
public LogbookDTO findById(Long flightNumber) {
	Optional<Logbook> obj = repository.findById(flightNumber);
	//Logbook entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found!"));
	Logbook entity = obj.get();
	return new LogbookDTO(entity);
}




//REVER O UPDATE
@Transactional
public LogbookDTO update(Long flightNumber, LogbookDTO dto) {
	try {
		Logbook entity = repository.getOne(flightNumber);//se usar o findById toca o BD 2 vezes. USAR O GETONE
		copyDtotoEntity(dto, entity);
		
		entity = repository.save(entity);
		return new LogbookDTO(entity);
	}
	catch(EntityNotFoundException e) {
		throw new ResourceNotFoundException("Flight number not found!" + flightNumber);
	}
}
	
//Nao coloca o @Transactional para capturar excecao e se coloca-lo não catura o exception que vem do DB
public void delete(Long flightNumber) {
	try {
		repository.deleteById(flightNumber);
	}
	catch(EmptyResultDataAccessException e){
		throw new ResourceNotFoundException("Flight number not found" + flightNumber);
	}
	catch(DataIntegrityViolationException e) {
		throw new DatabaseException("Integrity Violation!");
	}
}
	
	
	

// aqui é outro eemplo de PUT
//@RequestMapping(value="/reservations", method=RequestMethod.PUT)
//public Reservation updateReservation(UpdateReservationRequest request) {
//	
//	Reservation reservation = reservationRepository.findById(request.getId()).get();
//	reservation.setNumberOfBags(request.getNumberOfBags());
//	reservation.setCheckedIn(request.isCheckIn());
//	
//	return reservationRepository.save(reservation);
//	
//}

private void copyDtotoEntity (LogbookDTO dto, Logbook entity) {
	//entity.setFlightNumber(dto.getFlightNumber());
	entity.setInitDate(dto.getInitDate());
	entity.setTailNumber(dto.getTailNumber());
	entity.setLogbookPage(dto.getLogbookPage());
	entity.setCrew1(dto.getCrew1());
	entity.setCrew2(dto.getCrew2());
	entity.setCrew3(dto.getCrew3());
	entity.setPf(dto.getPf());
	entity.setAptFrom(dto.getAptFrom());
	entity.setAptTo(dto.getAptTo());
	entity.setStartupTime(dto.getStartupTime());
	entity.setToTime(dto.getToTime());
	entity.setLandTime(dto.getLandTime());
	entity.setShutdownTime(dto.getShutdownTime());
	entity.setBlockTime(dto.getBlockTime());
	entity.setFlightTime(dto.getFlightTime());
	entity.setDayTime(dto.getDayTime());
	entity.setNightTime(dto.getNightTime());
	entity.setIfrTime(dto.getIfrTime());
	entity.setVfrTime(dto.getVfrTime());
	entity.setDayLand(dto.getDayLand());
	entity.setNightLand(dto.getNightLand());
	entity.setCicle(dto.getCicle());
	entity.setPaxNumber(dto.getPaxNumber());
	entity.setInitialFuel(dto.getInitialFuel());
	entity.setFinalFuel(dto.getFinalFuel());
	entity.setUsedFuel(dto.getUsedFuel());
	entity.setFuelPlace(dto.getFuelPlace());
	entity.setFuelCia(dto.getFuelCia());
	entity.setFuelReceiptNumber(dto.getFuelReceiptNumber());
	entity.setUplifted_fuel_liters(dto.getUplifted_fuel_liters());
	entity.setUplifted_fuel_kg(dto.getUplifted_fuel_kg());
	entity.setAirDist(dto.getAirDist());
	entity.setGndDist(dto.getGndDist());
	entity.setSolicitor(dto.getSolicitor());
	entity.setTaxasApt(dto.getTaxasApt());
	entity.setTaxasNav(dto.getTaxasNav());
	entity.setTripSupport(dto.getTripSupport());
	entity.setFboHandlerName(dto.getFboHandlerName());
	entity.setFboHanlder(dto.getFboHandler());
	entity.setCatering(dto.getCatering());
	entity.setCrewHotel(dto.getCrewHotel());
	entity.setGastoVariavelTotal(dto.getGastoVariavelTotal());
	entity.setEngCostPerEngine(dto.getEngCostPerEngine());
	entity.setObs(dto.getObs());
	entity.setCompletionStatus(dto.isCompletionStatus());
	entity.setEndDate(dto.getEndDate());
	entity.setMoment(dto.getMoment());
	entity.setFuelPrice(dto.getFuelPrice());
	entity.setEngCicle(dto.getEngCicle());
	entity.setApuCicle(dto.getApuCicle());
	entity.setTotalHour(dto.getTotalHour());
	entity.setTotalCicle(dto.getTotalCicle());
	entity.setNextMx(dto.getNextMx());
	entity.setHorasDispMx(dto.getHorasDispMx());
	entity.setJourneyTime(dto.getJourneyTime());
	
	
	
//	for(LogbookDTO dtoUpdated : dto.getFlightNumber()) {
//		Logbook logbook = logbookRepository.getOne(dtoUpdated.getFlightNumber());
//		entity.getFlightNumber
//	}

}
}