package br.imd.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.imd.modelo.Historico;;

public class HistoricoDAO {
	
	private Connection conn;
	
	public HistoricoDAO() throws SQLException{
		conn = Conexao.getConnection();
		conn.setAutoCommit(false);
	}
	public void inserirHistorico(Historico historico) throws SQLException{
		List<Historico> realizados = listar();
		
		for (Historico r: realizados){
			if (r.getDataOperacao() == historico.getDataOperacao() && r.getValor() == historico.getValor() && r.getTipoOperacao() == historico.getTipoOperacao()){
				throw new SQLException("Registro em duplicidade. Inclusão não permitida.");
			}
		}
		
		String sql = "insert into historico values (default, ?, ?, ?, ?)";
		PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
		
		pstmt.setInt(1,  historico.getTipoOperacao());
		pstmt.setDouble(2, historico.getValor());
		pstmt.setDate(3, historico.getDataOperacao());
		pstmt.setInt(4, historico.getIdConta());
		pstmt.execute();
		conn.commit();
		pstmt.close();
		System.out.println("Historico " +	historico.getIdHistorico()+ " cadastrado.");

	}
	
	public void alterarHistorico(Historico historico) throws SQLException{
			String sql = "update historico set tipoOperacao = ? where historico.idConta = conta.idConta and idHistorico = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, historico.getTipoOperacao());
			pstmt.setInt(2, historico.getIdHistorico());
			pstmt.execute();
			conn.commit();
			pstmt.close();
			System.out.println("Historico " +	historico.getIdHistorico() + " alterado.");
	}

	public void deletarHistorico(Historico historico)	throws SQLException{
			String sql = "delete from historico where idConta = conta.idConta and idHistorico = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, historico.getIdHistorico());
			pstmt.execute();
			conn.commit();
			pstmt.close();
			System.out.println("Historico " +	historico.getIdHistorico() + " deletado.");
	 
	}
	
	public List<Historico> listar() throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement("Select * from historico");
		List<Historico> historicos = new ArrayList<Historico>();
		rs = pstmt.executeQuery();
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
