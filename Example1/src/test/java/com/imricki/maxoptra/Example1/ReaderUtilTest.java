package com.imricki.maxoptra.Example1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.imricki.maxoptra.csvreader.ReaderUtil;
import com.imricki.maxoptra.model.BankDetail;

@RunWith(MockitoJUnitRunner.class)
class ReaderUtilTest {

	@InjectMocks
	private ReaderUtil service;

	@Mock
	List<BankDetail> list = new ArrayList<>();

//	@Mock
//	File csvFile = new File("test.csv");

	@BeforeEach
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	void shouldgetBeansFromFile() throws IOException {

		// Given

//		BankDetail dt1 = new BankDetail("Royal Bank", "5601-2345-3446-5678", LocalDate.now());
//		BankDetail dt2 = new BankDetail("of Canada", "5601-2345-3446-5678", LocalDate.now());
//		BankDetail dt3 = new BankDetail("Canada", "5601-2345-3446-5678", LocalDate.now());
//		File csvFile = new File("test.csv");
//		list.add(dt1);
//		list.add(dt2);
//		list.add(dt3);

		// When ----------------------------//
		// when(ReaderUtil.csvToDetailsWithHeaders(csvFile)).thenReturn(list);

		// test the add functionality
		// Assert.assertEquals(2, list.size());

		// Then ----------------------------//

	}

//	public static List<BankDetail> csvToDetailsWithHeaders(File csvFile) throws IOException {
//
//		LOGGER.info("Call() ----> csvToDetailsWithHeaders()");
//
//		FileReader reader = new FileReader(csvFile, StandardCharsets.UTF_8);
//
//		CsvToBean<BankDetail> CsvToBeanMapper = new CsvToBeanBuilder<BankDetail>(reader).withType(BankDetail.class)
//				.withSeparator(SEPARATOR).build();
//
//		List<BankDetail> detailBeans = CsvToBeanMapper.parse();
//
//		reader.close();
//
//		return detailBeans;
//
//	}
}
