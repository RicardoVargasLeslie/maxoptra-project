package com.imricki.maxoptra.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BankDetailDto is a Data Transfer Object that is sent to the View to show the
 * data.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDetailDto {

	@NotEmpty(message = "Bank Cant Be Blank")
	private String bank;

	@NotEmpty(message = "Bank Cant Be Blank")
	@Size(max = 19, min = 1)
	@Pattern(regexp = "(\\d{4})-(\\d{4})-(\\d{4})-.*?", message = "Incorrect Format: 5601-2345-3446-xxxx")
	private String cardNumber;

	@NotEmpty(message = "Bank Cant Be Blank")
	@Pattern(regexp = "\\b(\\w{3})-(\\d{4})", message = "Incorrect Format: Nov-2017")
	private String expirydate;

}
