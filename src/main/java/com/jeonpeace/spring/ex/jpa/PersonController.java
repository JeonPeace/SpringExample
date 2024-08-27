package com.jeonpeace.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.ex.jpa.domain.Person;
import com.jeonpeace.spring.ex.jpa.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
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
	
}
