package br.com.magnasistemas.entity.historico;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.magnasistemas.enumerator.Escolaridade;
import br.com.magnasistemas.enumerator.SituacaoEscolar;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "TB_HIST_CIDADAO")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class HistoricoCidadao extends HistoricoPessoa {

	public HistoricoCidadao() {
		super();

	}

	@Column
	@Enumerated(EnumType.STRING)
	protected SituacaoEscolar situacaoEscolar;

	@Column
	@Enumerated(EnumType.STRING)
	protected Escolaridade escolaridade;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "FK_HIST_DOCUMENTOS")
	protected HistoricoDocumento documentos;

	public SituacaoEscolar getSituacaoEscolar() {
		return situacaoEscolar;
	}

	public void setSituacaoEscolar(SituacaoEscolar situacaoEscolar) {
		this.situacaoEscolar = situacaoEscolar;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public HistoricoDocumento getDocumentos() {
		return documentos;
	}

	public void setDocumentos(HistoricoDocumento documentos) {
		this.documentos = documentos;
	}

	@Override
	public Long getId() {

		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@Override
	public String getUsuario() {
		return usuario;
	}

}
