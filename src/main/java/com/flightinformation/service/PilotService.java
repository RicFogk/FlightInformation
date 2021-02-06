package com.flightinformation.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flightinformation.dto.PilotDTO;
import com.flightinformation.model.Pilot;
import com.flightinformation.repository.PilotRepository;

@Service
public class PilotService {

@Autowired
private PilotRepository repository;

@Transactional(readOnly = true)
public List<PilotDTO> findAll(){
List<Pilot> list = repository.findAll();
return list.stream().map(x -> new PilotDTO(x)).collect(Collectors.toList());
}

@Transactional(readOnly = true)
public List<PilotDTO> findById(Long id) {
	Optional<Pilot> obj= repository.findById(id);
	//Pilot entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
	return obj.stream().map(x -> new PilotDTO(x)).collect(Collectors.toList());
}
}
