package br.com.magnasistemas.entity;

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

@Table(name = "TB_CIDADAOS")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cidadao extends Pessoa {

	public Cidadao() {
		super();

	}

	@Column
	@Enumerated(EnumType.STRING)
	protected SituacaoEscolar situacaoEscolar;

	@Column
	@Enumerated(EnumType.STRING)
	protected Escolaridade escolaridade;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "FK_DOCUMENTOS")
	protected Documento documentos;

	

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

	public Documento getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Documento documentos) {
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
		return this.usuario;
	}

}
