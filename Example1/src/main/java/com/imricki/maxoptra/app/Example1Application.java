package com.imricki.maxoptra.app;

import java.io.File;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.utils.DataUtils;

@SpringBootApplication
public class Example1Application {

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

//			LocalDate date = DataUtils.stringToLocalDate("Oct-2017");
//
//			System.err.println("Salida -> " + date);
		};

	}
}