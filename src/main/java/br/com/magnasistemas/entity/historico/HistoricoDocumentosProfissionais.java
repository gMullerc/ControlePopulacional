package br.com.magnasistemas.entity.historico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_HIST_DOCUMENTO_PROFISSIONAL")
public class HistoricoDocumentosProfissionais {

	@Id
	@Column(name = "PK_DOCUMENTO_PROFISSIONAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Long idDocumentoProfissional;

	@Column
	private String pis;
	@Column
	private String carteiraDeTrabalho;

	public HistoricoDocumentosProfissionais() {
		super();
	}

	public void setIdDocumentoProfissional(Long idDocumentoProfissional) {
		this.idDocumentoProfissional = idDocumentoProfissional;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

}
