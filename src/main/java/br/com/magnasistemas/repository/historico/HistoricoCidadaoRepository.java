package br.com.magnasistemas.repository.historico;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.entity.Cidadao;
import br.com.magnasistemas.entity.historico.HistoricoCidadao;

public interface HistoricoCidadaoRepository extends JpaRepository<HistoricoCidadao, Long> {

	HistoricoCidadao save(Cidadao cidadaoAnterior);
	
	



}
