package com.flightinformation.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.flightinformation.model.Logbook;
import com.flightinformation.repository.LogbookRepositoryQueries;


//ESSE ARQUIVO É MUITO IMPORTANTE TER O SUFIXO IMPL


@Repository
public class LogbookRepositoryImpl implements LogbookRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Logbook> find(Long flightNumber, String crew1, String crew2){
		
		var jpql = "from Logbook where flightNumber like :flightNumber" 
				+"and crew1 and crew2";
		
		return manager.createQuery(jpql, Logbook.class)
				.setParameter("flightNumber", "%" + flightNumber + "%")
				.setParameter("crew1", crew1)
				.setParameter("crew2", crew2)
				.getResultList();
	}
}
