package br.imd.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.imd.modelo.Conta;

public class ContaDAO {

	private Connection conn;
	
	public ContaDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	public void inserirConta(Conta conta) throws SQLException{
		String sql = "insert into conta values (default, ?, ?, ?)";
		PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
		
		pstmt.setString(1,  conta.getNumeroConta());
		pstmt.setDouble(2, conta.getSaldo());
		pstmt.setInt(3, conta.getIdCliente());
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Conta " +	conta.getNumeroConta()+ " cadastrada.");

	}
	
	public void alterarConta(Conta conta) throws SQLException{
			String sql = "update conta c, cliente cl set saldo = ? where cl.idCliente = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, conta.getSaldo());
			pstmt.setInt(2, conta.getIdCliente());
			pstmt.execute();
			conn.commit();
			pstmt.close();
			System.out.println("Saldo da conta" +	conta.getNumeroConta()+ " alterado.");
	}

	public void deletarConta(Conta conta)	throws SQLException{
			String sql = "delete from conta where numeroConta = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, conta.getNumeroConta());
			pstmt.execute();
			conn.commit();
			pstmt.close();
			System.out.println("Conta " +	conta.getNumeroConta()+ " deletada.");
	 
	}
	
	public List<Conta> listarPorNumeroConta(int numeroConta) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String arg = Integer.toString(numeroConta);
		pstmt = conn.prepareStatement("Select * from conta where numeroConta = " + arg);
		List<Conta> contas = new ArrayList<Conta>();
		rs = pstmt.executeQuery();
		while(rs.next()){
			Conta c = new Conta();
			c.setIdCliente(rs.getInt("idcliente"));
			c.setNumeroConta(rs.getString("numeroConta"));
			c.setSaldo(rs.getDouble("saldo"));
			contas.add(c);
		}
		return contas;
	} 
	
	public List<Conta> listarPorIdCliente(int idCliente) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String arg = Integer.toString(idCliente);
		pstmt = conn.prepareStatement("Select * from conta where idCliente = " + arg);
		List<Conta> contas = new ArrayList<Conta>();
		rs = pstmt.executeQuery();
		while(rs.next()){
			Conta c = new Conta();
			c.setIdCliente(rs.getInt("idcliente"));
			c.setNumeroConta(rs.getString("numeroConta"));
			c.setSaldo(rs.getDouble("saldo"));
			contas.add(c);
		}
		return contas;
	} 

	public List<Conta> listarPorCPF(String cpf) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement("Select * from conta c, cliente cl where cl.idCliente = c.idCliente and cl.cpf = " + cpf);
		List<Conta> contas = new ArrayList<Conta>();
		rs = pstmt.executeQuery();
		while(rs.next()){
			Conta c = new Conta();
			c.setIdCliente(rs.getInt("idcliente"));
			c.setNumeroConta(rs.getString("numeroConta"));
			c.setSaldo(rs.getDouble("saldo"));
			contas.add(c);
		}
		return contas;
	} 

}
