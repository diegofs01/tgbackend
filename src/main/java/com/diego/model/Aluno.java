package com.diego.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Aluno {
	private String ra;
	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String numeroTelefone;
	private String numeroCelular;
	private String email;
	private int idCurso;
	
	public Aluno() {}
	
	public Aluno(
			@JsonProperty("ra") String ra,
			@JsonProperty("nome") String nome,
			@JsonProperty("cpf") String cpf,
			@JsonProperty("rg") String rg,
			@JsonProperty("endereco") String endereco,
			@JsonProperty("numero") int numero,
			@JsonProperty("complemento") String complemento,
			@JsonProperty("bairro") String bairro,
			@JsonProperty("cidade") String cidade,
			@JsonProperty("estado") String estado,
			@JsonProperty("cep") String cep,
			@JsonProperty("numeroTelefone") String numeroTelefone,
			@JsonProperty("numeroCelular") String numeroCelular,
			@JsonProperty("email") String email,
			@JsonProperty("idCurso") int idCurso) {
		
		this.ra = ra;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.numeroTelefone = numeroTelefone;
		this.numeroCelular = numeroCelular;
		this.email = email;
		this.idCurso = idCurso;
	}
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
}
