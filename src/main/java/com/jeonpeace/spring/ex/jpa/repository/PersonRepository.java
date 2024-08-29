package com.jeonpeace.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeonpeace.spring.ex.jpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	// 1행 insert
	// id(PK)를 기반으로 하나의 행을 조회하는 기능
	
	// id 기준으로 내림차순 정렬된 결과 조회
	// ORDER BY `id` DESC
	public List<Person> findAllByOrderByIdDesc();
	
	// id 기준으로 내림차순한 결과를 2개만 조회
	// ORDER BY `id` DESC LIMIT 2
	public List<Person> findTop2ByOrderByIdDesc();
	
	// 전달 받은 이름과 일치하는 행 조회
	// WHERE `name` = #{name}
	public List<Person> findByName(String name);
	
	// 전달 받은 이름들과 일치하는 행 조회
	// WHERE `name` IN (#{name1}, #{name1})
	public List<Person> findByNameIn(List<String> nameList);	
	
	// 전달 받은 값이 포함된 email 컬럼을 가진 행 조회
	// WHERE `email` LIKE `%gmail%`
	public List<Person> findByEmailContaining(String email);
	
	// id 컬럼의 값이 특정 값 사이에 대응되는 행을 id 기반으로 내림차순 정렬한 결과 조회
	// WHERE `id` BETWEEN 1 AND 5 ORDER BY `id` DESC
	public List<Person> findByIdBetweenOrderByIdDesc(int start, int end);
	
	// 쿼리를 직접 작성해서 실행
	// Native Query
	// hobby 컬림이 일치하는 데이터 조회
	@Query(value="SELECT * FROM `user` WHERE `hobby` = :hobby", nativeQuery=true)
	public List<Person> selectByHobby(@Param("hobby")String hobby);
	
}
