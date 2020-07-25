package com.imricki.maxoptra.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * DataUtil is a helper class to manipulate Strings.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 */
public final class DataUtil {

	private static final Logger LOGGER = Logger.getLogger(DataUtil.class.getName());

	private DataUtil() {

	}

	/**
	 * Ofuscate card number.
	 *
	 * @param cardNuumber to Ofuscate
	 * @return the cardNuumber Ofuscated
	 */
	public static String ofuscateCardNumber(String cardNuumber) {

		LOGGER.info("Call() ----> ofuscateCardNumber()");

		if (cardNuumber != null && !cardNuumber.isBlank() && cardNuumber.length() == 19) {

			cardNuumber = cardNuumber.replaceFirst(".{14}", "xxxx-xxxx-xxxx");

		}

		return cardNuumber;

	}

	/**
	 * From date to string.
	 *
	 * @param source date
	 * @return date in string format
	 */
	public static String fromDateToString(LocalDate date) {

		LOGGER.info("Call() ----> fromDateToString()");

		String dateFormated = date.format(DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH));

		return dateFormated.substring(0, 1).toUpperCase() + dateFormated.substring(1);
	}
}
