package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.utils.DataUtils;
import com.imricki.maxoptra.utils.ObjectMapperUtils;

@Service
public class ProcesData implements BankService {

	@Override
	public List<BankDetailDto> sortByExpiringDate(File csvFile) throws IOException {

		List<BankDetail> list = DataUtils.csvToDetailsWithHeaders(csvFile);

		list.sort(Comparator.comparing(BankDetail::getExpirydate, Comparator.reverseOrder()));

//		list.forEach(System.out::print);

		return ObjectMapperUtils.mapAll(list, BankDetailDto.class);
	}

}
