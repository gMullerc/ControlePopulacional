package br.com.magnasistemas.api.records.pessoa;

import java.time.LocalDate;
import java.util.List;

import br.com.magnasistemas.api.enumerator.enumEtnia;
import br.com.magnasistemas.api.enumerator.enumGenero;
import br.com.magnasistemas.api.records.contato.DadosContato;
import br.com.magnasistemas.api.records.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(

		@NotBlank String nome, 
		@NotNull enumGenero genero, 
		@NotNull enumEtnia etnia,
		@NotNull LocalDate dataDeNascimento, 
		@NotNull @Valid List<DadosEndereco> endereco,
		@NotNull @Valid List<DadosContato> contato) {
}
