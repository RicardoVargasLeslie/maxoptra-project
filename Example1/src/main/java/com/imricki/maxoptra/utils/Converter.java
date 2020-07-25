package com.imricki.maxoptra.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public final class Converter {

	public static LocalDate dateFormatter(LocalDate date) {

		return date;

	}

	public static LocalDate textToLocalDate(String text) {

		System.err.println("Cadena Sin Parsear -> " + text);
		String[] parts = text.split("-");
		String Mes = parts[0];
		String Año = parts[1];
		System.err.println("Cadena -> Año " + Año);
		System.err.println("Cadena -> Mes " + Mes);
		DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH);
		TemporalAccessor accessor = parser.parse(Mes);
		Month monthFromInt = Month.of(accessor.get(ChronoField.MONTH_OF_YEAR));

		LocalDate date = LocalDate.of(Integer.valueOf(Año), monthFromInt, 1);

		System.err.println("LocalDate parseado -> " + date);

		return date;

	}
}
