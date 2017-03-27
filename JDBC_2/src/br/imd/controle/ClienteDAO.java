package br.imd.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.imd.modelo.Cliente;

public class ClienteDAO {
	private Connection conn;
	
	public ClienteDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void inserirCliente(Cliente cliente) throws SQLException{
		String sql = "insert into cliente values (default, ?, ?, ?)";
		PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
		
		pstmt.setString(1,  cliente.getNomeCliente());
		pstmt.setString(2, cliente.getCpf());
		pstmt.setDate(3, cliente.getDataNasc());
		
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Cliente " +	cliente.getNomeCliente()+ " cadastrado.");

	}
	
	public void alterarCliente(Cliente cliente) throws SQLException{
			String sql = "update cliente set nome = ? where cpf = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cliente.getNomeCliente());
			pstmt.setString(2, cliente.getCpf());
			pstmt.execute();
			conn.commit();
			pstmt.close();
			System.out.println("Cliente " +	cliente.getNomeCliente()+ " alterado.");
	}

	public void deletarCliente(Cliente cliente)	throws SQLException{
			String sql = "delete from cliente where	cpf = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cliente.getCpf());
			pstmt.execute();
			conn.commit();
			pstmt.close();
			System.out.println("Cliente " +	cliente.getCpf()+ " deletado.");
	 
	}
	
	public List<Cliente> listar() throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement("Select * from cliente");
		List<Cliente> clientes = new ArrayList<Cliente>();
		rs = pstmt.executeQuery();
		while(rs.next()){
			Cliente c = new Cliente();
			c.setNomeCliente(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			clientes.add(c);
		}
		return clientes;
	} 
	
}
