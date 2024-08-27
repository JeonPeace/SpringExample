package com.jeonpeace.spring.ex.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.spring.ex.jpa.domain.Person;
import com.jeonpeace.spring.ex.jpa.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public Person addPerson(String name, String yyyymmdd, String email, String hobby, String introduce){
		
		Person user = Person.builder()
					.name(name)
					.yyyymmdd(yyyymmdd)
					.email(email)
					.hobby(hobby)
					.introduce(introduce)
					.build();
				
		Person result = personRepository.save(user);
		
		return result;
	}
	
}
