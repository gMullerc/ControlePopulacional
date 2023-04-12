package br.com.magnasistemas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_DOCUMENTOS")
@Entity
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_DOCUMENTO")
	private Long id;

	@Column(unique = true)
	@NotNull
	@NotBlank
	private String certidaDeNascimento;

	@Column(unique = true)
	@NotNull
	@NotBlank
	private String rg;

	@Column(unique = true)
	@NotNull
	@NotBlank
	private String cpf;

	public Documento() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getId() {
		return id;
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
