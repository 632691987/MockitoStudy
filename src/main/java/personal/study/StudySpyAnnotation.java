package personal.study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StudySpyAnnotation {


	@Spy
	HashMap<String, Integer> hashMap;

	@Test
	public void saveTest() {
		hashMap.put("A", 10);

		verify(hashMap, times(1)).put("A", 10);
		verify(hashMap, times(0)).get("A");

		assertEquals(1, hashMap.size());
		assertEquals(new Integer(10), (Integer) hashMap.get("A"));
	}

}
