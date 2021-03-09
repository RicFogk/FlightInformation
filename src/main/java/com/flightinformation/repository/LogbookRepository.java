package com.flightinformation.repository;



import java.sql.Date;
import java.sql.Time;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightinformation.model.Logbook;

@Repository
public interface LogbookRepository extends JpaRepository <Logbook, Long>, LogbookRepositoryQueries {
//tipo parametrizado tipo da chave primaria do produt id to tipo long

	//Modelo do FLIGHT
	//@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	//List<Flight> findFlights(@Param("departureCity") String from,@Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);

	//******************* Usando o Optinal -> So retorna um
	
	
	@Query("from Logbook where flightNumber=:flightNumber ")
	List<Logbook> findPilotWithLogbook(@Param("flightNumber") Long flightNumber);
	
	
	@Query("from Logbook where initDate=:initDate")
	List<Logbook> findByInitDate(@Param("initDate") Date initDate);
	
	 
	//usar o Optional no lugar do List so retorna um. tentar usar->like %:init_date%
	//--> soma de colunas a partir de uma data
	//SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(flight_time))) FROM logbook AS total_hour WHERE init_date >='2021-01-01' ;
	@Query("from Logbook where YEAR(init_date)= 2021")
//	@Query("from Logbook year=:year")
	List<Logbook> findByYear(@Param("init_date") String init_date);
	
	
	
	@Query("from Logbook where crew3=:crew3 ")
	List<Logbook> findByCrew3(@Param("crew3") String crew3);
	
	
	
	//EXTERNALIZANDO POR MEIO ARQ XML
	//@Query("from Logbook where solicitor=:solicitor ") <-- INSERI NUM ARQUIVO XML NA PASTA META-INF
	List<Logbook> findBySolicitor(@Param("solicitor") String solicitor);
	
	
	
	
	//CALCULANDO TEMPO TOTAL POR CREW -- tentativa de usar JPQL **NAO DEU CERTO
	// MYSQL QUERY (CODIGO USADO NO MYSQL)--> SELECT  SEC_TO_TIME( SUM( TIME_TO_SEC( `block_time` ) ) ) AS timeSum  FROM logbook WHERE pf > 'fogaca'
	//@Query("from logbook where pf like %:pf% = :'fogaca'")
	
	//@Query("SELECT FUNC('SEC_TO_TIME', SUM(FUNC('TIME_TO_SEC', w.block_time))) FROM logbook w WHERE pf>'fogaca'")
	
	//abaixo **NATIVE QUERY  funcionando ----------------------------------------------------------------------------------------------------------
	@Query(value = "SELECT  SEC_TO_TIME( SUM( TIME_TO_SEC( `block_time` ) ) ) AS timeSum  FROM logbook WHERE pf = 'Fogaca'", nativeQuery = true)
	String consultarTotalTimePfFogaca(@Param("pf") String pf);
	
	@Query(value = "SELECT  SEC_TO_TIME( SUM( TIME_TO_SEC( `block_time` ) ) ) AS timeSum  FROM logbook WHERE pf = 'Yana'", nativeQuery = true)
	String consultarTotalTimePfYana(@Param("pf") String pf);
	
	@Query(value = "SELECT  SEC_TO_TIME( SUM( TIME_TO_SEC( `block_time` ) ) ) AS timeSum  FROM logbook WHERE pf = 'Thiago'", nativeQuery = true)
	String consultarTotalTimePfThiago(@Param("pf") String pf);
// 	
// *************  CRIAR  AGRUPAMENTO ENTRE OS 3 PILOTOS NO ANO	*******************************************
	// nao mexer --> @Query(value = "SELECT YEAR(init_date) as year, pf, SEC_TO_TIME(SUM(TIME_TO_SEC(block_time))) AS year_total FROM logbook GROUP BY pf", nativeQuery = true)
	@Query(value = "SELECT YEAR(init_date) as year, pf, SEC_TO_TIME(SUM(TIME_TO_SEC(block_time))) AS year_total FROM logbook GROUP BY pf", nativeQuery = true) //<-- Teste
	//String consultarTotalTimeAmongPilots(@Param("pf") String pf);
	List<Object[]> consultarTotalTimeAmongPilots(@Param("pf") String pf);
	//----------------------------------------------------------------------------------------------------------------------------------------------
	
