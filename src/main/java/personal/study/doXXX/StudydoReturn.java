package personal.study.doXXX;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StudydoReturn {

	@Mock
	private List<String> stringList;

	@Test
	public void conductPOC() {
		String resultValue = "AN RESULT VALUE";
		doReturn(resultValue).when(stringList).get(0);

		assertThat(stringList.get(0), equalTo(resultValue));
	}

}
