package br.com.magnasistemas.api.records.cidadao;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import br.com.magnasistemas.api.records.pessoa.DadosAtualizacaoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCidadao(Long id, @Valid @NotNull DadosAtualizacaoPessoa pessoa,
		@NotNull enumEscolaridade escolaridade, @NotNull enumSituacaoEscolar situacaoEscolar) {

}
