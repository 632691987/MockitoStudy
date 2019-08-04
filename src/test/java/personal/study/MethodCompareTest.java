package personal.study;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import personal.study.entity.MyList;

public class MethodCompareTest {

    @Test
    public final void tagA_thenReturn() {
        final MyList<String> listMock = Mockito.mock(MyList.class);
        when(listMock.add(ArgumentMatchers.anyString())).thenReturn(false);

        final boolean added = listMock.add(randomAlphabetic(6));
        assertThat(added, is(false));
    }

    @Test
    public final void tagA_doReturn() {
        final MyList<String> listMock = Mockito.mock(MyList.class);
        doReturn(false).when(listMock).add(ArgumentMatchers.anyString());

        final boolean added = listMock.add(randomAlphabetic(6));
        assertThat(added, is(false));
    }

    @Test
    public final void tagA_doAnswer() {
        String resultValue = "a_result_value";

        final MyList<String> listMock = Mockito.mock(MyList.class);
        doAnswer(invocation -> resultValue).when(listMock).get(ArgumentMatchers.anyInt());

        final String element = listMock.get(1);
        assertThat(element, is(equalTo(resultValue)));
    }

    @Test(expected = IllegalStateException.class)
    public final void tagB_thenThrow() {
        final MyList<String> listMock = Mockito.mock(MyList.class);
        when(listMock.add(ArgumentMatchers.anyString())).thenThrow(IllegalStateException.class);

        listMock.add(randomAlphabetic(6));
    }

    @Test(expected = IllegalStateException.class)
    public final void tagB_doThrow() {
        final MyList<String> listMock = Mockito.mock(MyList.class);
        doThrow(IllegalStateException.class).when(listMock).clear();

        listMock.clear();
    }

    @Test(expected = IllegalStateException.class)
    public final void tagB_combine() {
        final MyList<String> listMock = Mockito.mock(MyList.class);
        when(listMock.add(ArgumentMatchers.anyString())).thenReturn(false).thenThrow(IllegalStateException.class);

        listMock.add(randomAlphabetic(6));
        listMock.add(randomAlphabetic(6));
    }

    @Test
    public final void tagC_thenCallRealMethod() {
        final MyList<String> listMock = Mockito.mock(MyList.class);
        when(listMock.size()).thenCallRealMethod();

        assertThat(listMock.size(), equalTo(1));
    }
}