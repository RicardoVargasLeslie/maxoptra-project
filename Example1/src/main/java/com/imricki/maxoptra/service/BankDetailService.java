package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.imricki.maxoptra.dto.BankDetailDto;

/**
 * BankDetailService is a interface with the methods to procces data.
 *
 * @author Ricardo Vargas
 * @version 1.0
 */
public interface BankDetailService {

	/**
	 * Process list.
	 *
	 * @param csvFile the csv file
	 * @return the list with all data to the view
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	List<BankDetailDto> processCsv(File csvFile) throws IOException;

	BankDetailDto addDetails(BankDetailDto newDetail);

	List<BankDetailDto> getAll();

}
