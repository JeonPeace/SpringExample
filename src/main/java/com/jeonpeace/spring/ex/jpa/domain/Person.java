package com.jeonpeace.spring.ex.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String yyyymmdd;
	private String email;
	private String hobby;
	private String introduce;
	
	@CreationTimestamp
	@Column(name="createdAt") // 원래 snake형식이 국룰 ex) phone_number 그래서 이렇게 되있으면 이름 고정해줘야함
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updateAt")
	private LocalDateTime updateAt;
	
}