package br.com.magnasistemas.entity.historico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_HIST_DOCUMENTO")
@Entity
public class HistoricoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_HIST_DOCUMENTO")
	private Long id;

	@Column
	private Long idDocumento;

	@Column
	@NotNull
	@NotBlank
	private String certidaDeNascimento;

	@Column
	@NotNull
	@NotBlank
	private String rg;

	@Column
	@NotNull(message = "{campo.cpf.invalido}")
	@NotBlank(message = "{campo.cpf.invalido}")
	private String cpf;

	public HistoricoDocumento() {
		super();
	}


	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
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



	

}
