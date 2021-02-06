package com.flightinformation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightinformation.model.Pilot;

@Repository
public interface PilotRepository extends JpaRepository <Pilot, Long> {
//tipo parametrizado tipo da chave primaria do produt id to tipo long

//@Query("SELECT DISTINCT obj FROM Pilot obj JOIN FETCH obj.logbook "
//+ " WHERE obj.status= 0 ORDER BY obj.moment ASC")
//List<Pilot> findOrdersWithProducts();
	
}

