package personal.study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ArgThatStudy {

	@Mock
	private List<String> stringList;

	@Test
	public void testArgThatWithLambda() {
		String inputString = "THIS IS AN INPUT VALUE";
		stringList.add(inputString);

		//str 就是仔细判断的那个入参
		verify(stringList).add(argThat(str -> str.length() == inputString.length()));
	}

	@Test
	public void testArgThatWithWhen() {
		when(stringList.add(argThat(arg-> arg.length() < 5))).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, () -> stringList.add("1234"));
	}

}