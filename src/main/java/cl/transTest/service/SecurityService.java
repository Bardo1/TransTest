package cl.transTest.service;
/**
 * SecurityService - Clase capa de interfaz para las gestiones de servicio de seguridad de usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
public interface SecurityService {
    
	String findLoggedInUsername();

    void autoLogin(String username, String password);
}
