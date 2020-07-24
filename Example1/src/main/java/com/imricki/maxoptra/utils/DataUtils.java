package com.imricki.maxoptra.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.imricki.maxoptra.model.BankDetail;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public final class DataUtils {

	private static final char SEPARATOR = ',';

	private DataUtils() {

	}

	public static String ofuscateCardNumber(String cardNuumber) {

		// "5601-2345-3446-5678"
		if (cardNuumber != null && !cardNuumber.isBlank() && cardNuumber.length() == 19) {

			cardNuumber = cardNuumber.replaceFirst(".{14}", "xxxx-xxxx-xxxx");

		}

		return cardNuumber;

	}

	public static List<BankDetail> csvToDetailsWithHeaders(File csvFile) throws IOException {

		System.err.println(csvFile.getName());

		FileReader reader = new FileReader(csvFile, StandardCharsets.UTF_8);

		// CSV with Headers
		CsvToBean<BankDetail> cb = new CsvToBeanBuilder<BankDetail>(reader).withType(BankDetail.class)
				.withSeparator(SEPARATOR).build();
		List<BankDetail> details = cb.parse();

		reader.close();

		return details;

	}

	// Check Not Mapping
//	public static List<Detail> csvToDetailsWithOutHeaders(File csvFile) throws IOException {
//
//		System.err.println(csvFile.getName());
//
//		// In case we have a CSV file without Header
//		HeaderColumnNameMappingStrategy<Detail> ms = new HeaderColumnNameMappingStrategy<>();
//		ms.setType(Detail.class);
//
//		FileReader reader = new FileReader(csvFile, StandardCharsets.UTF_8);
//
//		CsvToBean<Detail> cb = new CsvToBeanBuilder<Detail>(reader).withMappingStrategy(ms).withSeparator(SEPARATOR)
//				.build();
//
//		List<Detail> details = cb.parse();
//
//		reader.close();
//
//		return details;
//
//	}
}
