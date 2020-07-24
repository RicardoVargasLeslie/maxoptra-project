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

			String str = DataUtils.ofuscateCardNumber("5601-2345-3446-5678");

			System.err.println(str);

//			DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH);
//			TemporalAccessor accessor = parser.parse("Feb");
//			System.out.println(accessor.get(ChronoField.MONTH_OF_YEAR)); // prints 2
//			
//			LocalDate t;
//			
//			String date = "04/2018";
//			DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("MM/yyyy")
//					.parseDefaulting(ChronoField.DAY_OF_MONTH, 1).toFormatter();
//			LocalDate parsedDate = LocalDate.parse(date, dateFormat);
//			System.out.println(parsedDate); // prints: 2018-04-01
//
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
//
//			String date = "16-Aug-2016";
//
//			LocalDate localDate = LocalDate.parse(date, formatter);
//
//			System.out.println(localDate); // default, print ISO_LOCAL_DATE
//
//			System.out.println(formatter.format(localDate)); // print formatter date
		};

	}
}