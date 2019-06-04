package personal.study;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

public class ResetMock {

	@Test
	public void testPOC() {
		List mock = mock(List.class);
		when(mock.size()).thenReturn(10);
		mock.add(1);

		reset(mock);
	}
}
