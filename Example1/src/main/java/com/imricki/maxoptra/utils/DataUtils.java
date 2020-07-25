package com.imricki.maxoptra.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.model.BankDetail;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
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

	public static List<BankDetailDto> mapLists(List<BankDetail> listFromCsv) {

		List<BankDetailDto> dtoList = new ArrayList<>(listFromCsv.size());

		for (BankDetail bankDetail : listFromCsv) {

			dtoList.add(new BankDetailDto(bankDetail.getBank(), bankDetail.getCardNumber(),
					fromDateToString(bankDetail.getExpirydate())));
		}

		return dtoList;
	}

	public static String fromDateToString(LocalDate date) {

		return date.format(DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH)).toUpperCase();
	}
}
