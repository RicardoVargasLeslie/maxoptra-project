package com.imricki.maxoptra.csvreader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.multipart.MultipartFile;

import com.imricki.maxoptra.model.BankDetail;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * ReaderUtil permits to read the CSV file and Marshall it to beans.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 * 
 */
public final class ReaderUtil {

	private static final Logger LOGGER = Logger.getLogger(ReaderUtil.class.getName());

	private static final char SEPARATOR = ',';

	private ReaderUtil() {

	}

	/**
	 * Csv to details with headers.
	 *
	 * @param csvFile the csv file
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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

	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		file.transferTo(convFile);

		System.err.println(convFile.getName() + " NOMBREEEEEEEE");
		return convFile;
	}
}
