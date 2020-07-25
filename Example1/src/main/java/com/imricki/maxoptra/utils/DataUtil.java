package com.imricki.maxoptra.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Logger;

public final class DataUtil {

	private static final Logger LOGGER = Logger.getLogger(DataUtil.class.getName());

	private DataUtil() {

	}

	public static String ofuscateCardNumber(String cardNuumber) {

		LOGGER.info("Call() ----> ofuscateCardNumber()");

		if (cardNuumber != null && !cardNuumber.isBlank() && cardNuumber.length() == 19) {

			cardNuumber = cardNuumber.replaceFirst(".{14}", "xxxx-xxxx-xxxx");

		}

		return cardNuumber;

	}

	public static String fromDateToString(LocalDate date) {

		LOGGER.info("Call() ----> fromDateToString()");

		String dateFormated = date.format(DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH));

		return dateFormated.substring(0, 1).toUpperCase() + dateFormated.substring(1);
	}
}
