package cl.transTest.presentation;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.transTest.domain.Sale;
import cl.transTest.exception.ServiceException;
import cl.transTest.service.SaleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CountDownLatch;
/**
 * SaleController - Clase para la gestion de ingreso y depliegue de ventas
 * 
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
@RestController
@Slf4j
public class SaleController {
    
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
    // para dar tiempo a la respuesta
	private final CountDownLatch latch = new CountDownLatch(1);
	
	public SaleController() {
	}

    /**
	*
	* @param  Sale
	* @return ResponseEntity<String>
	* @throws ServiceException
	*/
	@ApiOperation(value = "Endpoint de llamada al método de inserción de una venta")
	@PostMapping("/v1/insertSale")
	public ResponseEntity<String> insertStock(@RequestBody Sale sale) throws ServiceException{
		
		log.info("Start service : {} ", sale);
		log.info("Inicia el método de ingreso de venta");
		
		// valida que vengan todos los datos
	  	if ( 0 == sale.getNumber() || null == sale.getQuantity() || null ==  sale.getValue()|| null == sale.getNumber()|| null == sale.getDescription()||null == sale.getDescription()|| null == sale.getDate()) {
			throw new ServiceException(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Deben enviarse todos los parámetros.");			
		}	
	  	// Ingresa la venta y valida que se una ejecución correcta
		Sale s= saleService.createOrUpdate(sale);
		if(s==null) {
			throw new ServiceException(String.valueOf(HttpStatus.BAD_REQUEST.value()),"Error al ingresar el stock");			
		}
		
		log.info("Finaliza el método del ingreso de una venta");
		return new ResponseEntity<>("Se ha ingresado la venta con exito", HttpStatus.OK);
	}
    
	/**
	*
	* @return ResponseEntity<List<Sale>>
	* @throws ServiceException
	*/            
    @ApiOperation(value = "Endpoint que lista todos las ventas almacenadas")
	@GetMapping("/v1/listSale")
	public ResponseEntity<List<Sale>> listSale() throws ServiceException{
		
		log.info("Inicia el método de despliegue de lista de ventas");	
	  	List<Sale> listSale= saleService.findAll();
	  	log.info("Finaliza el método de despliegue de lista de ventas");
		return new ResponseEntity<>(listSale, HttpStatus.OK);
	}
    
	@ApiOperation(value = "Endpoint para enviar a la cola de mensajes según la fecha del dia")
	@GetMapping("/v1/sendQueueByDayDate")
	public ResponseEntity<List<Sale>> sendByDay() throws Exception {
		
		log.info("Inicia el método GET sendByDay");
		//Obtención de la fecha del dia
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now(); 
		List<Sale> listSale=null;
		
		try {
			// Buscamos todos los registros según la fecha del dia
			listSale = saleService.findAllByDate(new SimpleDateFormat("yyyy-MM-dd").parse(dtf.format(now)));
			// Si no hay registros nos lanza la excepcion
		  	if (listSale.isEmpty()) {
				throw new ServiceException(String.valueOf(HttpStatus.BAD_REQUEST.value()),"No se han ingresado ventas en el dia de hoy");			
			}	
		  	// Envia la solicitud de ventas a al cola de mensajes
			this.enviar(listSale);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(listSale, HttpStatus.OK);	
    }
	
	public void enviar(List<Sale> listSale) throws Exception{
			//Codificamos la lista de ventas del dia en base64 para enviar un string a la cola
			String encodedMessage = Base64.getEncoder().encodeToString(listSale.toString().getBytes());
			rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", encodedMessage);
			this.getLatch().await(1000, TimeUnit.MILLISECONDS);
	}
	
	public CountDownLatch getLatch() {
		return latch;
	}
	 
}