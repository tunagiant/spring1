package com.example.demo2.controller;

public class MemberForm {
	
	private String name;

	public String getName() {
		return name;
	}

	// 3. 스프링에서 setName을 통해서 html에서 받아온 name attribute을 setName을 호출해서 MemberForm에 설정
	public void setName(String name) {
		this.name = name;
	}
	

}
