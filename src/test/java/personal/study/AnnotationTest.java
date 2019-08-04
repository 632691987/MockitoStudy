package personal.study;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MockitoJUnitRunner.class use for allow @Mock, @Spy work
 * allow the annotation work
 *
 *
 * verify(__object__).xxx(parameters) method: test if called __object__.xxx(parameters) function
 *
 * when(__object__.xxx(parameters)).thenReturn() mock this method
 *
 *
 * Following is the same:
 * 1, Mockito.doReturn(100).when(spiedList).size();
 * 2, Mockito.when(spiedList.size()).thenReturn(100);
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {

    @Mock
    private List<String> mockedList;

    /**
     * Spy means, it will call real method until a method be stubbed
     */
    @Spy
    private List<String> spiedList = new ArrayList<>();

    @Captor
    private ArgumentCaptor<String> argCaptor;

    /**
     * It could use this init method instead of use @RunWith(MockitoJUnitRunner.class)
     */
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void whenNotUseMockAnnotation_tagA() {
        final List<String> mockedList = Mockito.mock(List.class);
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    @Test
    public void whenUseMockAnnotation_tagA() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    @Test
    public void whenNotUseSpyAnnotation_tagB() {
        final List<String> spiedList = Mockito.spy(new ArrayList<>());
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");

        assertEquals(2, spiedList.size());

        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }

    @Test
    public void whenUseSpyAnnotation_tagB() {
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");

        assertEquals(2, spiedList.size());

        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }

    @Test
    public void whenNotUseCaptorAnnotation_tagC() {
        final List<String> mockedList = Mockito.mock(List.class);
        final ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
        mockedList.add("one");
        Mockito.verify(mockedList).add(argCaptor.capture());

        assertEquals("one", argCaptor.getValue());
    }

    @Test
    public void whenUseCaptorAnnotation_tagC() {
        mockedList.add("one");
        Mockito.verify(mockedList).add(argCaptor.capture());

        assertEquals("one", argCaptor.getValue());
    }

}
