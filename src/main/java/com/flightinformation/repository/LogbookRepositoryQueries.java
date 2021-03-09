package com.flightinformation.repository;

import java.util.List;

import com.flightinformation.model.Logbook;

public interface LogbookRepositoryQueries {

	List<Logbook> find(Long flightNumber, String crew1, String crew2);

}