	//*****************  ACHAR OS VOOS REGULAMENTADOS **********************************************************************************************
	// SQL funcionand0 =>   -- SHOW SHOW SHOW SHOW --> agora tem que pegar o startup do primeiro voo e shutdwon do ultimo voo DO DIA!!!!!
	//SELECT flight_number, startup_time, shutdown_time from logbook WHERE timediff(shutdown_time, startup_time) > '03:00:00'
	//----------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	//@Query("select u from User u where u.firstname = :#{#customer.firstname}")
	// sum(taxas_apt + trip_support + fbo_handler + catering + crew_hotel + eng_cost_per_engine) as total
	
	//@Query("select u from User u where u.firstname = :#{#customer.firstname}")
	//List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);
	
	//@Query(value = "SELECT u from Logbook u where u.flight_number =:#{#flight_number} AND sum(taxas_apt + trip_support + fbo_handler + catering + crew_hotel + eng_cost_per_engine)", nativeQuery = true)  //sum(taxas_apt + trip_support + fbo_handler + catering + crew_hotel + eng_cost_per_engine) as total", nativeQuery = true)
	//@Query(value = "SELECT  sum(taxas_apt + trip_support + fbo_handler + catering + crew_hotel + eng_cost_per_engine) as total select u from Logbook u where u.flight_number = :#{#flight_number} ", nativeQuery = true)
	
	//@Query(value = "SELECT sum(taxas_apt + trip_support + fbo_handler + catering + crew_hotel + eng_cost_per_engine) as total from Logbook where flightNumber = 10332020")// SELECT sum(taxas_apt + trip_support + fbo_handler + catering + crew_hotel + eng_cost_per_engine) as total 
	
	//@Query(value="from Logbook flight_number=:flight_number SELECT sum(taxas_apt + trip_support + fbo_handler + catering + crew_hotel + eng_cost_per_engine) ")
	
	
	
	//-------------------------------- NAO MEXER -----------------------------------------
//	@Query(value="SELECT SUM(a FROM Logbook a WHERE a.flightNumber = :flightNumber, SUM(taxasApt + tripSupport + fboHandler + catering + crewHotel + engHostPerEngine))")
//	//@Query(value=“SELECT a FROM Logbook a WHERE a.flightNumber = :flightNumber”)
//	List<Logbook> findByCustoVariavel(@Param("flightNumber") Long flightNumber);
	//------------------------------------------------------------------------------------
	
	
	
	//---------------NAO MEXER ------------------------------------------------------------
	//@Query(value = "SELECT sum(taxas_apt + catering ) as total FROM logbook a WHERE flight_number = :flightNumber", nativeQuery=true)
	//@Query(value = "SELECT gastoVariavelTotal FROM logbook a WHERE flight_number = :flightNumber", nativeQuery=true)
//	Double findByCustoVariavel(@Param("flightNumber") Long flightNumber);
	//-------------------------------------------------------------------------------------
	
	
	//TESTE BED
	//@Query(value="select sum(taxas_apt + catering) as total from Logbook a where a.flightNumber= ?1")
	//@Query(value = "SELECT sum(taxas_apt + trip_support + fbo_handler + catering + crew_hotel + eng_cost_per_engine) as total FROM Logbook WHERE a.flightNumber = :flightNumber")
	//@Query(value="SELECT SUM (a.taxasApt + a.taxasNav) as total from Logbook a WHERE  a.flightNumber = :flightNumber ")
	//@Query(value="select a FROM Logbook a where a.flightNumber= ?1 ")
	//@Query(value="select sum(a.taxasApt), WHERE a Logbook a where a.flightNumber = :flightNumber")
	//@Query(value="SELECT  sum (taxasApt + tripSupport)as total FROM Logbook a WHERE a.flightNumber = :flightNumber " )
	//@Query(value="SELECT a FROM Logbook a WHERE sum(a.taxas_apt + a.trip_nav)AS total WHERE a.flightNumber = :flightNumber " )
	//-->08:57 12022021 -->@Query(value="select u from Logbook u where u.flightNumber = :flightNumber ")
	//@Query(value="SELECT a FROM Logbook a WHERE a.flightNumber = :flightNumber ")
	//---->List<Logbook> findByCustoVariavel(@Param("flightNumber") Long flightNumber);
	
	//@Query(value="SELECT a FROM Logbook a WHERE a.flightNumber = :flightNumber")
	
