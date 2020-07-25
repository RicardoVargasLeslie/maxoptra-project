package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.imricki.maxoptra.csvreader.ReaderUtil;
import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.mapper.ListMapperUtil;
import com.imricki.maxoptra.model.BankDetail;

@Service
public class ProcesData implements BankDetailService {

	private static final Logger LOGGER = Logger.getLogger(ProcesData.class.getName());

	@Override
	public List<BankDetailDto> ProcessList(File csvFile) throws IOException {

		LOGGER.info("Call() ----> ProcessList()");
		List<BankDetail> listFromCsv = ReaderUtil.csvToDetailsWithHeaders(csvFile);
		listFromCsv.sort(Comparator.comparing(BankDetail::getExpirydate, Comparator.reverseOrder()));

		return ListMapperUtil.mapLists(listFromCsv);

	}

}
