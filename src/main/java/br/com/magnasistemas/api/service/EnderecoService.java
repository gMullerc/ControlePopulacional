package br.com.magnasistemas.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.exception.NotFoundExceptionHandler;
import br.com.magnasistemas.api.model.Endereco;
import br.com.magnasistemas.api.model.Pessoa;
import br.com.magnasistemas.api.records.endereco.DadosAtualizaEndereco;
import br.com.magnasistemas.api.records.endereco.DadosEndereco;
import br.com.magnasistemas.api.records.pessoa.DadosAtualizacaoPessoa;
import br.com.magnasistemas.api.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	
	public List<Endereco> criarEndereco(List<DadosEndereco> dadosEndereco) {
		List<Endereco> end = new ArrayList<>();
		for (DadosEndereco dadosEnderecos : dadosEndereco) {
			Endereco endereco = new Endereco();
			
			endereco.setLogradouro(dadosEnderecos.logradouro());
			endereco.setBairro(dadosEnderecos.bairro());
			endereco.setCep(dadosEnderecos.cep());
			endereco.setCidade(dadosEnderecos.cidade());
			
			endereco.setComplemento(dadosEnderecos.complemento());
			endereco.setNumero(dadosEnderecos.numero());
			endereco.setUf(dadosEnderecos.uf());
			
			
			
			end.add(endereco);
		}
		
		return end;
	
	}
	
	public List<Endereco> atualizarEndereco(DadosAtualizacaoPessoa dados, Pessoa pessoa) {

		List<Endereco> end = pessoa.getEndereco();
		List<DadosAtualizaEndereco> dadosEndereco = dados.endereco();

		for (DadosAtualizaEndereco dadosend : dadosEndereco) {

			Endereco ref = repo.getReferenceById(dadosend.enderecos_id());

			if (!end.contains(ref)) {
				throw new NotFoundExceptionHandler("Não foi possível localizar esse endereço em seu nome");
			}

			ref.setBairro(dadosend.bairro());
			ref.setCep(dadosend.cep());
			ref.setCidade(dadosend.cidade());
			ref.setComplemento(dadosend.complemento());
			ref.setNumero(dadosend.numero());
			ref.setLogradouro(dadosend.logradouro());
			end.add(ref);
		}
		return end;
	}

}
