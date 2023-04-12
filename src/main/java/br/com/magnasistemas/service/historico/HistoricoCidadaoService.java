package br.com.magnasistemas.service.historico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.entity.Cidadao;
import br.com.magnasistemas.entity.Contato;
import br.com.magnasistemas.entity.Documento;
import br.com.magnasistemas.entity.Endereco;
import br.com.magnasistemas.entity.historico.HistoricoCidadao;
import br.com.magnasistemas.entity.historico.HistoricoContato;
import br.com.magnasistemas.entity.historico.HistoricoDocumento;
import br.com.magnasistemas.entity.historico.HistoricoEndereco;
import br.com.magnasistemas.repository.historico.HistoricoCidadaoRepository;

@Service
public class HistoricoCidadaoService {

	@Autowired
	private HistoricoCidadaoRepository historicoCidadaoRepository;

	public HistoricoCidadao registrarNovoCidadao(Cidadao dados) {

		HistoricoCidadao historicoRegistrarCidadao = new HistoricoCidadao();
		
		historicoRegistrarCidadao.setNome(dados.getNome());
		historicoRegistrarCidadao.setDataDeNascimento(dados.getDataDeNascimento());
		historicoRegistrarCidadao.setEtnia(dados.getEtnia());
		historicoRegistrarCidadao.setGenero(dados.getGenero());

		historicoRegistrarCidadao.setEndereco(converterEnderecoParaHistoricoDeEnderecos(dados));
		historicoRegistrarCidadao.setContato(converterContatoParaHistoricoDeContatos(dados));
		historicoRegistrarCidadao.setDocumentos(converterDocumentoParaHistoricoDeDocumentos(dados.getDocumentos()));

		historicoRegistrarCidadao.setEscolaridade(dados.getEscolaridade());
		historicoRegistrarCidadao.setSituacaoEscolar(dados.getSituacaoEscolar());
		historicoRegistrarCidadao.setTimeStamp(LocalDateTime.now());
		

		return historicoCidadaoRepository.save(historicoRegistrarCidadao);
	}

	private HistoricoDocumento converterDocumentoParaHistoricoDeDocumentos(Documento documentoCidadao) {
		HistoricoDocumento historicoDocumento = new HistoricoDocumento();
		historicoDocumento.setCertidaDeNascimento(documentoCidadao.getCertidaDeNascimento());
		historicoDocumento.setCpf(documentoCidadao.getCpf());
		historicoDocumento.setRg(documentoCidadao.getRg());
		historicoDocumento.setId(documentoCidadao.getId());
		
		return historicoDocumento;
	}

	private List<HistoricoContato> converterContatoParaHistoricoDeContatos(Cidadao dadosCidadao) {
		List<HistoricoContato> listaDeHistoricosDeContatos = new ArrayList<>();
		for (Contato endereco : dadosCidadao.getContato()) {

			HistoricoContato historicoContato = new HistoricoContato();
			historicoContato.setCelular(endereco.getCelular());
			historicoContato.setEmail(endereco.getEmail());
			historicoContato.setTelefone(endereco.getTelefone());
			listaDeHistoricosDeContatos.add(historicoContato);
		}
		return listaDeHistoricosDeContatos;
	}

	private List<HistoricoEndereco> converterEnderecoParaHistoricoDeEnderecos(Cidadao dadosCidadao) {
		List<HistoricoEndereco> listaDeHistoricosDeEnderecos = new ArrayList<>();
		for (Endereco endereco : dadosCidadao.getEndereco()) {
			HistoricoEndereco historicoEndereco = new HistoricoEndereco();
			historicoEndereco.setBairro(endereco.getBairro());
			historicoEndereco.setLogradouro(endereco.getLogradouro());
			historicoEndereco.setNumero(endereco.getNumero());
			historicoEndereco.setUf(endereco.getUf());
			historicoEndereco.setComplemento(endereco.getComplemento());
			historicoEndereco.setCep(endereco.getCep());
			historicoEndereco.setCidade(endereco.getCidade());
			

			listaDeHistoricosDeEnderecos.add(historicoEndereco);
		}
		return listaDeHistoricosDeEnderecos;
	}

}
