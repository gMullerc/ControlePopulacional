package br.com.magnasistemas.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumEtnia;
import br.com.magnasistemas.api.enumerator.enumGenero;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import br.com.magnasistemas.api.model.Cidadao;
import br.com.magnasistemas.api.records.cidadao.DadosCadastroCidadao;
import br.com.magnasistemas.api.records.contato.DadosContato;
import br.com.magnasistemas.api.records.documentos.DadosDocumento;
import br.com.magnasistemas.api.records.endereco.DadosEndereco;
import br.com.magnasistemas.api.records.pessoa.DadosCadastroPessoa;
import br.com.magnasistemas.api.repository.CidadaoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CidadaoControllerTest {

	
	@Autowired 
	private CidadaoRepository cidadaoRepository;
	@Autowired
	private CidadaoController cidadaoController;
	
	
	
	private List<DadosContato> criarContato() {
		
		List<DadosContato> contatos = new ArrayList<>();
		DadosContato contato = new DadosContato("985421298", "55120429", "guilherme.mcosta15@gmail.com");
		contatos.add(contato);
		return contatos;
	}

	private List<DadosEndereco> criarEndereco() {
		List<DadosEndereco> enderecos = new ArrayList<>();
		DadosEndereco endereco = new DadosEndereco("Chinigua", "Inga", "05736100", "São Paulo", "A", "3", "Sp");
		enderecos.add(endereco);
		return enderecos;
	}

	private DadosDocumento criarDocumento() {
		DadosDocumento docs = new DadosDocumento("23478234", "50054476889", "53034418x");
		return docs;
	}

	private DadosCadastroPessoa criarPessoa() {
		DadosCadastroPessoa pessoa = new DadosCadastroPessoa("Guilherme", enumGenero.MASCULINO, enumEtnia.BRANCO,
				LocalDate.now(), criarEndereco(), criarContato());
		return pessoa;
	}

	private DadosCadastroCidadao criarCidadao() {
		DadosCadastroCidadao cidadao = new DadosCadastroCidadao(criarPessoa(), enumSituacaoEscolar.CURSANDO,
				enumEscolaridade.FUNDAMENTAL, criarDocumento());
		return cidadao;
	}
	
	@Test
	@Description("Deve retornar um status CREATED")
	void testaCriacaoDeCidadao() {

		cidadaoRepository.deleteAll();
		DadosCadastroCidadao dados = criarCidadao();
		ResponseEntity<Cidadao> respo = cidadaoController.cadastrar(dados);
		
		assertEquals(HttpStatus.CREATED, respo.getStatusCode());
	}

	
	@Test
	@Description("Deve retornar um status BAD_REQUEST")
	void testaCriacaoDeCidadaoInválido() {
		cidadaoRepository.deleteAll();
		
		DadosCadastroCidadao dados = new DadosCadastroCidadao(null, null, null, null);
		
		ResponseEntity<Cidadao> respo = cidadaoController.cadastrar(dados);
		
		assertEquals(HttpStatus.BAD_REQUEST, respo.getStatusCode());
	}
}
