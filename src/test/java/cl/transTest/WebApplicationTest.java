package cl.transTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
/**
 * User - Clase objeto de Usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WebApplication.class)
@SpringBootConfiguration
public class WebApplicationTest {

    @Test
    public void contextLoads() {
    }
    
}