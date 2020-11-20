

package cl.transTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import cl.transTest.domain.Receiver;

/**
 * MessagingRabbitmqTest - Clase MessagingRabbitmqTest
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
	    public void enviaMensaje() throws Exception {
		 
        		 try {
		        RabbitTemplate rt = Mockito.mock(RabbitTemplate.class);
		        rt.convertAndSend("spring-boot-exchange", "foo.bar.baz");
				}
				catch (AmqpConnectException e) {
				}
	    }

	//@Test
	public void test() throws Exception {
		try {
			
		//	rabbitTemplate.convertAndSend("spring-boot","Hello from RabbitMQ!");
			rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz");
			receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		}
		catch (AmqpConnectException e) {
			// ignore - rabbit is not running
		}
	}

	
	
}
