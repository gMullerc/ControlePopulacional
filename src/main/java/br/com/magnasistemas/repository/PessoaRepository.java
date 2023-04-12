package br.com.magnasistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
