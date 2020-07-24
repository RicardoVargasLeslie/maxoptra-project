package com.imricki.maxoptra.model;

import com.opencsv.bean.CsvBindByName;

public class BankDetail {

	@CsvBindByName(column = "Bank")
	private String bank;

	@CsvBindByName(column = "Card number")
	private String cardNumber;

	@CsvBindByName(column = "Expiry date")
	private String expirydate;

	public BankDetail() {

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
		return "Detail [bank=" + bank + ", cardNumber=" + cardNumber + ", expirydate=" + expirydate + "]";
	}

}
