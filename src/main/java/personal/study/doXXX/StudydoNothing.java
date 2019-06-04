package personal.study.doXXX;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)

public class StudydoNothing {

	@Spy
	private List<String> stringList = new ArrayList<>();

	@Test
	public void conductPOC() {
		doNothing().when(stringList).clear();
		stringList.add("A TESTING 1");
		stringList.add("A TESTING 2");
		stringList.clear();
		assertThat(stringList, Matchers.hasSize(2));
		assertThat(stringList, Matchers.not(Matchers.empty()));
	}

}
