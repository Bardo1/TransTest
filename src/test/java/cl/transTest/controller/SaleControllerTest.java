package cl.transTest.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cl.transTest.domain.Sale;
import cl.transTest.presentation.SaleController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * User - Clase objeto de Usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
@ExtendWith(MockitoExtension.class)
class SaleControllerTest {

    private static Sale p1;
    private static Sale p2;
    private static Sale p3;

    @Mock
    private SaleController saleController;


    @BeforeAll
    public static void init() {
     
        p1 = new Sale(1,"",1,111,new Date());
        p2 = new Sale(2,"",22,222,new Date());
        p3 = new Sale(3,"",33,333,new Date());

    }

   
    @Test
    void findAll_whenNoRecord(){
    	List<Sale> list= new ArrayList<Sale>();	  
    	ResponseEntity<List<Sale>> re= new ResponseEntity<>(list, HttpStatus.OK);	
        Mockito.when(saleController.listSale()).thenReturn(re);
        assertThat(saleController.listSale().getBody().size(), is(0));
        Mockito.verify(saleController, Mockito.times(1)).listSale();
    }

    @Test
    void findAll_whenRecord() {
       
    	List<Sale> list= new ArrayList<Sale>();	  
    	list.add(p1);
    	list.add(p2);
    	list.add(p3);
    	
    	ResponseEntity<List<Sale>> re= new ResponseEntity<>(list, HttpStatus.OK);	
        Mockito.when(saleController.listSale()).thenReturn(re);  
        assertThat(saleController.listSale().getBody().size(), is(3));
        Mockito.verify(saleController, Mockito.times(1)).listSale();
    }

    @Test
    void create() {    	
    	Mockito.when(saleController.insertStock(p1)).thenReturn(new ResponseEntity<>("", HttpStatus.OK));
        ResponseEntity<String> p = saleController.insertStock(p1);
        assertThat(p.getStatusCode(), is(HttpStatus.OK));
    }
    
   
}
 