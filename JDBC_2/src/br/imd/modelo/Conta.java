package br.imd.modelo;

public class Conta {
	private int idConta;
	private String numeroConta;
	private double saldo;
	private int idCliente;
	
	public Conta(int idConta, String numeroConta, double saldo, int idCliente) {
		super();
		this.idConta = idConta;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.idCliente = idCliente;
	}
	
	public Conta(){
		
	}
	
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
}
