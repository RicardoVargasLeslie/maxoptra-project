package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.utils.DataUtils;

@Service
public class ProcesData implements BankService {

	@Override
	public List<BankDetail> sortByExpiringDate(File csvFile) throws IOException {

		List<BankDetail> list = DataUtils.csvToDetailsWithHeaders(csvFile);

		List<LocalDate> dates = new ArrayList<LocalDate>();

		Collections.sort(dates, Collections.reverseOrder());

		return null;
	}

}
