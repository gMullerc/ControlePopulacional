package br.com.magnasistemas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.entity.Cidadao;
import br.com.magnasistemas.service.CidadaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cidadao")
public class CidadaoController {

	@Autowired
	private CidadaoService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Cidadao> cadastrar(@RequestBody @Valid Cidadao dados) {
		service.criarCidadao(dados);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<Page<Cidadao>> procurar(@PageableDefault(size = 10, sort = "id") Pageable paginacao) {

		return ResponseEntity.status(HttpStatus.OK).body(service.listagem(paginacao));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cidadao> procurarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarPorID(id));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<Cidadao> atualizar(@RequestBody @Valid Cidadao dados) {
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
