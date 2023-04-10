package br.com.magnasistemas.api.records.documentos;

import jakarta.validation.constraints.NotBlank;

public record DadosDocumento(@NotBlank String certidaDeNascimento, @NotBlank String cpf, @NotBlank String rg) {

}
