package br.com.magnasistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.entity.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