	//-------------------------------------------------------------- RETORNA SOMA GASTO VARIVEL POR ID ---------------------------------------------------------------
	@Query(value = "SELECT sum(taxas_apt + trip_support + fbo_handler + catering + crew_hotel + eng_cost_per_engine) FROM Logbook WHERE flight_number = :flightNumber", nativeQuery = true)
	Double findByCustoVariavel (@Param("flightNumber") Long flightNumber);
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
//	
	//jpql
	//@Query("from Logbook b where b.crew1='Fogaca' ")
	//String..
	
	
	
	//FUNCIONNA NAO MEXER USAR O CLONE ABAIXO
	@Query(value = "SELECT  SEC_TO_TIME( SUM( TIME_TO_SEC( `flight_time` ) ) ) AS timeSum  FROM logbook WHERE YEAR (init_date)=2021", nativeQuery = true)
	String consultarTotalTimePerYear2021(@Param("init_date") String init_date);
	
	
//	@Query(value = "SELECT  SEC_TO_TIME( SUM( TIME_TO_SEC( `flight_time` ) ) ) AS timeSum  FROM logbook WHERE   YEAR (initDate) AS %:initDate% ", nativeQuery = true)
//	String consultarTotalTimePerYear2021(@Param("initDate") String initDate);
	
	

	
	
	//--------------------------------- RETORNA TOTAL DE POUSOS POR CREW last 90 days ------------------------------------------------
	//MYSQL
	/*
	SELECT SUM(day_land) + SUM(night_land)as totalLdg  FROM logbook where  init_date >= now()-interval 90 day AND crew1="Fogaca"
	SELECT SUM(day_land) + SUM(night_land)as totalLdg  FROM logbook where  init_date >= now()-interval 90 day AND  crew1="Yana" OR crew2="Yana"
	SELECT SUM(day_land) + SUM(night_land)as totalLdg  FROM logbook where  init_date >= now()-interval 90 day AND crew2="Thiago" 
	 */
	
	@Query(value="SELECT SUM(day_land) + SUM(night_land) FROM logbook WHERE  init_date >= now()-interval 90 day AND crew1='Fogaca'", nativeQuery = true)
	String findTotalPouso90Fogaca (@Param("crew1") String crew1);
	
	@Query(value="SELECT SUM(day_land) + SUM(night_land) FROM logbook WHERE  init_date >= now()-interval 90 day AND crew1='Yana' OR crew2='Yana'", nativeQuery = true)
	String findTotalPouso90Yana (@Param("crew2") String crew2);
	
	@Query(value="SELECT SUM(day_land) + SUM(night_land) FROM logbook WHERE  init_date >= now()-interval 90 day AND crew2='Thiago'", nativeQuery = true)
	String findTotalPouso90Thiago (@Param("crew3") String crew3);
	//--------------------------------------------------------------------------------------------------------------------------------

	
	
	
//	@Query(value = "SELECT  SEC_TO_TIME( SUM( TIME_TO_SEC( `flight_time` ) ) ) AS timeSum  FROM SELECT EXTRACT (YEAR FROM init_date) FROM logbook", nativeQuery = true)
//	String consultarTotalTimePerYear(@Param("flight_time") String init_date);
	
	//EXISTE
	boolean existsByAptFrom(String aptFrom);
	
	//COUNTADORES
	int countByAptFrom(String aptFrom);
	int countByCrew1(String crew1);
	int countByCrew2(String crew2);
	int countByCrew3(String crew3);
	int countByCrew1AndCrew2(String crew1, String crew2);
	int countByPf(String pf);
	
	
	
	
	
	
	//arrumar os Lists abaixo
	List<Logbook> findByCrew1 (String crew1);
	List<Logbook> findByCrew2 (String crew2);
	//List<Logbook> findByCrew3 (String crew3);
	
	//nao esta correto, esta buscando todos os voos 
	List<Logbook> findByCrew1AndCrew2 (String crew1, String crew2);
	
	
	//USING DYNAMIC JPQL IMPL FILE
	//List<Logbook> find(Long flightNumber, String crew1, String crew2);  apagou e moveu pois colocou como heranca (exends apos <Logbook, Long na interface)
	
	

//@Query("SELECT DISTINCT obj FROM Logbook obj JOIN FETCH obj.pilot")
//List<Logbook> findPilotWithLogbook();
}
