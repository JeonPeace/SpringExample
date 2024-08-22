package com.jeonpeace.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.spring.ex.mvc.domain.User;
import com.jeonpeace.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	// 가장 최근 등록된 사용자 정보 리턴
	public User getLastUser() {
		
		User lastUser = userRepository.selectLastUser();
		
		return lastUser;
	}
	
	public int addUser(String name, String birthday, String email, String introduce) {
		
		int count = userRepository.insertUser(name, birthday, email, introduce);
		
		return count;
		
	}
	
	public int addUserByObject(User user) {
		
		int count = userRepository.insertUserByObject(user);
		
		return count;
		
	}
	
	public boolean isDuplicateEmail(String email) {
		
		int count = userRepository.selectCountByEmail(email);
		
		if(count == 0) {
			// 중복 안됨
			return false;
		}else {
			// 중복됨
			return true;
		}
	}
	
}
