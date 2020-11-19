package cl.transTest.service;
/*
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
import org.springframework.boot.test.context.SpringBootTest;

import cl.transTest.domain.ArticleRequest;
import cl.transTest.repository.ArticleRequestRepository;
import cl.transTest.service.ArticleRequestService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class SaleServiceTest {

    private static ArticleRequest p1;
    private static ArticleRequest p2;

    @Mock
    private ArticleRequestRepository articleRequestRepository;

    @InjectMocks
    private ArticleRequestService articleRequestService;

    @BeforeAll
    public static void init() {
        p1 = new ArticleRequest(1,1, 11, 111,new Date());
        p2 = new ArticleRequest(2,2, 22, 222,new Date());
    }
    
    @Test
	public void firstTest() {
    	assertThat(1,is(1));
	}

    @Test
    public void findAllTest_WhenNoRecord() {
       Mockito.when(articleRequestRepository.findAll()).thenReturn(Arrays.asList());
       assertThat(articleRequestService.findAll().size(), is(0));
       Mockito.verify(articleRequestRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void findAllTest_WhenRecord() {
        Mockito.when(articleRequestRepository.findAll()).thenReturn(Arrays.asList(p1, p2));
        assertThat(articleRequestService.findAll().size(), is(2));
        assertThat(articleRequestService.findAll().get(0), is(p1));
        assertThat(articleRequestService.findAll().get(1),is(p2));
        Mockito.verify(articleRequestRepository, Mockito.times(3)).findAll();
    }

    @Test
    public void findById() {
        Mockito.when(articleRequestRepository.findById(1)).thenReturn(Optional.of(p2));
        assertThat(articleRequestService.findById(1), is(Optional.of(p2)));
        Mockito.verify(articleRequestRepository, Mockito.times(1)).findById(1);
    }


    @Test
    void createOrUpdate() {

        Mockito.when(articleRequestRepository.save(p1)).thenReturn(p1);
        assertThat(articleRequestService.createOrUpdate(p1), is(p1));
        Mockito.verify(articleRequestRepository, Mockito.times(1)).save(p1);
        
        Mockito.when(articleRequestRepository.save(p2)).thenReturn(p2);
        assertThat(articleRequestService.createOrUpdate(p2).getCantidad(), is(22));
        Mockito.verify(articleRequestRepository, Mockito.times(1)).save(p2);
    }

    @Test
    void deleteById() {
        articleRequestService.deleteById(1);
        Mockito.verify(articleRequestRepository, Mockito.times(1)).deleteById(1);
    }
}*/