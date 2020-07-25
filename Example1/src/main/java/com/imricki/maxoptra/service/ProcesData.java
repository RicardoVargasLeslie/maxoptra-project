package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.utils.DataUtils;

@Service
public class ProcesData implements BankService {

	@Override
	public List<BankDetailDto> Operate(File csvFile) throws IOException {

		List<BankDetail> listFromCsv = DataUtils.csvToDetailsWithHeaders(csvFile);
		List<BankDetailDto> listDto = new ArrayList<BankDetailDto>();

//		list.forEach(System.out::print);
//
//		String formattedDate = "";
//		String output = "";
//		formattedDate = list.get(i).getExpirydate().format(DateTimeFormatter.ofPattern("MMM-yyy"));
//		output = formattedDate.substring(0, 1).toUpperCase() + formattedDate.substring(1).replace(".", "");

		return backtoView(sortByExpiringDate(listFromCsv));

	}

	private List<BankDetail> sortByExpiringDate(List<BankDetail> listFromCsv) {

		listFromCsv.sort(Comparator.comparing(BankDetail::getExpirydate, Comparator.reverseOrder()));

		System.err.println("In order method");
		return listFromCsv;

	}

	private List<BankDetailDto> backtoView(List<BankDetail> listFromCsv) {
		List<BankDetailDto> dto;
		System.err.println("backtoView------->");
		listFromCsv.forEach(System.out::print);

		for (int i = 0; i < listFromCsv.size(); i++) {

		}

		return null;

	}

	private String fromDateToString(LocalDate date) {

//		LocalDate.parse("2017-11-01");

		String formattedDate = date.format(DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH)).toUpperCase();

		return formattedDate;
	}
}
