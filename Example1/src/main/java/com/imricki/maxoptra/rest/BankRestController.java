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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.imricki.maxoptra.csvreader.ReaderUtil;
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

	@PostMapping("/upload")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {

		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("disabled", 1);
		} else {

			List<BankDetailDto> details = new ArrayList<>();

			details.forEach(System.out::println);

			File f = ReaderUtil.convert(file);
			details = procesData.ProcessList(f);

			model.addAttribute("details", details);
//
		}

		return "index";
	}

	@RequestMapping(value = "/save")
	public String save(BankDetailDto bankDetailDto, Model model) {

		model.addAttribute("details", bankDetailDto);

		System.err.println("holaaaaa");
		return "save";
	}

}
