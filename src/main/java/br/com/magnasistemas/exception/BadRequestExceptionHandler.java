package br.com.magnasistemas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadRequestExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadRequestExceptionHandler() {
		super();
		
	}

}
