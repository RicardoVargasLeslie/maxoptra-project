package com.imricki.maxoptra.model;

import java.time.LocalDate;

import com.imricki.maxoptra.converter.StringToLocaldDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

/**
 * BankDetail is the domain object that represents the bank details.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 */
public class BankDetail {

	@CsvBindByName(column = "Bank", required = true)
	private String bank;

	@CsvBindByName(column = "Card number", required = true)
	private String cardNumber;

	@CsvCustomBindByName(column = "Expiry date", converter = StringToLocaldDateConverter.class, required = true)
	private LocalDate expirydate;

	public BankDetail() {

	}

	public BankDetail(String bank, String cardNumber, LocalDate expirydate) {
		super();
		this.bank = bank;
		this.cardNumber = cardNumber;
		this.expirydate = expirydate;
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
