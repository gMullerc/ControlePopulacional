package br.com.magnasistemas.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.magnasistemas.entity.Cidadao;
import br.com.magnasistemas.entity.Contato;
import br.com.magnasistemas.entity.Documento;
import br.com.magnasistemas.entity.DocumentosProfissionais;
import br.com.magnasistemas.entity.Endereco;
import br.com.magnasistemas.entity.historico.HistoricoContato;
import br.com.magnasistemas.entity.historico.HistoricoDocumento;
import br.com.magnasistemas.entity.historico.HistoricoDocumentosProfissionais;
import br.com.magnasistemas.entity.historico.HistoricoEndereco;

@Component
public class ConverterParaHistorico {

	public HistoricoDocumento converterDocumentoParaHistoricoDeDocumentos(Documento documentoCidadao) {
		HistoricoDocumento historicoDocumento = new HistoricoDocumento();
		historicoDocumento.setCertidaDeNascimento(documentoCidadao.getCertidaDeNascimento());
		historicoDocumento.setCpf(documentoCidadao.getCpf());
		historicoDocumento.setRg(documentoCidadao.getRg());
		historicoDocumento.setIdDocumento(documentoCidadao.getId());
		return historicoDocumento;
	}

	public List<HistoricoContato> converterContatoParaHistoricoDeContatos(Cidadao dadosCidadao) {
		List<HistoricoContato> listaDeHistoricosDeContatos = new ArrayList<>();
		for (Contato contato : dadosCidadao.getContato()) {

			HistoricoContato historicoContato = new HistoricoContato();
			historicoContato.setIdContato(contato.getId());
			historicoContato.setCelular(contato.getCelular());
			historicoContato.setEmail(contato.getEmail());
			historicoContato.setTelefone(contato.getTelefone());
			listaDeHistoricosDeContatos.add(historicoContato);
		}
		return listaDeHistoricosDeContatos;
	}

	public List<HistoricoEndereco> converterEnderecoParaHistoricoDeEnderecos(Cidadao dadosCidadao) {
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
			historicoEndereco.setIdEndereco(endereco.getId());

			listaDeHistoricosDeEnderecos.add(historicoEndereco);
		}
		return listaDeHistoricosDeEnderecos;
	}

	public HistoricoDocumentosProfissionais converterDocumentoProfissionalParaHistoricoDeDocumentosProfissionais(
			DocumentosProfissionais documentoProfissional) {
		HistoricoDocumentosProfissionais historicoDocumentoProfissionais = new HistoricoDocumentosProfissionais();
		historicoDocumentoProfissionais.setCarteiraDeTrabalho(documentoProfissional.getCarteiraDeTrabalho());
		historicoDocumentoProfissionais.setPis(documentoProfissional.getPis());
		historicoDocumentoProfissionais.setIdDocumentoProfissional(documentoProfissional.getId());

		return historicoDocumentoProfissionais;
	}

}
