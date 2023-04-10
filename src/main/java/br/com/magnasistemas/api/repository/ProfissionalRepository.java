package br.com.magnasistemas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.api.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
