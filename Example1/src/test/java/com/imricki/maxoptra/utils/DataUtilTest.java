package com.imricki.maxoptra.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DataUtilTest {

	@Test
	void shouldCastDateToString() {

		// Given ----------------------------//
		final LocalDate dateInput;
		dateInput = LocalDate.parse("2017-11-01");

		final String output = "Nov-2017";

		// When ----------------------------//
		Assert.assertEquals(DataUtil.fromDateToString(dateInput), output);

	}

}
