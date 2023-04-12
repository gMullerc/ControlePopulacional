package br.com.magnasistemas.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Entidade<T, ID> {

	@JsonIgnore
	protected String usuario = "Guilherme";

	private LocalDateTime timeStamp;

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public abstract ID getId();

	public abstract void setId(ID id);

	public abstract String getUsuario();

}
