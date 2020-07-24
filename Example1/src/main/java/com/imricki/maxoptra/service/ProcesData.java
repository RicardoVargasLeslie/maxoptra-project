package com.imricki.maxoptra.service;

import org.springframework.stereotype.Service;

import com.imricki.maxoptra.utils.DataUtils;

@Service
public class ProcesData implements BankService {

	@Override
	public void sortByExpiringDate() {

	}

	@Override
	public void ofuscateData(String cardNumber) {

		DataUtils.ofuscateCardNumber(cardNumber);
	}

}
