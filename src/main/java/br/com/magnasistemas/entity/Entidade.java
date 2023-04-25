package br.com.magnasistemas.entity;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Entidade<T, ID> {

	@JsonIgnore
	protected String usuario = "Guilherme";

	protected ZonedDateTime timeStamp;
	@JsonIgnore
	protected ZonedDateTime lastModify;

	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(ZonedDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setLastModify(ZonedDateTime lastModify) {
		this.lastModify = lastModify;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public abstract Long getId();


	public abstract void setId(Long id) ;
	
	}
	


