package cl.transTest.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.transTest.domain.Sale;
import cl.transTest.repository.SaleRepository;
import cl.transTest.service.SaleService;
/**
 * SaleServiceImpl - Clase implementación del servicio de venta
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleRepository saleRepository;

	@Override
	public List<Sale> findAll() {
        return saleRepository.findAll();
	}

	@Override
	public Optional<Sale> findById(Integer i) {
        return saleRepository.findById(i);
	}

	@Override
	public Sale createOrUpdate(Sale sale) {
        return saleRepository.save(sale);
	}

	@Override
	public List<Sale> findAllByDate(Date date) {
	   return saleRepository.findAllByDate(date);
	}

}
