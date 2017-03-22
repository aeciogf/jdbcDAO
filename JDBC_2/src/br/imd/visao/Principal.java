package br.imd.visao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.imd.controle.ClienteDAO;
import br.imd.modelo.Cliente;

public class Principal {

	
	
	public static void main(String args[]) throws SQLException{
		int op = 4;
		switch(op){
			case 1: cadastrarClientes(); break;
			case 2: consultarClientes(); break;
			case 3: alterarClientes(); break;
			case 4: deletarClientes(); break;
	}
}

	private static void deletarClientes() throws SQLException {
		Cliente c = new Cliente();
		c.setCpf("325.785.909-04");
		ClienteDAO cDao = new ClienteDAO();
		cDao.deletarCliente(c);
	}
	
	private static void alterarClientes()  throws SQLException {
		Cliente c = new Cliente();
		c.setNome("Demi Moore das Virgens");
		c.setCpf("345.654.213-05");
		ClienteDAO cDao = new ClienteDAO();
		cDao.alterarCliente(c);
	}
	

	private static void consultarClientes() throws	SQLException {
		ClienteDAO cDao = new ClienteDAO();
		List<Cliente> clientes = new
		ArrayList<Cliente>();
		clientes = cDao.listar();
		for(Cliente c : clientes){
			System.out.println(c.getNome() + "\t" +
			c.getCpf());
		}
	}

	private static void cadastrarClientes() throws SQLException {
		Cliente c1 = new Cliente();
		c1.setNome("Roberto Carlos do Real Madrid");
		c1.setCpf("178.235.479-19");
		ClienteDAO cDao = new ClienteDAO();
		cDao.inserirCliente(c1);

	}
}
