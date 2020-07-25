package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.imricki.maxoptra.dto.BankDetailDto;

public interface BankService {

	List<BankDetailDto> ProcessList(File csvFile) throws IOException;

}
