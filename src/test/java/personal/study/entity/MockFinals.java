package personal.study.entity;

import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * original, mockito can not mock final class, but add following dependency would be ok
 *
 <dependency>
     <groupId>org.mockito</groupId>
     <artifactId>mockito-inline</artifactId>
     <version>${mockito.version}</version>
 </dependency>
 *
 */
public class MockFinals {

    @Test
    public void whenMockFinalClassMockWorks() {
        FinalList<String> finalList = new FinalList();
        FinalList mock = mock(FinalList.class);
        when(mock.size()).thenReturn(2);
        assertNotEquals(mock.size(), finalList.size());
    }

    @Test
    public void whenMockFinalMethodMockWorks() {
        MyList<String> myList = new MyList();
        MyList mock = mock(MyList.class);
        when(mock.finalMethod()).thenReturn(1);
        assertNotEquals(mock.finalMethod(), myList.finalMethod());
    }

}
