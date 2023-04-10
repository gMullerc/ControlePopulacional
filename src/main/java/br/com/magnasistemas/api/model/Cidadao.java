package br.com.magnasistemas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cidadaos")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cidadao extends Pessoa {

	public Cidadao() {
		super();
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Enumerated(EnumType.STRING)
	protected enumSituacaoEscolar situacaoEscolar;

	@Enumerated(EnumType.STRING)
	protected enumEscolaridade escolaridade;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "documentos_id")
	protected Documento documentos;



	public enumSituacaoEscolar getSituacaoEscolar() {
		return situacaoEscolar;
	}

	public void setSituacaoEscolar(enumSituacaoEscolar situacaoEscolar) {
		this.situacaoEscolar = situacaoEscolar;
	}

	public enumEscolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(enumEscolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Documento getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Documento documentos) {
		this.documentos = documentos;
	}

}
