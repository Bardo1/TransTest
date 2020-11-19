package cl.transTest.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* ServiceException - Clase servicio para excepciones
*
* @author Walter Munoz
* @since 1.0
* @version 1.0 version inicial
*/
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 4442125330868704757L;
	
	private String code;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	/**
	 * @param code
	 * @param message
	*/
	public ServiceException(String code, String message) {
		super(message);
		this.code = code;
		this.timestamp = LocalDateTime.now();
	}
	
	public String getCode() {
		return code;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
}