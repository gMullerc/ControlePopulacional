package br.com.magnasistemas.api.records.pessoa;

import java.util.List;

import br.com.magnasistemas.api.enumerator.enumGenero;
import br.com.magnasistemas.api.model.Contato;
import br.com.magnasistemas.api.model.Endereco;
import br.com.magnasistemas.api.model.Pessoa;

public record DadosListagemPessoa(Long id, String nome, enumGenero genero, List<Endereco> endereco, List<Contato> contato ) {

    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getGenero(), pessoa.getEndereco(), pessoa.getContato());
    }
}
