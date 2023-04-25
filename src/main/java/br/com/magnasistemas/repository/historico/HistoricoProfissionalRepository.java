package br.com.magnasistemas.repository.historico;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.entity.Profissional;
import br.com.magnasistemas.entity.historico.HistoricoCidadao;
import br.com.magnasistemas.entity.historico.HistoricoProfissional;

public interface HistoricoProfissionalRepository extends JpaRepository<HistoricoProfissional, Long> {

	HistoricoCidadao save(Profissional profissionalAnterior);
	
	



}
