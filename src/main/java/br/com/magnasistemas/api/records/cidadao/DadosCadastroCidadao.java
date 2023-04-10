package br.com.magnasistemas.api.records.cidadao;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import br.com.magnasistemas.api.records.documentos.DadosDocumento;
import br.com.magnasistemas.api.records.pessoa.DadosCadastroPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCidadao(@NotNull DadosCadastroPessoa pessoa, @NotNull enumSituacaoEscolar situacaoEscolar,
		@NotNull enumEscolaridade escolaridade, @NotNull @Valid DadosDocumento documentos) {

}
