package personal.study.doXXX;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)

public class StudydoThrow {

	@Mock
	private List<String> stringList;

	@Test
	public void conductPOC() {
		doThrow(new RuntimeException()).when(stringList).get(0);
		assertThrows(RuntimeException.class, () -> stringList.get(0));
	}

}
