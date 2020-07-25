package com.imricki.maxoptra.dto;

/**
 * BankDetailDto is a Data Transfer Object that is sent to the View to show the
 * data.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 */
public class BankDetailDto {

	private String bank;

	private String cardNumber;

	private String expirydate;

	public BankDetailDto() {

	}

	public BankDetailDto(String bank, String cardNumber, String expirydate) {
		super();
		this.bank = bank;
		this.cardNumber = cardNumber;
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
