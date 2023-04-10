package br.com.magnasistemas.api.model;

import java.math.BigDecimal;

import br.com.magnasistemas.api.enumerator.enumTipoDeProfissional;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profissionais")
public class Profissional extends Cidadao {

	public Profissional() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String cargo;
	@Enumerated(EnumType.STRING)
	protected enumTipoDeProfissional tipoDeProfissional;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "documentos_profissionais_id")
	protected DocumentosProfissionais documentosProfissionais;
	protected BigDecimal remuneracao;

	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public enumTipoDeProfissional getTipoDeProfissional() {
		return tipoDeProfissional;
	}

	public void setTipoDeProfissional(enumTipoDeProfissional tipoDeProfissional) {
		this.tipoDeProfissional = tipoDeProfissional;
	}

	public DocumentosProfissionais getDocumentosProfissionais() {
		return documentosProfissionais;
	}

	public void setDocumentosProfissionais(DocumentosProfissionais documentosProfissionais) {
		this.documentosProfissionais = documentosProfissionais;
	}

	public BigDecimal getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

}
