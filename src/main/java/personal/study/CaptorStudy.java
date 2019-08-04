package personal.study;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CaptorStudy {

	@Captor
	private ArgumentCaptor<List<String>> captor;

	@Test
	public void testArgumentCaptor() {
		List<String> asList = Arrays.asList("someElement_test", "someElement");
		final List<String> mockedList = mock(List.class);
		mockedList.addAll(asList);

		verify(mockedList).addAll(captor.capture()); // When verify,you can capture the arguments of the calling method
		final List<String> capturedArgument = captor.getValue();
		assertThat(capturedArgument, hasItem("someElement"));
	}
}
