package br.com.magnasistemas.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magnasistemas.entity.Cidadao;
import br.com.magnasistemas.entity.Contato;
import br.com.magnasistemas.entity.Documento;
import br.com.magnasistemas.entity.Endereco;
import br.com.magnasistemas.enumerator.Escolaridade;
import br.com.magnasistemas.enumerator.Etnia;
import br.com.magnasistemas.enumerator.Genero;
import br.com.magnasistemas.enumerator.SituacaoEscolar;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CidadaoServiceTest {
	final String BASE_PATH = "/cidadao";

	@Autowired
	private TestRestTemplate restTemplate;

	private List<Contato> criarContato() {
		List<Contato> contatos = new ArrayList<>();
		Contato contato = new Contato();
		contato.setCelular("985421298");
		contato.setTelefone("234234");
		contato.setEmail("Guilherme.mcosta15@gmail.com");
		contatos.add(contato);
		return contatos;
	}

	private List<Endereco> criarEndereco() {
		List<Endereco> enderecos = new ArrayList<>();
		Endereco endereco = new Endereco();

		endereco.setLogradouro("Chinigua");
		endereco.setBairro("Inga");
		endereco.setCep("05736100");
		endereco.setCidade("São Paulo");
		endereco.setComplemento("a");
		endereco.setNumero("3");
		endereco.setUf("SP");
		enderecos.add(endereco);
		return enderecos;
	}

	private Documento criarDocumento() {
		Documento docs = new Documento();
		docs.setCertidaDeNascimento("32422");
		docs.setCpf("3242");
		docs.setRg("3242");
		return docs;
	}
	private Documento criarDocumento2() {
		Documento docs = new Documento();
		docs.setCertidaDeNascimento("3242");
		docs.setCpf("32422");
		docs.setRg("32242");
		return docs;
	}

	private Cidadao criarCidadao() {
		Cidadao cidadao = new Cidadao();
		cidadao.setNome("Guilherme");
		cidadao.setDataDeNascimento(LocalDate.now());
		cidadao.setGenero(Genero.MASCULINO);
		cidadao.setEtnia(Etnia.PARDO);
		cidadao.setEscolaridade(Escolaridade.MEDIO);
		cidadao.setContato(criarContato());
		cidadao.setDocumentos(criarDocumento());
		cidadao.setEndereco(criarEndereco());
		cidadao.setSituacaoEscolar(SituacaoEscolar.CURSANDO);
		return cidadao;
	}

	@Test
	@Description("Deve retornar um cidadao válido com status CREATED")
	void testCadastrarCidadaoVálido() {
		
		Cidadao dados = criarCidadao();
		dados.setDocumentos(criarDocumento2());
		ResponseEntity<String> response = restTemplate.postForEntity("/cidadao", dados, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	/*@Test
	@Description("Deve retornar um exception e um status de not_found")
	void testCadastrarCidadaoInválido() {

		DadosCadastroCidadao cid = new DadosCadastroCidadao(null, null, null, null);
		ResponseEntity<String> response = restTemplate.postForEntity("/cidadao", cid, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}*/
}
