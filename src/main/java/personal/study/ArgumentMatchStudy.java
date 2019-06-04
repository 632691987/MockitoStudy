package personal.study;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArgumentMatchStudy {

	@Test
	public void testArgumentMatch() {
		//You can mock concrete classes, not just interfaces
		LinkedList mockedList = mock(LinkedList.class);

		//stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");

		//following prints "element"
		assertThat(mockedList.get(999), equalTo("element"));

		//you can also verify using an argument matcher
		verify(mockedList).get(anyInt());
		verify(mockedList).get(eq(999));
	}

}
