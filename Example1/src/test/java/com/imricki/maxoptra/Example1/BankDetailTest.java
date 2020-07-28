package com.imricki.maxoptra.Example1;



import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.imricki.maxoptra.dto.BankDetailDto;


import com.imricki.maxoptra.service.ProcesData;

@RunWith(MockitoJUnitRunner.class)
 class BankDetailTest {

	@InjectMocks
	private ProcesData service;

	@Mock
	private BankDetailDto dtoMock;

	@Mock
	private ArrayList<BankDetailDto> listMock;

	@BeforeEach
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	void shouldAddAnewDetail() {
		
		// Given ----------------------------//
		when(dtoMock.getBank()).thenReturn("HSBC Canada");
		when(dtoMock.getCardNumber()).thenReturn("5601-2345-3446-5678");
		when(dtoMock.getExpirydate()).thenReturn("Nov-2017");
		
		// When ----------------------------//
		service.addDetails(dtoMock);
	
		// Then ----------------------------//
		InOrder inOrder = Mockito.inOrder(dtoMock, listMock);
		inOrder.verify(listMock).add(dtoMock);
		inOrder.verifyNoMoreInteractions();

	}

//		
//		when(dto.getBank()).thenReturn("HSBC Canada");
//		when(dto.getCardNumber()).thenReturn("5601-2345-3446-5678");
//		when(dto.getExpirydate()).thenReturn("Nov-2017");
////		
//		service.addDetails(dto);
//		list.add(dto);
//		
//		InOrder inOrder = Mockito.inOrder(mock, list);
//		inOrder.verify(list).add(mock);
//		inOrder.verifyNoMoreInteractions();

	// }

//	@Test
//	void shouldDoNothinBadDetails() {
//		
//		//Given
//		
//		BankDetailDto badDetail=null;
//		// -------------------------------------//
//		 
//		when(dto).then(null);
//		
//		// When ----------------------------------//
//		service.addDetails(dto);
//		
//		// Then -----------------------------------//
//		InOrder InOrder = Mockito.inOrder(dto);
//		InOrder.verify(dto).getBank().equals(null);
//		
//		InOrder.verifyNoMoreInteractions();
////		// ---------------------------------//
//	}
}
