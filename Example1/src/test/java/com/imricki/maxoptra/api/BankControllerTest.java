package com.imricki.maxoptra.api;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

class BankControllerTest {

	@InjectMocks
	BankController api;

	@Mock
	Model model;

	@Test
	void shouldShowform() {

	}

//	@GetMapping("/addForm")
//	public String showAddForm(Model model) {
//		LOGGER.info("showAddUpForm() ----> index()");
//
//		model.addAttribute("bankDetailDto", new BankDetailDto());
//		return "new";
//	}
}
