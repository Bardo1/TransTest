package cl.transTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.transTest.domain.Role;
/**
 * RoleRepository - Clase conexión con la gestiones de persistencia de roles de usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
}
