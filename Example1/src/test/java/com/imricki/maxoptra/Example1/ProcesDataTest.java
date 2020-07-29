package com.imricki.maxoptra.Example1;

import static org.mockito.Mockito.when;

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
import com.imricki.maxoptra.service.ProcesData;

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
		Assert.assertEquals(service.getAll(), listMock);

	}
}
