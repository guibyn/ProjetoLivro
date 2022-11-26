package gui.view.co;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import dao.db.Conexao;
import exception.HandlerException;
import gui.view.cadastro.GuiCadastrarEdicao;
import model.vo.VoAutor;
import model.vo.VoEdicao;
import model.vo.VoLivro;

public class CoCadastrarEdicao {
	
	GuiCadastrarEdicao gui;
	Conexao conexao;
	DAO DAO;
	ArrayList<VoLivro> listaDeLivros;
	
	

	public CoCadastrarEdicao(Conexao conexao) throws HandlerException, SQLException {
		this.conexao = conexao;
		this.listaDeLivros = this.getListaLivros();
		this.gui = new GuiCadastrarEdicao(conexao,this,this.listaDeLivros);
		
		
		
		gui.setVisible(true);
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
	
	private VoLivro getLivro(int id) {
		return listaDeLivros.get(id);
	}



	public void cadastrar(String edicao, String ano) throws SQLException, HandlerException {
		VoEdicao ed = new VoEdicao();
		ed.setAno(ano);
		ed.setEdicao(edicao);
		ed.setIdlLivro(getChosenId());
		DAO.cadastrarEdicao(conexao,ed);
		
	}
}
