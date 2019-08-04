package bddmockito;

import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willThrow;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.invocation.InvocationOnMock;


public class BDDMockitoIntegrationTest {
    
    PhoneBookService phoneBookService;
    PhoneBookRepository phoneBookRepository;
    
    String momContactName = "Mom";
    String momPhoneNumber = "01234";
    String xContactName = "x";
    String tooLongPhoneNumber = "01111111111111";
    
    @Before
    public void init() {
        phoneBookRepository = Mockito.mock(PhoneBookRepository.class);
        phoneBookService = new PhoneBookService(phoneBookRepository);
    }
    
    @Test
    public void givenValidContactName_whenSearchInPhoneBook_thenReturnPhoneNumber() {
        given(phoneBookRepository.contains(momContactName)).willReturn(true);
        given(phoneBookRepository.getPhoneNumberByContactName(momContactName))
          .will((InvocationOnMock invocation) -> {
            if(invocation.getArgument(0).equals(momContactName)) {
                return momPhoneNumber;
            } else {
                return null;
            }
        });
        
        String phoneNumber = phoneBookService.search(momContactName);
        
        then(phoneBookRepository).should().contains(ArgumentMatchers.eq(momContactName));
        then(phoneBookRepository).should().getPhoneNumberByContactName(ArgumentMatchers.eq(momContactName));
        Assert.assertEquals(phoneNumber, momPhoneNumber);
    }
    
    @Test
    public void givenInvalidContactName_whenSearch_thenRetunNull() {
        given(phoneBookRepository.contains(xContactName)).willReturn(false);
        
        String phoneNumber = phoneBookService.search(xContactName);
        
        then(phoneBookRepository).should(times(1)).contains(ArgumentMatchers.eq(xContactName));
        then(phoneBookRepository).should(never()).getPhoneNumberByContactName(xContactName);
        Assert.assertEquals(phoneNumber, null);
    }
    
    @Test
    public void givenValidContactNameAndPhoneNumber_whenRegister_thenSucceed() {
        given(phoneBookRepository.contains(momContactName)).willReturn(false);
        
        phoneBookService.register(momContactName, momPhoneNumber);
        
        verify(phoneBookRepository).insert(momContactName, momPhoneNumber);
    }
    
    @Test
    public void givenEmptyPhoneNumber_whenRegister_thenFail() {
        given(phoneBookRepository.contains(momContactName)).willReturn(false);
        
        phoneBookService.register(xContactName, "");
        
        then(phoneBookRepository).should(never()).insert(momContactName, momPhoneNumber);
    }
    
    @Test
    public void givenLongPhoneNumber_whenRegister_thenFail() {
        given(phoneBookRepository.contains(xContactName)).willReturn(false);
        willThrow(new RuntimeException())
          .given(phoneBookRepository).insert(any(String.class), eq(tooLongPhoneNumber));
        
        try {
            phoneBookService.register(xContactName, tooLongPhoneNumber);
            fail("Should throw exception");
        } catch (RuntimeException ex) { }
        
        then(phoneBookRepository).should(never()).insert(momContactName, tooLongPhoneNumber);
    }
    
    @Test
    public void givenExistentContactName_whenRegister_thenFail() {
        given(phoneBookRepository.contains(momContactName))
          .willThrow(new RuntimeException("Name already exist"));
        
        try {
            phoneBookService.register(momContactName, momPhoneNumber);
            fail("Should throw exception");
        } catch(Exception ex) { }
        
        then(phoneBookRepository).should(never()).insert(momContactName, momPhoneNumber);
    }

}
