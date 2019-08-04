package personal.study;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

public class CallRealMethod {

	@Test
	public void testCallRealMethod() {
		List<String> lists = mock(List.class);
		when(lists.size()).thenCallRealMethod();
	}

}
