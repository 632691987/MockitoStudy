package personal.study;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class OrderStudy {

	@Test
	public void testVerifyInOrder() {
		// A. Single mock whose methods must be invoked in a particular order
		List singleMock = mock(List.class);

		//using a single mock
		singleMock.add("was added first");
		singleMock.add("was added second");

		//create an inOrder verifier for a single mock
		InOrder inOrder1 = inOrder(singleMock);

		//following will make sure that add is first called with "was added first", then with "was added second"
		inOrder1.verify(singleMock).add("was added first");
		inOrder1.verify(singleMock).add("was added second");

		// B. Multiple mocks that must be used in a particular order
		List firstMock = mock(List.class);
		List secondMock = mock(List.class);

		//using mocks
		firstMock.add("was called first");
		secondMock.add("was called second");

		//create inOrder object passing any mocks that need to be verified in order
		InOrder inOrder2 = inOrder(firstMock, secondMock);

		//following will make sure that firstMock was called before secondMock
		inOrder2.verify(firstMock).add("was called first");
		inOrder2.verify(secondMock).add("was called second");

		// Oh, and A + B can be mixed together at will
	}

	/**
	 * Stubbing consecutive calls
	 */
	@Test
	public void testConsecutiveCalls() {
		// A. Single mock whose methods must be invoked in a particular order
		List singleMock = mock(List.class);

		when(singleMock.get(1)).thenThrow(new RuntimeException()).thenReturn("A VALUE");

		assertThrows(RuntimeException.class, () -> singleMock.get(1));
		assertThat(singleMock.get(1), equalTo("A VALUE"));
		assertThat(singleMock.get(1), equalTo("A VALUE"));
		assertThat(singleMock.get(1), equalTo("A VALUE"));
		assertThat(singleMock.get(1), equalTo("A VALUE"));
	}

}
