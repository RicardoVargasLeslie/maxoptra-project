package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.utils.DataUtils;

@Service
public class ProcesData implements BankService {

	@Override
	public List<BankDetailDto> Operate(File csvFile) throws IOException {

		List<BankDetail> listFromCsv = DataUtils.csvToDetailsWithHeaders(csvFile);
		listFromCsv.sort(Comparator.comparing(BankDetail::getExpirydate, Comparator.reverseOrder()));

		return DataUtils.mapLists(listFromCsv);

	}

}
