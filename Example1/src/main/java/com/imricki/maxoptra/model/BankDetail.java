package com.imricki.maxoptra.model;

import java.time.LocalDate;

import com.imricki.maxoptra.converter.StringToLocaldDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BankDetail is the domain object that represents the bank details.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDetail {

	@CsvBindByName(column = "Bank", required = true)
	private String bank;

	@CsvBindByName(column = "Card number", required = true)
	private String cardNumber;

	@CsvCustomBindByName(column = "Expiry date", converter = StringToLocaldDateConverter.class, required = true)
	private LocalDate expirydate;

}
