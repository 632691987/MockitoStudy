package personal.study;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class DescriptionStudy {

	@Test
	public void testPOC() {
		LinkedList mockedList = mock(LinkedList.class);

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		//verification using never(). never() is an alias to times(0)
		verify(mockedList, never().description("LinkedList should not have 'never happened' parameter")).add("never happened");

		//verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce().description("At least call once")).add("three times");
		verify(mockedList, atLeast(2).description("should at least call 2 times")).add("three times");
		verify(mockedList, atMost(5).description("should at most call 5 times")).add("three times");
	}

}
