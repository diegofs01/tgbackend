package com.diego.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoModelo;
	private int anoFabricacao;
	private String cor;
	private String paisFabricacao;
	private String raAluno;
	
	public Veiculo() {}
	
	public Veiculo(
			@JsonProperty("placa") String placa,
			@JsonProperty("marca") String marca,
			@JsonProperty("modelo") String modelo,
			@JsonProperty("anoModelo") int anoModelo,
			@JsonProperty("anoFabricacao") int anoFabricacao,
			@JsonProperty("cor") String cor,
			@JsonProperty("paisFabricacao") String paisFabricacao,
			@JsonProperty("raAluno") String raAluno) {
		
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
		this.paisFabricacao = paisFabricacao;
		this.raAluno = raAluno;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPaisFabricacao() {
		return paisFabricacao;
	}

	public void setPaisFabricacao(String paisFabricacao) {
		this.paisFabricacao = paisFabricacao;
	}

	public String getRaAluno() {
		return raAluno;
	}

	public void setRaAluno(String raAluno) {
		this.raAluno = raAluno;
	}
	
}
