package com.imricki.maxoptra.rest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.service.ProcesData;

@Controller
public class BankRestController {

	@Autowired
	private ProcesData procesData;

	private static final Logger LOGGER = Logger.getLogger(BankRestController.class.getName());

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/upload-csv-file")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {

//		// validate file
//		if (file.isEmpty()) {
//			model.addAttribute("message", "Please select a CSV file to upload.");
//			model.addAttribute("status", false);
//		} else {
//			// save users list on model

		List<BankDetailDto> details = new ArrayList<>();

		details.forEach(System.out::println);

		File f = convert(file);
		details = procesData.ProcessList(f);

		model.addAttribute("details", details);
//			model.addAttribute("status", true);
//
//		}

		return "index";
	}

	public File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		file.transferTo(convFile);

		System.err.println(convFile.getName() + " NOMBREEEEEEEE");
		return convFile;
	}
}
