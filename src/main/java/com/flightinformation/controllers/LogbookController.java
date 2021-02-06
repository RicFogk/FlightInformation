

package com.flightinformation.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flightinformation.dto.LogbookDTO;
import com.flightinformation.service.LogbookService;

@RestController //anotacao que é um controlador e responsebody
@RequestMapping(value="/logbook")
public class LogbookController {


	
@Autowired
private LogbookService logbookService;


@GetMapping
public ResponseEntity <List<LogbookDTO>> findAll(){ //RESPONSEENTITY REPRESENTE UMA RESPOSTA HTTP ONDE PODE TER UMA INSTACIA DENTRO
List<LogbookDTO> list = logbookService.findAll();
return ResponseEntity.ok().body(list);
}



//CRIAR METODO BUSCAR POR FLIGHTNUMBER

@GetMapping("/{flightNumber}")
public ResponseEntity<LogbookDTO> findById(@PathVariable Long flightNumber){
	
	LogbookDTO dto =  logbookService.findById(flightNumber) ;

//	if(logbookDTO != null) {
//		return ResponseEntity.ok().body(logbookDTO);
//	}
	
	return ResponseEntity.ok().body(dto);
}



@PostMapping
public ResponseEntity<LogbookDTO> insert(@RequestBody LogbookDTO dto){
	dto = logbookService.insert(dto);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{flightNumber}").buildAndExpand(dto.getFlightNumber()).toUri();
	
	return ResponseEntity.created(uri).body(dto);
	
}

//ARRUMAR UPDATE
@PutMapping("/{flightNumber}")
public ResponseEntity<LogbookDTO> update (@PathVariable Long flightNumber, @RequestBody LogbookDTO dto){
	//dto = logbookService.findById(flightNumber);
	dto = logbookService.update(flightNumber, dto);
	return ResponseEntity.ok().body(dto);
	
	
	//return ResponseEntity.ok().body(dto);
}

@DeleteMapping("/{flightNumber}")
public ResponseEntity<LogbookDTO> delete (@PathVariable Long flightNumber){
	logbookService.delete(flightNumber);
	return ResponseEntity.noContent().build();
}





//Extraido do curso Algaworks
//@PutMapping("/{flightNumber}")
//public ResponseEntity<LogbookDTO> update (@PathVariable Long flightNumber, @RequestBody LogbookDTO logbookDTO){
//	
//	LogbookDTO logbookDTOAtual = logbookService.findById(flightNumber);
//	
//	if(logbookDTOAtual != null) {
//	BeanUtils.copyProperties(logbookDTO, logbookDTOAtual, "flightNumber");
//	
//	logbookDTOAtual = logbookService.save(logbookDTOAtual);
//	return ResponseEntity.ok(logbookDTOAtual);
//}
//	return ResponseEntity.notFound().build();
//}



//public Logbook addLogbook(Logbook newLogbook) {
//	new Logbook.setFlightNumber(01012021);
//	return newLogbook;
//}
//@Transactional
//public LogbookDTO addLogbook(LogbookDTO newLogbook) {
//
//		
//	Logbook logbook = new Logbook();
//	newLogbook.setFlightNumber(newLogbook.getFlightNumber());
//	newLogbook.setInitDate(newLogbook.getInitDate());
//	newLogbook.setTailNumber(newLogbook.getTailNumber());
//	newLogbook.setLogbookPage(newLogbook.getLogbookPage());
//	newLogbook.setCrew1(newLogbook.getCrew1());
//	newLogbook.setCrew2(newLogbook.getCrew2());
//	newLogbook.setCrew3(newLogbook.getCrew3());
//	newLogbook.setPf(newLogbook.getPf());
//	newLogbook.setAptFrom(newLogbook.getAptFrom());
//	newLogbook.setAptTo(newLogbook.getAptTo());
//	newLogbook.setStartupTime(newLogbook.getStartupTime());
//	newLogbook.setToTime(newLogbook.getToTime());
//	newLogbook.setLandTime(newLogbook.getLandTime());
//	newLogbook.setShutdownTime(newLogbook.getShutdownTime());
//	newLogbook.setBlockTime(newLogbook.getBlockTime());
//	newLogbook.setFlightTime(newLogbook.getFlightTime());
//	newLogbook.setDayTime(newLogbook.getDayTime());
//	newLogbook.setNightTime(newLogbook.getNightTime());
//	newLogbook.setIfrTime(newLogbook.getIfrTime());
//	newLogbook.setVfrTime(newLogbook.getVfrTime());
//	newLogbook.setDayLand(newLogbook.getDayLand());
//	newLogbook.setNightLand(newLogbook.getNightLand());
//	newLogbook.setCicle(newLogbook.getCicle());
//	newLogbook.setPaxNumber(newLogbook.getPaxNumber());
//	newLogbook.setInitialFuel(newLogbook.getInitialFuel());
//	newLogbook.setFinalFuel(newLogbook.getFinalFuel());
//	newLogbook.setUsedFuel(newLogbook.getUsedFuel());
//	newLogbook.setFuelPlace(newLogbook.getFuelPlace());
//	newLogbook.setFuelCia(newLogbook.getFuelCia());
//	newLogbook.setFuelReceiptNumber(newLogbook.getFuelReceiptNumber());
//	newLogbook.setUplifted_fuel_liters(newLogbook.getUplifted_fuel_liters());
//	newLogbook.setUplifted_fuel_kg(newLogbook.getUplifted_fuel_kg());
//	newLogbook.setAirDist(newLogbook.getAirDist());
//	newLogbook.setGndDist(newLogbook.getGndDist());
//	newLogbook.setTaxasApt(newLogbook.getTaxasApt());
//	newLogbook.setTaxasNav(newLogbook.getTaxasNav());
//	newLogbook.setTripSupport(newLogbook.getTripSupport());
//	newLogbook.setFboHandlerName(newLogbook.getFboHandlerName());
//	newLogbook.setFboHanlder(newLogbook.getFboHanlder());
//	newLogbook.setCatering(newLogbook.getCatering());
//	newLogbook.setCrewHotel(newLogbook.getCrewHotel());
//	newLogbook.setEngCostPerEngine(newLogbook.getEngCostPerEngine());
//	newLogbook.setObs(newLogbook.getObs());
//	newLogbook.setCompletionStatus(newLogbook.isCompletionStatus());
//	newLogbook.setEndDate(newLogbook.getEndDate());
//	newLogbook.setMoment(newLogbook.getMoment());
//	newLogbook.setFuelPrice(newLogbook.getFuelPrice());
//
//	
//	return new LogbookDTO(logbook);
//	
//}

//@PostMapping
//@RequestMapping(method=RequestMethod.POST, value="/logbook")
//public Logbook create(@RequestBody Logbook logbook){
//return repository.saveAndFlush(logbook);
//}

//@PostMapping("/logbook")
//public ResponseEntity<LogbookDTO> insert(@Valid @RequestBody LogbookDTO dto){
//	dto = service.insert(dto);
//	URI uri = ServletUriComponentBuilder.fromCurrentRequest().path("/flightNumber").buildAndExpand(dto.getFlightNumber()).toUri();
//	return ResponseEntity.ok().body(dto);
//}



//@PostMapping
//public ResponseEntity<LogbookDTO> insert(@RequestBody LogbookDTO dto){
//dto = service.insert(dto);
//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{flightNumber}")
//.buildAndExpand(dto.getFlightNumber()).toUri();
//return ResponseEntity.created(uri).body(dto);
//}

//@PutMapping("/{id}/delivered")
//public ResponseEntity<LogbookDTO> setDelivered(@PathVariable Long id){
//LogbookDTO dto = service.setDelivered(id);
//return ResponseEntity.ok().body(dto);
//}


}
