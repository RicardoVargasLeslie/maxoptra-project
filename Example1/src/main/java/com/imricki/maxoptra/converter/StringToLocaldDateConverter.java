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

public final class StringToLocaldDateConverter extends AbstractBeanField<Object, Object> {

	private static final Logger LOGGER = Logger.getLogger(StringToLocaldDateConverter.class.getName());

	public StringToLocaldDateConverter() {

	}

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		String[] parts = value.split("-");
		String Mes = parts[0];
		String Año = parts[1];
		DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH);
		TemporalAccessor accessor = parser.parse(Mes);
		Month monthFromInt = Month.of(accessor.get(ChronoField.MONTH_OF_YEAR));

		return LocalDate.of(Integer.valueOf(Año), monthFromInt, 1);

	}

}
