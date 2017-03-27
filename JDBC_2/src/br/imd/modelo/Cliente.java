package br.imd.modelo;

import java.util.Date;

public class Cliente {

	private int idCliente;
	private String nomeCliente;
	private String cpf;
	private Date dataNasc;
	
	public Cliente(int idCliente, String nomeCliente, String cpf, Date dataNasc) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}

	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
