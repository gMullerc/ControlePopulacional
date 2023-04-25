package br.com.magnasistemas.entity;

import java.math.BigDecimal;

import br.com.magnasistemas.enumerator.TipoDeProfissional;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PROFISSIONAIS")
public class Profissional extends Cidadao {

	public Profissional() {
		super();
	}

	@NotNull
	@NotBlank
	@Column
	protected String cargo;
	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	protected TipoDeProfissional tipoDeProfissional;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "FK_DOCUMENTOS_PROFISSIONAIS")
	protected DocumentosProfissionais documentosProfissionais;
	
	
	@NotNull
	@Column
	@NotNull
	protected BigDecimal remuneracao;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public TipoDeProfissional getTipoDeProfissional() {
		return tipoDeProfissional;
	}

	public void setTipoDeProfissional(TipoDeProfissional tipoDeProfissional) {
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
