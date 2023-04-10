package br.com.magnasistemas.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "DocumentosProfissionais")
@Table(name = "documentos_profissionais")
public class DocumentosProfissionais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentos_profissionais_id;
	@Column(unique = true)
	private String pis;
	@Column(unique = true)
	private String carteiraDeTrabalho;


	public DocumentosProfissionais() {
	}

	public void setDocumentos_profissionais_id(Long documentos_profissionais_id) {
		this.documentos_profissionais_id = documentos_profissionais_id;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public Long getDocumentos_profissionais_id() {
		return documentos_profissionais_id;
	}

	public String getPis() {
		return pis;
	}

	public String getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}
}
