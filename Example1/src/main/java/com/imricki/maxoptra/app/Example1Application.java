package com.imricki.maxoptra.app;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.imricki.maxoptra.service.ProcesData;

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

			// List<BankDetail> list = DataUtils.csvToDetailsWithHeaders(new
			// File("test.csv"));

			// List<BankDetail> list

			// list.sort(Comparator.comparing(BankDetail::getExpirydate,
			// Comparator.reverseOrder()));

//			System.err.println("------------------Antes--------------------");
//			list.forEach(System.out::print);
//
//			list.sort(Comparator.comparing(BankDetail::getExpirydate, Comparator.reverseOrder()));
//
//			System.err.println("------------------Despues--------------------");
//			list.forEach(System.out::print);

			System.err.println("-------" + procesData.Operate(new File("test.csv")));

		};

	}
}