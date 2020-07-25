package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.utils.DataUtils;

@Service
public class ProcesData implements BankService {

	@Override
	public List<BankDetail> sortByExpiringDate(File csvFile) throws IOException {

		System.err.println("Innnnnnnnnnnnn");
		List<BankDetail> list = DataUtils.csvToDetailsWithHeaders(csvFile);

		list.sort(Comparator.comparing(BankDetail::getExpirydate, Comparator.reverseOrder()));

		list.forEach(System.out::print);
		return list;
	}

}
