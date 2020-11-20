package cl.transTest.service;

import cl.transTest.domain.Sale;
import cl.transTest.domain.User;
import cl.transTest.repository.SaleRepository;
import cl.transTest.repository.UserRepository;
import cl.transTest.service.Impl.SaleServiceImpl;
import cl.transTest.service.Impl.UserServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private static User p1;
    private static User p2;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @BeforeAll
    public static void init() {
 
         p1 = new User(1L,"","","");
         p2 = new User(2L,"walter","","");
      
    }
    
    @Test
	public void exampleTest() {
    	assertThat(1,is(1));
	}
    
    @Test
    public void findAllTest_WhenNoRecord() {
       Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList());
       assertThat(userServiceImpl.findAll().size(), is(0));
       Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void findAllTest_WhenRecord() {
        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(p1, p2));
        assertThat(userServiceImpl.findAll().size(), is(2));
        assertThat(userServiceImpl.findAll().get(0), is(p1));
        assertThat(userServiceImpl.findAll().get(1),is(p2));
        Mockito.verify(userRepository, Mockito.times(3)).findAll();
    }

    @Test
    public void findByUsername() {
        Mockito.when(userRepository.findByUsername("walter")).thenReturn(p2);
        assertThat(userServiceImpl.findByUsername("walter"), is(p2));
        Mockito.verify(userRepository, Mockito.times(1)).findByUsername("walter");
    }

    @Test
    void save() {
        Mockito.when(userRepository.save(p1)).thenReturn(p1);
        assertThat(userRepository.save(p1), is(p1));
        Mockito.verify(userRepository, Mockito.times(1)).save(p1);
 
        Mockito.when(userRepository.save(p2)).thenReturn(p2);
        assertThat(userRepository.save(p2).getUsername(), is("walter"));
        Mockito.verify(userRepository, Mockito.times(1)).save(p2);
    }
    
  
}