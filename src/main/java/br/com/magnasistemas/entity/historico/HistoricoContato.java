package br.com.magnasistemas.entity.historico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_HIST_CONTATO")
@Entity
public class HistoricoContato {

	@Id
	@Column(name = "PK_CONTATO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Long idContato;

	@Column
	@NotNull
	private String celular;
	@Column
	@NotNull
	private String telefone;
	@Column
	@NotNull
	private String email;

	public HistoricoContato() {
		super();
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}