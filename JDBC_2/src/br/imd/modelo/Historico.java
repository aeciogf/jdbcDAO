package br.imd.modelo;

import java.sql.Date;

public class Historico {

	private int idHistorico;
	private int tipoOperacao;
	private double valor;
	private Date dataOperacao;
	private int idConta;
	
	public Historico(int idHistorico, int tipoOperacao, double valor, Date dataOperacao, int idConta) {
		super();
		this.idHistorico = idHistorico;
		this.tipoOperacao = tipoOperacao;
		this.valor = valor;
		this.dataOperacao = dataOperacao;
		this.idConta = idConta;
	}
	
	public Historico(){
		
	}

	public int getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}

	public int getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	
	
	
}
