package cl.transTest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.transTest.domain.Sale;

/**
 * SaleRepository - Clase conexión con la gestiones de persistencia de ventas
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
	
    List<Sale> findAllByDate(Date date);

}
