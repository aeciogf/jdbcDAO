package br.imd.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.imd.controle.ClienteDAO;
import br.imd.controle.ContaDAO;
import br.imd.controle.HistoricoDAO;
import br.imd.modelo.Cliente;
import br.imd.modelo.Historico;

public class GenericDAO {

	private Connection conn;
	
	public GenericDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}

	public List<Historico> listar(Cliente cliente) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement("Select * from historico h, conta c, cliente cl where h.idConta = c.idConta and c.idCliente = cl.idCliente and cl.cpf = ?");
		List<Historico> historicos = new ArrayList<Historico>();
		pstmt.setString(1, cliente.getCpf());
		rs = pstmt.executeQuery();
		System.out.println("Cliente: " + cliente.getNomeCliente() + "\n");
		while(rs.next()){
			Historico h = new Historico();
			h.setDataOperacao(rs.getDate("dataOperacao"));
			h.setIdConta(rs.getInt("idConta"));
			h.setTipoOperacao(rs.getInt("tipoOperacao"));
			h.setValor(rs.getDouble("valor"));
			historicos.add(h);
		}
		return historicos;
	}
	
}
