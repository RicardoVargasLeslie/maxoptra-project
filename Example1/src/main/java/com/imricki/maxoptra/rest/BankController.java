package com.imricki.maxoptra.rest;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.imricki.maxoptra.csvreader.ReaderUtil;
import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.service.ProcesData;

/**
 * BankController is the entry point to the API
 *
 * @author Ricardo Vargas
 * @version 1.0
 */
@Controller
public class BankController {

	@Autowired
	private ProcesData procesDataService;

	private static final Logger LOGGER = Logger.getLogger(BankController.class.getName());

	/**
	 * Displays the form before inserting data
	 *
	 * @return the form view
	 */
	@GetMapping("/addForm")
	public String showAddForm(Model model) {
		LOGGER.info("showAddUpForm() ----> index()");

		model.addAttribute("bankDetailDto", new BankDetailDto());
		return "new";
	}

	/**
	 * Base URL
	 *
	 * @param the lists of objects to load in the view
	 * @return the main view
	 */
	@GetMapping(value = "/")
	public String index(Model model) {

		LOGGER.info("Call() ----> index()");

		model.addAttribute("details", procesDataService.getAllBankDetails());

		return "index";
	}

	/**
	 * Upload CSV file.
	 *
	 * @param the csv file to ipload
	 * @param the model object to load the view
	 * @return the upload view
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@PostMapping("/upload")
	public String uploadCSVFile(@RequestParam("file") MultipartFile multiPartFile, Model model) throws IOException {

		LOGGER.info("Call() ----> upload()");

		if (multiPartFile.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("disabled", 1);
		} else {

			File file = ReaderUtil.convert(multiPartFile);

			model.addAttribute("details", procesDataService.processCsv(file));

		}

		return "index";
	}

	/**
	 * Save.
	 *
	 * @param bankDetailDto the object to be saved
	 * @param bindingResult tests if there is errors
	 * @return the save view
	 */
	@PostMapping(value = "/save")
	public String save(@Valid BankDetailDto bankDetailDto, BindingResult bindingResult, Model model) {

		LOGGER.info("Call() ----> save()");

		if (bindingResult.hasErrors()) {

			return "new";
		}

		model.addAttribute("bankDetailDto", procesDataService.addDetails(bankDetailDto));

		return "redirect:/";
	}

}
