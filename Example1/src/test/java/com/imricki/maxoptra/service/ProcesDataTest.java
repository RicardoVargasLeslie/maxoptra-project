package com.imricki.maxoptra.service;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.imricki.maxoptra.dto.BankDetailDto;

@RunWith(MockitoJUnitRunner.class)
class ProcesDataTest {

	@InjectMocks
	private ProcesData service;

	@Mock
	private BankDetailDto dtoMock;

	@Mock
	private List<BankDetailDto> listMock;

	@BeforeEach
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	void shouldAddAnewDetail() {

		// Given ----------------------------//

		final String bankInput = "HSBC Canada";
		final String cardNumberInput = "5601-2345-3446-5678";
		final String expirydateInput = "Nov-2017";

		// ---------------------------------//
		when(dtoMock.getBank()).thenReturn(bankInput);
		when(dtoMock.getCardNumber()).thenReturn(cardNumberInput);
		when(dtoMock.getExpirydate()).thenReturn(expirydateInput);

		// When ----------------------------//
		service.addDetails(dtoMock);

		// Then ----------------------------//
		InOrder inOrder = Mockito.inOrder(dtoMock, listMock);
		inOrder.verify(listMock).add(dtoMock);
		inOrder.verifyNoMoreInteractions();

	}

	@Test
	void shouldGetAllDetails() {

		// Given ----------------------------//

		final BankDetailDto dt1 = new BankDetailDto("HSBC", "5555666", "Nov-2018");
		final BankDetailDto dt2 = new BankDetailDto("HSBC", "4343444", "Nov-2017");

		listMock.add(dt1);
		listMock.add(dt2);

		// When ----------------------------//
		Assert.assertEquals(service.getAllBankDetails(), listMock);

	}

	@Test
	void shouldMapCsvToBean() throws IOException {

		// Given ----------------------------//
		final List<BankDetailDto> beanList = new ArrayList<>();

		final BankDetailDto dt1 = new BankDetailDto("HSBC Canada", "xxxx-xxxx-xxxx-5678", "Nov-2017");
		final BankDetailDto dt2 = new BankDetailDto("Royal Bank of Canada", "xxxx-xxxx-xxxx-2456", "Oct-2017");
		final BankDetailDto dt3 = new BankDetailDto("American Express", "3786-7334-8965-345", "Dec-2018");
		beanList.add(dt3);
		beanList.add(dt1);
		beanList.add(dt2);
		final File csvFile = new File("test.csv");

		// When ----------------------------//
		Assert.assertEquals(service.processCsv(csvFile), beanList);

	}

}
