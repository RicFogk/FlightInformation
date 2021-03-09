

package com.flightinformation.controllers;

import java.net.URI;
import java.sql.Date;
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
import com.flightinformation.model.Logbook;
import com.flightinformation.repository.LogbookRepository;
import com.flightinformation.service.LogbookService;

@RestController //anotacao que é um controlador e responsebody
@RequestMapping(value="/logbook")
public class LogbookController {

@Autowired
private LogbookRepository logbookRepository;
	
@Autowired
private LogbookService logbookService;


@GetMapping
public ResponseEntity <List<LogbookDTO>> findAll(){ //RESPONSEENTITY REPRESENTE UMA RESPOSTA HTTP ONDE PODE TER UMA INSTACIA DENTRO
List<LogbookDTO> list = logbookService.findAll();


return ResponseEntity.ok().body(list);
}


//CRIAR METODO BUSCAR POR FLIGHTNUMBER -------------------

@GetMapping("/{flightNumber}")
public ResponseEntity<LogbookDTO> findById(@PathVariable Long flightNumber){
	
	//Pesquisar e implementar o Optional pra nao votar null
	LogbookDTO dto =  logbookService.findById(flightNumber) ;

//	if(logbookDTO != null) {
//		return ResponseEntity.ok().body(logbookDTO);
//	}
	
	return ResponseEntity.ok().body(dto);
}


//CRIAR METODO BUSCA POR CREW --------------------------
@GetMapping("/perCrew1")
public List<Logbook> logbookPerCrew1( String crew1){
	
	return logbookRepository.findByCrew1(crew1);
}

@GetMapping("/perCrew2")
public List<Logbook> logbookPerCrew2( String crew2){
	
	return logbookRepository.findByCrew2(crew2);
}

@GetMapping("/perCrew3")
public List<Logbook> logbookPerCrew3( String crew3){
	
	return logbookRepository.findByCrew3(crew3);
}

@GetMapping("/perCrew1&2")
public List<Logbook> logbookPerCrew1AndCrew2( String crew1, String crew2){
	
	return logbookRepository.findByCrew1AndCrew2(crew1, crew2);
}

// BUSCA POR DATA --------------------------------------
@GetMapping("/perDate")
public List<Logbook> logbookPerDate(Date initDate){
	
	return logbookRepository.findByInitDate(initDate);
}

//NAO MUDAR --
@GetMapping("/perYear")
public List<Logbook> logbookPerYear( String init_date){
	
	
	
	return logbookRepository.findByYear(init_date);
}

//@GetMapping("/perYear/{year}")
//public List<Logbook> logbookPerYear(@PathVariable ("year") String year){
//	
//	return logbookRepository.findInitDate(year);
//}




// BUSCA POR SOLICITOR ---------------------------------
@GetMapping("/perSolicitor")
public List<Logbook> logbookPerSolicitor(String solicitor){
	
	return logbookRepository.findBySolicitor(solicitor);
}

// BUSCA POR EXISTS
@GetMapping("/perExists")
public boolean logbookAptFromExists(String aptFrom){
	
	return logbookRepository.existsByAptFrom(aptFrom);
}

//BUSCA POR quantidade ----------------------------------
@GetMapping("/perAptFromCount")
public int logbookAptFromCount(String aptFrom){
	
	return logbookRepository.countByAptFrom(aptFrom);
}

@GetMapping("/perCrew1Count")
public int logbookCrew1FromCount(String crew1){
	
	return logbookRepository.countByCrew1(crew1);
}

@GetMapping("/perCrew2Count")
public int logbookCrew2FromCount(String crew2){
	
	return logbookRepository.countByCrew2(crew2);
}

@GetMapping("/perCrew3Count")
public int logbookCrew3FromCount(String crew3){
	
	return logbookRepository.countByCrew3(crew3);
}



@GetMapping("/perCrew1And2Count")
public int logbookCrew1AndCrew2FromCount(String crew1, String crew2){
	
	return logbookRepository.countByCrew1AndCrew2(crew1, crew2);
}

// BUSCAR POR QUATIDADE AS PF
@GetMapping("/perPfCount")
public int logbookPfCount(String pf){
	
	return logbookRepository.countByPf(pf);
}

//SOMAR HORAS AS PF -------------------------------------
@GetMapping("/perPfTotalTimeFogaca")
public String logbookPfTotalTimeFogaca(String pf){
	
	return logbookRepository.consultarTotalTimePfFogaca(pf);
}

@GetMapping("/perPfTotalTimeYana")
public String logbookPfTotalTimeYana(String pf){
	
	return logbookRepository.consultarTotalTimePfYana(pf);
}

@GetMapping("/perPfTotalTimeThiago")
public String logbookPfTotalTimeThiago(String pf){
	
	return logbookRepository.consultarTotalTimePfThiago(pf);
}

//------------FUNCIONA NAO MEXER -------------------------
@GetMapping("/perPfTotalTimeAmongPilots")
//public String logbookPfTotalTimeAmongPilots(String pf){
	public List<Object[]> logbookPfTotalTimeAmongPilots(String pf){
	
	//return logbookRepository.consultarTotalTimeAmongPilots(pf);
	return logbookRepository.consultarTotalTimeAmongPilots(pf);

}
//-------------------------------------------------------------

//NAO MEXER NESSE AQUI ESTA CORRETO! USAR O ABAIXO
//------------------------------------------------
@GetMapping("/perYear2021")
public String logbookTotalTimePerYear2021(String init_date){
	
	return logbookRepository.consultarTotalTimePerYear2021(init_date);
}


//--------------- SOMAR GASTO VARIAVEL POR FLIGHTNUMBER ----------
@GetMapping("/variavelPerFlightNumber")
public Double gastoVariavelPerId(Long flightNumber) {
	return logbookRepository.findByCustoVariavel(flightNumber);
}
//-----------------OUTRO METODO-------FUNCIONA--------------------------
//--->FUNCIONA
//@GetMapping("/variavelPerFlightNumber/{flightNumber}")
//public ResponseEntity<LogbookDTO> findByCustoVariavel(@PathVariable Long flightNumber){
//	
//	//Pesquisar e implementar o Optional pra nao votar null
//	LogbookDTO dto =  logbookService.findById(flightNumber) ;
//
////	if(logbookDTO != null) {
////		return ResponseEntity.ok().body(logbookDTO);
////	}
//	
//	return ResponseEntity.ok().body(dto);
//}

//-------------------------- SOMAR LAND PER CREW WITHING LAST 90 DAYS

@GetMapping("/last90daysLandingFogaca")
public String calculoNumeroPousosFogaca(String crew1) {
	return logbookRepository.findTotalPouso90Fogaca(crew1);
}

@GetMapping("/last90daysLandingYana")
public String calculoNumeroPousosYana(String crew2) {
	return logbookRepository.findTotalPouso90Yana(crew2);
}

@GetMapping("/last90daysLandingThiago")
public String calculoNumeroPousosThiago(String crew3) {
	return logbookRepository.findTotalPouso90Thiago(crew3);
}



//--- POST -----------------------------------------------

@PostMapping
public ResponseEntity<LogbookDTO> insert(@RequestBody LogbookDTO dto){
	dto = logbookService.insert(dto);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{flightNumber}").buildAndExpand(dto.getFlightNumber()).toUri();
	
	return ResponseEntity.created(uri).body(dto);
	
}

//--- PUT -----------------------------------------------
//ARRUMAR UPDATE
@PutMapping("/{flightNumber}")
public ResponseEntity<LogbookDTO> update (@PathVariable Long flightNumber, @RequestBody LogbookDTO dto){
	//dto = logbookService.findById(flightNumber);
	dto = logbookService.update(flightNumber, dto);
	return ResponseEntity.ok().body(dto);
	
	
	//return ResponseEntity.ok().body(dto);
}

//--- DELETE -----------------------------------------------
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
