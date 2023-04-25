
package br.com.magnasistemas.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magnasistemas.entity.Cidadao;
import br.com.magnasistemas.entity.Contato;
import br.com.magnasistemas.entity.Documento;
import br.com.magnasistemas.entity.Endereco;
import br.com.magnasistemas.entity.Profissional;
import br.com.magnasistemas.enumerator.Escolaridade;
import br.com.magnasistemas.enumerator.Etnia;
import br.com.magnasistemas.enumerator.Genero;
import br.com.magnasistemas.enumerator.SituacaoEscolar;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CidadaoControllerTest {
 
	@Autowired
	private TestRestTemplate restTemplate;

	private List<Contato> criarContato() {
		List<Contato> contatos = new ArrayList<>();
		Contato contato = new Contato();
		contato.setCelular("11 96742-3298");
		contato.setTelefone("11 945565633");
		contato.setEmail("Guilherme.mcosta15@gmail.com");
		contatos.add(contato);
		return contatos;
	}

	private List<Endereco> criarEndereco() {
		List<Endereco> enderecos = new ArrayList<>();
		Endereco endereco = new Endereco();

		endereco.setLogradouro("Chinigua");
		endereco.setBairro("Inga");
		endereco.setCep("05736-100");
		endereco.setCidade("São Paulo");
		endereco.setComplemento("a");
		endereco.setNumero("3");
		endereco.setUf("SP");
		enderecos.add(endereco);
		return enderecos;
	}

	private Documento criarDocumento() {
		Documento docs = new Documento();
		docs.setCertidaDeNascimento("1234/82135");
		docs.setCpf("590.355.786-23");
		docs.setRg("53.535.535-X");
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
		cidadao.setUsuario("Jonas");
		cidadao.setTimeStamp(ZonedDateTime.now());
		cidadao.setLastModify(ZonedDateTime.now());
		return cidadao;
	}

	private Cidadao criarCidadaoParaAtualizar() {
		Cidadao cidadao = new Cidadao();
		cidadao.setId(2l);
		cidadao.setNome("Jonas");
		cidadao.setDataDeNascimento(LocalDate.now());
		cidadao.setGenero(Genero.MASCULINO);
		cidadao.setEtnia(Etnia.PARDO);
		cidadao.setEscolaridade(Escolaridade.MEDIO);
		cidadao.setContato(criarContato());
		cidadao.setDocumentos(criarDocumento());
		cidadao.setEndereco(criarEndereco());
		cidadao.setSituacaoEscolar(SituacaoEscolar.CURSANDO);
		cidadao.setUsuario("Jonas");
		cidadao.setTimeStamp(ZonedDateTime.now());
		cidadao.setLastModify(ZonedDateTime.now());
		return cidadao;
	}

	@Test
	@Description("Cadastrar: Deve retornar um cidadao inválido com status BADREQUEST")
	void testCadastrarCidadaoInválido() {

		Cidadao dados = new Cidadao();
		ResponseEntity<String> response = restTemplate.postForEntity("/cidadao", dados, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	@DisplayName("Cadastrar: Deve retornar um cidadao válido com status CREATED")
	void testCadastrarCidadaoVálido() {

		Cidadao dados = criarCidadao();
		Documento docs = new Documento();
		docs.setCpf("500.544.768-98");
		docs.setRg("53.034.412-X");
		docs.setCertidaDeNascimento("1242/1221");
		dados.setDocumentos(docs);
		ResponseEntity<String> response = restTemplate.postForEntity("/cidadao", dados, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	
	
	@Test
	@DisplayName("Listagem: Deve retornar uma lista de cidadão cadastrados com status OK")
	void testaListagemDeCidadao() {

		Cidadao dados = criarCidadao();
		Documento doc = new Documento();
		doc.setCpf("550.544.768-22");
		doc.setRg("54.034.432-X");
		doc.setCertidaDeNascimento("1252/1221");
		dados.setDocumentos(doc);
		restTemplate.postForEntity("/cidadao", dados, String.class);
		ResponseEntity<String> response = restTemplate.getForEntity("/cidadao", String.class);
		
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());

	}

	@Test
	@DisplayName("Detalhar por id: Deve retornar OK caso o id seja Válido")
	void testDetalharCidadaoPorIdValido() {
		Cidadao dados = criarCidadao();
		Documento doc = new Documento();
		doc.setCpf("516.544.768-32");
		doc.setRg("23.035.412-X");
		doc.setCertidaDeNascimento("1252/1921");
		dados.setDocumentos(doc);
		restTemplate.postForEntity("/cidadao", dados, String.class);
		ResponseEntity<Cidadao> response = restTemplate.exchange("/cidadao/2", HttpMethod.GET, null, Cidadao.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	@DisplayName("Detalhar por id: Deve retornar Notfound caso o id seja inválido")
	void testDetalharCidadaoPorIdInvalido() {

		ResponseEntity<Cidadao> response = restTemplate.exchange("/cidadao/15", HttpMethod.GET, null, Cidadao.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void testAtualizarCidadao() {
		Cidadao cidadao = criarCidadao();
		Cidadao novosDados = criarCidadaoParaAtualizar();
		restTemplate.postForEntity("/cidadao", cidadao, String.class);
		ResponseEntity<Cidadao> response = restTemplate.exchange("/cidadao", HttpMethod.PUT,
				new HttpEntity<>(novosDados), Cidadao.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNull(response.getBody());
	}
	
	
	@Test
	void testaAtualizacaoDoCidadaoComDadosInvalidos() {
		Cidadao dados = criarCidadao();
		dados.setId(213l);
		Cidadao invalido = criarCidadaoParaAtualizar();
		invalido.setId(24l);
		

		restTemplate.postForEntity("/cidadao", dados, Cidadao.class);
		ResponseEntity<Cidadao> response = restTemplate.exchange("/cidadao", HttpMethod.PUT,
				new HttpEntity<>(invalido), Cidadao.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertNotNull(response.getBody());
	}
	
	@Test
	@DisplayName("Excluir por id: Deve retornar no_content caso o exista o cidadao")
	void testeDeletarCidadaoValido() {


	
		ResponseEntity<Cidadao> response = restTemplate.exchange("/cidadao/3", HttpMethod.DELETE , null, Cidadao.class);
		
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	@DisplayName("Excluir por id: Deve retornar NOT_FOUND caso não exista o Profissional")
	void testeDeletarProfissionalInvalido() {

		ResponseEntity<Profissional> response = restTemplate.exchange("/profissional/55", HttpMethod.DELETE, null,
				Profissional.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}
