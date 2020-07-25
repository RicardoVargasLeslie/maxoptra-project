package com.imricki.maxoptra.app;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.service.ProcesData;
import com.imricki.maxoptra.utils.DataUtils;

@SpringBootApplication(scanBasePackages = { "com" })
public class Example1Application {

	@Autowired
	private ProcesData procesData;

	public static void main(String[] args) {
		SpringApplication.run(Example1Application.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {

			List<BankDetail> list = DataUtils.csvToDetailsWithHeaders(new File("test.csv"));

			for (BankDetail elem : list) {
				System.out.println("Element : " + elem);
			}

			List<BankDetailDto> orderlist = procesData.sortByExpiringDate(new File("test.csv"));
			orderlist.forEach(System.out::println);

			LocalDate today = LocalDate.now();

			String formattedDate = today.format(DateTimeFormatter.ofPattern("MMM-yyy"));

			String output = formattedDate.substring(0, 1).toUpperCase() + formattedDate.substring(1).replace(".", "");
			System.out.println(output);
		};

	}
}