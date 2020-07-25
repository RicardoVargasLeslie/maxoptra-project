package com.imricki.maxoptra.csvreader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

import com.imricki.maxoptra.model.BankDetail;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public final class ReaderUtil {

	private static final Logger LOGGER = Logger.getLogger(ReaderUtil.class.getName());
	private static final char SEPARATOR = ',';

	private ReaderUtil() {

	}

	public static List<BankDetail> csvToDetailsWithHeaders(File csvFile) throws IOException {

		LOGGER.info("Call() ----> csvToDetailsWithHeaders()");

		System.err.println(csvFile.getName());

		FileReader reader = new FileReader(csvFile, StandardCharsets.UTF_8);

		CsvToBean<BankDetail> CsvToBeanMapper = new CsvToBeanBuilder<BankDetail>(reader).withType(BankDetail.class)
				.withSeparator(SEPARATOR).build();

		List<BankDetail> detailBeans = CsvToBeanMapper.parse();

		reader.close();

		return detailBeans;

	}

}
