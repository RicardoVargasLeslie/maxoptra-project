package com.imricki.maxoptra.csvreader;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import com.imricki.maxoptra.model.BankDetail;

@RunWith(MockitoJUnitRunner.class)
class ReaderUtilTest {

	@BeforeEach
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	void shouldParseFiletoObjects() throws IOException {

		// Given ----------------------------//
		final List<BankDetail> beanList = new ArrayList<>();
		final LocalDate d1;
		d1 = LocalDate.parse("2017-11-01");
		final LocalDate d2;
		d2 = LocalDate.parse("2017-10-01");
		final LocalDate d3;
		d3 = LocalDate.parse("2018-12-01");

		final BankDetail dt1 = new BankDetail("HSBC Canada", "5601-2345-3446-5678", d1);
		final BankDetail dt2 = new BankDetail("Royal Bank of Canada", "4519-4532-4524-2456", d2);
		final BankDetail dt3 = new BankDetail("American Express", "3786-7334-8965-345", d3);
		beanList.add(dt1);
		beanList.add(dt2);
		beanList.add(dt3);
		final File csvFile = new File("test.csv");

		// When ----------------------------//
		Assert.assertEquals(ReaderUtil.csvToDetailsWithHeaders(csvFile), beanList);

	}

	@Test
	void shouldNotConvertFile() throws IOException {

		// Given ----------------------------//
		final MultipartFile multifile = null;
		final File csvFile = new File("");

		// When ----------------------------//
		Assert.assertEquals(ReaderUtil.convert(multifile), csvFile);

	}

	@Test
	void shouldConvertFile() throws IOException {

		// Given ----------------------------//
		final MultipartFile multifile = null;
		final File csvFile = new File("");

		// When ----------------------------//
		Assert.assertEquals(ReaderUtil.convert(multifile), csvFile);

	}

}
