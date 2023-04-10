package br.com.magnasistemas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.api.model.Cidadao;
import br.com.magnasistemas.api.records.cidadao.DadosAtualizacaoCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosCadastroCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosListagemCidadao;
import br.com.magnasistemas.api.service.CidadaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cidadao")
public class CidadaoController {

	@Autowired
	private CidadaoService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Cidadao> cadastrar(@RequestBody @Valid DadosCadastroCidadao dados) {
		service.criarCidadao(dados);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<DadosListagemCidadao>> procurar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarCidadao());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DadosListagemCidadao> procurarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarPorID(id));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<Cidadao> atualizar(@RequestBody @Valid DadosAtualizacaoCidadao dados) {
		service.atualizarCidadao(dados);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<HttpStatus> deletar(@PathVariable Long id) {
		service.deletarCidadao(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
