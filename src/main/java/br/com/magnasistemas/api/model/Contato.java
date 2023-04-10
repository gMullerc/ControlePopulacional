package br.com.magnasistemas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "contatos")
@Entity(name = "Contato")

public class Contato {

	public Contato() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contatos_id;
	private String celular;
	private String telefone;
	private String email;
	@ManyToOne
	@JoinColumn(name = "pessoa_id", insertable = false, updatable = false)
	@JsonIgnore
	private Pessoa pessoas_id;

	public Long getContatos_id() {
		return contatos_id;
	}

	public void setContatos_id(Long contatos_id) {
		this.contatos_id = contatos_id;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pessoa getPessoas_id() {
		return pessoas_id;
	}

	public void setPessoas_id(Pessoa pessoas_id) {
		this.pessoas_id = pessoas_id;
	}

}
