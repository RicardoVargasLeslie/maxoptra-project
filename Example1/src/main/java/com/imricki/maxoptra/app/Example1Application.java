package com.imricki.maxoptra.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = { "com" })
public class Example1Application {

//	@Autowired
//	private ProcesData procesData;

	public static void main(String[] args) {
		SpringApplication.run(Example1Application.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {

//			System.err.println(procesData.ProcessList(new File("test.csv")));

		};
	}
}