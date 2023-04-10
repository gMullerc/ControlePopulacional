package br.com.magnasistemas.api.records.pessoa;

import java.util.List;

import br.com.magnasistemas.api.records.contato.DadosAtualizaContato;
import br.com.magnasistemas.api.records.endereco.DadosAtualizaEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(Long id, @NotNull @NotBlank String nome, @Valid @NotNull List<DadosAtualizaEndereco> endereco,
		@Valid List<DadosAtualizaContato> contato) {
}
