package personal.study;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StudyInjectMock {

	@Mock
	private List<String> stringList;

	@InjectMocks
	private StudyInjectMockEntity entity;

	@Test
	public void testPOC() {
		Assert.assertThat(entity.getStringList(), notNullValue());
	}


}

class StudyInjectMockEntity {
	private List<String> stringList;

	public StudyInjectMockEntity(List<String> stringList) {
		this.stringList = stringList;
	}

	public List<String> getStringList() {
		return stringList;
	}

	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}
}