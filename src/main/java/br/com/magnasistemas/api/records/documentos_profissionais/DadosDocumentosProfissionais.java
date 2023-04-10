package br.com.magnasistemas.api.records.documentos_profissionais;

import jakarta.validation.constraints.NotBlank;

public record DadosDocumentosProfissionais(@NotBlank String pis, @NotBlank String carteiraDeTrabalho) {

}
