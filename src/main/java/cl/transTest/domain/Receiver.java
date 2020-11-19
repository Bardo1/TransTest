package cl.transTest.domain;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

/**
 * Receiver - Clase Receptor, a la escucha de la cola MQ
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {	
		final Base64.Decoder decoder = Base64.getDecoder();
        try {
        	//Decodifica el codigo base 64 recibido
			System.out.println("Recibe Mensaje decodificado <" + new String(decoder.decode(message), "UTF-8") + ">");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		latch.countDown();
	}
	
	public CountDownLatch getLatch() {
		return latch;
	}

}
