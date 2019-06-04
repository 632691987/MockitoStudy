package personal.study;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ThenStudy {

	@Test
	public void testPOC() {
		String inputString = "input string value";
		ThenStudyEntity entity = mock(ThenStudyEntity.class);

		entity.getResult(inputString);

		//Following is the same
		then(entity).should().getResult(eq(inputString));
		verify(entity).getResult(inputString);
		verifyNoMoreInteractions(entity);
	}

}
class ThenStudyEntity {
	public String getResult(String input) {
		return getInternalResult(input);
	}

	public String getInternalResult(String input) {
		return input + input;
	}
}