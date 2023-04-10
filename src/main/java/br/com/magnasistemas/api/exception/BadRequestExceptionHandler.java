package br.com.magnasistemas.api.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadRequestExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadRequestExceptionHandler() {
		super();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DadosErrosValidacao>> tratarErro404(MethodArgumentNotValidException ex) {
		return ResponseEntity.notFound().build();
	}

	private record DadosErrosValidacao(String campo, String mensagem) {

	}

}
