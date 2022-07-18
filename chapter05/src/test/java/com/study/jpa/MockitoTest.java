package com.study.jpa;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

	@SuppressWarnings("unchecked")
	@Test
	void listTest() throws Exception {
		List<String> mockedList = mock(List.class);

		mockedList.add("one");
		mockedList.clear();

		verify(mockedList).add("one");
		verify(mockedList).clear();
		// verify(mockedList).add("two"); // error
	}

	@SuppressWarnings("unchecked")
	@Test
	void stubTest() throws Exception {
		LinkedList<String> mockedList = mock(LinkedList.class);

		when(mockedList.get(0)).thenReturn("first");

		System.out.println(mockedList.get(0)); // first
		System.out.println(mockedList.get(999)); // null
	}
}
