package com.jeonpeace.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.jeonpeace.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {

	// 가장 최근에 등록된 행 조회
	public User selectLastUser();
	
}
