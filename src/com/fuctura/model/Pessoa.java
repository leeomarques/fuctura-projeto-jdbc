package com.fuctura.model;

public class Pessoa {
	private String nome;
	private int idade;
	private String cpf;
	private String sexo;
	private Endereco endereco;
	private Conta conta;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, int idade, String cpf, String sexo, Endereco endereco, Conta conta) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.sexo = sexo;
		this.endereco = endereco;
		this.conta = conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", sexo=" + sexo + ", endereco="
				+ endereco + ", conta=" + conta + ", getNome()=" + getNome() + ", getIdade()=" + getIdade()
				+ ", getCpf()=" + getCpf() + ", getSexo()=" + getSexo() + ", getEndereco()=" + getEndereco()
				+ ", getConta()=" + getConta() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
