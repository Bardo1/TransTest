package cl.transTest.service;

import java.util.List;
import cl.transTest.domain.User;
/**
 * UserService - Clase capa de interfaz para las gestiones de servicio de usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
public interface UserService {
   
	void save(User user);
    
	User findByUsername(String username);
    
	List<User> findAll();
}
