package br.com.magnasistemas.api.records.contato;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizaContato(@NotNull Long contato_id,String email, @NotBlank @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{5}\\-\\d{4})") String telefone,
		@NotBlank @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4}\\-\\d{4})") String celular) {

}
