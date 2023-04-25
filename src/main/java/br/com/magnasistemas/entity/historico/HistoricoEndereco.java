package br.com.magnasistemas.entity.historico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_HIST_ENDERECO")
@Entity
public class HistoricoEndereco {

	public HistoricoEndereco() {
		super();
	}

	@Id
	@Column(name = "PK_HIST_ENDERECO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Long idEndereco;
	@Column

	private String logradouro;
	@Column

	private String bairro;
	@Column

	private String cep;
	@Column

	private String numero;
	@Column

	private String complemento;
	@Column

	private String cidade;
	@Column
	private String uf;

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
