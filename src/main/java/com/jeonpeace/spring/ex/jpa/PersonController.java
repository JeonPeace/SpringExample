package com.jeonpeace.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.ex.jpa.domain.Person;
import com.jeonpeace.spring.ex.jpa.repository.PersonRepository;
import com.jeonpeace.spring.ex.jpa.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonRepository personRepository;
	
	// C, U, D
	@GetMapping("/jpa/lombok/create")
	@ResponseBody
	public Person createPerson() {
		
		Person user = personService.addPerson("전전전", "20201010", "jeonjeonejeon@naver.com", "낚시", "낚시 가즈아~");
	
		return user;
	}
	
	
	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public Person lombokTest() {
		
//		Person user = new Person(50, "전진우", "20010522", "jeon@gamil.com", "게임", "안녕하세요", null, null);
//		user.setName("전전전");

		Person user = Person.builder()
				.name("전진우")
				.yyyymmdd("20010522")
				.email("jeon@gmail.com")
				.hobby("게임")
				.introduce("안녕하세요")
				.build();
		
		return user;
	}
	
	@GetMapping("/jpa/lombok/find")
	@ResponseBody
	public List<Person> findPerson(){
		
		// 모든 행 조회
		List<Person> personList = null;
		
//		personList = personRepository.findAll();
		
//		personList = personRepository.findAllByOrderByIdDesc();
//		personList = personRepository.findTop2ByOrederByIdDesc();
//		personList = personRepository.findByName("전진우");
		// 전진우, 유재석
		List<String> nameList = new ArrayList<>();
		nameList.add("전진우");
		nameList.add("유재석");
		
//		personList = personRepository.findByNameIn(nameList);
//		personList = personRepository.findByEmailContaining("naver");
//		personList = personRepository.findByIdBetweenOrderByIdDesc(2, 3);
		
		personList = personRepository.selectByHobby("게임");
		
		return personList;
	}
	
	
	
}
