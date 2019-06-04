package personal.study;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StubbingStudy {
	/**
	 * How about some stubbing?
	 */
	@Test
	public void testStubbing() {
		//You can mock concrete classes, not just interfaces
		LinkedList mockedList = mock(LinkedList.class);

		//stubbing
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());

		assertThat(mockedList.get(0), equalTo("first"));
		assertThat(mockedList.get(999), nullValue());
		assertThrows(RuntimeException.class, () -> mockedList.get(1));

		verify(mockedList).get(0);
	}

}
