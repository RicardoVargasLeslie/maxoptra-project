package com.imricki.maxoptra.model;

import java.time.LocalDate;

import com.imricki.maxoptra.LocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

public class BankDetail {

	@CsvBindByName(column = "Bank")
	private String bank;

	@CsvBindByName(column = "Card number")
	private String cardNumber;

	@CsvCustomBindByName(column = "Expiry date", converter = LocalDateConverter.class)
	private LocalDate expirydate;

	public BankDetail() {

	}

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
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

	@Override
	public String toString() {
		return "BankDetail [bank=" + bank + ", cardNumber=" + cardNumber + ", expirydate=" + expirydate + "]";
	}

}
