package com.flightinformation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightinformation.model.Logbook;

@Repository
public interface LogbookRepository extends JpaRepository <Logbook, Long> {
//tipo parametrizado tipo da chave primaria do produt id to tipo long

	//Modelo do FLIGHT
	//@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	//List<Flight> findFlights(@Param("departureCity") String from,@Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);

	
	@Query("from Logbook where flightNumber=:flightNumber ")
	List<Logbook> findPilotWithLogbook(@Param("flightNumber") Long flightNumber);
	
	

//@Query("SELECT DISTINCT obj FROM Logbook obj JOIN FETCH obj.pilot")
//List<Logbook> findPilotWithLogbook();
}
