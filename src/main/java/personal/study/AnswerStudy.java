package personal.study;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerStudy {

	@Test
	public void testStubbingWithCallbacks() {
		// A. Single mock whose methods must be invoked in a particular order
		Map<String, String> maps = mock(Map.class);
		String returnValue = "a value";

		/**
		 when(maps.get(anyString())).thenAnswer(
		 new Answer() {
		 public Object answer(InvocationOnMock invocation) {
		 Object[] args = invocation.getArguments();// arguments
		 Object mock = invocation.getMock();       // class org.mockito.codegen.Map$MockitoMock$1157789223
		 return returnValue;
		 }
		 });
		 */
		when(maps.get(anyString())).thenAnswer(invocation -> returnValue); // Lambda
		assertThat(maps.get("foo"), equalTo(returnValue));
	}


}
