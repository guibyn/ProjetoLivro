package gui.view.co;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import dao.db.Conexao;
import exception.HandlerException;
import gui.view.cadastro.GuiCadastrarAutor;
import model.vo.VoAutor;

public class CoCadastrarAutor {
	
	GuiCadastrarAutor gui;
	ArrayList<VoAutor> listaDeAutores;
	DAO DAO;
	Conexao conexao;

	public CoCadastrarAutor(Conexao conexao) throws HandlerException, SQLException {
		this.conexao = conexao;
		this.listaDeAutores = this.getListaAutores();
		this.gui = new GuiCadastrarAutor(this);
		this.gui.setVisible(true);
	}
	
	
	private ArrayList<VoAutor> getListaAutores() throws HandlerException, SQLException {
		String sql = "SELECT * from autor";
		this.DAO = new DAO(conexao,sql);
		ResultSet result = DAO.getResult();
		ArrayList<VoAutor> lista = new ArrayList<VoAutor>();
		while(result.next()) {
			VoAutor a = new VoAutor();
			a.setId(result.getInt("id"));
			a.setNome(result.getString("nome"));
			lista.add(a);
		}
		return lista;
	}


	public boolean cadastrar(String nome) throws SQLException, HandlerException {
		boolean exists = false;
		listaDeAutores = getListaAutores();
		for (VoAutor a : listaDeAutores) {
			if (a.getnome().equals(nome)){
				exists = true;}
			}
		if (exists) {
			System.out.println("Este nome ja esta cadastrado");
			return false;
			}
		
		else {
			DAO.cadastrarAutor(conexao,nome);
			return true;
		}
		
		
	}

}
