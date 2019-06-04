package personal.study;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class POCStudy {

	@Test
	public void testPOC() {

		List<String> mockedList = mock(List.class);

		mockedList.add("avc");
		mockedList.clear();


		//Following is the same
		then(mockedList).should().add(eq("avc"));
		verify(mockedList).add("avc");



		verify(mockedList).clear();
		verifyNoMoreInteractions(mockedList);


	}

}
