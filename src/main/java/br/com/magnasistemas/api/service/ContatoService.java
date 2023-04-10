package br.com.magnasistemas.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.exception.NotFoundExceptionHandler;
import br.com.magnasistemas.api.model.Contato;
import br.com.magnasistemas.api.model.Pessoa;
import br.com.magnasistemas.api.records.contato.DadosAtualizaContato;
import br.com.magnasistemas.api.records.contato.DadosContato;
import br.com.magnasistemas.api.records.pessoa.DadosAtualizacaoPessoa;
import br.com.magnasistemas.api.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repo;
	
	
	public List<Contato> criarContato(List<DadosContato> dadosContato) {
		List<Contato> cont = new ArrayList<>();
		for (DadosContato dadosContatos : dadosContato) {
			Contato contato = new Contato();
			
			contato.setCelular(dadosContatos.celular());
			contato.setTelefone(dadosContatos.telefone());
			contato.setEmail(dadosContatos.email());
			cont.add(contato);
		}
		
		return cont;
	
	}

	

	public List<Contato> atualizarContato(DadosAtualizacaoPessoa dados, Pessoa pessoa) {

		List<Contato> cont = pessoa.getContato();
		List<DadosAtualizaContato> dadosCont = dados.contato();
		for (DadosAtualizaContato dadoscontato : dadosCont) {

			Contato ref = repo.getReferenceById(dadoscontato.contato_id());

			if (!cont.contains(ref)) {
				throw new NotFoundExceptionHandler("Não foi possível localizar esse contato em seu nome");
			}

			ref.setCelular(dadoscontato.celular());
			ref.setEmail(dadoscontato.email());
			ref.setTelefone(dadoscontato.telefone());
			cont.add(ref);
		}

		return cont;
	}

}
