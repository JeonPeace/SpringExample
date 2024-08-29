package com.jeonpeace.spring.ex.jpa.service;

import java.util.Optional;

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
	
	public Person updatePerson(int id, String hobby) {
		
		// update 대상을 조회한다.
		// 조회된 객체에서 수정을 진행한다.
		// 해당 객체를 저장한다
		
		// Optional
		// null 일수도 있는 객체를 저장할 때 사용하는 객체
		// null 일수도 있는 객체를 리턴할 때 사용
		Optional<Person> optionalPerson = personRepository.findById(id);
		Person person = optionalPerson.orElse(null);
		
		person = person.toBuilder().hobby(hobby).build();
		
		Person result = personRepository.save(person);
		
		return result;
	}
	
	public void deleteStudent(int id) {
		
		// 삭제 대상을 조회한다.
		// 조회된 객체를 통해 삭제한다.
		Optional<Person> optionalPerson = personRepository.findById(id);
		Person person = optionalPerson.orElse(null);
		
		personRepository.delete(person);
	}
	
	
	
	
}
