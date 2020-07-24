package com.imricki.maxoptra.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DetailsDto {

	@NotNull(message = "bank cannot be null")
	@NotEmpty
	private String bank;

	@NotNull(message = "cardNumber cannot be null")
	@NotEmpty
	@Size(min = 4, max = 16, message = "cardNumber Me must be between 4 and 16 characters")
	private String cardNumber;

	@NotNull(message = "expirydate cannot be null")
	@NotEmpty
	private LocalDate expirydate;

	public DetailsDto() {

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

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

}
