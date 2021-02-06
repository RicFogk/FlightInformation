package com.flightinformation.controllers;

import java.util.List;

//import java.util.List;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//
//import com.flightinformation.model.Pilot;
//import com.flightinformation.repository.PilotRepository;

import com.flightinformation.dto.LogbookDTO;
import com.flightinformation.dto.PilotDTO;
import com.flightinformation.model.Pilot;
import com.flightinformation.repository.PilotRepository;
import com.flightinformation.service.PilotService;

//@RestController
//@RequestMapping(value="/pilot")
//public class PilotController {
//
//@Autowired
////private PilotService service;
//private PilotRepository repository;
//
//@Autowired
//PilotController(PilotRepository repository){
//	this.repository = repository; 
//}

//@RequestMapping(value="/pilot", method=RequestMethod.GET)
//public List<Pilot> getPilots(){
//	return repository.findAll();
//}
//@GetMapping
//public ResponseEntity <List<PilotDTO>> findAll(){
//List<PilotDTO> list = service.findAll();
//return ResponseEntity.ok().body(list);
//}
//

//
//@RequestMapping(value="/pilot", method=RequestMethod.POST)
//public Pilot savePilot(Pilot pilot) {
//	return repository.save(pilot);
//}



//@GetMapping
//public ResponseEntity <List<PilotDTO>> findAll(){
//List<PilotDTO> list = service.findAll();
//return ResponseEntity.ok().body(list);
//}
//
//@PostMapping
//public ResponseEntity<PilotDTO> insert(@RequestBody PilotDTO dto){
//dto = service.insert(dto);
//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//.buildAndExpand(dto.getId()).toUri();
//return ResponseEntity.created(uri).body(dto);
//}
//
//@PutMapping("/{id}")
//public ResponseEntity<PilotDTO> setDelivered(@PathVariable Long id){
//PilotDTO dto = service.setDelivered(id);
//return ResponseEntity.ok().body(dto);
//}
//
//
//}

@RestController
@RequestMapping(value="pilot")

public class PilotController{
	
	@Autowired
	private PilotService service;
	private PilotRepository pilotRepository;
	
	 @Autowired
     PilotController(PilotRepository pilotRepository) {
             this.pilotRepository = pilotRepository;
     }
	 
//	 @Autowired
//     PilotService(PilotService service) {
//             this.service = service;
//     }
	
//	@GetMapping
//	public ResponseEntity <List<PilotDTO>> findAll(){
//		List<PilotDTO> list= service.findAll();
//		return ResponseEntity.ok().body(list);
//	}
	 
		@GetMapping
		public ResponseEntity <List<PilotDTO>> findAll(){
			List<PilotDTO> list= service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
//	    @RequestMapping(value = "/pilot/{id}", method = RequestMethod.GET)
//        public Pilot getPilot(@PathVariable("id") Long id) {
//                return service.findById(id).get();
//        }
	    @RequestMapping("/{id}")
		public ResponseEntity<List<PilotDTO>> findById (@PathVariable ("id") Long id) {
//			PilotDTO dto = service.findById(id);
//	    	return ResponseEntity.ok().body(dto);
	    	List<PilotDTO> list= service.findById(id);
			return ResponseEntity.ok().body(list);
		}
	  
		
//		@GetMapping("/pilot/{id}")
//		public ResponseEntity findPilotById(@PathVariable Long id) {
//			return pilotRepository.findById(id).isPresent() ? service.findById(id).get():null);
//		}
	
//	 @RequestMapping(value = "/pilot", method = RequestMethod.GET)
//     public List<PilotDTO> list = pilotRepository.getPilots() {
//             return pilotRepository.findAll();
//     }
	
}