package cl.transTest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import cl.transTest.domain.Sale;
/**
 * User - Clase objeto de Usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
public interface SaleService {
	
	List<Sale> findAllByDate(Date date);
	
    List<Sale> findAll();
    
    Optional<Sale> findById(Integer i);
    
    Sale createOrUpdate(Sale sale);
    
}
