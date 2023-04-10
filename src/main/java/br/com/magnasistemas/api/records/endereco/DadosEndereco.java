package br.com.magnasistemas.api.records.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(@NotBlank @NotNull String logradouro, @NotBlank @NotNull String bairro,
		@NotBlank @NotNull @Pattern(regexp = "\\d{8}") String cep, @NotBlank @NotNull String cidade,
		@NotBlank @NotNull String uf, String complemento, @NotBlank @NotNull String numero) {
}