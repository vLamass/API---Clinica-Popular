package org.serratec.individual.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<String> erros = new ArrayList<>();
		for (FieldError error: ex.getBindingResult().getFieldErrors()) {
			erros.add(error.getField() + ": " + error.getDefaultMessage());
		}
		
		ErroResposta erroResposta = new ErroResposta(status.value(),
				"Existem Campos Inválidos, confira o preenchimento", LocalDateTime.now(), erros);
		
		return super.handleExceptionInternal(ex, erroResposta,headers, status, request);
	}
	//erro 404
	@ExceptionHandler(NotFoundException.class)
		public ResponseEntity<ErroResposta> handleNotFound(NotFoundException ex) {

    		ErroResposta erro = new ErroResposta(
            404,
            "Recurso não encontrado",
            LocalDateTime.now(),
            List.of(ex.getMessage())
    );

    return ResponseEntity.status(404).body(erro);
}
	//erro 409
	@ExceptionHandler(ConflictException.class)
		public ResponseEntity<ErroResposta> handleConflict(ConflictException ex) {

   			ErroResposta erro = new ErroResposta(
            409,
            "Conflito de dados",
            LocalDateTime.now(),
            List.of(ex.getMessage())
    );

    return ResponseEntity.status(409).body(erro);
}




}