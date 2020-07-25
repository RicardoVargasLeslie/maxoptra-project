package com.imricki.maxoptra.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.imricki.maxoptra.dto.BankDetailDto;
import com.imricki.maxoptra.model.BankDetail;
import com.imricki.maxoptra.utils.DataUtil;

/**
 * ListMapperUtil mapps the model domain object with the Dto Object.
 * 
 * @author Ricardo Vargas
 * @version 1.0
 */
public final class ListMapperUtil {

	private static final Logger LOGGER = Logger.getLogger(ListMapperUtil.class.getName());

	private ListMapperUtil() {

	}

	/**
	 * Map the model domain object with the Dto Object.
	 *
	 * @param listFromCsv the list from csv
	 * @return the the Dto list to send to the view
	 */
	public static List<BankDetailDto> map(List<BankDetail> listFromCsv) {

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
