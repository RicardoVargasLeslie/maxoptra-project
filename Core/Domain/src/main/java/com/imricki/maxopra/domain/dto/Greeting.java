package com.imricki.maxopra.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class Greeting {

	String name = "pepe";

	public String getName() {
		return name;
	}

	public Greeting() {
		// TODO Auto-generated constructor stub
	}
}
