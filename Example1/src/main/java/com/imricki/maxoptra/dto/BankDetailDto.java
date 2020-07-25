package com.imricki.maxoptra.dto;

import com.imricki.maxoptra.converter.LocalDateToStringConverter;
import com.opencsv.bean.CsvCustomBindByName;

public class BankDetailDto {

	private String bank;

	private String cardNumber;

	@CsvCustomBindByName(column = "Expiry date", converter = LocalDateToStringConverter.class)
	private String expirydate;

	public BankDetailDto() {

	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	@Override
	public String toString() {
		return "BankDetailDto [bank=" + bank + ", cardNumber=" + cardNumber + ", expirydate=" + expirydate + "]";
	}

}
