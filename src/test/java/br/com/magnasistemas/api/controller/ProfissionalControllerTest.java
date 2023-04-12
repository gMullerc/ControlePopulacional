
package br.com.magnasistemas.api.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import br.com.magnasistemas.entity.DocumentosProfissionais;
import br.com.magnasistemas.entity.Endereco;
import br.com.magnasistemas.entity.Profissional;
import br.com.magnasistemas.enumerator.Escolaridade;
import br.com.magnasistemas.enumerator.Etnia;
import br.com.magnasistemas.enumerator.Genero;
import br.com.magnasistemas.enumerator.SituacaoEscolar;
import br.com.magnasistemas.enumerator.TipoDeProfissional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ProfissionalControllerTest {
	final String BASE_PATH = "/cidadao";

	@Autowired
	private TestRestTemplate restTemplate;

	private List<Contato> criarContato() {
		List<Contato> contatos = new ArrayList<>();
		Contato contato = new Contato();
		contato.setCelular("985421297");
		contato.setTelefone("55120429");
		contato.setEmail("Guilherme.mcosta15@hotmail.com");
		contatos.add(contato);
		return contatos;
	}

	private List<Endereco> criarEndereco() {
		List<Endereco> enderecos = new ArrayList<>();
		Endereco endereco = new Endereco();

		endereco.setLogradouro("Compoa");
		endereco.setBairro("Maua");
		endereco.setCep("05729333");
		endereco.setCidade("São Paulo");
		endereco.setComplemento("");
		endereco.setNumero("10");
		endereco.setUf("SP");
		enderecos.add(endereco);
		return enderecos;
	}

	private Documento criarDocumento() {
		Documento docs = new Documento();
		docs.setCertidaDeNascimento("839390");
		docs.setCpf("59937729876");
		docs.setRg("827461239");
		return docs;
	}

	private DocumentosProfissionais criarDocumentoProfissional() {
		DocumentosProfissionais docs = new DocumentosProfissionais();
		docs.setPis("7782399");
		docs.setCarteiraDeTrabalho("883940277283");
		return docs;
	}

	private Profissional criarProfissional() {
		Profissional profissional = new Profissional();
		profissional.setNome("Guilherme");
		profissional.setDataDeNascimento(LocalDate.now());
		profissional.setGenero(Genero.MASCULINO);
		profissional.setEtnia(Etnia.PARDO);
		profissional.setEscolaridade(Escolaridade.MEDIO);
		profissional.setContato(criarContato());
		profissional.setDocumentos(criarDocumento());
		profissional.setEndereco(criarEndereco());
		profissional.setSituacaoEscolar(SituacaoEscolar.CURSANDO);
		profissional.setCargo("Desenvolvedor");
		profissional.setDocumentosProfissionais(criarDocumentoProfissional());
		profissional.setRemuneracao(new BigDecimal(2233));
		profissional.setTipoDeProfissional(TipoDeProfissional.CLT);
		return profissional;
	}

	private Profissional criarProfissionalParaAtualizar() {
		Profissional profissional = new Profissional();
		profissional.setId(6l);
		profissional.setNome("Jonas");
		profissional.setDataDeNascimento(LocalDate.now());
		profissional.setGenero(Genero.MASCULINO);
		profissional.setEtnia(Etnia.PARDO);
		profissional.setEscolaridade(Escolaridade.MEDIO);
		profissional.setContato(criarContato());
		profissional.setDocumentos(criarDocumento());
		profissional.setEndereco(criarEndereco());
		profissional.setSituacaoEscolar(SituacaoEscolar.CURSANDO);
		profissional.setCargo("Financeiro");
		DocumentosProfissionais doc = new DocumentosProfissionais();
		doc.setCarteiraDeTrabalho("324234");
		doc.setPis("2342422");
		profissional.setDocumentosProfissionais(doc);
		profissional.setRemuneracao(new BigDecimal(5512));
		profissional.setTipoDeProfissional(TipoDeProfissional.AUTONOMO);
		return profissional;
	}

	@Test
	@Description("Cadastrar: Deve retornar um Profissional inválido com status BADREQUEST")
	void testCadastrarProfissionalInválido() {

		Profissional dados = new Profissional();
		ResponseEntity<Profissional> response = restTemplate.postForEntity("/profissional", dados, Profissional.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test

	@DisplayName("Cadastrar: Deve retornar um Profissional válido com status CREATED")
	void testCadastrarCidadaoVálido() {
		Profissional dados = criarProfissional();
		DocumentosProfissionais docProfissional = new DocumentosProfissionais();
		docProfissional.setCarteiraDeTrabalho("23233");
		docProfissional.setPis("2342323");
		dados.setDocumentosProfissionais(docProfissional);
		ResponseEntity<String> response = restTemplate.postForEntity("/profissional", dados, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test

	@DisplayName("Listagem: Deve retornar uma lista de Profissionais cadastrados com status OK")
	void testaListagemDeProfissional() {

		Profissional dados = criarProfissional();
		Documento doc = new Documento();
		doc.setCpf("50054476879");
		doc.setCertidaDeNascimento("232323");
		doc.setRg("324423424");
		dados.setDocumentos(doc);
		restTemplate.postForEntity("/profissional", dados, String.class);
		ResponseEntity<String> response = restTemplate.getForEntity("/profissional", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());

	}

	@Test

	@DisplayName("Detalhar por id: Deve retornar OK caso o id seja válido")
	void testDetalharProfissionalPorIdValido() {
		Profissional dados = criarProfissional();
		DocumentosProfissionais docProfissional = new DocumentosProfissionais();
		docProfissional.setCarteiraDeTrabalho("2323");
		docProfissional.setPis("232323");
		restTemplate.postForEntity("/profissional", dados, String.class);
		ResponseEntity<Profissional> response = restTemplate.exchange("/profissional/7", HttpMethod.GET, null,
				Profissional.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@DisplayName("Detalhar por id: Deve retornar Notfound caso o id seja inválido")
	void testDetalharProfissionalPorIdInvalido() {

		ResponseEntity<Profissional> response = restTemplate.exchange("/profissional/54", HttpMethod.GET, null,
				Profissional.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void testaAtualizacaoDoProfissionalComDadosValidos() {
		Profissional dados = criarProfissional();
		Profissional novosDados = criarProfissionalParaAtualizar();

		restTemplate.postForEntity("/profissional", dados, Profissional.class);
		ResponseEntity<Profissional> response = restTemplate.exchange("/profissional", HttpMethod.PUT,
				new HttpEntity<>(novosDados), Profissional.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNull(response.getBody());
	}
	
	@Test
	void testaAtualizacaoDoProfissionalComDadosInvalidos() {
		Profissional dados = criarProfissional();
		Profissional invalido = criarProfissionalParaAtualizar();
		invalido.setId(24l);
		

		restTemplate.postForEntity("/profissional", dados, Profissional.class);
		ResponseEntity<Profissional> response = restTemplate.exchange("/profissional", HttpMethod.PUT,
				new HttpEntity<>(invalido), Profissional.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertNotNull(response.getBody());
	}

	@Test
	@DisplayName("Excluir por id: Deve retornar no_content caso o exista o cidadao")
	void testeDeletarCidadaoValido() {

		criarProfissional();

		ResponseEntity<Cidadao> response = restTemplate.exchange("/profissional/6", HttpMethod.DELETE, null,
				Cidadao.class);

		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	@DisplayName("Excluir por id: Deve retornar no_content caso o exista o cidadao")
	void testeDeletarCidadaoInvalido() {

		criarProfissional();

		ResponseEntity<Cidadao> response = restTemplate.exchange("/profissional/50", HttpMethod.DELETE, null,
				Cidadao.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}


}