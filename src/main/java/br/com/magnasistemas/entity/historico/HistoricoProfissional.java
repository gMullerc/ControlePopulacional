package br.com.magnasistemas.entity.historico;

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
@Table(name = "TB_HIST_PROFISSIONAL")
public class HistoricoProfissional extends HistoricoCidadao {

	public HistoricoProfissional() {
		super();
	}

	@NotNull
	@NotBlank
	@Column
	protected String cargo;
	@Column
	@Enumerated(EnumType.STRING)
	protected TipoDeProfissional tipoDeProfissional;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "FK_DOCUMENTO_PROFISSIONAL")
	protected HistoricoDocumentosProfissionais documentosProfissionais;
	@NotNull
	@Column
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

	public HistoricoDocumentosProfissionais getDocumentosProfissionais() {
		return documentosProfissionais;
	}

	public void setDocumentosProfissionais(HistoricoDocumentosProfissionais documentosProfissionais) {
		this.documentosProfissionais = documentosProfissionais;
	}

	public BigDecimal getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
