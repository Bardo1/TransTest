

package cl.transTest;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


import cl.transTest.domain.Receiver;

/**
 * User - Clase objeto de Usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
public class MessagingRabbitmqTest {
	
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Receiver receiver;

	@Test
	public void test() throws Exception {
		try {
			rabbitTemplate.convertAndSend("spring-boot","Hello from RabbitMQ!");
			receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		}
		catch (AmqpConnectException e) {
			// ignore - rabbit is not running
		}
	}

}
