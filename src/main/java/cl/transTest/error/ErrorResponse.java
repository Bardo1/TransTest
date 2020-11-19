package cl.transTest.error;

import java.time.LocalDateTime;

/**
 * ErrorResponse - Clase que define el objeto error
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
public class ErrorResponse {

	private final int code;
	private final String message;


	public ErrorResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ErrorResponse(int code, String message, String error, LocalDateTime timestamp) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}


}