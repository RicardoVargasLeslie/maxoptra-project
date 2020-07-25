package com.imricki.maxoptra.converter;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.logging.Logger;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * StringToLocaldDateConverter permits the Marshalling from String to LocalDate.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 *
 */
public final class StringToLocaldDateConverter extends AbstractBeanField<Object, Object> {

	private static final Logger LOGGER = Logger.getLogger(StringToLocaldDateConverter.class.getName());

	public StringToLocaldDateConverter() {

	}

	/**
	 * Convert permits to build a LocalDate froma String
	 *
	 * @param initial String to build the LocalDate
	 * @return a LocalDate from a String
	 * @throws CsvDataTypeMismatchException    the csv data type mismatch exception
	 * @throws CsvConstraintViolationException the csv constraint violation
	 *                                         exception
	 */
	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		LOGGER.info("Call() ----> convert()");
		String[] parts = value.split("-");
		String month = parts[0];
		String year = parts[1];
		DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH);
		TemporalAccessor accessor = parser.parse(month);
		Month monthFromInt = Month.of(accessor.get(ChronoField.MONTH_OF_YEAR));

		return LocalDate.of(Integer.valueOf(year), monthFromInt, 1);

	}

}
