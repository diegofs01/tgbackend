package com.diego.model;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ocorrencia {
	private String placaVeiculo;
	private Date data;
	private Time hora;
	private String descricao;
	
	public Ocorrencia() {}
	
	public Ocorrencia(
			@JsonProperty("placaVeiculo") String placaVeiculo,
			@JsonProperty("data") Date data,
			@JsonProperty("hora") Time hora,
			@JsonProperty("descricao") String descricao) {
		
		this.placaVeiculo = placaVeiculo;
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
