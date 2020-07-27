package com.imricki.maxoptra.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * BankDetailDto is a Data Transfer Object that is sent to the View to show the
 * data.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 */
public class BankDetailDto {

	@NotEmpty(message = "Bank Cant Be Blank")
	private String bank;

	@NotEmpty(message = "Bank Cant Be Blank")
	@Size(max = 19, min = 1)
	@Pattern(regexp = "(\\d{4})-(\\d{4})-(\\d{4})-.*?", message = "Incorrect Format")
	private String cardNumber;

	@NotEmpty(message = "Bank Cant Be Blank")
	@Pattern(regexp = "\\b(\\w{3})-(\\d{4})", message = "Incorrect Format")
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
