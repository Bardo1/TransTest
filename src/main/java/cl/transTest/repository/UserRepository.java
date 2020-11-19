package cl.transTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.transTest.domain.User;
/**
 * UserRepository - Clase conexión con la gestiones de persistencia de usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
