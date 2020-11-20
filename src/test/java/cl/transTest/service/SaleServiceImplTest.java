package cl.transTest.service;

import cl.transTest.domain.Sale;
import cl.transTest.repository.SaleRepository;
import cl.transTest.service.Impl.SaleServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaleServiceImplTest {

    private static Sale p1;
    private static Sale p2;

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private SaleServiceImpl saleServiceImpl;

    @BeforeAll
    public static void init() {
    	 p1 = new Sale(1,"",1,111,new Date());
         p2 = new Sale(2,"",22,222,new Date());
    }
    
    @Test
	public void exampleTest() {
    	assertThat(1,is(1));
	}
    
    @Test
    public void findAllTest_WhenNoRecord() {
       Mockito.when(saleRepository.findAll()).thenReturn(Arrays.asList());
       assertThat(saleServiceImpl.findAll().size(), is(0));
       Mockito.verify(saleRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void findAllTest_WhenRecord() {
        Mockito.when(saleRepository.findAll()).thenReturn(Arrays.asList(p1, p2));
        assertThat(saleServiceImpl.findAll().size(), is(2));
        assertThat(saleServiceImpl.findAll().get(0), is(p1));
        assertThat(saleServiceImpl.findAll().get(1),is(p2));
        Mockito.verify(saleRepository, Mockito.times(3)).findAll();
    }

    @Test
    public void findById() {
        Mockito.when(saleRepository.findById(1)).thenReturn(Optional.of(p2));
        assertThat(saleServiceImpl.findById(1), is(Optional.of(p2)));
        Mockito.verify(saleRepository, Mockito.times(1)).findById(1);
    }

    @Test
    void createOrUpdate() {
        Mockito.when(saleRepository.save(p1)).thenReturn(p1);
        assertThat(saleServiceImpl.createOrUpdate(p1), is(p1));
        Mockito.verify(saleRepository, Mockito.times(1)).save(p1);
 
        Mockito.when(saleRepository.save(p2)).thenReturn(p2);
        assertThat(saleServiceImpl.createOrUpdate(p2).getNumber(), is(2));
        Mockito.verify(saleRepository, Mockito.times(1)).save(p2);
    }
  
}