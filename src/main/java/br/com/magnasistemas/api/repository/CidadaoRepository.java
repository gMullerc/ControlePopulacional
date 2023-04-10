package br.com.magnasistemas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.api.model.Cidadao;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {

}
