package cl.transTest.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import cl.transTest.domain.Sale;
/**
 * User - Clase objeto de Usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
@ExtendWith(MockitoExtension.class)
public class SaleControllerTestIT {

    private static Sale p1;
    
    private static TestRestTemplate restTemplate;
    
    @Bean
    public TestRestTemplate restTemplate() {
        return new TestRestTemplate();
    }

	@BeforeAll
    public static void init() {		
   	      p1 = new Sale(112,"Venta de producto x", 111,1,new Date()); 
         restTemplate =new TestRestTemplate();
	}
    
    @Test
    public void firsTest() {
        assertThat(1, is(1));
    }

    @Test
    public void findAddTestIT() throws URISyntaxException 
    {
        final String baseUrl = "http://localhost:8081/v1/insertSale";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("12345678", "12345678");
        HttpEntity<Sale> request = new HttpEntity<>(p1, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        assertThat(result.getStatusCode(), is(HttpStatus.OK));
    }
   
}
