package com.imricki.maxoptra.service;

import org.springframework.stereotype.Service;

import com.imricki.maxoptra.utils.OfuscateUtil;

@Service
public class ProcesData implements BankService {

	@Override
	public void sortByExpiringDate() {

	}

	@Override
	public void ofuscateData(String cardNumber) {

		OfuscateUtil.ofuscateCardData(cardNumber);
	}

}
