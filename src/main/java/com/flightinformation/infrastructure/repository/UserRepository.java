package com.flightinformation.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightinformation.controllers.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
