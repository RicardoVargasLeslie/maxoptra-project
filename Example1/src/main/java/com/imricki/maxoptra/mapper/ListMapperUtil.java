package com.imricki.maxoptra.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.utils.DataUtil;

public final class ListMapperUtil {

	private static final Logger LOGGER = Logger.getLogger(ListMapperUtil.class.getName());

	private ListMapperUtil() {

	}

	public static List<BankDetailDto> mapLists(List<BankDetail> listFromCsv) {

		LOGGER.info("Call() ----> mapLists()");

		List<BankDetailDto> listToView = new ArrayList<>(listFromCsv.size());

		for (BankDetail bankDetail : listFromCsv) {

			listToView.add(
					new BankDetailDto(bankDetail.getBank(), DataUtil.ofuscateCardNumber(bankDetail.getCardNumber()),
							DataUtil.fromDateToString(bankDetail.getExpirydate())));
		}

		return listToView;
	}

}
