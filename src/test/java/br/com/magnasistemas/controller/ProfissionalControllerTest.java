
package br.com.magnasistemas.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
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
		contato.setCelular("11 96742-3298");
		contato.setTelefone("11 9455-5633");
		contato.setEmail("Guilherme.mcosta15@hotmail.com");
		
		contatos.add(contato);
		return contatos;
	}

	private List<Endereco> criarEndereco() {
		List<Endereco> enderecos = new ArrayList<>();
		Endereco endereco = new Endereco();

		endereco.setLogradouro("Compoa");
		endereco.setBairro("Maua");
		endereco.setCep("05736-100");
		endereco.setCidade("São Paulo");
		endereco.setComplemento("");
		endereco.setNumero("10");
		endereco.setUf("SP");
		enderecos.add(endereco);
		return enderecos;
	}

	private Documento criarDocumento() {
		Documento docs = new Documento();
		docs.setCertidaDeNascimento("1234/4233");
		docs.setCpf("334.343.435.78");
		docs.setRg("23.323.244.X");
		return docs;
	}

	private DocumentosProfissionais criarDocumentoProfissional() {
		DocumentosProfissionais docs = new DocumentosProfissionais();
		docs.setPis("12345678910");
		docs.setCarteiraDeTrabalho("12345678910");
		return docs;
	}

	private Profissional criarProfissional() {
		Profissional profissional = new Profissional();
		profissional.setNome("Guilherme");
		profissional.setId(10l);
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
		profissional.setTimeStamp(ZonedDateTime.now());
		profissional.setLastModify(ZonedDateTime.now());
		return profissional;
	}

	private Profissional criarProfissionalParaAtualizar() {
		Profissional profissional = new Profissional();
		profissional.setId(2l);
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
		doc.setCarteiraDeTrabalho("12345678912");
		doc.setPis("12345678911");
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
	void testCadastrarProfissionalValido() {
		Profissional dados = criarProfissional();
		Documento documentos = new Documento();
		documentos.setCertidaDeNascimento("1233/1234");
		documentos.setCpf("500.544.768-12");
		documentos.setRg("53.373-333-X");
		DocumentosProfissionais docProfissional = new DocumentosProfissionais();
		docProfissional.setCarteiraDeTrabalho("12345678915");
		docProfissional.setPis("12345678918");
		dados.setDocumentos(documentos);
		dados.setDocumentosProfissionais(docProfissional);
		ResponseEntity<String> response = restTemplate.postForEntity("/profissional", dados, String.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test

	@DisplayName("Listagem: Deve retornar uma lista de Profissionais cadastrados com status OK")
	void testaListagemDeProfissional() {

		Profissional dados = criarProfissional();
		Documento documentos = new Documento();
		documentos.setCertidaDeNascimento("1243/1254");
		documentos.setCpf("500.544.763-22");
		documentos.setRg("53.373-332-X");
		DocumentosProfissionais docProfissional = new DocumentosProfissionais();
		docProfissional.setCarteiraDeTrabalho("12345678920");
		docProfissional.setPis("12345678924");
		dados.setDocumentos(documentos);
		dados.setDocumentosProfissionais(docProfissional);
		restTemplate.postForEntity("/profissional", dados, String.class);
		ResponseEntity<String> response = restTemplate.getForEntity("/profissional", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());

	}

	@Test

	@DisplayName("Detalhar por id: Deve retornar OK caso o id seja válido")
	void testDetalharProfissionalPorIdValido() {
		Profissional dados = criarProfissional();
		Documento documentos = new Documento();
		documentos.setCertidaDeNascimento("1243/1221");
		documentos.setCpf("500.544.763-22");
		documentos.setRg("53.373-332-X");
		DocumentosProfissionais docProfissional = new DocumentosProfissionais();
		docProfissional.setCarteiraDeTrabalho("12345678953");
		docProfissional.setPis("12345678986");
		dados.setDocumentos(documentos);
		
		dados.setDocumentosProfissionais(docProfissional);
		ResponseEntity<Profissional> response = restTemplate.exchange("/profissional/2", HttpMethod.GET, null,
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
	@DisplayName("Excluir por id: Deve retornar no_content caso o exista o Profissional")
	void testeDeletarProfissionalValido() {
		Profissional profissional = criarProfissional();
		Documento docs = new Documento();
		docs.setCertidaDeNascimento("1224/1293");
		docs.setCpf("334.543.435-78");
		docs.setRg("23.312.234-X");
		profissional.setDocumentos(docs);
		restTemplate.postForEntity("/profissional", profissional, Profissional.class);
		ResponseEntity<Profissional> response = restTemplate.exchange("/profissional/1", HttpMethod.DELETE, null,
				Profissional.class);

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