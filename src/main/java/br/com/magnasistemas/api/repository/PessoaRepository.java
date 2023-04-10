package br.com.magnasistemas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
