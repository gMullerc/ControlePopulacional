package br.com.magnasistemas.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "documentos")
@Entity(name = "Documentos")

public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentos_id;

	@Column(unique = true)
	private String certidaDeNascimento;
	@Column(unique = true)
	private String rg;
	@Column(unique = true)
	private String cpf;

	public Documento() {

	}

	public void setDocumentos_id(Long documentos_id) {
		this.documentos_id = documentos_id;
	}

	public void setCertidaDeNascimento(String certidaDeNascimento) {
		this.certidaDeNascimento = certidaDeNascimento;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getDocumentos_id() {
		return documentos_id;
	}

	public String getCertidaDeNascimento() {
		return certidaDeNascimento;
	}

	public String getRg() {
		return rg;
	}

	public String getCpf() {
		return cpf;
	}

}
