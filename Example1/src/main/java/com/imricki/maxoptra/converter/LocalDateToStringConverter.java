package com.imricki.maxoptra.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class LocalDateToStringConverter extends AbstractBeanField<Object, Object> {

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		System.err.println("Dentroo");
		LocalDate d = LocalDate.parse(value);
		String formattedDate = d.format(DateTimeFormatter.ofPattern("MMM-yyy"));

		String output = formattedDate.substring(0, 1).toUpperCase() + formattedDate.substring(1).replace(".", "");
		System.out.println(output + "rrrrrrrrrrrr");

		return output;
	}

}
