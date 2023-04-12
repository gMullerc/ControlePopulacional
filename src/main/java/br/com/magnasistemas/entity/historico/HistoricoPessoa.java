package br.com.magnasistemas.entity.historico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.magnasistemas.entity.Entidade;
import br.com.magnasistemas.enumerator.Etnia;
import br.com.magnasistemas.enumerator.Genero;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_HIST_PESSOA")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class HistoricoPessoa extends Entidade<HistoricoPessoa, Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "PK_HIST_PESSOA")
	protected Long id;

	@Column
	@NotNull
	protected LocalDateTime timeStamp;

	@Column
	@NotNull
	@NotBlank
	protected String nome;

	@Column
	@NotNull
	protected LocalDate dataDeNascimento;

	@Column
	protected Etnia etnia;

	@Column
	@Enumerated(EnumType.STRING)
	protected Genero genero;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_HIST_PESSOAS")
	protected List<HistoricoEndereco> historicoEndereco = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_HIST_PESSOAS")
	protected List<HistoricoContato> historicoContato = new ArrayList<>();

	public Long getId() {
		return id;
	}
	@Override
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	@Override
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<HistoricoEndereco> getHistoricoEndereco() {
		return historicoEndereco;
	}

	public void setHistoricoEndereco(List<HistoricoEndereco> historicoEndereco) {
		this.historicoEndereco = historicoEndereco;
	}

	public List<HistoricoContato> getHistoricoContato() {
		return historicoContato;
	}

	public void setHistoricoContato(List<HistoricoContato> historicoContato) {
		this.historicoContato = historicoContato;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Etnia getEtnia() {
		return etnia;
	}

	public void setEtnia(Etnia etnia) {
		this.etnia = etnia;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<HistoricoEndereco> getEndereco() {
		return historicoEndereco;
	}

	public void setEndereco(List<HistoricoEndereco> endereco) {
		this.historicoEndereco = endereco;
	}

	public List<HistoricoContato> getContato() {
		return historicoContato;
	}

	public void setContato(List<HistoricoContato> contato) {
		this.historicoContato = contato;
	}

	@Override
	public String getUsuario() {
		return usuario;
	}

}
