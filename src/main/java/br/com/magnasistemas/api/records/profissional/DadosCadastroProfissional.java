package br.com.magnasistemas.api.records.profissional;

import java.math.BigDecimal;

import br.com.magnasistemas.api.enumerator.enumTipoDeProfissional;
import br.com.magnasistemas.api.records.cidadao.DadosCadastroCidadao;
import br.com.magnasistemas.api.records.documentos_profissionais.DadosDocumentosProfissionais;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfissional(@NotNull DadosCadastroCidadao cidadao,
		@NotBlank String cargo,
		@NotNull enumTipoDeProfissional tipoDeProfissional, 
		@NotNull BigDecimal remuneracao,
		@NotNull @Valid DadosDocumentosProfissionais documentosProfissionais) {
}
