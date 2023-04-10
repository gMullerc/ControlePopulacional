package br.com.magnasistemas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.api.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
