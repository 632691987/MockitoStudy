package personal.study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Spy 的意思就是说，它真的会去调用哪个函数，除非用了 stubbing
 */
public class StudySpy {

	@Test
	public void testMethod1() {
		List<String> lists = new ArrayList<>();
		List<String> spyList2 = spy(lists);

		when(spyList2.size()).thenReturn(100);

		spyList2.add("a1");
		spyList2.add("a2");

		assertThat(spyList2.get(0), equalTo("a1"));
		assertThat(spyList2.get(1), equalTo("a2"));
		assertThat(spyList2.size(), equalTo(100));
		verify(spyList2, times(2)).add(anyString());
		verify(spyList2).size();
	}
}
