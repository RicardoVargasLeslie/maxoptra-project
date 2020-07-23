package com.imricki.maxopra.domain.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@GetMapping("/hola")
	public String greeting() {
		return new String("Hii");
	}
}
