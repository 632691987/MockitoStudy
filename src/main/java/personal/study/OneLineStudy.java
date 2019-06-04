package personal.study;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class OneLineStudy {

	String returnValue = "A RETURN";

	@Test
	public void testPOC() {
		OneLineEntity entity = when(mock(OneLineEntity.class).getResult(anyString())).thenReturn(returnValue).getMock();
		assertThat(entity.getResult("input"), equalTo(returnValue));
	}

}

class OneLineEntity {
	public String getResult(String inputString) {
		return "Result : " + inputString;
	}
}