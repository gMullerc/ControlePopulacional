package br.com.magnasistemas.api.records.profissional;

import java.math.BigDecimal;

import br.com.magnasistemas.api.enumerator.enumTipoDeProfissional;
import br.com.magnasistemas.api.records.cidadao.DadosAtualizacaoCidadao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfissional(Long id, @Valid @NotNull DadosAtualizacaoCidadao cidadao, String cargo,
		enumTipoDeProfissional tipoDeProfissional, BigDecimal remuneracao) {

}
