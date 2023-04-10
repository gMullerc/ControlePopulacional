package br.com.magnasistemas.api.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundExceptionHandler(String mensagem) {
		super(mensagem);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DadosErrosValidacao>> tratarErro400(MethodArgumentNotValidException ex) {
		List<FieldError> erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacao::new).toList());
	}

	private record DadosErrosValidacao(String campo, String mensagem) {

		public DadosErrosValidacao(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}

	}
}
