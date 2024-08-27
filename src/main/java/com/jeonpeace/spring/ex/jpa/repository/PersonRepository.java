package com.jeonpeace.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeonpeace.spring.ex.jpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	// 1행 insert
	
}
