package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.imricki.maxoptra.csvreader.ReaderUtil;
import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.mapper.ListMapperUtil;
import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.utils.DataUtil;

/**
 * ProcesData is the implementation of BankDetailService interface.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 */
@Service
public class ProcesData implements BankDetailService {

	private static final Logger LOGGER = Logger.getLogger(ProcesData.class.getName());

	private List<BankDetailDto> detailsList = new ArrayList<>();

	/**
	 * Process list.
	 *
	 * @param csvFile the csv file
	 * @return the list of Dto to return to the view
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public List<BankDetailDto> ProcessCsv(File csvFile) throws IOException {

		LOGGER.info("Call() ----> ProcessList()");
		List<BankDetail> listFromCsv = ReaderUtil.csvToDetailsWithHeaders(csvFile);
		listFromCsv.sort(Comparator.comparing(BankDetail::getExpirydate, Comparator.reverseOrder()));

		return ListMapperUtil.map(listFromCsv);

	}

	/**
	 * Adds a new object to the list
	 *
	 * @param newDetail the new detail
	 */
	@Override
	public BankDetailDto addDetails(BankDetailDto newDetail) {

		newDetail.setCardNumber(DataUtil.ofuscateCardNumber(newDetail.getCardNumber()));

		detailsList.add(newDetail);
		return newDetail;

	}

	/**
	 * Gets the all the dtos
	 *
	 * @return the all
	 */
	@Override
	public List<BankDetailDto> getAll() {

		detailsList.sort(Comparator.comparing(BankDetailDto::getExpirydate, Comparator.reverseOrder()));

		return detailsList;
	}

}
