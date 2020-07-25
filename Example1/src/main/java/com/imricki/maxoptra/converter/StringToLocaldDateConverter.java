package com.imricki.maxoptra.converter;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class StringToLocaldDateConverter extends AbstractBeanField<Object, Object> {

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		String[] parts = value.split("-");
		String Mes = parts[0];
		String Año = parts[1];
		DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH);
		TemporalAccessor accessor = parser.parse(Mes);
		Month monthFromInt = Month.of(accessor.get(ChronoField.MONTH_OF_YEAR));

		LocalDate date = LocalDate.of(Integer.valueOf(Año), monthFromInt, 1);

		return date;
	}

}
