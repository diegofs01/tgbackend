package com.diego.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Curso {
	private int id;
	private String nome;
	
	public Curso() {}
	
	public Curso (
		@JsonProperty("id") int id,
		@JsonProperty("nome") String nome) {
		
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}