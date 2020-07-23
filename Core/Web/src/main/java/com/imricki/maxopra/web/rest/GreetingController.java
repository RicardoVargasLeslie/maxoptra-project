package com.imricki.maxopra.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imricki.maxopra.domain.dto.Greeting;

@RestController
public class GreetingController {

	
	@Autowired
	private Greeting g;
	
	@GetMapping("/hola")
	public String greeting() {
		return g.getName();
	}
}
