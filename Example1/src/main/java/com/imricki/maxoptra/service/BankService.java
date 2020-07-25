package com.imricki.maxoptra.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.imricki.maxoptra.model.BankDetail;

public interface BankService {

	List<BankDetail> sortByExpiringDate(File csvFile) throws IOException;

}
