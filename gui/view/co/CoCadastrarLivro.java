package gui.view.co;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import dao.db.Conexao;
import exception.HandlerException;
import gui.view.cadastro.GuiCadastrarLivro;
import model.vo.VoAutor;
import model.vo.VoLivro;

public class CoCadastrarLivro {
	GuiCadastrarLivro gui;
	Conexao conexao;
	DAO DAO;
	ArrayList<VoAutor> listaDeAutores;
	ArrayList<VoLivro> listaDeLivros;
	
	public CoCadastrarLivro(CoJanelaInicial coInicio, Conexao conexao) throws HandlerException, SQLException {
		this.conexao = conexao;
		this.listaDeAutores = this.getListaAutores();
		this.listaDeLivros = this.getListaLivros();
		this.gui = new GuiCadastrarLivro(this,listaDeAutores);
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
	
	private ArrayList<VoLivro> getListaLivros() throws HandlerException, SQLException {
		String sql = "SELECT * from livro";
		this.DAO = new DAO(conexao,sql);
		ResultSet result = DAO.getResult();
		ArrayList<VoLivro> lista = new ArrayList<VoLivro>();
		while(result.next()) {
			VoLivro a = new VoLivro();
			a.setId(result.getInt("id"));
			a.setTitulo(result.getString("titulo"));
			lista.add(a);
		}
		return lista;
	}


	private int getChosenId() {
		return gui.getChosenId();
	}
	
	private VoAutor getAutor(int id) {
		return listaDeAutores.get(id);
	}


	public void cadastrar(String titulo) throws SQLException, HandlerException {
		this.listaDeLivros = this.getListaLivros();
		int idautor = this.getChosenId();
		int idlivro = listaDeLivros.size();
		DAO.cadastrarLivro(conexao,titulo,idlivro,idautor);
		
	}
	
	
	

}



